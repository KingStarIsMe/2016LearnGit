package years.year2017.months01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class Day12_home {
	public static void main(String[]args){
		//装饰模式
		Animal jerry = new Rat();
		jerry = new DecorateAnimal(jerry,FlyFeature.class);
		jerry = new DecorateAnimal(jerry, DigFeature.class);
		jerry.doStuff();
	}
}
/**
 * 动物
 * @author wangxing
 *
 */
interface Animal{
	public void doStuff();
}
class Rat implements Animal{

	@Override
	public void doStuff() {
		// TODO Auto-generated method stub
		System.out.println("老鼠");
		
	}
	
}
/**
 * 能力
 * @author wangxing
 *
 */
interface Feature{
	public void load();
}
class FlyFeature implements Feature{

	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("飞行");
	}
}
class DigFeature implements Feature{

	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("遁地");
	}
	
}
/**
 * 装饰模式
 * @author wangxing
 *
 */
class DecorateAnimal implements Animal{
	/**
	 * 定义一个动物
	 */
	private Animal animal;
	/**
	 * 使用哪一个包装容器
	 */
	private Class<? extends Feature> clz;
	public DecorateAnimal(Animal _animal,Class<? extends Feature> _clz){
		this.animal=_animal;
		this.clz=_clz;
	}
	
	@Override
	public void doStuff() {
		// TODO Auto-generated method stub
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				Object obj= null;
				if(Modifier.isPublic(method.getModifiers())){
					obj = method.invoke(clz.newInstance(), args);
				}
				animal.doStuff();
				return obj;
			}
		};
		//当前加载器
		ClassLoader cl = getClass().getClassLoader();
		//动态代理
		Feature proxy = (Feature)Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
		proxy.load();
	}
	
}
