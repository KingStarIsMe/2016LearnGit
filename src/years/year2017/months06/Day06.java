package years.year2017.months06;

public class Day06 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 输入两个链表，找出它们的第一个公共结点。
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1==null||pHead2==null){
			 return null;
		 }
		 ListNode ln1 = pHead1;
		 ListNode ln2 = pHead2;
		 while(ln1!=ln2){
			 ln1=ln1==null?pHead2:ln1.next;
			 ln2=ln2==null?pHead1:ln2.next;
		 }
		 return ln1;
    }
	/**
	 * 统计一个数字在排序数组中出现的次数。
	 * @param array
	 * @param k
	 * @return
	 */
	 public int GetNumberOfK(int [] array , int k) {
	        if(array==null || array.length==0){
	        	return 0;
	        }
	        int l=array.length;
	        int count=0;
	        if(array[0]<array[l-1]){
	        	//递增
	        	if(array[0]>k || array[l-1]<k){
	        		return count;
	        	}
	        	for(int i=0;i<l;i++){
		        	if(array[i]==k){
		        		count++;
		        	}else if(array[i]>k){
		        		break;
		        	}
		        }
	        }else{
	        	//递减
	        	if(array[0]<k || array[l-1]>k){
	        		return count;
	        	}
	        	for(int i=0;i<l;i++){
		        	if(array[i]==k){
		        		count++;
		        	}else if(array[i]<k){
		        		break;
		        	}
		        }
	        }
	        return count;
	 }
}
