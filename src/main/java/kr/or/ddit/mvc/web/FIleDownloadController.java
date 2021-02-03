package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("file")
@Controller
public class FIleDownloadController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/fileDownloadView")
	public String fileDownloadView(String userid, Model model) {
		//1. file다운로드 파일의 경로 ==> realfilename
		//2. 다운로드시 보여줄 파일명 ==>filename
		//1,2를 model에 넣어준다
		// userid 파라미터를 보낸다고 가정
		// 파라미터를 이용하려 해당 사용자의 사진정보(realFilename, filename)을 조회하여 처리
		
		UserVo userVo=userService.selectUser(userid);
		model.addAttribute("realfilename",userVo.getRealfilename());
		model.addAttribute("filename",userVo.getFilename());
		
		return "fd";
	}
	@RequestMapping("fileDownload")
	public void fileDownload(HttpServletResponse response,String userid) {
		UserVo userVo= userService.selectUser(userid);
		
		// d:\\upload\\sally.png
		String realfilename = (String) userVo.getRealfilename();
		String filename = (String) userVo.getFilename();

		response.setHeader("Content-Disposition","attachement; filename="+filename);
				
		ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
			FileInputStream fis = new FileInputStream(new File(realfilename));
			byte[] buf= new byte[512];
			
			while(fis.read(buf)!= -1) {
				sos.write(buf);
			}
			fis.close();
			sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
}
