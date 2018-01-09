package years.year2017.months10.Day13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class BeanFactory {
	public static Object getBean(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Object obj = Class.forName(className).newInstance();
		InvocationHandler handler = new Day13(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}
	
	public static <T> T getBean(String className,Class<T> clazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (T)getBean(className);
	}
}
