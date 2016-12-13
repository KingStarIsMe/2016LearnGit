package years.year2016.months12;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class Day13 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
	 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	 * @param root
	 * @param target
	 * @return
	 */
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 
		 return null;
	 }
	
	public static void main(String []args){
		try {
//			test1();
//			test2();
			test3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);
	private static int index =1;
	public static void  test1() throws InterruptedException{
		final CountDownLatch startCountDown = new CountDownLatch(1);
		final Thread[]threads = new Thread[10];
		for(int i=0;i<10;i++){
			threads[i] = new Thread(){
				public void run(){
					try {
						startCountDown.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int j=0;j<100;j++){
						index++;
						TEST_INTEGER.incrementAndGet();//增加1后返回增加后的值
					}
				}
			};
			threads[i].start();
		}
//		Thread.sleep(1000);
		startCountDown.countDown();
		for(Thread t:threads){
			t.join();
		}
		System.out.println(TEST_INTEGER.get());
		System.out.println(index);
	}
	private final static AtomicIntegerArray ATOMIC_INTEGER_ARRAY = new AtomicIntegerArray(10);
	public static void test2() throws InterruptedException{
		Thread[] threads = new Thread[100];
		for(int i=0;i<100;i++){
			final int index=i%10;
			final int threadNum = i;
			threads[i] = new Thread(){
				public void run(){
					int result = ATOMIC_INTEGER_ARRAY.addAndGet(index, index+1);
					System.out.println("线程编号："+threadNum+",对应的原始值为："+(index+1)+",增加后的值结果为"+result);
				}
			};
			threads[i].start();
		}
		for(Thread t : threads){
			t.join();
		}
		System.out.println("--------------\n执行完毕，结果列表：");
		for(int i=0;i<ATOMIC_INTEGER_ARRAY.length();i++){
			System.out.println(ATOMIC_INTEGER_ARRAY.get(i));
		}
	}
	public final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<String>();
	private final static Random RANDOM_OBJECT = new Random();
	public static void test3() throws InterruptedException{
		final CountDownLatch startCountDownLatch = new CountDownLatch(1);
		Thread[]threads = new Thread[20];
		for(int i=0;i<20;i++){
			final int num =1;
			threads[i]=new Thread(){
				public void run(){
					String oldValue = ATOMIC_REFERENCE.get();
					try {
						startCountDownLatch.await();
						Thread.sleep(RANDOM_OBJECT.nextInt()&1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(ATOMIC_REFERENCE.compareAndSet(oldValue, oldValue+num)){
						System.out.println("线程："+num+",进行了对象的修改");
					}
				}
			};
			threads[i].start();
		}
		Thread.sleep(200);
		startCountDownLatch.countDown();
		for(Thread t :threads){
			t.join();
		}
		System.out.println("最终结果为："+ATOMIC_REFERENCE.get());
		
	}
	
}
