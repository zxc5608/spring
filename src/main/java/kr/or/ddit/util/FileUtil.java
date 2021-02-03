package kr.or.ddit.util;

public class FileUtil {
	public static String getFileName(String contentDisposition) {
		
		String[] attrs = contentDisposition.split("; ");
		
		for(String attr: attrs) {
			if(attr.startsWith("filename=")) {
				attr=attr.replace("filename=","");
				return attr.substring(1,attr.length() -1);
			}
			System.out.println(attr);
		}
		return "";
	}
	
	public static String getFileExtension(String filename) {
		
		//line.brown.png
		
		
		return filename.substring(filename.lastIndexOf(".") +1 );
		
	}
	public static String getFileExtension1(String filename) {
		
		//brown
		if(filename.indexOf(".")== -1)
			return "";
		
		return "." + filename.substring(filename.lastIndexOf(".") +1 );
		
	}
}
