package kr.or.ddit.model;

import java.util.List;

public class UsersVo {
	private List<UserVo> userVoList;

	public List<UserVo> getUserVoList() {
		return userVoList;
	}

	public void setUserVoList(List<UserVo> userVoList) {
		this.userVoList = userVoList;
	}

	@Override
	public String toString() {
		return "UsersVo [userVoList=" + userVoList + "]";
	}

	
	


	
	
}
