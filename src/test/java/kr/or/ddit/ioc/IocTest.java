package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.service.UserService;

@ContextConfiguration(locations=
					{"classpath:/kr/or/ddit/ioc/ioc.xml",
					 "classpath:/kr/or/ddit/config/spring/datasource-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class IocTest {
	
	//@Resource(name="userService")
	//************************************************
	// 객체 이름을 변경시 Autowired가 실패하는 부분 추후 확인
	//************************************************
	@Autowired
	private UserService userService;
	
	@Resource(name="userService")
	private UserService userService2;
	
	@Resource(name="userServiceCons")
	private UserService userServiceCons;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype2;
	
	@Resource(name="dbConfig")
	private DbConfig dbConfig;

	// userServiceCons 스프링 빈이 정상적으로 생성 되었는지 테스트
	@Test
	public void userServiceConsTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(userServiceCons);
	}

	@Test
	public void beanScopeTest() {
		
		//디자인 패턴의 signleton 개념으로 보면 두개의 객체는 한 클래스로 부터 나왔으므로 동일 해야함
		//하지만 스프링의 singleon 개념은 bean 엘레멘트를 기준으로 하나의 객체가 생성된다
		assertNotEquals(userService, userServiceCons);		
	}
	
	@Test
	public void beanScopeTest2() {
		
		//동일한 스프링 빈을 주입받았으므로 userService, userService2는 같은 객체다
		assertEquals(userService, userService2);
	}
	
	@Test
	public void beanScopePrototypeTest() {
		//동일한 userServicePrototype 빈을 주입 (scope : prototype)
		assertNotEquals(userServicePrototype, userServicePrototype2);
	}
	
	@Test
	public void propertyPlaceholderTest() {
		assertNotNull(dbConfig);
		assertEquals("yongyong", dbConfig.getUsername());
		assertEquals("java", dbConfig.getPassword());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbConfig.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbConfig.getDriverClassName());
	}
}








