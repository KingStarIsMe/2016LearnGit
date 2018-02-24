package years.year2018.months02;

/**
 * 人员类
 * @author 王星
 * @version 2018-2-24
 *
 */
public class People {
	/**
	 * 构造方法
	 * @param peopleid 人员id
	 * @param name 人员姓名
	 * @param age 人员年龄
	 */
	public People(int peopleid,String name,int age){
		this.peopleid=peopleid;
		this.setName(name);
		this.setAge(age);
	}
	/**
	 * 构造方法 
	 * @param peopleid 人员id
	 * @param name 人员姓名
	 * @param age 人员年龄
	 * @param sex 人员性别
	 */
	public People(int peopleid,String name,int age,String sex){
		this.peopleid=peopleid;
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
	}
	/**
	 * 人员id
	 */
	private int peopleid;	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 返回人员姓名
	 * @return 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 更改人员姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 返回人员年龄
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 设置人员年龄
	 * @exception 人员年龄不能大于200,不能小于0
	 * @param age
	 */
	public void setAge(int age) {
		if(age>200||age<0){
			throw new RuntimeException("人员年龄不能小于0岁,不能大于200岁");
		}
		this.age = age;
	}
	/**
	 * 返回人员性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置人员性别
	 * @exception 人员性别只能是男或者女
	 * @param sex
	 */
	public void setSex(String sex) {
		if("男女".indexOf(sex)==-1){
			throw new RuntimeException("人员性别只能是男或者女");
		}
		this.sex = sex;
	}
	/**
	 * 获取人员id
	 * @return
	 */
	public int getPeopleid() {
		return peopleid;
	}
}
