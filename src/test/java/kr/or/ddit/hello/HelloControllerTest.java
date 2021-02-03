package kr.or.ddit.hello;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.test.config.WebTestConfig;

/*
 * java- gui swing, awt ,java fx, swt
 */

public class HelloControllerTest extends WebTestConfig{
	
	//@Resource(name= "helloController")
	//스프링 빈중에 대입 가능한 타입의 스프링 빈을 주입한다
	//만약 동일한 타입의 스프링 빈이 여러개 있을경우 @Qulofier 어노테이션을 통해
	// 특정 스프링 빈의 이름을 지칭할수 있다. 
	// ==> @Resource(name="userService")
	//***************************************
	
	

	
	// localhost/hello/view
	@Test
	public void ViewTest() throws Exception{
			// get을 실행하겟다             어떤상태인지 기대
		
		MvcResult mvcResult = mocmvc.perform(get("/hello/view"))
										.andExpect(status().isOk())
										.andExpect(view().name("hello"))
										.andExpect(model().attributeExists("userVo"))
										.andDo(print())
										.andReturn();

		
		ModelAndView mav= mvcResult.getModelAndView();
		
		assertEquals("hello", mav.getViewName());
		UserVo uservo=(UserVo)mav.getModel().get("userVo");
		assertEquals("브라운",uservo.getUsernm());
		
		
		
	}
	@Test
	public void pathVariableTest() throws Exception{
		MvcResult mvcResult = mocmvc.perform(get("/hello/path/cony"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("subpath"))
				.andDo(print())
				.andReturn();
	}

}
