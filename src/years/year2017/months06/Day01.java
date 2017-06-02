package years.year2017.months06;

import java.util.ArrayList;

public class Day01 {
	/**
	 * 计算数值的n次方	
	 * @param base
	 * @param exponent
	 * @return
	 */
	 public double Power(double base, int exponent) {
	        return Math.pow(base, exponent);
	  }
	 /**
	  * 输入两棵二叉树A，B，判断B是不是A的子结构
	  * （ps：我们约定空树不是任意一个树的子结构）
	  * @param root1
	  * @param root2
	  * @return
	  */
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 boolean flag=false;
		 //空树不是任意一个树的子结构
	        if(root2==null){
	        	return flag;
	        }else{
	        	//B树不为空，A树为空，则B不是A的子树
	        	if(root1==null){
	        		return flag;	
		        }	
	        }
	        //A树的值与B树的值相等
	        if(root1.val==root2.val){
	        	//判定AB子树是否一致
	        	flag = isSubTree(root1, root2);
	        }
	        //树2不是直接树1的子结构
	        if(!flag){
	        	//判定树2是否是树1左子树的子结构
	        	 flag = HasSubtree(root1.left, root2);
	             if(!flag){
	            	 //判定树2是否为树1右子树的子结构
	                 flag = HasSubtree(root1.right, root2);
	             }
	        }
	        return flag;
	  }
	 /**
	  * 树2是否为树1的子结构
	  * @param root1
	  * @param root2
	  * @return
	  */
	 public boolean isSubTree(TreeNode root1,TreeNode root2){
		 //B树如果为空则B树为A树子树
	        if(root2==null){
	        	return true;
	        }else{
	        	//B树不为空A树为空则B不是A的子树
	        	if(root1==null){
	        		return false;	
		        }	
	        }
	        //A树和B树的值相等
	        if(root1.val==root2.val){
	        	//判定A，B树的左右子树是否能一直返回true；能则B子树在A子树中存在，B为A的子结构
	            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
	        }else{
	        return false;
	        }
	 }
	 public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }
	 }
	 ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	 /**
	  * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	  * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	  * @param root 二叉树
	  * @param target 求和数
	  * @return
	  */
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 if(root == null ) return listAll;
		 findPath(new ArrayList<Integer>(), root, target);
		 return listAll;
	}
	 /**
	  * 
	  * @param path
	  * @param node
	  * @param target
	  */
	public void findPath(ArrayList<Integer>path,TreeNode node,int target){
		if(node==null){
			return;
		}
		path.add(node.val);
		target -= node.val;
		if(node.left==null&&node.right==null){
			if(target==0){
				listAll.add(path);
			}
			return;
		}
		ArrayList<Integer>temp = new ArrayList<Integer>();
		temp.addAll(path);
		findPath(path, node.left, target);
		findPath(temp, node.right, target);
	}
}
