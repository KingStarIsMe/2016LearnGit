package years.year2017.months10;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Day12 {
	public static void main(String []args){
		try {
			temp_Property();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp_Method();
		
	}
	public static void temp_Property() throws IntrospectionException{
		Field [] fs = temp_d.class.getDeclaredFields();
		for(Field f : fs){
			System.out.println("---->"+f.getName()+"---"+f.getType());
			PropertyDescriptor p = new PropertyDescriptor(f.getName(),temp_d.class);
			System.out.println(p.getDisplayName());
			System.out.println(p.getName());
			System.out.println(p.getPropertyEditorClass());
			System.out.println(p.getPropertyType());
			System.out.println(p.getWriteMethod());
			System.out.println(p.getShortDescription());
			System.out.println(p.getReadMethod());
		}
	}

	public static void temp_Method(){
		try {
			Method m = Day12.class.getDeclaredMethod("test_r", String.class,int.class);
			try {
				String a = (String)m.invoke(null, "ss",11);
				System.out.println(a);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void test_void(String a,int b){
		System.out.println("String "+ a+" int "+b);
	}
	public static String test_r(String a,int b){
		return "String "+ a+" int "+b;
	}
	class temp_d{
		String name;
		String station;
		int id;
		public String getName() {
			return name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStation() {
			return station;
		}
		public void setStation(String station) {
			this.station = station;
		}
		
	}
}
