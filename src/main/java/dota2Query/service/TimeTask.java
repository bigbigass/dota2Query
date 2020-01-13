package dota2Query.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dota2Query.dao.MatchDao;
import dota2Query.dao.UserDao;
import dota2Query.dao.User_matDao;
import dota2Query.domain.User;

@Component
public class TimeTask {
	@Autowired
	@Qualifier("dota2QueryService")
	Dota2QueryService dota2QueryService;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private MatchDao matchDao;
	@Autowired
	private User_matDao user_matDao;
	
	@Scheduled(fixedRate = 1000 * 60 * 5)//定时调用
	public void sysTimerTask() {
		List<User> users = userDao.selectIsSysUser();//获取所有的已同步用户
		for (User user:users) {
			System.out.println("start SYS!");
			dota2QueryService.getAndSaveAndUpdateUserMatchHistory(user.getDota2_acc_id(), true, null);
		}
	}
}
