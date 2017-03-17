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
		TreeNode root = createBinaryTree(pre, 0, length - 1, in, 0, length - 1,map);
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
	private TreeNode createBinaryTree(int[] front, int fstart, int fend,
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
			root.left = createBinaryTree(front, fstart + 1, fstart + lleft,
					middle, mstart, index_m - 1);
		}
		if (lright > 0) {
			root.right = createBinaryTree(front, fstart + lleft + 1, fend,
					middle, index_m + 1, mend);
		}
		return root;
	}
	private TreeNode createBinaryTree(int[] front, int fstart, int fend,
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
			root.left = createBinaryTree(front, fstart + 1, fstart + lleft,
					middle, mstart, index_m - 1,map);
		}
		if (lright > 0) {
			root.right = createBinaryTree(front, fstart + lleft + 1, fend,
					middle, index_m + 1, mend,map);
		}
		return root;
	}
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
    public int pop2() {
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
