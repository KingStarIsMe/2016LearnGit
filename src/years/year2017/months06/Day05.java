package years.year2017.months06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day05 {
	public static void main(String[]args){
		int[]input = {4,5,1,6,2,7,3,8};
		int k=4;
		Day05 d = new Day05();
//		d.GetLeastNumbers_Solution(input, k);
		int[]array={6,-3,-2,7,-15,1,2,2}; 
//		d.FindGreatestSumOfSubArray(array);
//		d.GetUglyNumber_Solution(2);
		String str="NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
		d.FirstNotRepeatingChar(str);
		
	}
	/**
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = input.length;
        if(l<k){
        	return new ArrayList<Integer>();
        }
        for(int i=0;i<l;i++){
        	if(i<k){
        		if(stack.empty() || stack.peek()<=input[i]){
        			stack.add(input[i]);
        		}else{
        			adjustStack(stack, input[i],k);
        		}
        	}else{
        		if(stack.size()>=k&&stack.peek()>input[i]){
        			stack.pop();
        			adjustStack(stack, input[i],k);
        		}
        		
        	}
        }
        ArrayList<Integer> data = new ArrayList<Integer>(stack);  
        return data;
    }
	/**
	 * 调整栈中数据位置
	 * @param stack
	 * @param data
	 */
	public void adjustStack(Stack<Integer> stack,int data,int k){
		if(stack.empty()){
			stack.push(data);
			return;
		}else{
			int t = stack.peek();
			if(t>data){
				stack.pop();
				adjustStack(stack, data,k);
				stack.push(t);
			}else{
				stack.push(data);
				return;
			}
		}
	}
	/**
	 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
	 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,
	 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
	 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 你会不会被他忽悠住？(子向量的长度至少是1)
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
        
        int l=array.length;
        if(l==0){
        	return 0;
        }
        //定义数组存放每一个点能产生的连续加合的最大值
        int [] temp =  new int[l];
        temp[0] = array[0];
        int max = temp[0];
        for(int i=1;i<l;i++){
        	//如上一个节点的最大值大于0则当前节点的最大值是上一个节点+当前节点的值
        	if(temp[i-1]>0){
        		temp[i]=temp[i-1]+array[i];
        	}else{
        		//如上一个节点最大值小于0则当前节点的最大值为当前节点
        		temp[i]=array[i];
        	}
        	if(max<temp[i]){
        		max=temp[i];
        	}
        }
        return max;
    }
	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
	 * @param numbers
	 * @return
	 */
	public String PrintMinNumber(int [] numbers) {
		int l= numbers.length;
		if(l==0){
			return "";
		}
		String[]ss = new String[l];
		for(int i=0;i<l;i++){
			ss[i]=String.valueOf(numbers[i]);
		}
		/**
		 * 通过自定义的String排序方式对数组做排序
		 */
		Arrays.sort(ss,new Comparator<String>() {
			public int compare(String s1,String s2){
				//两个字符串相连后取小的数值排在前面
				String t1 = s1+s2;
				String t2 = s2+s1;
				return t1.compareTo(t2);
			}
		});
		StringBuilder s = new StringBuilder();
		for(int i=0;i<l;i++){
			s.append(ss[i]);
		}
		return s.toString();
	}
	/**
	 * 丑数
	 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
	 * 习惯上我们把1当做是第一个丑数。
	 * 求按从小到大的顺序的第N个丑数。
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {
		if(index<=1){
			return 1;
		}
		int[]uglys = new int[index];
		int count=0;
		int i2=0;
		int i3=0;
		int i5=0;
		uglys[0]=1;
		int temp = 0;
		while(count<index-1){
			temp = Math.min(uglys[i2]*2, Math.min(uglys[i3]*3, uglys[i5]*5));
			if(temp==uglys[i2]*2)i2++;
			if(temp==uglys[i3]*3)i3++;
			if(temp==uglys[i5]*5)i5++;
			uglys[++count]=temp;
		}
		return uglys[index-1];
	}
	/**
	 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
	 * @param str
	 * @return
	 */
	public int FirstNotRepeatingChar(String str) {
		  if(str.equals("")&&str==null)return -1;
	        char[] ch = str.toCharArray();
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        for(int i=0;i<ch.length;i++){
	            if(map.get(ch[i])!=null){
	                map.put(ch[i],map.get(ch[i])+1);
	            }else{
	                map.put(ch[i],1);
	            }
	        }
	        for(int i=0;i<ch.length;i++){
	            if(map.get(ch[i])==1)return i;
	        }
	        return -1;
    }
}
