package dota2Query.controller;

import java.util.List;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.FormatFlagsConversionMismatchException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.javassist.bytecode.ConstantAttribute;
import org.jose4j.json.internal.json_simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;

import dota2Query.dao.MatchDao;
import dota2Query.dao.UserDao;
import dota2Query.dao.User_matDao;
import dota2Query.domain.DataOf20;
import dota2Query.domain.DataOfBrowser;
import dota2Query.domain.DataOfLogin;
import dota2Query.domain.Match;
import dota2Query.domain.User;
import dota2Query.domain.User_mat;
import dota2Query.service.AuthorizationService;
import dota2Query.service.Dota2QueryService;
import dota2Query.util.common.CaptcharCode;
import dota2Query.util.common.PageModel;

@Controller
@CrossOrigin
public class Dota2queryController {
	private final String DOMAIN = "localhost:8080";//"www.dotainfo.xyz";
	@Autowired
	AuthorizationService authorizationService;
	
	@Autowired
	@Qualifier("dota2QueryService")
	Dota2QueryService dota2QueryService;
	@Autowired
	MatchDao matchDao;
	
	boolean flag = true;
	
	public static void  main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Set<Long> in = new HashSet<Long>();
		System.out.println("Srtart!!!!");
		in.add(new Long("123123123"));
		in.add(new Long("123123123"));
		
		System.out.println("testForNewLong!::"+in.size());
	}
	
	
	@RequestMapping(value="/asy",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String testAsyTask() throws IOException{
		
		return matchDao.selectNewMatch(899745569L).toString();
	}
	//
	@RequestMapping(value="/nasy/{id}/{flag}")
	@ResponseBody
	public String testasyA(@PathVariable String id,@PathVariable String flag,HttpServletRequest request) throws InterruptedException {
		if (flag.equals("y")){
			dota2QueryService.getAndSaveAndUpdateUserMatchHistory(new Long(id), true,request);
		}else {
			System.out.println("S!!");
			dota2QueryService.getAndSaveAndUpdateUserMatchHistory(new Long(id), false,request);
		}
		return "OVER!";
	}
	
	@RequestMapping(value="/json")
	@ResponseBody
	public Object setJson(HttpServletResponse response,HttpServletRequest request)throws Exception{
		Match match  = dota2QueryService.getMatch(new Long(request.getParameter("matId")),request);
	    return match;
		
	}
	
	@RequestMapping(value="/code")
	public void getCode(HttpServletResponse response,HttpServletRequest request) {
		HttpSession session= request.getSession();
		System.out.println(session.getId());
		session.setAttribute("captcharCode", 	CaptcharCode.drawImage(response));
		
		System.out.println(session.getAttribute("captcharCode")+"   Time: " + session.getMaxInactiveInterval());
		
	}

	@RequestMapping(value="/login")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response,@RequestBody DataOfBrowser dataOfBrowser) {
		DataOfLogin dataOfLogin = new DataOfLogin();
			HttpSession session= request.getSession();
			System.out.println(session.getId());
		String code =(String)session.getAttribute("captcharCode");
		
		if (dataOfBrowser.getToken()!=null) {
			dota2QueryService.login(dataOfBrowser.getToken());
			
		}
		if (!dataOfBrowser.getCatcharCode().toLowerCase().equals(code.toLowerCase())) {
			dataOfLogin.setState("Error");
			dataOfLogin.setCode("2");
			
			return dataOfLogin;
		}
		if (!dota2QueryService.login(dataOfBrowser.getAccount(), dataOfBrowser.getPassword())) {
			dataOfLogin.setState("Error");
			dataOfLogin.setCode("1");
			
			return dataOfLogin;
		}
		dataOfLogin.setToken(authorizationService.createToken(dataOfBrowser.getAccount()));
		return dataOfLogin;
	}
	//注册
	@RequestMapping(value="/register")
	@ResponseBody
	public Object register(HttpServletRequest request,HttpServletResponse response,@RequestBody DataOfBrowser dataOfBrowser){
		DataOfLogin dataOfLogin = new DataOfLogin();
		HttpSession session= request.getSession();
		String code =(String)session.getAttribute("captcharCode");
		if (!dataOfBrowser.getCatcharCode().toLowerCase().equals(code.toLowerCase())) {
			dataOfLogin.setState("Error");
			dataOfLogin.setCode("2");
			
			return dataOfLogin;
		}
		if (dota2QueryService.getUserByAccount(dataOfBrowser.getAccount())!=null) {
			dataOfLogin.setState("Error");
			dataOfLogin.setCode("3");
			
			return dataOfLogin;
		}
		//注册
		User user = new User();
		user.setAccount(dataOfBrowser.getAccount());
		user.setPassword(dataOfBrowser.getPassword());
		dota2QueryService.registerUser(user);
		if (dota2QueryService.login(dataOfBrowser.getAccount(), dataOfBrowser.getPassword())) {
			dataOfLogin.setToken(authorizationService.createToken(dataOfBrowser.getAccount()));
		}
		
		return dataOfLogin;
	}

	@RequestMapping(value="/getUser")
	@ResponseBody
	public Object getUser(@RequestBody DataOfBrowser dataOfBrowser) {
		String account=null;
		User user=null;

		if ((account=authorizationService.verifyToken(dataOfBrowser.getToken()))!=null) {
			System.out.println(account);
				user = dota2QueryService.getUserByAccount(account);
				System.out.print(user);
				if (user.getDota2_acc_id()!=0) {
					user.setMatNum(dota2QueryService.getUserMatchNum(user.getDota2_acc_id()));
					user.setDataOf20(dota2QueryService.getMatchOf20(user.getDota2_acc_id()));
					user.setDataOf20Lobby7(dota2QueryService.getMatchOf20Lobby7(user.getDota2_acc_id()));
				}
				user.setPassword("");//除去密码
				user.setMatchs(null);
			
				
				return user;
		}

		return null;
	}
	
	@RequestMapping(value="/getUserImg/{faceId}")
	public void getImage(@PathVariable String faceId,HttpServletRequest request,
			HttpServletResponse response, @RequestHeader String referer) {
		if (referer!=null) {
			String imageDir = request.getServletContext().getRealPath("/WEB-INF/userImg");
			File file = new File(imageDir,faceId+".jpg");
			if (file.exists()) {
				response.setContentType("image/jpg");
				byte[] buffer = new byte[1024];
				FileInputStream fis= null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while(i != -1) {
						os.write(buffer,0,i);
						i = bis.read(buffer);
					}
				}catch (IOException e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally {
					if (bis != null) {
						try {
							bis.close();
						}catch (IOException e) {
							e.printStackTrace();
							// TODO: handle exception
						}
					}
					if(fis !=  null) {
						try {
							fis.close();
						}catch (IOException e) {
							e.printStackTrace();
							// TODO: handle exception
						}
					}
				}
			}
		}
	}
	
	@RequestMapping(value="/get_usermat_list")
	@ResponseBody
	public List<Match> getUserMatList(@RequestBody DataOfBrowser dataOfBrowser) {
		Map< String, Object> param = new HashMap<String,Object>();
		param.put("acc_id", dataOfBrowser.getAcc_id());
		PageModel pageModel = new PageModel();
		pageModel.setPageIndex(dataOfBrowser.getPageNum());
		pageModel.setPageSize(10);
		param.put("pageModel", pageModel);
		List<Match> matchs =  dota2QueryService.getMatchByPage(param);
		for (Match match: matchs) {
			match.getUsers().clear();
			for (User_mat user_mat : match.getUser_mats()) {
				if (user_mat.getAcc_id().equals(dataOfBrowser.getAcc_id())) {
					match.getUser_mats().clear();
					match.getUser_mats().add(user_mat);
					break;
				}
			}
		}
	
		return matchs;
	}
	@RequestMapping(value="/apinum")
	@ResponseBody
	public int getApinum() {
		return dota2QueryService. getApiNum();
	}
	@RequestMapping(value="/sysuser")
	@ResponseBody
	public void sysUser(@RequestBody DataOfBrowser dataOfBrowser,HttpServletRequest request) {
		if (!dataOfBrowser.getAccount().equals("")&&dataOfBrowser.getAcc_id()!=0) {
			if (dota2QueryService.sysUserInfoVer(dataOfBrowser.getAcc_id()-76561197960265728L, dataOfBrowser.getAccount(), request)) {
				dota2QueryService.sysUserInfo(dataOfBrowser.getAcc_id()-76561197960265728L, dataOfBrowser.getAccount(), request);
			}
		}
		return;
	}
	@RequestMapping(value="/account/login/steam/verification")//steam登录处理
	public String virurl(HttpServletRequest request) {
	String tmp = dota2QueryService.vaildataOfSteam(request);
		return "redirect:http://"+DOMAIN+"/loginofsteam/"+tmp;
	}
	@RequestMapping(value="/account/login/steam/bind/{account}")//绑定steam处理
	public String bindSteam(HttpServletRequest request,@PathVariable("account")String account) {
		String steam_code = dota2QueryService.vaildataOfSteam(request);//这个用来获取steam32
		int code = dota2QueryService.bindSteamAcc(account, steam_code);
		if (code==1) {
			try {
				dota2QueryService.sysUserInfoVer(new Long(steam_code)-76561197960265728L,account,request);//将用户状态置为正在同步
				return "redirect:http://"+DOMAIN+"/userinfocode/"+code;
			}finally {
				dota2QueryService.bindSteamAccCode1(account, steam_code,request);
			}
		}else if (code==2) {
			try {
				dota2QueryService.sysUserInfoVer(new Long(steam_code)-76561197960265728L,account,request);//将用户状态置为正在同步
				return "redirect:http://"+DOMAIN+"/userinfocode/"+code;
			}finally {
				dota2QueryService.bindSteamAccCode2(account, steam_code,request);
			}
		}else 
		return "redirect:http://"+DOMAIN+"/userinfocode/"+code;
	}
	
	@RequestMapping(value="/findSteamId/{steam32}")
	@ResponseBody
	public Object getSteamToken(@PathVariable("steam32")String steam32,HttpServletRequest request) {

		if (dota2QueryService.isSteamLogin(steam32)) {
			DataOfLogin dataOfLogin = new DataOfLogin();
			dataOfLogin.setState("ok");
			dataOfLogin.setToken(authorizationService.createToken(dota2QueryService.getOrCreateUserBySteam32(steam32,request)));
			return dataOfLogin;
		}
		return null;
	}
}
