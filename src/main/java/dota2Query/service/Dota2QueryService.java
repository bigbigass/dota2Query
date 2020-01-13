package dota2Query.service;

import java.util.List;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dota2Query.dao.MatchDao;
import dota2Query.domain.DataOf20;
import dota2Query.domain.Match;
import dota2Query.domain.User;

public interface Dota2QueryService {
	public boolean saveMatch(Long mat_id,boolean flag,HttpServletRequest request);
	public void getAndSaveAndUpdateUserMatchHistory(Long acc_id,boolean update,HttpServletRequest request);
	public void registerUser(User user);
	public boolean login(String account, String password);
	public String login(String token);
	public boolean captcharCode();
	public User getUserByAccount(String account);
	public Match getMatch(Long matId,HttpServletRequest request);
	public void getSteamInfo(Long steam32,boolean update,boolean getimg,HttpServletRequest request);
	public int getApiNum();
	public int getUserMatchNum(Long acc_id);
	public List<Match> getMatchByPage(Map<String, Object> params);
	public float getMatchOf20(Long acc_id);
	public float getMatchOf20Lobby7(Long acc_id);
	public boolean sysUserInfoVer(Long acc_id,String account,HttpServletRequest request);
	public String vaildataOfSteam(HttpServletRequest request);
	public boolean isSteamLogin(String steam32);
	public String getOrCreateUserBySteam32(String steam32,HttpServletRequest request);
	public void sysUserInfo(Long acc_id,String account,HttpServletRequest request) ;
	public int bindSteamAcc(String account,String steam_code);
	public void bindSteamAccCode1(String account,String steam_code,HttpServletRequest request);
	public void bindSteamAccCode2(String account,String steam_code,HttpServletRequest request);
}
