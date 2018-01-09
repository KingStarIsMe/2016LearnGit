package years.year2017.months10.Day16;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class ContervionService {
//	public static <T> T convertMapToBean(Map<String,String> row,Class<T> clazz ) throws InstantiationException, IllegalAccessException{
//		Object obj = clazz.newInstance();
//		List<Field> l = 
//	}
	public static void main(String[]args){
		try {
			UserDo u = UserDo.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
