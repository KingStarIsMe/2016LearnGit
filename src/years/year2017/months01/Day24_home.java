package years.year2017.months01;

import java.util.Stack;

public class Day24_home {
	/**
	 * 递归逆序一个栈
	 * @param stack
	 * @return
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int result =stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int last = getAndRemoveLastElement(stack);
			stack.push(last);
			return last;
		}
	}
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
