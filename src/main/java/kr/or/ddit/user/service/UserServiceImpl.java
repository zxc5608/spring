package kr.or.ddit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public UserServiceImpl() {}
		
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public UserVo getUser(String userid) {
		
		return userDao.getUser(userid);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
