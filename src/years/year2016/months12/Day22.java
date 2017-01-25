package years.year2016.months12;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Day22 {
	public static void main(String[]args) throws InterruptedException{
		processOneGroup("队伍1");
		processOneGroup("队伍2");
//		processOneGroup("队伍3");
	}
//	private static class CountDownLatchTest{
	private final static int GROUP_SIZE=5;
	private final static Random random = new Random();
	private static void processOneGroup(final String groupNmae) throws InterruptedException{
		final CountDownLatch preCountDown = new CountDownLatch(GROUP_SIZE);
		final CountDownLatch startCountDown = new CountDownLatch(1);
		final CountDownLatch endCountDown = new CountDownLatch(GROUP_SIZE);
		System.out.println("====>\n 分组："+groupNmae+"比赛开始：");
		for(int i=0;i<GROUP_SIZE;i++){
			new Thread(String.valueOf(i)){
				public void run(){
					preCountDown.countDown();
					System.out.println("我是线程组：【"+groupNmae+"】,第"+this.getName()+"号线程，我已经准备就绪");
					try {
						startCountDown.countDown();
						startCountDown.await();
						Thread.sleep(Math.abs(random.nextInt())%1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("我是线程组：【"+groupNmae+"】,第"+this.getName()+"号线程，我已经执行完成");
					endCountDown.countDown();
					
				}
			}.start();
			}
		preCountDown.await();
		System.out.println("各就各位，预备");
		startCountDown.countDown();
		endCountDown.await();
		System.out.println(groupNmae+" 比赛结束");
	}
//	}
}
