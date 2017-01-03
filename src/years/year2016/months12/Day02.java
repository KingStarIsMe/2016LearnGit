//package years.year2016.months12;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Random;
//
//public class Day02 {
//	public static void main(String []args){
//		String  s1 = getActivationCode("string", 80);
//		System.out.println(s1);
//		String  s2 = getActivationCode("number", 50);
//		System.out.println(s2);
//		String  s3 = getActivationCode("string-number", 10);
//		System.out.println(s3);
//	}
//
//	private static final char[] LETTER = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
//			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
//			'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
//			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
//			'w', 'x', 'y', 'z' };
//	private static final int LETTER_LENGTH =LETTER.length;
//	private static final char[] NUMBER = {'0','1','2','3','4','5','6','7','8','9'};
//	private static final int NUMBER_LENGTH =NUMBER.length;
//	private static final char[] LETTER_NUMBER = { 'A', 'B', 'C', 'D', 'E', 'F',
//			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
//			'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
//			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
//			't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
//			'6', '7', '8', '9' };
//	private static final int LETTER_NUMBER_LENGTH =LETTER_NUMBER.length;
//	/**
//	 * 返回激活码
//	 * @param type 返回激活码类型 [string,number,string-number]
//	 * @param length 返回激活码长度
//	 * @return
//	 */
//	public static String getActivationCode(String type,int length){
//		StringBuilder code=new StringBuilder(length);
//		int state=0;
//		//判定生成何种类型的验证码
//		if("string".equals(type)){
//			state=0;
//		}else if("number".equals(type)){
//			state=1;
//		}else if("string-number".equals(type)){
//			state=2;
//		}else {
//		 new RuntimeException("传入的type值不符合标准，请从新传入，string,number,string-number，中的一个座位type");	
//		}
//		if(length<=0||length>=100){
//			new RuntimeException("传入生成激活码长度异常请重新传递,激活码长度范围1到99");
//		}
//		//获取随机数
//		Random r = new Random();
//		for(int i=0;i<length;i++){
//			if(state==0){
//				code.append(LETTER[r.nextInt(LETTER_LENGTH)]);
//			}else if(state==1){
//				code.append(NUMBER[r.nextInt(NUMBER_LENGTH)]);
//			}else if(state==2){
//				code.append(LETTER_NUMBER[r.nextInt(LETTER_NUMBER_LENGTH)]);
//			}
//		}
//		return code.toString();
//	}
//	private static final int PAGS_SIZE=102400;
//	public void writeFile(String path) throws IOException{
//		File file = new File(path);
//		FileInputStream fis = new FileInputStream(file);
//		long filelength = file.length();
//		if(filelength>PAGS_SIZE){
//			byte[]bytes = new byte[PAGS_SIZE];
//			int allLength = 0;
//			int length = fis.read(bytes);
//			while(length>0){
//				allLength +=length;
//				this.wr
//			}
//		}
//	}
//}
