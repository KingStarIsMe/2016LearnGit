package years.year2016.months11;

import java.io.File;

import years.year2016.months10.WebUtil;

public class Day17 {
	public static void main(String[]args){
		String dir = "\\MX5\\手机存储";
		File f = new File(dir);
		if(f.exists()){
			if(f.isFile()){
				
			}else{
				for(File file:f.listFiles()){
					System.out.println(file.getName()+" : "+WebUtil.getFileSize(file)+"MB");
				}
			}
		}else{
			System.out.println("文件不存在");
		}
	}
}
