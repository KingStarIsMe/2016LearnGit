package years.year2017.months11;

public class Day21 {
	public static void main(String []args){
		Day21 d = new Day21();
		String ss = "string";
		System.out.println(ss);
		d.changeData_string(ss);
		System.out.println(ss);
		StringBuffer sbf = new StringBuffer("StringBuffer");
		System.out.println(sbf);
		d.changeData_stringbuffer(sbf);
		System.out.println(sbf);
		StringBuilder sbl = new StringBuilder("StringBuilder");
		System.out.println(sbl);
		d.changeData_stringbuilder(sbl);
		System.out.println(sbl);
	}
	public void changeData_string(String ss){
		ss="asd";
	}
	public void changeData_stringbuffer(StringBuffer ss){
		ss=new StringBuffer("asd");
	}
	public void changeData_stringbuilder(StringBuilder ss){
		ss.append("_asd");
	}
	
}
