package years.year2017.months06;

import java.awt.List;
import java.util.HashMap;

public class Day14 {
	StringBuilder sp = new StringBuilder();
	HashMap<Character, Integer> mapdata = new HashMap<Character, Integer>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sp.append(ch);
        if(mapdata.containsKey(ch)){
        	mapdata.put(ch, 2);
        }else{
        	mapdata.put(ch, 1);
        }
    }
  //return the first appearence once char in current stringstream
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    public char FirstAppearingOnce()
    {
    	int l=sp.length();
    	char[]cs=new char[l];
    	sp.getChars(0, l, cs, 0);
    	char  data = '#';
    	for(int i=0;i<l;i++){
    		if(mapdata.get(cs[i])==1){
    			data=cs[i];
    			break;
    		}
    	}
    	return data;
    }
    
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        public void add(int val){
        	ListNode temp = this;
        	while(temp.next!=null){
        		temp=temp.next;
        	}
        	temp.next=new ListNode(val);
        }
        ListNode(int[]vals) {
        	this.val = vals[0];
        	int l=vals.length;
        	for(int i=1;i<l;i++){
        		add(vals[i]);
        	}
        }
    }
    /**
     * 一个链表中包含环，请找出该链表的环的入口结点。
     * 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
     * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,
     * p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，
     * p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null || pHead.next==null){
        	return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p1!=null&&p2!=null){
        	p1=p1.next;
        	p2=p2.next.next;
        	if(p1==p2){
        		p2=pHead;
        		while(p1!=p2){
        			p1=p1.next;
        			p2=p2.next;
        		}
        		if(p1==p2){
        			return p1;
        		}
        	}
        }
        return null;
    }
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead==null || pHead.next==null){
        	return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
         while(p2!=null){
        	 p1.next=null;
        	 p1=p2;
        	 p2=p2.next;
         }
        return p1;
    }
    public static void main(String[]args){
    	Day14 d =new Day14();
    	int[]l={1,2,3,3,4,4,5};
    	ListNode pHead = d.new ListNode(l);
    	d.deleteDuplication(pHead);
    }
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
    	 if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
             return pHead;
         }
         if (pHead.val == pHead.next.val) { // 当前结点是重复结点
             ListNode pNode = pHead.next;
             while (pNode != null && pNode.val == pHead.val) {
                 // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                 pNode = pNode.next;
             }
             return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
         } else { // 当前结点不是重复结点
             pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
             return pHead;
         }
    }
    public ListNode deleteNode(ListNode node){
    	ListNode t = node;
    	t=t.next;
    	return t;
    }
}
