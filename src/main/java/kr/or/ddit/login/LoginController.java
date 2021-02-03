package kr.or.ddit.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("login")
@Controller
public class LoginController{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	//특정 파라미터의 값이 
	@RequestMapping(path="view",method = {RequestMethod.GET})
	public String view() {
		return "login";
	}

	/*
	 * @RequestMapping("process") public String process(String userid ,String pass,int price) {
	 * 
	 * logger.debug("userid:{}",userid);
	 * logger.debug("pass:{}",pass); logger.debug("price:{}",price);
	 * 
	 * return ""; }
	 */
	
	@RequestMapping(path="process" ,method= {RequestMethod.POST})
	public String process(UserVo uservo,HttpSession session, RedirectAttributes rda) {
		logger.debug("uservo:{},",uservo);
		
		UserVo dbUser = userService.selectUser(uservo.getUserid());
		
		if(dbUser != null && uservo.getPass().equals(dbUser.getPass())) {
			session.setAttribute("S_USER", dbUser);
			return "main";
		}
		else {
		
			//내부적으로 session을 사용하여 속성을 저장
			//리다이렉트 처리가 완료되면 스프링 프레임워크에서 자동으로 session에서 제거 
			rda.addFlashAttribute("msg", "잘못된사용자정보입니다");
			
			//일반 속성을 추가한 경우: addAttribute
			//리다이렉트 페이지의 파라미터로 전달된다
			rda.addAttribute("userid","brown");
			
			return "redirect:/login/view";
		}
		
	}
}
