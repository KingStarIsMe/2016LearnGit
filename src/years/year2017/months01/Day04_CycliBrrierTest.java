package years.year2017.months01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Day04_CycliBrrierTest {
	private static final  int THREAD_COUNT=3;
	/**
	 * 拦截步骤使用
	 */
	private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(THREAD_COUNT, new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("----->我是导游，本次点名结束，准备走入下一环节");
		}
	}); 
	public static void main(String[]args){
		for(int i=0;i<THREAD_COUNT;i++){
			new Thread(String.valueOf(i)){
				public void run(){
					try {
						System.out.println("我是线程："+this.getName()+"我们抵达旅游地点！");
//						CYCLIC_BARRIER.await();
						System.out.println("我是线程："+this.getName()+"我们开始骑车！");
						CYCLIC_BARRIER.await();
						System.out.println("我是线程："+this.getName()+"我们开始爬山！");
						CYCLIC_BARRIER.await();
						System.out.println("我是线程："+this.getName()+"我们回到宾馆休息！");
						CYCLIC_BARRIER.await();
						System.out.println("我是线程："+this.getName()+"我们开始乘车返回！");
						CYCLIC_BARRIER.await();
						System.out.println("我是线程："+this.getName()+"我们到家！");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
			
		}
	}
}
