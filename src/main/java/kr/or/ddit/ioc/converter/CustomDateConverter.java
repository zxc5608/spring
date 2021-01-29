package kr.or.ddit.ioc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date> {
	
	private String dateFormat;
	
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	//source :2021-01-11 ,yyyy-mm-dd
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}

}
