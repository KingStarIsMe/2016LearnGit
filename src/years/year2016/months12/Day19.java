package years.year2016.months12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day19 {
	public static void main(String[]args){
		Day19 d = new Day19();
		String content ="Talk is cheap. Show me the code.--Linus Torvalds as sss"; 
//		d.getStringWordNum(content);
		Map<String,Integer> map = d.statisticsWordShowCount(content);
		for(String word : map.keySet()){
			System.out.println("word is "+word + " ; wordnum is"+map.get(word));
		}
	}
	public void getFileTxtString(String path) throws IOException{
		File f = new File(path);
		if(!f.exists()){
			throw new RuntimeException("文件不存在");
		}
		BufferedReader r = new BufferedReader(new FileReader(f));
		String stemp=null;
		StringBuffer str = new StringBuffer();
		while((stemp=r.readLine())!=null){
			str.append(stemp);
		}
		r.close();
		
	}
	/**
	 * 根据传入字符串，返回字符串中单词出现个数
	 * @param content
	 * @return
	 */
	public Map<String,Integer> statisticsWordShowCount(String content){
		String[]words = content.split("\\b\\w+\\b", 0);
		Map<String,Integer> wordsmap = new HashMap<String, Integer>();
		int l = words.length;
		for(int i=0;i<l;i++){
			if(wordsmap.containsKey(words[i])){
				wordsmap.put(words[i], 1);
			}else{
				wordsmap.put(words[i], wordsmap.get(words[i])+1);
			}
		}
		return wordsmap;
	}
	/**
	 * 获取传入字符串中的单词个数
	 * @param content
	 * @return
	 */
	public int getStringWordNum(String content){
		int num=0;
		Pattern pattern = Pattern.compile("\\b\\w+\\b");
		Matcher m = pattern.matcher(content);
		while(m.find()){
			num++;
		}
		System.out.println(num);
		return num;
	}
}
