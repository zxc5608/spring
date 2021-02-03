package kr.or.ddit.mvc.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.test.config.WebTestConfig;

public class MvcControllerTest extends WebTestConfig{
	
	@Test
	public void MvcControllerTest() throws Exception {
		mocmvc.perform(get("/mvc/fileupload/view"))
				.andExpect(view().name("file/view"))
				.andDo(print());
	}
	
	@Test
	public void fileuploadTest() throws Exception{
		ClassPathResource resource = new ClassPathResource("kr/or/ddit/upload/cony.png");
		
		MockMultipartFile file= new MockMultipartFile("picture", "cony.png","image/png",resource.getInputStream());
		
		mocmvc.perform(fileUpload("/mvc/fileupload/upload")
						.file(file)
						.param("userid", "brown"))
						.andExpect(view().name("file/view"))
						.andDo(print());
	}


	
}
