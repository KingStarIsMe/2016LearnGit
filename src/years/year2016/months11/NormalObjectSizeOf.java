package years.year2016.months11;

import java.lang.instrument.Instrumentation;

public class NormalObjectSizeOf {
	private static Instrumentation inst ;
	public static void premain(String agentArgs,Instrumentation instp){
		inst = instp;
	}
	/**
	 * 返回对象的内存占用大小
	 * @param object
	 * @return
	 */
	public static long sizeOf(Object object){
		return inst.getObjectSize(object);
	}
}
