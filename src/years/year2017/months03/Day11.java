package years.year2017.months03;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Day11 {
	class TaxCalculator implements Callable<Integer> {
		private int seedMoney;
		public TaxCalculator(int _seeMoney){
			this.seedMoney = _seeMoney;
		}
		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			TimeUnit.MILLISECONDS.sleep(10000);
			return this.seedMoney/10;
		}
		
	}
}
