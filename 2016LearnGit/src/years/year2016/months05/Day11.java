package years.year2016.months05;

public class Day11 {
	public static void main(String[]args){
		Day11 d = new Day11();
//		String a =d.rotateString("ABCDEFGH",8,4);
//		System.out.println(a);
		int[][]arr={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		d.printMatrix(arr,4,3);
	}
	/**
	 * 对于一个字符串，和字符串中的某一位置，请设计一个算法，
	 * 将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
	 * 给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。
	 * @param A
	 * @param n
	 * @param p
	 * @return
	 */
    public String rotateString(String A, int n, int p) {
        // write code here
    	if(n==0||n<=p||p==0){
    		return A;
    	}else {
    		/*方法1
    		 A = A.substring(p+1, n)+A.substring(0,p+1);
    		return A;
    		*/
    		/*方法2*/
    		return (A+A).substring(p+1, n+p+1);
    	}
    }
    /**
     * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
     * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
     * @param mat
     * @param n
     * @param m
     * @return
     */
    public int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
    	int j=0;//进行数据遍历的基础变量
    	int [] arr=new int[m*n];//建立一个返回数组
    	int t=0;//记录数组添加的位置
    	//循环整个数组的列数
    	for(int i=0;i<n;i++){
    		//如果列中当前行小于行的长度-1则没打印完当前行，否则则为打印下一行
    		if(j<=m-1){
    			while(j<=m-1){
    				arr[t++]=mat[i][j++];
    			}
    		}else{
    			while(j>0){
    				arr[t++]=mat[i][--j];
    			}
    		}
    	}
    	return arr;
    }
}
