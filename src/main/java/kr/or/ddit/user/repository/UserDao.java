package kr.or.ddit.user.repository;

import kr.or.ddit.model.UserVo;

public interface UserDao {
	
	//사용자 아이디로 사용자 조회
	UserVo getUser(String userid);
}
