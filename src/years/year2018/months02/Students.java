package years.year2018.months02;

import java.util.List;

/**
 * 学生类
 * @author 王星
 * @version 2018-2-24
 *
 */
public class Students extends People {
	/**
	 * 构造方法
	 * @param peopleid 人员id
	 * @param name 姓名
	 * @param age 年龄
	 * @param sex 性别
	 */
	public Students(int peopleid, String name, int age, String sex) {
		super(peopleid, name, age, sex);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 学生的构造方法
	 * @param peopleid 人员id
	 * @param name 姓名
	 * @param age 年龄
	 * @param sex 性别
	 * @param className 班级
	 * @param teachers 老师组
	 */
	public Students(int peopleid, String name, int age, String sex,String className,List<Teacher> teachers) {
		super(peopleid, name, age, sex);
		// TODO Auto-generated constructor stub
		this.setClassName(className);
		this.setTeachers(teachers);
	}
	/**
	 * 班级
	 */
	private String className ;
	/**
	 * 老师对象组
	 */
	private List<Teacher> teachers;
	/**
	 * 获取学生班级
	 * @return
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 修改学生班级
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * 获取学生老师对象组
	 * @return
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}
	/**
	 * 修改学生老师对象组
	 * @param teachers
	 */
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
