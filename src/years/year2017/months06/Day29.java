package years.year2017.months06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day29 {
	public static void main(String[]args){
		System.out.println(11/2);
	}
	int count=0;
	List<Integer> list = new ArrayList<Integer>();
	public void Insert(Integer num) {
	    count++;
	    list.add(num);
    }
	/**
	 * 题目描述:
	 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	 * @return
	 */
    public Double GetMedian() {
    	Collections.sort(list);
        if(count%2==1){
        	//奇数
        	int index=count/2;
        	return Double.valueOf(list.get(index));
        }else{
        	//偶数
        	int index1 = count/2;
        	int index2 = count/2+1;
        	return (Double.valueOf(list.get(index1))+Double.valueOf(list.get(index2)))/2;
        }
    }
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
     * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int l = num.length;
		if(l<size || size<=0){
			
		}else{
			int count = l-size;
			for(int i=0;i<=count;i++){
				list.add(getMaxInWindows(num, i, size));
			}
	  
		}
		return list;
    }
    public int getMaxInWindows(int[]num,int start,int size){
    	int max = num[start];
    	for(int i=start,l=start+size;i<l;i++){
    		max = max>num[i]?max:num[i];
    	}
    	return max;
    }
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     *  例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
     *  但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     *  路径不能再次进入该格子。
     * @param matrix 用来充当矩阵的数组
     * @param rows 行数
     * @param cols 列数
     * @param str 要寻找的字符串
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null || matrix.length==0
        		|| str==null || str.length==0 
        		|| matrix.length!=rows*cols 
        		|| rows<=0 || cols<=0 || rows*cols < str.length) {
            return false ;
        }
 
        boolean[] visited = new boolean[rows*cols] ;
        int[] pathLength = {0} ;
 
        for(int i=0 ; i<=rows-1 ; i++) {
            for(int j=0 ; j<=cols-1 ; j++) {
                if(hasPathCore(matrix, rows, cols, str, i, j, visited, pathLength)) { return true ; }
            }
        }
 
        return false ;
    }
     
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int[] pathLength) {
        boolean flag = false ;
 
        if(row>=0 && row<rows 
        		&& col>=0 && col<cols 
        		&& !visited[row*cols+col] 
        		&& matrix[row*cols+col]==str[pathLength[0]]) {
            pathLength[0]++ ;
            visited[row*cols+col] = true ;
            if(pathLength[0]==str.length) { return true ; }
            flag = hasPathCore(matrix, rows, cols, str, row, col+1, visited, pathLength)  ||
                   hasPathCore(matrix, rows, cols, str, row+1, col, visited, pathLength)  ||
                   hasPathCore(matrix, rows, cols, str, row, col-1, visited, pathLength)  ||
                   hasPathCore(matrix, rows, cols, str, row-1, col, visited, pathLength) ;
            if(!flag) {
                pathLength[0]-- ;
                visited[row*cols+col] = false ;
            }
        }
 
        return flag ;
    }
     
}
