package years.year2017.months06;

import java.util.ArrayList;
import java.util.HashMap;

public class Day07 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
	 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
	 * 最长路径的长度为树的深度。
	 * @param root
	 * @return
	 */
public int TreeDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        int ldepth = TreeDepth(root.left)+1;
        int rdepth = TreeDepth(root.right)+1;
        if(ldepth>rdepth){
        	return ldepth;
        }else{
        	return rdepth;
        }
    }
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 左右子树高度差不超过1
 * @param root
 * @return
 */
	public boolean IsBalanced_Solution(TreeNode root) {
	    if(root ==null){
	    	return true;
	    }
	    int lDepth = TreeDepth(root.left);
	    int rDepth = TreeDepth(root.right);
	    if(lDepth-rDepth>1 || rDepth-lDepth>1 ){
	    	return false;
	    }
	    return true;
	}
	/**
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	 * @param array
	 * @param num1
	 * @param num2
	 * num1,num2分别为长度为1的数组。传出参数
	 * 将num1[0],num2[0]设置为返回结果
	 */
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int l = array.length;
        HashMap<Integer, Integer > temp = new HashMap<Integer, Integer>(l/2+1);
        for(int i = 0;i<l;i++){
        	if(temp.containsKey(array[i])){
        		temp.put(array[i], 2);
        	}else{
        		temp.put(array[i], 1);
        	}
        }
        boolean flag = true;
        for(int i : temp.keySet()){
        	if(temp.get(i)==1){
        		if(flag){
        			flag=false;
        			num1[0]=i;
        		}else{
        			num2[0]=i;
        		}
        	}
        }
    }
	/**
	 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
	 * 他马上就写出了正确答案是100。
	 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
	 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
	 * 输出描述:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 * @param sum
	 * @return
	 */
	 public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		 ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer>temp;
         if(sum<3)return list;
         int s=(int) Math.sqrt(2*sum);
         for(int i=s;i>=2;i--)
             {
                 if(2*sum%i==0)
                     {
                         int d=2*sum/i;
                         if(d%2==0&&i%2!=0||d%2!=0&&i%2==0)
                             {
                                 int a1=(d-i+1)/2;
                                 int an=(d+i-1)/2;
                                 temp=new ArrayList<Integer>();
                                 for(int j=a1;j<=an;j++)
                                     temp.add(j);
                                 list.add(temp);
                             }
                     }
             }
         return list;
	 }
	 public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
		 ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer>temp;
         if(sum<3)return list;
         return list;
	 }
}
