package years.year2017.months01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Day18_home {

} 
abstract class AbsPopulator {
	public final void dataInitialing(){
		doInit();
	}
	protected abstract void doInit();
}

class UserPopulator extends AbsPopulator{
	@Override
	protected void doInit() {
		// TODO Auto-generated method stub
		
	}
}

abstract class AbsPopulator_2 {
	public final void dataInitialing() throws Exception{
		Method[]methods = getClass().getMethods();
		for(Method m: methods){
			if(isInitDataMethod(m)){
				m.invoke(this);
			}
		}
	}
	/**
	 * 判断是否是数据初始化方法
	 * @param m
	 * @return
	 */
	private boolean isInitDataMethod(Method m){
		return m.getName().startsWith("init")
				//init开始
				&& Modifier.isPublic(m.getModifiers())
				//公开方法
				&& m.getReturnType().equals(Void.TYPE)
				//返回void
				&& !m.isVarArgs()
				//输出参数为空
				&& !Modifier.isAbstract(m.getModifiers())
				//不是抽象方法
				;
	}
}

class UserPopulator2 extends AbsPopulator_2{
	public void initUser(){
		
	}
	public void initPassword(){
		
	}
	public void initJobs(){
		
	}
}
