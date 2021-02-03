package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.model.UserVo;

public interface UserService {

	UserVo selectUser(String userid);
	
	List<UserVo> selectAllUser();

	Map<String, Object>  selectpagingUser(PageVo pvo);

	int selectAlluserCnt() ;
	
	int modifyUser(UserVo userVo);
	
	int registUser(UserVo userVo);

	int deleteUser(String userid);
}
