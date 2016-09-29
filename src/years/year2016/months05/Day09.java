package years.year2016.months05;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Day09 {
	public static void main(String args[]){
		
	}
	/**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * @param array
	 * @param target
	 * @return
	 */
	 public boolean Find(int [][] array,int target) {
		 boolean flag = false;
		 //二维数组的列长
		 int l1 = array.length-1;
		 int i=0;
		 //如果长度大于0，并且i值小于第一列的长度则继续循环运行
		 while(l1>=0 && i<array[0].length){
			 //如果最末位一行的第i列上值大于需要的值，则向上移动一行
			 if(array[l1][i]>target){
				 l1--;
			 //如果当前遍历行的首位小于当前值，则向右移动i值
			 }else if(array[l1][i]<target){
				 i++;
			//如果等于则返回true
			 }else{
				flag = true;
			 }
		 }
		 return flag;
	 }
	 private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	 private ArrayList<Integer> list = new ArrayList<Integer>();
	 /**
	  * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	  * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	  * @param root
	  * @param target
	  * @return
	  */
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 if(root == null){
			 return listAll; 
		 }
		 //把当前节点的值放入
		 list.add(root.val);
		 //将当前节点值从输入总数中减除
		 target -= root.val;
		 //判定当前值是否判定结束，判定是否整个树都遍历完成
		 if(target == 0 && root.left == null && root.right == null){
			 listAll.add(list);
		 }
		 //左节点遍历
		 FindPath(root.left, target);
		 //右节点遍历
		 FindPath(root.right, target);
		 //删除最后一个节点
		 list.remove(list.size()-1);
	     return listAll;
	 }
	 
	 public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
}
