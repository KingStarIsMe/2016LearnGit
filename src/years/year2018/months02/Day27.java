package years.year2018.months02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Day27 {
	public static void main(String[]args){
		testSystemClass();
	}
	public static void testSystemClass(){
		Map< String, String> evn = System.getenv();
		//遍历输出系统中所有的环境变量
		for(String name:evn.keySet()){
			System.out.println(name+"---"+evn.get(name));
		}
		//输出指定的系统环境变量
		System.out.println(System.getenv("JAVA_HOME"));
		
		Properties proper = System.getProperties();
		System.out.println(proper);
		try {
			File f = new File("C:\\Users\\Administrator\\Desktop\\SystemProperties.js");
			proper.store(new FileOutputStream(f), "System Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(proper.getProperty("os.name"));
		
	} 
}
