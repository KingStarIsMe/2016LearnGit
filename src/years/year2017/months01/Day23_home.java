package years.year2017.months01;

import java.util.Stack;

public class Day23_home {
	/**
	 * 两个栈实现一个队列 
	 * @author wangxing
	 *
	 */
	public class TwoStackQueue{
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;
		public TwoStackQueue(){
			this.stackPush = new Stack<Integer>();
			this.stackPop = new Stack<Integer>();
		}
		public void add(int pushInt){
			this.stackPush.push(pushInt);
		}
		public int poll(){
			if(this.stackPop.empty() && this.stackPush.empty()){
				throw new RuntimeException();
			}else if(this.stackPop.empty()){
				while(!this.stackPush.empty()){
					this.stackPop.push(this.stackPush.pop());
				}
			}
			return this.stackPop.pop();
		}
		public int peek(){
			if(this.stackPop.empty() && this.stackPush.empty()){
				throw new RuntimeException();
			}else if(this.stackPop.empty()){
				while(!this.stackPush.empty()){
					this.stackPop.push(this.stackPush.pop());
				}
			}
			return this.stackPop.peek();
		}
	}
}
