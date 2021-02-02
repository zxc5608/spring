package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.test.config.ModelTestConfig;

public class UserServiceTest extends ModelTestConfig{

	@Resource(name="userService")
	private UserService userService;
	@Test
	public void UserServiceTest() {
		/***Given***/
		String userid= "brown";

		/***When***/
		UserVo uservo= userService.selectUser(userid);

		/***Then***/
		assertEquals("브라운", uservo.getUsernm());
	}

	//전체 사용자 조회 테스트 
			@Test
			public void selectAllUsertest() {
				/***Given***/
				

				/***When***/
				List<UserVo> userList= userService.selectAllUser();
				

				/***Then***/
				assertEquals(16, userList.size());

			}
			
			//사용자 아이디를 이용하여 특정사용자 정보 조회
			@Test
			public void selectUserTest() {
				/***Given***/
				String userid= "brown";
				
				
				/***When***/
				UserVo user = userService.selectUser(userid);
				
				/***Then***/
				assertNotNull(user);
				assertEquals("브라운", user.getUsernm());
			}
			
			//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
			@Test
			public void selectUserNotExsistTest() {
				/***Given***/
			
				String userid= "brownNotexsist";
				
				/***When***/
				UserVo user = userService.selectUser(userid);
				
				/***Then***/
				assertNull(user);
				
			}

			@Test
			public void ModifyUserTest() {
				/***Given***/
				
				
				//userid usernm pass reg_gt alias addr1 addr2 zipcode 
				UserVo userVo = new UserVo("ddit","대덕인재","dditpass",new Date(),"개발원m","대전 중구 중앙로 76","4층 대덕인재개발원","34940","brown.png","uuid-generated-filename.png");
				
				/***When***/
				int updateCnt =userService.modifyUser(userVo);
				
				/***Then***/
				
				assertEquals(1,updateCnt);
				
			}
}
