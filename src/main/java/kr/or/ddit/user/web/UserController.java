package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileUtil;
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
	@RequestMapping("AllUserTiles")
	public String AllUserTiles(Model model) {
		logger.debug("allusercont");
		List<UserVo>userList=userService.selectAllUser();
		model.addAttribute("userlist",userList);
		
		return "tiles.user.AllUser";
	}
	
	@RequestMapping("pagingUser")
	public String pagingUser(@RequestParam(defaultValue = "1") int page,
							 @RequestParam(defaultValue = "5") int pageSize,
							 Model model) {
		logger.debug("page:{},pageSize:{}",page,pageSize);
		
		PageVo pageVo= new PageVo(page,pageSize);
		
		
		model.addAllAttributes(userService.selectpagingUser(pageVo));
	
		
		return "user/pagingUser";
	
	}
	
	@RequestMapping("pagingUserTiles")
	public String pagingUserBody(@RequestParam(defaultValue = "1") int page,
							 @RequestParam(defaultValue = "5") int pageSize,
							 Model model) {
		logger.debug("page:{},pageSize:{}",page,pageSize);
		
		PageVo pageVo= new PageVo(page,pageSize);
		
		
		model.addAllAttributes(userService.selectpagingUser(pageVo));
	
		
		return "tiles.user.pagingUser";
	}
	
	//사용자 리스트가 없는 상태의 화면만 응답으로 생성
	@RequestMapping("pagingUserAjaxView")
	public String pagingUserAjaxView() {
		return "tiles.user.pagingUserAjax";
	}
	
	
//	Ajax
	@RequestMapping("pagingUserAjax")
	public String pagingUserAjax(@RequestParam(defaultValue = "1") int page,
							 @RequestParam(defaultValue = "5") int pageSize,
							 Model model) {
		logger.debug("page:{},pageSize:{}",page,pageSize);
		
		PageVo pageVo= new PageVo(page,pageSize);
		
		model.addAllAttributes(userService.selectpagingUser(pageVo));
		
		return "jsonView";
	}
	
	@RequestMapping("pagingUserAjaxHtml")
	public String pagingUserAjaxHtml(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int pageSize,
			Model model) {
		logger.debug("page:{},pageSize:{}",page,pageSize);
		
		PageVo pageVo= new PageVo(page,pageSize);
		
		model.addAllAttributes(userService.selectpagingUser(pageVo));
		
		return "user/pagingUserAjaxHtml";
	}
	
	/*
	 * pagingUserAjaxHtml=> /WEB-INF/views/user/pagingUserAjaxHtml.jsp
	 */
	
	
	
	//@RequestMapping("pagingUser")
	public String pagingUser(PageVo pageVo) {
		
		logger.debug("pageVo:{}",pageVo);
		
		return "";
	}
	
	
	
	@RequestMapping("userTiles")
	public String userControllerTiles(@RequestParam String userid,Model model ) {
		
		UserVo user= userService.selectUser(userid);
		
		model.addAttribute("user",user);
		
		return "tiles.user.user";
		
	}
	@RequestMapping("user")
	public String userController(@RequestParam String userid,Model model ) {
		
		UserVo user= userService.selectUser(userid);
		
		model.addAttribute("user",user);
		
		return "user/user";
		
	}
	@RequestMapping(path="userModify", method= RequestMethod.GET)
	public String userModify(@RequestParam String userid , Model model) {
		
		model.addAttribute("user",userService.selectUser(userid));
		return "user/userModify";
	}
	
	
	@RequestMapping(path="userModify",method=RequestMethod.POST)
	public String userModify(UserVo userVo, MultipartFile profile,String ifilename, String irealfilename,  PageVo pageVo, Model model) {
		String filename="";
		String realfilename="";
		
		if(profile.getSize()>0) {
			filename= profile.getOriginalFilename();
			String fileExtention = FileUtil.getFileExtension1(filename);
			realfilename=UUID.randomUUID().toString()+fileExtention;
			
			try {
				profile.transferTo(new File("d:\\upload\\"+realfilename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userVo.setFilename(filename);
			userVo.setRealfilename(realfilename);
			int file1= userService.modifyUser(userVo);
		}
		else {
			userVo.setFilename(ifilename);
			userVo.setRealfilename(irealfilename);
			userService.modifyUser(userVo);
		}
		
		int pageSize=5;
		int page=1;
		
		if(pageVo.getPageSize()==0) {
			pageVo.setPageSize(pageSize);
		}
		if(pageVo.getPage()==0) {
			pageVo.setPage(page);
		}
		model.addAllAttributes(userService.selectpagingUser(pageVo));

		
		
		return "user/pagingUser";
	}
	@RequestMapping("deleteUser")
	public String deleteUser(@RequestParam String userid,Model model,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int pageSize) {
		
		model.addAttribute("userid",userService.deleteUser(userid));
		
		PageVo pageVo= new PageVo(page,pageSize);
		
		
		model.addAllAttributes(userService.selectpagingUser(pageVo));
	
		
		return "user/pagingUser";
	}

	@RequestMapping(path="registUser", method=RequestMethod.GET)
	public String registUserview() {
		//return "user/registUser";
		return "tiles.user.registUser";
	}
	
	//bindingresult객체는 command객체 바로 뒤에 인자로 기술해야한다
	@RequestMapping(path="registUser", method=RequestMethod.POST)
	public String registUser(@Valid UserVo userVo,BindingResult result, MultipartFile profile,Model model) {
		
		//new UserVoValidator().validate(userVo, result);
		
		if(result.hasErrors()) {
			logger.debug("result has error");
			return "user/registUser";
		}
		
		String filename= profile.getOriginalFilename();
		String fileExtension=FileUtil.getFileExtension1(filename);
		String realfilename= UUID.randomUUID().toString()+fileExtension;
		userVo.setFilename(filename);
		userVo.setRealfilename(realfilename);
		
		try {
			profile.transferTo(new File("d:\\upload\\"+realfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int insertCnt= 0;
		logger.debug("insertCnt:{}",insertCnt);
		try {
			insertCnt=userService.registUser(userVo);
			
		} catch (Exception e) {
			insertCnt=0;
		}
		
		if(insertCnt ==1) {
			return "redirect:/user/pagingUser";
		}else {
			
			return "user/registUser";
		}
		
		
	}
	@RequestMapping("excelDownload")
	public String excelDownload(Model model) {
		List<String> header =new ArrayList<String>();
		header.add("사용자 아이디");
		header.add("사용자 이름");
		header.add("사용자 별명");
		
		model.addAttribute("header",header);
		model.addAttribute("data",userService.selectAllUser());
		
		return "userExcelDownloadView";
		
	}
	//localhost/user/profile
	@RequestMapping("profile")
	public void profile(HttpServletResponse resp,String userid,HttpServletRequest req) {
		
		resp.setContentType("image");
		
		
		UserVo uservo =userService.selectUser(userid);
		String path="";
		
		if(uservo.getRealfilename() == null) {
			path = req.getServletContext().getRealPath("/image/unknown.png");
		}
		else {
			path= uservo.getRealfilename();			
		}
		
		logger.debug("path : {}",path);
		try {
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = resp.getOutputStream();
			
			byte[]buff=new byte[512];
			while(fis.read(buff)!= -1) {
				sos.write(buff);
			}
			fis.close();
			sos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping("profileDownload")
	public void profileDownload(HttpServletResponse resp,String userid,HttpServletRequest req) {
		
		UserVo uservo =userService.selectUser(userid);
		
		resp.setHeader("Content-Disposition","attachement; filename="+uservo.getFilename());
		resp.setContentType("image");
		String path="";
		
		if(uservo.getRealfilename() == null) {
			path = req.getServletContext().getRealPath("/image/unknown.png");
		}
		else {
			path="d:\\upload\\"+ uservo.getRealfilename();			
		}
		
		logger.debug("path : {}",path);
		try {
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = resp.getOutputStream();
			
			byte[]buff=new byte[512];
			while(fis.read(buff)!= -1) {
				sos.write(buff);
			}
			fis.close();
			sos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	} 

	
}