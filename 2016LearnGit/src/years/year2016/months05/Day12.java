package years.year2016.months05;

public class Day12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day12 d = new Day12() ;
		int[][]mat={{4,46,89},{28,66,99},{26,21,71}};//{{1,2,3},{4,5,6},{7,8,9}};
		d.clockwisePrint(mat, 3,3);
	}
	/**
	 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
	 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
	 * @param mat
	 * @param n
	 * @return
	 */
	public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
		int[][] arr = new int[n][n];
		int x=0;
		int y=0;
		for(int i=0;i<n;i++){
			y=0;
			for(int j=n-1;j>=0;j--){
				arr[x][y]=mat[j][i];
				y++;
			}
			x++;
		}
		return arr;
    }
	/**
	 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
	 * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
	 * @param mat
	 * @param n
	 * @param m
	 * @return
	 */
	public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
		int[]arr= new int[n*m];
		int index=0;
		int temp=0;
		
		return arr;
    }
}
