package years.year2017.months03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day17 {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int length = pre.length;
		if (length == 0) {
			return null;
		}
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<length;i++){
			map.put(in[i], i);
		}
		TreeNode root = createBinaryTree_map(pre, 0, length - 1, in, 0, length - 1,map);
		return root;
	}
	/**
	 * 重建二叉树的方法
	 * @param front
	 * @param fstart
	 * @param fend
	 * @param middle
	 * @param mstart
	 * @param mend
	 * @return
	 */
	private TreeNode createBinaryTree_for(int[] front, int fstart, int fend,
			int[] middle, int mstart, int mend) {
		int rootval = front[fstart];
		TreeNode root = new TreeNode(rootval);
		root.left = null;
		root.right = null;
		if (fstart == fend) {
			return root;
		}
		int index_m = 0;
		//获取前序中树根在中序中的位置
		for (int i = mstart; i <= mend; i++) {
			if (rootval == middle[i]) {
				index_m = i;
				break;
			}
		}
		int lleft = index_m - mstart;
		int lright = mend - index_m;
		if (lleft > 0) {
			root.left = createBinaryTree_for(front, fstart + 1, fstart + lleft,
					middle, mstart, index_m - 1);
		}
		if (lright > 0) {
			root.right = createBinaryTree_for(front, fstart + lleft + 1, fend,
					middle, index_m + 1, mend);
		}
		return root;
	}
	private TreeNode createBinaryTree_map(int[] front, int fstart, int fend,
			int[] middle, int mstart, int mend, Map<Integer,Integer >map) {
		int rootval = front[fstart];
		TreeNode root = new TreeNode(rootval);
		root.left = null;
		root.right = null;
		if (fstart == fend) {
			return root;
		}
		//获取前序中树根在中序中的位置
		int index_m = map.get(rootval);
		
		int lleft = index_m - mstart;
		int lright = mend - index_m;
		if (lleft > 0) {
			root.left = createBinaryTree_map(front, fstart + 1, fstart + lleft,
					middle, mstart, index_m - 1,map);
		}
		if (lright > 0) {
			root.right = createBinaryTree_map(front, fstart + lleft + 1, fend,
					middle, index_m + 1, mend,map);
		}
		return root;
	}
	
	/**
	 * 两个栈实现对列
	 */
	class MyQueue{
	    Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
	    	stack1.push(node);
	    }
	    
	    public int pop() {
	    	if(stack2.isEmpty() && !stack1.isEmpty()){
	    		while(!stack1.isEmpty()){
	        		stack2.push(stack1.pop());
	        	}
	    	}
	    	if(!stack2.isEmpty()){
	    		return stack2.pop();
	    	}else {
	    		throw new RuntimeException();
	    	}
	    }
	    public int pop_full() {
	        while(!stack1.isEmpty()){
	            stack2.push(stack1.pop());
	        }
	        int first=stack2.pop();
	        while(!stack2.isEmpty()){
	            stack1.push(stack2.pop());
	        }
	        return first;
	    }
	}
	/**把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
	 public int minNumberInRotateArray_for(int [] array) {
		    int min =0;
		    int l=array.length;
		    if(l>=1){
		    	min=array[0];
		    	for(int i=1;i<l;i++){
		    		if(min>array[i]){
		    			min = array[i];
		    		}
		    	}
		    }
		    return min;
	 }
	 public int minNumberInRotateArray_while(int []arr){
		 int min=0;
		 int l = arr.length;
		 if(l>=1){
			 min=arr[0];
			 int i=1;
			 while(i<l){
				 if(min>arr[i]){
					 min = arr[i];
					 break;
				 }
				 i++;
			 }
			 
		 }
		 return min;
	 }
}
