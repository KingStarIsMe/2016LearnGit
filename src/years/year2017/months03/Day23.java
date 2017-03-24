package years.year2017.months03;

import java.util.HashMap;
import java.util.Map;

public class Day23 {
	public static void main(String[]args){
		Day23 d = new Day23();
		
		int n=2;
		double base = 2;
		int exponent = -3;
		
		System.out.println(d.Power(base, exponent));
//		for(int i=1;i<100;i++){
//			System.out.println(--n);
//			System.out.println(Integer.toBinaryString(n));
//			System.out.println(Integer.toBinaryString(n*-1));
//			n=n<<1;
//			System.out.println(i>>>4);
////			System.out.println(d.NumberOf1_2(i)+"----"+i+"二进制包含1的次数");
//		}
	}
	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * @param n
	 * 用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
	 * @return
	 */
	 public int NumberOf1(int n) {
		 int count =0;
		 int temp = 1;
		 if(n>=0){
			 while(temp!=0 && temp<=n){
				 if((n&temp)!=0){
					 count ++;
				 }
				 temp=temp<<1;
			 }
		 }else{
			 while(temp!=0){
				 if((n&temp)!=0){
					 count ++;
				 }
				 temp=temp<<1;
			 }
		 }
		 
		 return count;
	 }
	 /**
	  * 每次与自己-1进行位的与运算直到将自身的数值清0为止
	  * @param n
	  * @return
	  */
	 public int NumberOf1_2(int n) {
		int count=0;
		System.out.println(Integer.toBinaryString(n)+"-----要进行判定的数据的二进制");
		while(n!=0){
			count++;
			System.out.println(Integer.toBinaryString(n-1));
			n=(n-1)&n;
		}
		return count;
	 }
	 /**
	  * 使用java提供的方法将int数据转为二进制字符串，然后将0替换除去，统计字符串长度
	  * @param n
	  * @return
	  */
	 public int NumberOf1_3(int n) {
		 return Integer.toBinaryString(n).replaceAll("0","").length(); 
	 }
	 /**
	  * 使用java提供的直接统计方法
	  * @param n
	  * @return
	  */
	 public int NumberOf1_4(int n) {
		 return Integer.bitCount(n);
	 }
	 /**
	  * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	  * @param base
	  * @param exponent
	  * @return
	  */
	 public double Power(double base, int exponent) {
		 double result = 1;
		 if(exponent<=-1){
			 result=result/(Power_positive(base, exponent*-1));
		 }else if(exponent==0){
			 return 1d;
		 }else{
			 result=Power_positive(base, exponent);
		 }
		 return result;
	 }
	 
	 /**
	  * 正数n次方计算
	  * @param base
	  * @param exponent
	  * @return
	  */
	 private double Power_positive(double base, int exponent){
		 if(exponent==1){
			 return base;
		 }
		 double result =1;
		 String exponentBinary = Integer.toBinaryString(exponent);
		 char[]binarys = exponentBinary.toCharArray();
		 int ls = binarys.length;
		 Map<Integer,Double> onePlaceData = new HashMap<Integer, Double>();
		 for(int i=0;i<ls;i++){
			 if(i==0){
				 onePlaceData.put(i,base);
			 }else{
				 onePlaceData.put(i,onePlaceData.get(i-1)*onePlaceData.get(i-1));
			 }
		 }
		 
		 for(int i=0;i<ls;i++){
			 if(binarys[i]=='1'){
				result=result* onePlaceData.get(i);
			 }
		 }
		 return result;
	 }
	 /**
	  * 负数n次方计算
	  * @param base
	  * @param exponent
	  * @return
	  */
	 private double Power_negative(double base, int exponent){
		double result =1;
		 
		return result;
	 }
	 public double Power2(double base, int exponent) {
			double r=1d;
			
			
			if(exponent==0){
				return 1d;
			}
			//exponent是否为负数
			boolean b = false;
			if(exponent<0){
				b=true;
				exponent=-exponent;
			}
			for(int i=0;i<exponent;i++){
				r=r*base;
			}
			if(b){
				r=1/r;
			}
			return r;
		}
}
