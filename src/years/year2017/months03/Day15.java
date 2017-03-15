package years.year2017.months03;

public class Day15 {
	public static void main(String[]args){
		Day15 d = new Day15();
		int target=15;
		int[][]array =
		//{{}};
		{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(d.twoArrayFind1(target, array));
		System.out.println(d.twoArrayFind2(target, array));
	}
	/**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * @param target
	 * @param array
	 * @return
	 */
    public boolean twoArrayFind1(int target, int [][] array) {
    	int x = array.length-1;
    	if(x==-1 ){
    		return false;
    	}
    	int y = array[0].length-1;
    	if(y==-1 ){
    		return false;
    	}
    	int x_index = 0;
    	int y_index = 0;
    	//传入值小于数组第一个值和大于数组最后一个值都不在二维数组内
    	if(target<array[0][0] || target>array[x][y]){
    		return false;
    	}
    	if(target==array[0][0] || target==array[x][y]){
    		return true;
    	}
    	int temp_data = array[x_index][y_index];
		while (x_index <= x 
				&& y_index <= y 
				&& x_index >=0 
				&& y_index >= 0
				) {
			temp_data = array[x_index][y_index];
			if(temp_data==target){
    			return true;
    		}
    		if(temp_data < target){
    			x_index++;
    			y_index++;
    		}else if(temp_data > target) {
    			y_index--;
    		}
    		
    		
    	}
    	return false;
    }
    /**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * @param target
	 * @param array
	 * @return
	 */
    public boolean twoArrayFind2(int target, int [][] array) {
    	int xl = array.length-1;
    	if(xl==-1){
    		return false;
    	}
    	int yl = array[0].length-1;
    	if(yl==-1){
    		return false;
    	}
    	int yi = 0;
    	int t = array[xl][yi];
    	while(xl>=0 && yi<=yl){
    		t = array[xl][yi];
    		if(target > t){
    			yi++;
    		}else if(t>target){
    			xl--;
    		}else {
    			return true;
    		}
    	}
    	return false;
    }
}
