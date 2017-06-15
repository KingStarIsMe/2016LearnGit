package years.year2017.months06;

public class Day09 {
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	/**
	 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
	 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
	 */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	for(int i=0;i<length;i++){
    		for(int j=length-1;j>i;j--){
    			if(numbers[i]==numbers[j]){
    				duplication[0]=numbers[i];
    				return true;
    			}
    		}
    	}
    	return false;
    }
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
    	int l =A.length;
    	int[]B=new int[l];
    	for(int i=0;i<l;i++){
    		B[i]=1;
    		for(int j=0;j<l;j++){
    			if(i!=j){
    				B[i]*=A[j];
    			}
    		}
    	}
    	return B;
    }
   
    
}
