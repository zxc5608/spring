package kr.or.ddit.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String process(UserVo uservo, HttpSession session) {
		logger.debug("uservo:{},",uservo);
		
		UserVo dbUser = userService.selectUser(uservo.getUserid());
		
		if(dbUser != null && uservo.getPass().equals(dbUser.getPass())) {
			session.setAttribute("S_USER", dbUser);
			return "main";
		}
		else {
			return "redirect:/login/view";
		}
		
	}
}
