package dota2Query.service;

import dota2Query.dao.UserDao;
import dota2Query.dao.User_matDao;
import dota2Query.domain.DataOf20;
import dota2Query.domain.Match;
import dota2Query.domain.User;
import dota2Query.domain.User_mat;
import dota2Query.dao.MatchDao;
import dota2Query.factory.Dota2SessionFactory;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.session.SqlSession;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.asm.Label;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.*;
import org.w3c.dom.CharacterData;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("dota2QueryService")

public class Dota2QueryServiceImpl implements Dota2QueryService{

	private static int apiNum = 1242;
	private static Map<String, String> steamLoginList = new HashMap<String, String>();
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private User_matDao user_matDao;
	@Autowired
	AuthorizationService authorizationService;
	
	//同步
	//private boolean flag;
	private int error = 0;
	
	public void blockNetwork() throws InterruptedException {
		synchronized (this) {
			apiNum++;
			Thread.sleep(1*1000);
		}
	}
	public void updateSteamImg(String url,String name,HttpServletRequest request) {
		byte[] buffer = new byte[1024];
		try {
			URL urlL = new URL(url);
			URLConnection connectionI = urlL.openConnection();
			connectionI.connect();
		
			File file = new File(request.getServletContext().getRealPath("/WEB-INF/userImg")+"/"+name);
			OutputStream inputStream = new FileOutputStream(file);
			int i = connectionI.getInputStream().read(buffer);
			while(i  != -1) {
				inputStream.write(buffer,0,i);
				i = connectionI.getInputStream().read(buffer);
				System.out.println(i);
			}
		file.createNewFile();
		inputStream.close();
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//true为save
	public void saveAndUpdateUserMat(XPath path, Document document,boolean flag,HttpServletRequest request) throws NumberFormatException, XPathExpressionException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException  {
		User_mat user_mat = null;
		Method method = null;
		NodeList abilityList = null;;
		for (int i = 1;i<=Integer.parseInt(path.evaluate("/result/human_players", document));i++) {
			user_mat = new User_mat();
			if (!path.evaluate("/result/players/player["+i+"]/account_id", document).equals("")) {
				user_mat.setAcc_id(new Long(path.evaluate("/result/players/player["+i+"]/account_id", document)));
			}else {
				user_mat.setAcc_id(new Long("4232488429"));
			}
			user_mat.setMat_id(new Long(path.evaluate("/result/match_id", document)));
			user_mat.setSolt(new Integer(path.evaluate("/result/players/player["+i+"]/player_slot", document)));
			user_mat.setHero_id(new Integer(path.evaluate("/result/players/player["+i+"]/hero_id", document)));
			user_mat.setItem0(new Integer(path.evaluate("/result/players/player["+i+"]/item_0", document)));
			user_mat.setItem1(new Integer(path.evaluate("/result/players/player["+i+"]/item_1", document)));
			user_mat.setItem2(new Integer(path.evaluate("/result/players/player["+i+"]/item_2", document)));
			user_mat.setItem3(new Integer(path.evaluate("/result/players/player["+i+"]/item_3", document)));
			user_mat.setItem4(new Integer(path.evaluate("/result/players/player["+i+"]/item_4", document)));
			user_mat.setItem5(new Integer(path.evaluate("/result/players/player["+i+"]/item_5", document)));
			user_mat.setBac0(new Integer(path.evaluate("/result/players/player["+i+"]/backpack_0", document)));
			user_mat.setBac1(new Integer(path.evaluate("/result/players/player["+i+"]/backpack_1", document)));
			user_mat.setBac2(new Integer(path.evaluate("/result/players/player["+i+"]/backpack_2", document)));
			if (path.evaluate("/result/players/player["+i+"]/backpack_3", document)!="") {
				user_mat.setBac3(new Integer(path.evaluate("/result/players/player["+i+"]/backpack_3", document)));
			}
			user_mat.setKill_num(new Integer(path.evaluate("/result/players/player["+i+"]/kills", document)));
			user_mat.setDeaths(new Integer(path.evaluate("/result/players/player["+i+"]/deaths", document)));
			user_mat.setAssists(new Integer(path.evaluate("/result/players/player["+i+"]/assists", document)));
			if (path.evaluate("/result/players/player["+i+"]/leaver_status", document)!="") {
				user_mat.setLeaver_status(new Integer(path.evaluate("/result/players/player["+i+"]/leaver_status", document)));
			}
		    user_mat.setLast_hit(new Integer(path.evaluate("/result/players/player["+i+"]/last_hits", document)));
			user_mat.setDenis(new Integer(path.evaluate("/result/players/player["+i+"]/denies", document)));
			user_mat.setGpm(new Integer(path.evaluate("/result/players/player["+i+"]/gold_per_min", document)));
			user_mat.setXpm(new Integer(path.evaluate("/result/players/player["+i+"]/xp_per_min", document)));
		    user_mat.setLevel(new Integer(path.evaluate("/result/players/player["+i+"]/level", document)));
		    if (!path.evaluate("/result/players/player["+i+"]/hero_damage", document).equals("")) {
		    	user_mat.setHero_damage(new Integer(path.evaluate("/result/players/player["+i+"]/hero_damage", document)));
		    }
		    if (!path.evaluate("/result/players/player["+i+"]/tower_damage", document).equals("")) {
		    	user_mat.setTower_damage(new Integer(path.evaluate("/result/players/player["+i+"]/tower_damage", document)));
		    }
		    if (!path.evaluate("/result/players/player["+i+"]/hero_healing", document).equals("")) {
		    	user_mat.setHero_healing(new Integer(path.evaluate("/result/players/player["+i+"]/hero_healing", document)));
		    }
		    if (!path.evaluate("/result/players/player["+i+"]/gold_spent", document).equals("")){
		    	user_mat.setGold_spent(new Integer(path.evaluate("/result/players/player["+i+"]/gold_spent", document)));
		    }
			
		    if (!path.evaluate("/result/players/player[1]/ability_upgrades/ability[1]/ability", document).equals("")) {
		    	abilityList = (NodeList)path.evaluate("/result/players/player["+i+"]/ability_upgrades/ability", document, XPathConstants.NODESET);
				//利用反射动态调用方法名
				for (int index = 0; index <abilityList.getLength();index++) {
					Element abilityNode = (Element)abilityList.item(index);
					Class<?> c = user_mat.getClass();
					method = c.getMethod("setAbility_code"+(index+1), Integer.class);
					method.invoke(user_mat, new Object[] {new Integer(path.evaluate("ability",abilityNode))});
					method = c.getMethod("setAbility_time"+(index+1), Integer.class);
					method.invoke(user_mat, new Object[] {new Integer(path.evaluate("time", abilityNode))});
					method = c.getMethod("setAbility_level"+(index+1), Integer.class);
					method.invoke(user_mat,  new Object[] {new Integer(path.evaluate("level", abilityNode))});
				}
		    }
			if(flag) {
						user_matDao.save(user_mat);
						if (userDao.selectUserById(user_mat.getAcc_id())==null) {
						getSteamInfo(user_mat.getAcc_id(), false, false,request);
						}else {
							System.out.println("已经存在用户！！！！！！！"+userDao.selectUserById(user_mat.getAcc_id()));
						}
				}
			else {
					user_matDao.update(user_mat);		
					getSteamInfo(user_mat.getAcc_id(), true, false,request);
			}
		}
	}
	
	public InputStream getHistryFileStream(Long acc_id,Long mat_id) {
		try {
			//URL urlk = new URL("http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?key=78239F1CA39EBD17EFA9F637F7523D4C&account_id=182331313&format=xml&hero_id=107start_at_match_id=3727052817");
			String urlL = "http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1?key=78239F1CA39EBD17EFA9F637F7523D4C&account_id="+acc_id+"&format=xml";
			if(mat_id!=null)urlL +="&start_at_match_id="+mat_id;
			URL url = new URL(urlL);
			URLConnection connection = url.openConnection();
			connection.connect();
			
			return connection.getInputStream();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//保存比赛false为保存
	@Override
	public boolean saveMatch(Long mat_id, boolean flag,HttpServletRequest request) {
		//if (matchDao.selectMatchById(mat_id)!=null) {System.out.println("ERROR"); return;}
		
		try{
			String url = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=78239F1CA39EBD17EFA9F637F7523D4C&format=xml&match_id=";
			URL urlL = new URL(url+mat_id.toString());
			URLConnection connection = urlL.openConnection();
			connection.connect();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(connection.getInputStream());
			
			XPathFactory factoryXpatn = XPathFactory.newInstance();
			XPath path = factoryXpatn.newXPath();
			
			if (!path.evaluate("/result/error",document).equals("")) {
				System.out.println("NONONON");
				return false;
			}
			
			Match match = new Match();
			if(flag) {
				saveAndUpdateUserMat(path, document, false,request);
			}
			else {
				match.setMat_id(new Long(path.evaluate("/result/match_id", document)));
				match.setSeq(new Long(path.evaluate("/result/match_seq_num", document)));
				match.setStart(new Long(path.evaluate("/result/start_time", document)));
				match.setDuration(new Integer(path.evaluate("/result/duration", document)));
				match.setRadiant_win(path.evaluate("/result/radiant_win", document).equals("true")? 1:0);
				match.setCluster(new Integer(path.evaluate("/result/cluster", document)));
				match.setFirst_blood_time(new Integer(path.evaluate("/result/first_blood_time", document)));
				match.setLobby_type(new Integer(path.evaluate("/result/lobby_type", document)));
				match.setLeagueid(new Integer(path.evaluate("/result/leagueid", document)));
				match.setGame_mode(new Integer(path.evaluate("/result/game_mode", document)));
				match.setRadiant_score(new Integer(path.evaluate("/result/radiant_score", document)));
				match.setDire_score(new Integer(path.evaluate("/result/dire_score", document)));
			
				matchDao.saveMatch(match);
				 
				saveAndUpdateUserMat(path, document, true,request);
			}
		}catch (Exception e) {
			e.printStackTrace();
			error++;
			// TODO: handle exception
		}
		return true;
	}
	//获取此用户所有的比赛记录 或者刷新记录（500）
	@Override
	public void getAndSaveAndUpdateUserMatchHistory(Long acc_id, boolean update,HttpServletRequest request) {

			
		
		List<Long> match_id_list =  null;
		try {
			match_id_list =  new ArrayList<Long>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(getHistryFileStream(acc_id, null));
			
			XPathFactory factoryXpatn = XPathFactory.newInstance();
			XPath path = factoryXpatn.newXPath();
			int sum = 0;
			Long newMat_id = matchDao.selectNewMatch(acc_id);
			int status = Integer.parseInt(path.evaluate("/result/status",document));
			int rem = Integer.parseInt(path.evaluate("/result/results_remaining",document));

			boolean flag = true;
			int n = 1;
			while (status==1) {
				sum = new Integer(path.evaluate("/result/num_results", document));//当前页的结果数量
				if (flag) {//读取位置
				  n = 1;
				  flag = false;
				}
				else {
					n=2;
				}
				rem = Integer.parseInt(path.evaluate("/result/results_remaining",document));
				for (; n <= sum; n++) {
					if (update) {
						if (new Long(path.evaluate("/result/matches/match["+n+"]/match_id", document)).equals(newMat_id)) {
							System.out.print("!!!!!!!!!!!!!!!!!!");
							rem = 0;
							break;
						}
					}
					match_id_list.add(new Long(path.evaluate("/result/matches/match["+n+"]/match_id", document)));
					System.out.println(match_id_list.size());
				}
				//把用户id与比赛id(也就是读取下一页的起点)传入函数
				if (rem==0)break;
				document = builder.parse(getHistryFileStream(acc_id, new Long(path.evaluate("/result/matches/match["+sum+"]/match_id", document))));
				blockNetwork();
			}
			//写入数据库
		
			List<User_mat> user_mats = null;
			
			if (match_id_list.size()!=0) {
				for (int i = 0; i < match_id_list.size();i++) {
					if (matchDao.selectMatchById(match_id_list.get(i))==null){
							saveMatch(match_id_list.get(i),false,request);
						System.out.println(match_id_list.get(i));
						blockNetwork();
					}else {//如果已经记录则检测录入数据是是否为匿名状态，如果是，更新
						user_mats = user_matDao.selectUser_matByMat_id(match_id_list.get(i));
						boolean flag1 = true;
						for (int y = 0;y<user_mats.size();y++) {
							if (user_mats.get(y).getAcc_id().equals(acc_id))flag1=false;
						}
						if (flag1) {
							saveMatch(match_id_list.get(i), true,request);
							}
					}
					if (update) {
						//如果执行更新
						matchTypeCount(acc_id, match_id_list.get(i));
					}
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("NumberOfError:" + error);
		
	}
	
	//获取一场比赛的胜负情况并附加至用户信息中
	public void  matchTypeCount(Long acc_id,Long mat_id ) {
		User user = userDao.selectUserById(acc_id);
		DataOf20 data = user_matDao.selectMatchVic(acc_id, mat_id);
		if (data.getLobby_type()==7) {
			user.setLoby7(user.getLoby7()+1);//天梯场次累加
			if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {//天梯胜利和总胜利累加
				user.setLoby7win(user.getLoby7win()+1);
				user.setWin(user.getWin()+1);
			}
		}
		else if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {//普通比赛胜利
			user.setWin(user.getWin()+1);
		}
	}
	//注册用户
	@Override
	public void registerUser(User user) {
		userDao.save(user);
	}
	
	@Override
	//获取单个比赛
	public Match getMatch(Long matId,HttpServletRequest request) {
		Match match=null;
		if ((match=matchDao.selectMatchById(matId))!=null)
			return match;
		else {
			if (saveMatch(matId, false,request)) {
				match = matchDao.selectMatchById(matId);
				return match;
			}
		}
		return null;
	}

	@Transactional(readOnly=true)
	@Override
	public boolean login(String account,String password) {
		if(userDao.selectByAccountAndPassword(account, password)==null) {
			return false;
		}else
			return true;
		// TODO 自动生成的方法存根
	}
	//使用token进行验证
	@Override
	public String login(String token) {
		return authorizationService.verifyToken(token);
	}

	@Override
	public boolean captcharCode() {
		// TODO 自动生成的方法存根
		return false;
	}
	
	@Transactional(readOnly=true)
	@Override
	public User getUserByAccount(String account) {
		return userDao.selectUserByAccount(account);
	}
	//通过dota2id保存一个临时用户,或者将一个用户的steam信息进行更新，true为更新
	@Override
	public void getSteamInfo(Long steam32,boolean update,boolean getimg,HttpServletRequest request) {
		User user = null;
		try {
			String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=78239F1CA39EBD17EFA9F637F7523D4C&format=xml&steamids="+(76561197960265728L+steam32);
			URL urlL = new URL(url);
			URLConnection connection = urlL.openConnection();
			connection.connect();
			//blockNetwork();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(connection.getInputStream());
			
			XPathFactory factoryXpatn = XPathFactory.newInstance();
			XPath path = factoryXpatn.newXPath();
			
			if (path.evaluate("/response/players/player[1]/steamid", document).equals("")) {
				System.out.println("ID IS EMPTY");
				return;
			}
			
			user=new User();
	
			user.setSteam_code(path.evaluate("/response/players/player[1]/steamid", document));
			System.out.println("steamid:"+path.evaluate("/response/players/player[1]/steamid", document));
			user.setSteam_name(path.evaluate("/response/players/player[1]/personaname", document));
			System.out.println("name: "+path.evaluate("/response/players/player[1]/personaname", document));
			String imgName = path.evaluate("/response/players/player[1]/avatar", document);
			user.setDota2_acc_id(new Long(steam32));
			if(getimg) {

				if (imgName.equals("fef49e7fa7e1997310d705b2a6158ff8dc1cdfeb"))
					user.setImg("steam_default");
				else {
				
					user.setImg(76561197960265728L+steam32+"");
					updateSteamImg(path.evaluate("/response/players/player[1]/avatar", document), user.getSteam_code()+".jpg",request);
					updateSteamImg(path.evaluate("/response/players/player[1]/avatarmedium", document), user.getSteam_code()+"_medium.jpg",request);
					updateSteamImg(path.evaluate("/response/players/player[1]/avatarfull", document), user.getSteam_code()+"_full.jpg",request);
				}

			}
			if(update) {
				user.setId(userDao.selectUserBySteamId(steam32+76561197960265728L+"").getId());
				userDao.update(user);
			}
			else {
				userDao.save(user);}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	@Transactional(readOnly=true)
	public int getApiNum() {
		return apiNum;
	}
	@Override
	@Transactional(readOnly=true)
	public int getUserMatchNum(Long acc_id) {
			return matchDao.selectCountOfUserId(acc_id);
	}
	@Override
	public List<Match> getMatchByPage(Map<String, Object> params){
		return matchDao.selectMatchByParams(params);
	}
	//返回20场胜率
	@Override
	public float getMatchOf20(Long acc_id){
		List<DataOf20> dataOf20s = user_matDao.select20Match(acc_id);
		if (dataOf20s.size()==0)
			return 0;
		float vic = 0;
		float size  = dataOf20s.size();
		for (DataOf20 data: dataOf20s) {
			if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {
				vic++;
			}
		}

		return vic/size*100;	
	}
	//返回20场天梯胜率
	@Override
	public float getMatchOf20Lobby7(Long acc_id){
		List<DataOf20> dataOf20s = user_matDao.select20Match7(acc_id);
		if (dataOf20s.size()==0)
				return 0;
		
		float vic = 0;
		float size  = dataOf20s.size();
		for (DataOf20 data:dataOf20s) {
			if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {
				vic++;
			}
		}

		return vic/size*100;	
	}
	@Override//同步用户信息校验
	public boolean sysUserInfoVer(Long acc_id,String account,HttpServletRequest request) {
		User user = userDao.selectUserByAccount(account);
		if (user.getIsSys()==1||user.getIsSys()==2)//检测账户同步状态
			return false;
		//这里将用户设置为正在同步
		user.setIsSys(1);
		userDao.update(user);
		return true;
	}
	@Override
	public void sysUserInfo(Long acc_id,String account,HttpServletRequest request) {
		getAndSaveAndUpdateUserMatchHistory(acc_id, false,request);
		User user = userDao.selectUserById(acc_id);//获取dota2用户
		//User user2 = userDao.selectUserByAccount(account);//获取网站用户
	//	user.setAccount(user2.getAccount());
		//user.setPassword(user2.getPassword());
		user.setWin(getMatchWin(acc_id));
		user.setLoby7win(getMatchLobby7Win(acc_id));
		user.setLoby7(user_matDao.selectMatch7Num(acc_id));
		user.setIsSys(2);
		//userDao.deleteUserByAccount(account);//删除原来的网站用户
		userDao.update(user);//更新用户，将2个账户合并
	}
	//获取胜利数量
	public int getMatchWin(Long acc_id) {
		List<DataOf20> dataOf20s = user_matDao.selectMatch(acc_id);
		if (dataOf20s.size()==0)
			return 0;
		int vic = 0;
		for (DataOf20 data:dataOf20s) {
			if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {
				vic++;
			}
		}
		
		return vic;
	}
	//获取天梯胜利数量
	public int getMatchLobby7Win(Long acc_id) {
		List<DataOf20> dataOf20s = user_matDao.selectMatch7(acc_id);
		if (dataOf20s.size()==0)
			return 0;
		int vic = 0;
		for (DataOf20 data:dataOf20s) {
			if ((data.getRadiant_win()==0&&data.getSolt()>100)||(data.getRadiant_win()==1&&data.getSolt()<100)) {
				vic++;
			}
		}
		
		return vic;
	}
	@Override
	public String vaildataOfSteam(HttpServletRequest request) {
		String signed = request.getParameter("openid.identity");
		if(signed ==null || "".equals(signed)){
			return "";
			}
		String tmp = signed.replace("https://steamcommunity.com/openid/id/", "");
		steamLoginList.put(tmp, tmp);
		return tmp;
	}
	
	@Override
	public boolean isSteamLogin(String steam32) {
		if (steamLoginList.get(steam32)!=null)
			return true;
		return false;
	}
	//检测是否已有用户如果有返回账户名，否则创建后返回
	@Override
	public String getOrCreateUserBySteam32(String steam32,HttpServletRequest request) {
		steamLoginList.remove(steam32);//移除登录等待列表
		User user  = userDao.selectUserBySteamId(steam32);
		if (user==null) {
			//存入新用户从steam获取
			getSteamInfo(new Long(steam32) - 76561197960265728L, false,true, request);
			//创建网站用户
			User user2 = userDao.selectUserBySteamId(steam32);
			long num = 657;
			String tempAcc = new Long(steam32) - 76561197960265728L+num +"uid"+user2.getId();
			//检测数据库是否有此用户名
			while(true) {
				if (userDao.selectUserByAccount(tempAcc)!=null) {
					num++;
					tempAcc = new Long(steam32) - 76561197960265728L+num +"uid"+user2.getId();
				}
				else {
					break;
				}
			}

			user2.setAccount(tempAcc);
			user2.setPassword("1234567890");
			userDao.update(user2);
			
			return tempAcc;
		}
		else if (user.getAccount()==null){
			//有steam用户但是没有网站用户
			System.out.println("UOPDATE!");
			User user2 = userDao.selectUserBySteamId(steam32);
			long num = 657;
			String tempAcc = new Long(steam32) - 76561197960265728L+num +"uid"+user.getId();
			//检测数据库是否有此用户名
			while(true) {
				if (userDao.selectUserByAccount(tempAcc)!=null) {
					num++;
					tempAcc = new Long(steam32) - 76561197960265728L+num +"uid"+user.getId();
				}
				else {
					break;
				}
			}
			user2.setAccount(tempAcc);
			user2.setPassword("1234567890");
			userDao.update(user2);
			
			return tempAcc;
		}
		return user.getAccount();
	}
	@Override//校验网站用户的steacode状态
	public int bindSteamAcc(String account,String steam_code) {
		User user = userDao.selectUserByAccount(account);
		if (user.getIsSys()==1||user.getIsSys()==2) {
			return 0;//此用户已经绑定
		}
		User user2 = userDao.selectUserBySteamId(steam_code);
	
		if (user2==null) {//第二种情况，有网站用户但没有steam账号
			return 1;
		}
		if (user2.getIsSys()==1||user2.getIsSys()==2) {
			return 0;//此用户已经绑定
		}
		if (user2.getAccount()==null) {//第三种：有网站用户 有一个没头像的steam用户
			return 2;
		}
		else {
			return 3;
		}
	}
	@Override//将用户steamcode与user绑定传入sys方法
	public void bindSteamAccCode1(String account,String steam_code,HttpServletRequest request) {
		getSteamInfo(new Long(steam_code) - 76561197960265728L, false,true, request);//更新steam具体信息
		getAndSaveAndUpdateUserMatchHistory(new Long(steam_code) - 76561197960265728L, false,request);//开始同步比赛信息
		User user = userDao.selectUserByAccount(account);//获取网站用户
		User user2 = userDao.selectUserBySteamId(steam_code);//获取有头像的steam用户
		int tmpid = user2.getId();
		user2.setId(user.getId());
		user2.setWin(getMatchWin(new Long(steam_code) - 76561197960265728L));
		user2.setLoby7win(getMatchLobby7Win(new Long(steam_code) - 76561197960265728L));
		user2.setLoby7(user_matDao.selectMatch7Num(new Long(steam_code) - 76561197960265728L));
		user2.setIsSys(2);
		userDao.update(user2);
		userDao.deleteUserById(tmpid);
	}
	@Override
	public void bindSteamAccCode2(String account,String steam_code,HttpServletRequest request) {

		getSteamInfo(new Long(steam_code) - 76561197960265728L, true,true, request);//更新steam具体信息
		getAndSaveAndUpdateUserMatchHistory(new Long(steam_code) - 76561197960265728L, false,request);//开始同步比赛信息
		User user = userDao.selectUserByAccount(account);//获取网站用户
		User user2 = userDao.selectUserBySteamId(steam_code);//获取没唷头像的steam用户
		int tmpid = user2.getId();
		user2.setId(user.getId());
		user2.setWin(getMatchWin(new Long(steam_code) - 76561197960265728L));
		user2.setLoby7win(getMatchLobby7Win(new Long(steam_code) - 76561197960265728L));
		user2.setLoby7(user_matDao.selectMatch7Num(new Long(steam_code) - 76561197960265728L));
		user2.setIsSys(2);
		userDao.update(user2);
		userDao.deleteUserById(tmpid);
	}
	
}
