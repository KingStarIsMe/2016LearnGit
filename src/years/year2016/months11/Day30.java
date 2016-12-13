package years.year2016.months11;

public class Day30 {
	public static void main(String []args){
		long a = NormalObjectSizeOf.sizeOf(new String());
		System.out.println(a);
//		NormalObjectSizeOf.premain("", instp);
		long b = NormalObjectSizeOf.sizeOf("");
		System.out.println(b);
	}
}
