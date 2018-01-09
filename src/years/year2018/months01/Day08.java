package years.year2018.months01;

import java.math.BigDecimal;
import java.util.Scanner;

public class Day08 {
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		String a= s.next();
		int b=s.nextInt();
		bigDiv(a, b);
	}
	/**
	 * 大数除法获取商和余数
	 * @param a
	 * @param b
	 */
	public static void bigDiv(String a,int b){
		StringBuilder result = new StringBuilder();
		char[] a_arr = a.toCharArray();
		int r1 = 0 ;//余数
		int temp = 0;//临时数据
		int tt = 0;
		boolean flag=true;
		for(int i=0;i<a_arr.length;i++){
			temp = r1*10+Integer.parseInt(String.valueOf(a_arr[i]));//余数*10+当前位的数
			tt=temp/b;//除以被除数
			//类似除法的进位,从第一位开始除,不能除尽则余数*10+下一位再与被除数做除法,直到最后一位数字
			if(flag&&tt==0){
				
			}else if(!flag||tt!=0){
				flag=false;
				result.append(tt);
			}
			r1 = temp% b;
		}
		System.out.println(result.toString()+" " +r1);
	}
	
}
