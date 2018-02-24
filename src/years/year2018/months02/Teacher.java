package years.year2018.months02;


/**
 * 教师类
 * @author 王星
 * @version2018-2-24
 */
public class Teacher extends People {
	/**
	 * 
	 * @param peopleid 人员id
	 * @param name 姓名
	 * @param age 年龄
	 */
	public Teacher(int peopleid, String name, int age) {
		super(peopleid, name, age);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param peopleid 人员id
	 * @param name 姓名
	 * @param age 年龄
	 * @param subject 教学科目
	 */
	public Teacher(int peopleid, String name, int age,String subject) {
		super(peopleid, name, age);
		this.setSubject(subject);
	}
	/**
	 * 教学科目
	 */
	private String subject;
	/**
	 * 获取老师的教学科目
	 * @return
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 修改老师的教学科目
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
