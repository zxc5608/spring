package kr.or.ddit.test.config;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(locations = {"classpath:/kr/or/ddit/config/spring/application-context.xml",
									"classpath:/kr/or/ddit/config/spring/datasource-context.xml",
									"classpath:/kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration       //스프링 환경을 Web기반의 application Context로 생성
@RunWith(SpringJUnit4ClassRunner.class)

public class WebTestConfig{
	
	@Autowired							
	private WebApplicationContext context;
	
	protected MockMvc mocmvc;
	
	@Before
	public void setup() {
		mocmvc= MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Ignore
	@Test
	public void dummy() {
		
	}
}
