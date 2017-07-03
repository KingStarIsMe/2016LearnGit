package years.year2017.months06;

import java.util.ArrayList;

import years.year2017.months06.Day15.TreeNode;

public class Day19 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 * @param pRoot
	 * @return
	 */
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > llist = new ArrayList<ArrayList<Integer>>();
		if(pRoot==null){
			return llist;
		}
		ArrayList<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		treeNodeList.add(null);
		treeNodeList.add(pRoot);
		while(treeNodeList.size()>=1){
			TreeNode node = treeNodeList.remove(treeNodeList.size()-1);
			
		}
		return llist;
    }
}
