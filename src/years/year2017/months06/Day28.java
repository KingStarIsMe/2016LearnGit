package years.year2017.months06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Day28 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	int index = 0;
	/**
	 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
	 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
	 * @param pRoot
	 * @param k
	 * @return
	 * //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
	 * //     所以，按照中序遍历顺序找到第k个结点就是结果。
	 */
	TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null){
        	return null;
        }else {
        	if(k<=0){
        		return null;
        	}
        	TreeNode t = KthNode(pRoot.left, k);
        	if(t!=null){
        		return t;
        	}
        	index++;
        	if(k==index){
        		return pRoot;
        	}
        	t = KthNode(pRoot.right, k);
        	if(t!=null){
        		return t;
        	}
        }
        return null;
    }
	public static void main(String[]args){
		Day28 d = new Day28();
//			d.
		int i=0;
		for(;;){
			i++;
			System.out.println(i);
			testThreadExecutor();
			if(i>100)return;
		}
	}
	 public void testThread1() throws InterruptedException{
		 Thread t = new Thread(){
			public void run(){
				System.out.println("执行个线程玩");
			} 
		 };
		 t.start();
		 while(!t.getState().equals(Thread.State.TERMINATED)){
			 System.out.println("还没结束");
			 TimeUnit.MILLISECONDS.sleep(10);
		 }
		 System.out.println("结束线程你猜会怎么样");
		 t.start();
	 }
	 public static void testThreadExecutor(){
		 //线程池的使用
		 ExecutorService e = Executors.newFixedThreadPool(2);
		 for(int i = 0 ; i<5;i++){
			 e.submit(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
				}
				 
			 });
		 }
		 e.shutdown();
	 }
	 class Task{
		 public void doSomething(){
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringBuffer s = new StringBuffer();
			s.append("线程名称："+Thread.currentThread().getName());
		 }
	 }
}
