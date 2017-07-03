package years.year2017.months06;

import java.util.ArrayList;
import java.util.LinkedList;

public class Day27 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	    /**
	     * 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	     * @param pRoot
	     * @return
	     */
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> lls = new ArrayList<ArrayList<Integer>>();
		if(pRoot==null){
			return lls;
		}
		//定义一个对列用来存放每一层的tree节点
		LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
		//定义一个链表用来存放每一层输出的数值
		ArrayList<Integer> layerList = new ArrayList<Integer>();
		//将根节点放入到存放层tree节点的对列中
		layer.add(pRoot);
		//设置一个初始值表示当前运行到第几个当前层中的tree节点
		int start=0;
		//设置一个end用于记录当前有tree对列中有多少个节点，因为第一层只有一个节点所以end=1
		int end=1;
		//如果tree对列不为空则一直运行
		while(!layer.isEmpty()){
			//取出节点并删除该节点
			TreeNode temp = layer.remove();
			//将节点数值放入输出链表
			layerList.add(temp.val);
			//输出数量+1
			start++;
			//判断当前节点是否有左子树，有则将左子树放入tree节点对列中
			if(temp.left!=null){
				layer.add(temp.left);
			}
			//判断当前节点是否有右子树，有则将左子树放入tree节点对列中
			if(temp.right!=null){
				layer.add(temp.right);
			}
			//完成一层输出时end会和start相等，进行数据重置
			if(start==end){
				end = layer.size();
				start = 0;
				lls.add(layerList);
				layerList = new ArrayList<Integer>();
			}
		}
		return lls;
    }
	/**
	 * 序列化二叉树
	 * @param root
	 * @return
	 */
	String Serialize(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        if(root==null){
        	temp.append("#,");
        	return temp.toString();
        }
        temp.append(root.val+",");
        temp.append(Serialize(root.left));
        temp.append(Serialize(root.right));
        return temp.toString();
	  }
	int index=-1;
	/**
	 * 反序列化二叉树
	 * @param str
	 * @return
	 */
	 TreeNode Deserialize(String str) {
	       index++;
	       int len = str.length();
	       if(index>=len){
	    	   return null;
	       }
	       String[]temp = str.split(",");
	       TreeNode root = null;
	       if(!temp[index].equals("#")){
	    	  root = new TreeNode(Integer.valueOf(temp[index])) ;
	    	  root.left = Deserialize(str);
	    	  root.right = Deserialize(str);
	       }
	       return root;
	  }
}
