package years.year2017.months03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Day16 {
	public static void main(String[]args){
		Day16 d = new Day16();
		ListNode l = new ListNode(0);
		d.printListFromTailToHead(l);
		StringBuffer str = new StringBuffer();// null;//new StringBuffer("We Are Happy");
//		System.out.println(d.replaceSpace2(str));
//		System.out.println(d.replaceSpace(str));
	}
	/**
	 * 实现一个函数，将一个字符串中的空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 * @param str
	 * @return
	 */
	 public String replaceSpace2(StringBuffer str) {
		 if(str==null){
			 return null;
		 }
		 return str.toString().replaceAll(" ", "%20");
	 }
	 /**
		 * 实现一个函数，将一个字符串中的空格替换成“%20”。
		 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
		 * @param str
		 * @return
		 */
	 public String replaceSpace(StringBuffer str) {
		 if(str==null){
			 return null;
		 }
		 StringBuilder s2 = new StringBuilder();
		 int l = str.length();
		 char temp = ' '; 
		 for(int i=0;i<l;i++){
			 temp = str.charAt(i); 
			 if(temp==' '){
				s2.append("%20"); 
			 }else{
				 s2.append(temp);
			 }
		 }
		 return s2.toString();
	 }
	/**
	 * 输入一个链表，从尾到头打印链表每个节点的值
	 * @param listNode
	 * @return
	 */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer > s = new Stack<Integer>();
    	while(listNode!=null){
    		s.push(listNode.val);
    		listNode=listNode.next;
    	}
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!s.isEmpty()){
        	list.add(s.pop());
        }
        return list;
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	if(listNode!=null){
    		this.printListFromTailToHead2(listNode.next);
    		list.add(listNode.val);
    	}
        return list;
    }
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
    	ArrayList<Integer> l1 = new ArrayList<Integer>();
    	ArrayList<Integer> l2 = new ArrayList<Integer>();
    	while(listNode!=null){
    		l1.add(listNode.val);
    		listNode=listNode.next;
    	}
    	for(int i=l1.size()-1;i>=0;i--){
    		l2.add(l1.get(i));
    	}
        return l2;
    }
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	recursion(l,listNode);
    	return l;
    }
    private void recursion(ArrayList<Integer> l,ListNode listNode){
    	if(listNode!=null){
    		recursion(l, listNode.next);
    		l.add(listNode.val);
    	}
    }
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead5(ListNode listNode) {
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	while(listNode!=null){
    		l.add(listNode.val);
    		listNode=listNode.next;
    	}
    	if(l.size()>=1){
    		Collections.reverse(l);
    	}
    	return l;
    }
    
}
