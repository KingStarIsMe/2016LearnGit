package years.year2018.months01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Day09 {
	 public static void main(String[]args){
			
		}
	 /**
	  * 猜拳游戏
	  */
	 public static void guessingGame(){
		 Scanner s = new Scanner(System.in);
			String data = "";
			int winA=0;
			int winB=0;
			int failA=0;
			int failB=0;
			int drawA=0;
			int drawB=0;
			Map<String,Integer> mapWinA = new HashMap<String,Integer>();
			mapWinA.put("C",0);
	        mapWinA.put("B",0);
	        mapWinA.put("J",0);
			Map<String,Integer> mapWinB = new HashMap<String,Integer>();
			mapWinB.put("C",0);
	        mapWinB.put("B",0);
	        mapWinB.put("J",0);
			int num = Integer.parseInt(s.nextLine());
			//C代表“锤子”、J代表“剪刀”、B代表“布”
			for(int i=0;i<num;i++){
				data = s.nextLine();
				if("C J".equals(data)
					||"J B".equals(data)
				||"B C".equals(data)
					){
					String A = data.substring(0,1);
					mapWinA.put(A,mapWinA.get(A)+1);
					winA++;
					failB++;
				}else if("C C".equals(data)
					||"J J".equals(data)
				||"B B".equals(data)
					){
					drawA++;
					drawB++;
				}else if(
				"J C".equals(data)
				||"B C".equals(data)
				||"C B".equals(data)
				){
					String B = data.substring(2,3);
					mapWinB.put(B,mapWinB.get(B)+1);
					winB++;
					failA++;
				}
			}
			System.out.println(winA+" "+ drawA+" "+failA);
			System.out.println(winB+" "+ drawB+" "+failB);	
			System.out.println(getMaxValueKey(mapWinA)+" "+getMaxValueKey(mapWinB));
	 }
		public static String getMaxValueKey(Map<String,Integer> map){
			int C=map.get("C");
			int J=map.get("J");
			int B=map.get("B");
			int max=Math.max(C, Math.max(J,B));
			if(B==max){
				return "B";
			}else if(C==max){
				return "C";
			}else{
				return "J";
			}
		}
}
