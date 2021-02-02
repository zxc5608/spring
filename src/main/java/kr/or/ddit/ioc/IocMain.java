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
		 	1. ������ ���� ������ �̿��Ͽ� ������ �����̳ʸ� ����(kr/or/ddit/ioc/ioc/xml)
		 		������ �����̳� Ÿ��: ApplicationContext
		 	2. ������ �����̳ʿ��� ������� ������ ��(��ü)�� ��û
		 		DL(Dependency Lookup): ������ �����̳ʿ��� ������ ���� ��û�ϴ� ����
		 		
		 	3. ������ �����̳ʿ��� �����ǰ� �ִ� ���� �� ����� ������ Ȯ��
		 			 	
		 			 	ClassPathXmlApplicationContext()���������� ��ġ�� ���ڿ���
*/
		//�����������̿��ؼ� ������ �����̳� ���
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/ioc/ioc.xml");
		
		//DL
		UserDao userDao = (UserDao)context.getBean("userDao");
		UserVo userVo = userDao.selectUser("brown");
		logger.debug("userVo:{}",userVo);
		
		//������ �����̳ʷ� ���� userService������ ���� DL�� ���� ������
		//getUser�޼ҵ带 call, ��ȯ�� ��(UserVo)�� logger�� �������
		
		UserService userService  =(UserService)context.getBean("userService");
		userVo = userService.selectUser("brwon");
		logger.debug("userVo:{}",userVo);
		
		// context�� �ִ� bean�� ���� 
		for(String beanName : context.getBeanDefinitionNames()) {
			logger.debug("beanName:{}",beanName);
		}
		
	}
}
