package years.year2017.months06;

import java.util.ArrayList;

public class Day15 {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	 * 中序：左中右
	 * 如果当前节点有右子树则下一个节点为当前节点右子树上最左端的叶子
	 * 如果当前节点无右子树，则下一个节点是其父节点
	 * @param pNode
	 * @return
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
        	return null;
        }
        if(pNode.right!=null){
        	pNode = pNode.right;
        	while(pNode.left!=null){
        		pNode=pNode.left;
        	}
        	return pNode;
        }
        while(pNode.next!=null){
        	if(pNode.next.left==pNode){
        		return pNode.next;
        	}
        	pNode=pNode.next;
        }
        return null;
    }
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
	 * @param pRoot
	 * @return
	 */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
        	return true;
        }
        return judgeTreeSymmetrical(pRoot.left, pRoot.right);
    }
    boolean judgeTreeSymmetrical(TreeNode l,TreeNode r){
    	if(l==null){
    		return r==null;
    	}else if(r==null){
    		return false;
    	}
    	if(l.val!=r.val){
    		return false;
    	}
    	 return judgeTreeSymmetrical(l.left, r.right)&&judgeTreeSymmetrical(r.left, l.right);
    }
    
}
