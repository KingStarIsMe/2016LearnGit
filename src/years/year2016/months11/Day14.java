package years.year2016.months11;

public class Day14 {
	class Person{
		private String name;
		private int age;
		public void getInfo(){
			System.out.println("name is "+name);
			System.out.println("age is "+age);
		}
		
	}
	class Students extends Person {
		public void study(){
			
		}
	}
	public static void main(String []args)
	{	
		Day14 d = new Day14();
		int []nums = {10,9,8,11,5,1,9,5,8,3};
		d.quicksort(nums,0,9);
		for(int t:nums){
			System.out.println(t);
		}
	}
	private void swap(int[]s,int a,int b){
		int t = s[a];
		s[a] = s[b];
		s[b] = t;
	}
	private int partition(int []nums,int low,int high){
		int privot = nums[low];
		while(low<high){
			while(low<high && nums[high]>=privot){
				high--;
			}
			swap(nums, high, low);
			while(low<high && nums[low]<=privot){
				low++;
			}
			swap(nums, high, low);
		}
		return low;
	}
	public void quicksort(int []nums,int low,int high){
		if(low<high){
			int privot = partition(nums,low,high);
			quicksort(nums,low,privot-1);
			quicksort(nums,privot+1,high);
		}
	}
}
