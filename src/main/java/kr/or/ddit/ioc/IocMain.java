package kr.or.ddit.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;
public class IocMain {
	private static final Logger logger = LoggerFactory.getLogger(IocMain.class);
	public static void main(String[] args) {
/*
		 	1. 스프링 설정 파일을 이용하여 스프링 컨테이너를 생성(kr/or/ddit/ioc/ioc/xml)
		 		스프링 컨테이너 타입: ApplicationContext
		 	2. 스프링 컨테이너에게 만들어진 스프링 빈(객체)을 요청
		 		DL(Dependency Lookup): 스프링 컨테이너에게 스프링 빈을 요청하는 과정
		 		
		 	3. 스프링 컨테이너에서 관리되고 있는 빈이 잘 만들어 졌는지 확인
		 			 	
		 			 	ClassPathXmlApplicationContext()설정파일의 위치를 문자열로
*/
		//설정파일을이용해서 스프링 컨테이너 등록
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/ioc/ioc.xml");
		
		//DL
		UserDao userDao = (UserDao)context.getBean("userDao");
		UserVo userVo = userDao.getUser("brown");
		logger.debug("userVo:{}",userVo);
		
		//스프링 컨테이너로 부터 userService스프링 빈을 DL을 통해 얻어오고
		//getUser메소드를 call, 반환된 값(UserVo)을 logger를 통해출력
		
		UserService userService  =(UserService)context.getBean("userService");
		userVo = userService.getUser("brwon");
		logger.debug("userVo:{}",userVo);
		
		// context에 있는 bean을 찍어보자 
		for(String beanName : context.getBeanDefinitionNames()) {
			logger.debug("beanName:{}",beanName);
		}
		
	}
}
