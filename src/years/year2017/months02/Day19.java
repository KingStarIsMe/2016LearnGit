package years.year2017.months02;

public class Day19 {
	public static void main(String []args){
		
	}
	/**
	 * 一对兔子，从出生后第三个月起每个月生一对兔子，小兔子长三个月后每三个月又可以生一对兔子，假如兔子都不死亡，每个月的兔子数量是多少对
	 * @param months
	 * @return
	 */
	public int getHareNum(int months){
		return getHareNum_Fun(months);
	}
	public int getHareNum_Fun(int n){
		if(n==1||n==2){
			return 1;
		}else{
			return getHareNum_Fun(n-1)+getHareNum_Fun(n-2);
		}
	}
	/**
	 * 获取传入的两个数值之间所含有的素数的个数
	 * @param start
	 * @param end
	 * @return
	 */
	public int getNumAmongPrimeNum(int start,int end){
		int count = 0;
		if(start>end){
			return 0;
		}
		for(int i = start;i<end;i++){
			if(isPrime(i)){
				count++;
				System.out.println(i+" ");
				if(count%10==0){
					System.out.println();
				}
			}
		}
		System.out.println();
		System.out.println("在" +start+
				"和" +end+
				"之间工有" +count+
				"个素数");
		return count;
	}
	private boolean isPrime(int num){
		boolean flag = true;
		if(num==1){
			flag = false;
		}else{
			for(int i=2;i<=Math.sqrt(num);i++){
				if(num%i==0|| num==1){
					flag=false;
					break;
				}
			}
		}
		return flag;
	}
	
}
