package years.year2018.months02;

import java.util.ArrayList;

public class Day28 {
	public int max(int[] arr){
		int max=Integer.MIN_VALUE;
		for(int data : arr){
			if(data>max){
				max=data;
			}
		}
		return max;
	}
	
}
