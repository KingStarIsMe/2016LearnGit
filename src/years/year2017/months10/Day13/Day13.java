package years.year2017.months10.Day13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Day13 implements InvocationHandler {
	private Object target;
	
	public Day13(Object target){
		this.target=target;
	}
	public void println(String str,Object ...args ){
		System.out.println(str);
		if(args==null){
			System.out.println("未传入参数");
		}else{
			for(Object a : args){
				System.out.println(a);
			}
		}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("====>调用方法名称："+method.getName() );
		Class<?>[]variables = method.getParameterTypes();
		System.out.println("参数类型列表");
		for(Class<?> types : variables){
			System.out.println(types.getName());
		}
		System.out.println("传入参数值为：");
		for(Object arg:args){
			System.out.println(arg);
		}
		Object result = method.invoke(target, args);
		System.out.println("返回值为："+result);
		System.out.println("返回值类型为："+method.getReturnType());
		return null;
	}

}
