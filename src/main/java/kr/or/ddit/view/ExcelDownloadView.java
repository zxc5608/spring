package kr.or.ddit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.model.UserVo;

@RequestMapping
@Controller
public class ExcelDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition","attachement; filename=test.xlsx.");
		// header:List<String>
		// data:List<UserVo>
		
		List<String> header = (List<String>) model.get("header");
		List<UserVo> data = (List<UserVo>) model.get("data");
		
		//excel파일 생성 
		XSSFWorkbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("users");
//		행을 만들수있다
		int rownum=0;
		int colnum=0;
		Row row = sheet.createRow(rownum++);
		
		for(String h :header) {
			Cell cell=row.createCell(colnum++);
			cell.setCellValue(h);
		}
		//data
		
	
		
		for(UserVo user :data) {
			colnum=0;
			Row r=sheet.createRow(rownum++);
			r.createCell(colnum++).setCellValue(user.getUserid());
			r.createCell(colnum++).setCellValue(user.getUsernm());
			r.createCell(colnum++).setCellValue(user.getAlias());
		}
	
		//data는 나중에
		
		
		book.write(response.getOutputStream());
	}

}
