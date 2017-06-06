package years.year2017.months06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Day02 {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	/**
	 * 输入一个复杂链表
	 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。
	 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	 * @param pHead
	 * @return
	 */
	  public RandomListNode Clone(RandomListNode pHead)
	    {
		  RandomListNode p = pHead;
		  RandomListNode t= pHead;
		  while(p!=null){
			  RandomListNode q = new RandomListNode(p.label);
			  q.next=p.next;
			  p.next = q;
			  p=q.next;
		  }
		  while(t!=null){
			  RandomListNode q = t.next;
			  if(t.random!=null){
				  q.random=t.random.next;
			  }
			  t=q.next;
		  }
		  RandomListNode s = new RandomListNode(0);
		  RandomListNode s1 = s;
		  while(pHead!=null){
			  RandomListNode q = pHead.next;
			  pHead.next=q.next;
			  q.next = s.next;
			  s.next=q;
			  s=s.next;
			  pHead = pHead.next;
		  }
		  return s1.next;
	    }
	  /**
	   * 递归（把大问题转化若干子问题）
	   * 输入一个复杂链表
	   * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	   * 返回结果为复制后复杂链表的head。
	   * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	   * @param pHead
	   * @return
	   */
	  public RandomListNode Clone2(RandomListNode pHead){
		  if(pHead==null){
			  return null;
		  }
//		  每次处理一个节点
		  RandomListNode p = new RandomListNode(pHead.label);
		  p.next=pHead.next;
		  p.random=pHead.random;
		  p.next=Clone(pHead.next);
		  return p;
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
	   * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	   * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
	   * @param pRootOfTree
	   * @return
	   */
	  	public TreeNode Convert(TreeNode node) {
	        if(node==null){
	        	return null;
	        }else
	        if(node.left==null&&node.right==null){
	        	return node;	        	
	        }else{
	        	//将左子树构造成双链表，并返回头节点
	        	TreeNode left = Convert(node.left);
	        	TreeNode p = left;
	        	//定位到左子树双链表最后一个节点
	        	while(p!=null&&p.right!=null){
	        		p=p.right;
	        	}
	        	//如果左子树链表不为空，将根节点追加到左子树链表上
	        	if(left!=null){
	        		p.right=node;
	        		node.left=p;
	        	}
	        	//将右子树构造成双链表，并返回头结点
	        	TreeNode right = Convert(node.right);
	        	//如右子树链表不为空则将该链表追加在node节点后
	        	if(right!=null){
	        		right.left=node;
	        		node.right=right;
	        	}
	        	return left!=null?left:node;
	        }
	    }
	  	/**
	  	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	  	 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
	  	 * @param str
	  	 * @return
	  	 */
	  	 public ArrayList<String> Permutation(String str) {
//	  		ArrayList<String> strGroup = new ArrayList<String>();
	  		Set<String> strGroup = new HashSet<String>();
	  		int l = str.length();
	  		if(l==0){
	  			return new ArrayList<String>();
	  		}
	  		char[]strchars = str.toCharArray();
	  		strGroup(strchars, strGroup, 0, l);
	  		ArrayList<String> datalist = new ArrayList<String>(strGroup);
	  		Collections.sort(datalist);
	  		return datalist;
	     }
	  	 /**
	  	  * 进行数组全排列
	  	  * @param strchars
	  	  * @param set
	  	  * @param i
	  	  * @param l
	  	  */
	  	 public void strGroup(char[]strchars,Set<String> set,int i,int l){
	  		 if(i<l-1){
	  			char t;
	  			strGroup(strchars, set, i+1, l);
	  			for(int j=i+1;j<l;j++){
		  			t=strchars[i];
		  			strchars[i]=strchars[j];
		  			strchars[j]=t;
		  			strGroup(strchars, set, i+1, l);
		  			t=strchars[i];
		  			strchars[i]=strchars[j];
		  			strchars[j]=t;
	  			}
	  		 }else{
	  			 set.add(String.valueOf(strchars));
	  		 }
	  	 }
	  	 public static void main(String[]args){
	  		int[]a={1,2,3,2,2,2,5,4,2};
	  		Day02 d = new Day02();
	  		d.MoreThanHalfNum_Solution(a);
	  	 }
	  	 /**
	  	  * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	  	  * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
	  	  * 超过数组长度的一半，因此输出2。如果不存在则输出0。
	  	  * ｛
	  	  *   在遍历数组时保存两个值：
	  	  *   一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
	  	  *   若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。｝
	  	  * @param array
	  	  * @return
	  	  */
	  	 public int MoreThanHalfNum_Solution(int [] array) {
	         int l = array.length;
	         if(l==0){
	        	 return 0;
	         }
	         int result = array[0];
	         int num=1;
	         for(int i=1;i<l;i++){
	        	 if(num==0){
	        		 result=array[i];
	        	 }
	        	 if(array[i]==result){
	        		 num++;
	        	 }else{
	        		 num--;
	        	 }
	         }
	         num=0;
	         for(int i=0;i<l;i++){
	        	 if(array[i]==result){
	        		 num++;
	        	 }
	         }
	         if(num*2<=l){
	        	 result=0;
	         }
	         return result;
	     }
}
