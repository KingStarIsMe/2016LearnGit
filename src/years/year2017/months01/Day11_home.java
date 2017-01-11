package years.year2017.months01;

import java.awt.Menu;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Day11_home {
	
}
interface Subject{
	public void request();
}
class RealSubject implements Subject{
	public void request(){
		System.out.println("request---realSubject");
	}
}
/**
 * 静态代理
 * @author wangxing
 *
 */
class Proxy_static implements Subject{
	/**
	 * 要代理哪个实现类
	 */
	private Subject subject =null;
	/**
	 * 默认被代理者
	 */
	public Proxy_static(){
		subject = new RealSubject();
	}
	/**
	 * 预处理
	 */
	private void before(){
		System.out.println("预处理");
	}
	/**
	 * 善后处理
	 */
	private void after(){
		System.out.println("善后处理");
	}
	public void request(){
		before();
		subject.request();
		after();
	}
}
/**
 * 动态代理
 * @author wangxing
 *
 */
class SubjectHandler implements InvocationHandler{
	private Subject subject;
	public SubjectHandler(Subject _subject){
		subject = _subject;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("预处理");
		Object obj = method.invoke(subject, args);
		System.out.println("善后处理");
		return null;
	}
	
}
