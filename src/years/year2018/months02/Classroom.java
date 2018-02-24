package years.year2018.months02;


/**
 * 教室类
 * @author 王星
 * @version 2018-2-24
 *
 */
public class Classroom {
	/**
	 * 构造方法
	 * @param name 教室名称
	 */
	public Classroom(String name){
		this.setName(name);
	}
	/**
	 *教室名称 
	 */
	private String name;
	/**
	 * 获取教室名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置教室名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
