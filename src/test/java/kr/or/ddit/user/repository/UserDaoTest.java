package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.test.config.ModelTestConfig;

//������ ȯ�濡�� junit �ڵ带 ���� => junit�ڵ嵵 ������ ������ ���

public class UserDaoTest extends ModelTestConfig {
//		���� �ް���� ������ �� 
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void getUserTest() {
		/***Given***/
		String userid= "brown";

		/***When***/
		UserVo userVo= userDao.selectUser(userid);
		
		/***Then***/
		assertEquals("브라운", userVo.getUsernm());
		
	}
	@Test
	public void AllUserTest() {
		/***Given***/
		

		/***When***/
		List<UserVo> userList= userDao.selectAllUser();
		

		/***Then***/
		assertEquals(19, userList.size());

	}
	//사용자 아이디를 이용하여 특정사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		String userid= "brown";

		
		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}
	@Test
	public void selectpagingUserTest() {
		/***Given***/
		PageVo pvo= new PageVo(2,5);

		/***When***/
		List<UserVo> userList= userDao.selectpagingUser(pvo);
		/***Then***/
		assertEquals(5,userList.size());

	}
	@Test
	public void ModifyUserTest() {
		/***Given***/
		
		
		//userid usernm pass reg_gt alias addr1 addr2 zipcode 
		UserVo userVo = new UserVo("ddit","대덕인재","dditpass",new Date(),"개발원m","대전 중구 중앙로 76","4층 대덕인재개발원","34940","brown.png","uuid-generated-filename.png");
		
		/***When***/
		int updateCnt =  userDao.modifyUser(userVo);
		
		/***Then***/
		
		assertEquals(1,updateCnt);
		
	}


//삭제 테스트
	@Test
	public void deleteUserTest() {
		/***Given***/
		//해당 테스트가 실행될때는 testUser라는 사용자가 before메소드에 의해 등록이 된다
		String userid = "testUser";
		/***When***/
		int deleteCnt= userDao.deleteUser(userid);
		
		/***Then***/
		assertEquals(0, deleteCnt);
	}
}
