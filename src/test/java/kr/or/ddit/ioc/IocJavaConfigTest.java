package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.config.IocJavaConfig;
import kr.or.ddit.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IocJavaConfig.class})

public class IocJavaConfigTest {
	
	@Resource(name= "userServiceCons")
	private UserService userServiceCons;
	
	@Resource(name= "userService")
	private UserService userService;

	@Resource(name= "userService")
	private UserService userService2;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype2;
	
	@Resource(name= "dbConfig")
	private DbConfig dbConfig;
	
	
	//userServiceCons������ ���� ���������� �����Ǿ����� �׽�Ʈ

	@Test
	public void userServiceConsTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(userServiceCons);
	}
	@Test
	public void beanScopeTest() {
	
		// ������ ������ singleton�������� ���� �ΰ��� ��ü�� �� Ŭ������ ���� �������Ƿ� �����ؾ���
		//������ �������� singleton������ bean������Ʈ�� �������� �ϳ��� ��ü�� �����ȴ�.
		assertNotEquals(userService, userServiceCons);
		
	}
	
	@Test
	public void beanScopeTest2() {
	
		// ������ ������ ���� ���Թ޾����Ƿ�userService,userService2�� ���� ��ü��
		
		assertEquals(userService,userService2);
	}
	
	@Test
	public void ScopePrototypeTest2() {
		
		// ������ userServicePrototype���� ���� :(scope:prototype)
		
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
