package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.repository.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public UserServiceImpl() {}
		
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public UserVo selectUser(String userid) {
		
		return userDao.selectUser(userid);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
////////////////////////////////


	@Override
	public List<UserVo> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAllUser();
	}


	@Override
	public Map<String, Object> selectpagingUser(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageVo",pageVo);
		resultMap.put("userList", userDao.selectpagingUser(pageVo));
		//resultMap.put("userCnt", userDao.selectAlluserCnt());
		int userCnt= userDao.selectAlluserCnt();
		resultMap.put("pagination",(int)Math.ceil((double)userCnt/pageVo.getPageSize()));
		
		return resultMap;
	}


	@Override
	public int selectAlluserCnt() {
		// TODO Auto-generated method stub
		return userDao.selectAlluserCnt();
	}


	@Override
	public int modifyUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.modifyUser(userVo);
	}


	@Override
	public int registUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.registUser(userVo);
	}


	@Override
	public int deleteUser(String userid) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userid);
	}
}
