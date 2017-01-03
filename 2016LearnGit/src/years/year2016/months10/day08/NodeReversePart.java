package years.year2016.months10.day08;

import util.construction.Node;

public class NodeReversePart {
	public static void main(String[]args){
		
	}
	public Node<Integer> reversePart(Node<Integer>head,int from,int to){
		int len=0;
		Node<Integer> node1 = head;
		/**
		 * 要反转部分的前一个节点
		 */
		Node<Integer> fPre = null;
		/**
		 * 要反转部分的后一个节点
		 */
		Node<Integer> tPos = null;
		while(node1 !=null){
			len++;
			fPre = len == from-1?node1:fPre;
			tPos = len == to+1?node1:tPos;
			node1 = node1.getNext();
		}
		if(from>to||from<1||to>len){
			return head;
		}
		node1 = fPre==null?head:fPre.getNext();//反转节点的前一个节点为空，则反转部分包含头结点
		Node<Integer> node2 = node1.getNext();
		node1.setNext(tPos);
		Node<Integer> next=null;
		while(node2!=tPos){
			next = node2.getNext();
			node2.setNext(node1);
			node1 = node2;
			node2 = next;
		}
		if(fPre!=null){
			fPre.setNext(node1);
			return head;
		}
		return node1;
	}
}
