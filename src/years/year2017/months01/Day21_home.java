package years.year2017.months01;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Stack;

public class Day21_home {

private  class MyStack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack1(){
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum <= this.getMin()){
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("your stack is empty");
		}
		int value = this.stackData.pop();
		if(value == this.getMin()){
			this.stackMin.pop();
		}
		return value;
	}
	public int getMin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("your stack is empty.");
		}
		return this.stackMin.peek();
	}
}
}



class Utils{
	public static <T> Class <T> getGenricClassType(Class clz){
		Type type = clz.getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType)type;
			Type[]types = pt.getActualTypeArguments();
			if(types.length>0 && types[0] instanceof Class){
				return (Class)types[0];
			}
		}
		return (Class)Object.class;
	}
}
