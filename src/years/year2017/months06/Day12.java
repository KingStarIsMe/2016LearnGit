package years.year2017.months06;

public class Day12 {
	public static void main(String[]args){
		Day12 d = new Day12();
		String str = "123";
		d.StrToInt(str);
	}
	/**
	 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0 
	 * @param str
	 * @return
	 */
	public int StrToInt(String str) {
		if(str==null || str.length()==0){
			return 0;
		}
		char[]nums = str.toCharArray();
		int l = str.length();
		boolean plus = true;
		if(nums[0]=='-'){
			plus=false;
		}
		int sum = 0;
		for(int i=0;i<l;i++){
			if(i==0&&(nums[i]=='+'||nums[i]=='-')){
				continue;
			}
			if(nums[i]<48||nums[i]>57){
				return 0;
			}else{
				sum=sum*10+nums[i]-48;
			}
		}
		return plus?sum:sum*-1;
    }
	/**
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
	 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
	 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 * @param str
	 * @return
	 */
	 public boolean isNumeric(char[] str) {
		 
	        try{
	           Double.parseDouble(new String(str));
	        }catch(Exception e){
	           return false;
	        }
	        return true;
	        /*
		String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	         * */
	    }
}
