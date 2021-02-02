package kr.or.ddit.user.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.service.UserService;
@RequestMapping("user")
@Controller
public class UserController {
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource(name = "userService")
	private UserService userService;
	/*
	 * UserServiceI userservice = new UserService();
	 * 
	 * List<UserVo>userlist= userservice.selectAllUser(); logger.debug("userid:{}");
	 * req.setAttribute("userlist", userlist);
	 * 
	 * req.getRequestDispatcher("/user/AllUser.jsp").forward(req, resp);
	 */
	
	@RequestMapping("AllUser")
	public String AllUser(Model model) {
		logger.debug("allusercont");
		List<UserVo>userList=userService.selectAllUser();
		model.addAttribute("userlist",userList);
		
		return "user/AllUser";
	}
}
