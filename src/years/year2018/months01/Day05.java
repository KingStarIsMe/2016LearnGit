package years.year2018.months01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day05 {
	public static void main(String[]args){
		Day05 d = new Day05();
//		String a="42342";
//		String b="42341";
//		System.out.println(b.compareTo(a));
		Scanner in = new Scanner(System.in);
		in.nextLine();
//		  while (in.hasNext()) {
//	            int n = in.nextInt();
//	            int[]arr=new int[n];
//	            for (int i = 0; i < n; i++) {
//	                arr[i]=in.nextInt();
//	            }
//	            d.printMaxNum(n, arr);
//		  }
		int n=2;
		int[]arr={12,123};
//		  d.printMaxNum(n, arr);
		ArrayList<Integer>a = new ArrayList<Integer>();
		a.add(12);
		a.add(123);
		  d.printMaxNum(a);
	}
	public static void getTreeHight(){
		Scanner s = new Scanner(System.in);
		//总节点数
		int l = s.nextInt();
		int pernetnode = 0;
		int node = 0;
		int hight = 0;
		for(int i=0;i<l;i++){
			pernetnode = s.nextInt();
			node = s.nextInt();
			
		}
		
	}
	/**
	 * 根据传入数字数组,去组合出最大的一个数字进行输出
	 * @param length 数组长度
	 * @param num 数字数组
	 */
	public void printMaxNum(int length,int[]num){		
		String[]nums = new String[length];
		for(int i=0;i<length;i++){
			nums[i]=num[i]+"";
		}
		String temp =""; 
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if((nums[i]+nums[j]).compareTo((nums[j]+nums[i]))<0){
					temp = nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
				
			}
		}
		StringBuilder max = new StringBuilder();
		for(int i=0;i<length;i++){
			max.append(nums[i]);
		}
		System.out.println(max);
	}
	/**
	 * 根据传入数字数组,去组合出最大的一个数字进行输出
	 * @param list
	 */
	public void printMaxNum(List<Integer> list){
		//
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String t1 = o1.toString();
				String t2 = o2.toString();
				return (t2+t1).compareTo(t1+t2);
				
			}
		};
		Collections.sort(list,c);
		StringBuffer s = new StringBuffer();
		for(int i:list){
			s.append(i);
		}
		System.out.println(s);
	}
	
	/**
	 * 获取文件的内容返回字符串
	 * @param url
	 * @return
	 */
	public String getFileDataInformation(String url){
		StringBuilder result = new StringBuilder();
		File file = new File(url);
		if(file.exists()){
			try {
				BufferedReader r = new BufferedReader(new FileReader(file));
				String temp = null;
				while((temp=r.readLine())!=null){
					result.append(System.getProperty("line.separator"))//换行
					.append(temp);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result.toString();
	}
	/**
	 * 将数据写入到文件中
	 * @param url
	 * @param data
	 */
	public void writerStringFile(String url,String data){
		File temp = new File(url);
		if(!temp.exists()){
			try {
				temp.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
			writer.write(data);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 字符串字符逆序
	 * @param data
	 * @return
	 */
	public String reverseString(String data){
		char[] charArr = data.toCharArray();
		int l = charArr.length;
		StringBuilder result = new StringBuilder();
		for(int i=l-1;i>=0;i--){
			result.append(charArr[i]);
		}
		return result.toString();
	}
	/**
	 * 字符串 词逆序
	 * @param data
	 * @return
	 */
	public static String reverseWord(String data){
		String[] wordArr = data.split(" ");
		int l = wordArr.length;
		StringBuilder result = new StringBuilder();
        result.append(wordArr[l-1]);
		for(int i=l-2;i>=0;i--){
			result.append(" ").append(wordArr[i]);
		}
		return result.toString();
	}
	
}
