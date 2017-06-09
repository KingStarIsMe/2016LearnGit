package years.year2017.months06;

import java.util.ArrayList;

public class Day08 {
	public static void main(String[]args){
		int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		 int sum=21;
		 Day08 d = new Day08();
//		 d.FindNumbersWithSum(array, sum);
		 int num1=5,num2=15;
		 d.Add(num1, num2);
	}
	/**
	 * 入一个递增排序的数组和一个数字S，在数组中查找两个数，
	 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		int length=array.length;
		ArrayList<Integer> list = new ArrayList<Integer>(2);
		if(length==0){
			return list;
		}
		int l = 0;
		int r = length-1;
		while(l!=r && l<length && l<r){
			//如左端加上有端数据与要求值相等，则将数值保留，并验证是否之前的数值之积大于当前值如大于则替换，并更新左右索引
			if((array[l]+array[r])==sum){
				if(list.isEmpty()){
					list.add(array[l]);
					list.add(array[r]);
				}else{
					if((array[l]*array[r])<(list.get(0)*list.get(1))){
						list.set(0, array[l]);
						list.set(1, array[r]);
					}
				}
				l++;
				r--;
			}else if((array[l]+array[r])>sum){
				//如当前值大于最终要求值则对右端索引向左移动
				r--;
			}else if((array[l]+array[r])<sum){
				//如当前值小于最终要求值则对左端索引向右移动
				l++;
			}
			
		}
		return list;
    }
	/**
	 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
	 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
	 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
	 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
		if(str.trim().length()==0){
			return str;
		}
        String[]strtemp = str.split(" ");
        StringBuilder s = new StringBuilder();
        int l=strtemp.length;
        for(int i=l-1;i>=0;i--){
        	s.append(strtemp[i]);
        	if(i>0){
        		s.append(" ");
        	}
        }
        return s.toString();
    }
	/**
	 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
	 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！
	 * ！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
	 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”
	 * (大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 
	 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
	 * @param numbers
	 * @return
	 */
	 public boolean isContinuous(int [] numbers) {
		 int l = numbers.length;
		 if(l<=1){
			 return true;
		 }
		 int[]num_count =new int[14];
		 int max = -1;
		 int min = 14;
		 for(int i=0;i<l;i++){
			 if(numbers[i]==0){
				 num_count[0]++;
			 }else{
				 num_count[numbers[i]]++;
				 if(num_count[numbers[i]]>=2){
					 return false;
				 }
				 if(min>numbers[i]){
					min=numbers[i];
				 }else if(max<numbers[i]){
					max=numbers[i];
				 }
			 }
		 }
		 if(max-min>=5){
			 return false;
		 }
		 return true;
    }
	 /**
	  * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
	  * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
	  * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
	  * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
	  * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
	  * @param n
	  * @param m
	  * @return
	  */
	public int LastRemaining_Solution(int n, int m) {
		 if(n<1||m<1) return -1;
	        int[] array = new int[n];
	        int i = -1,step = 0, count = n;
	        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
	            i++;          //指向上一个被删除对象的下一个元素。
	            if(i>=n) i=0;  //模拟环。
	            if(array[i] == -1) continue; //跳过被删除的对象。
	            step++;                     //记录已走过的。
	            if(step==m) {               //找到待删除的对象。
	                array[i]=-1;
	                step = 0;
	                count--;
	            }        
	        }
	        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
	}
	/**
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 * @param n
	 * @return
	 */
	 public int Sum_Solution(int n) {
	        int sum=n;
	        boolean a=(n>0)&&((sum+=Sum_Solution(n-1))>0);
	        return sum;
	    }
	 /**
	  * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	  * @param num1
	  * @param num2
	  * @return
	  */
	 public int Add(int num1,int num2) {
		  while (num2!=0) {
	            int temp = num1^num2;
	            num2 = (num1&num2)<<1;
	            num1 = temp;
	        }
	        return num1;
	 }
	 public int StrToInt(String str) {
		 return Integer.valueOf("1123");
	 }
}
