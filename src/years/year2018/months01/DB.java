package years.year2018.months01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;


public class DB {
	
	private static Connection connection = null;
	/**
	 * 数据库用户名
	 */
	private static  String user = null;
	/**
	 * 数据库密码
	 */
	private static  String password = null;
	/**
	 * 数据库地址jdbc:数据库:thin:@数据库地址:端口号:数据库实例名
	 */
	private static String url = null;
	/**
	 * 数据库驱动
	 */
	private static String jdbcDriver = null;
	/**
	 * 连接池初始连接数大小
	 */
	private static int initialConnections = 10 ;
	/**
	 *连接池自动增加的连接数大小
	 */
	private static int incrementalConnections = 5;
	/**
	 * 连接池最大连接数
	 */
	private static int maxConnections = 100;
	/**
	 * 连接池中数据库连接
	 */
	private static Vector connections = null;
	/**
	 * 测试使用表
	 */
	private static String testTable = null;
	
	static{
			DB d = new DB();
			testTable = "goods";
			d.initDBData("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@192.168.1.50:1521:eyeshot", "learn", "wx1212");
	}
	/**
	 * 初始化数据库连接池基本信息
	 * @param jdbcDriver 驱动
	 * @param dburl 数据库连接
	 * @param user 用户名
	 * @param password 密码
	 */
	public void initDBData(String jdbcDriver,String dburl,String user,String password){
		this.jdbcDriver=jdbcDriver;
		this.url = dburl;
		this.user = user;
		this.password = password;
	}
	/**
	 * 创建数据库连接池
	 */
	public synchronized void createPool(){
		if(DB.connections != null){
			return ;
		}
		Driver driver = null;
		try {
			driver = (Driver)(Class.forName(jdbcDriver).newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connections = new Vector();
		
	}
	/**
	 * 创建数据库连接到数据库连接池
	 * @param numConnections
	 */
	private void createConnections(int  numConnections){
		for(int i=0;i<numConnections;i++){
			/**
			 * 当前的连接池连接数已经为最大连接数则不在创建链接
			 */
			if(this.maxConnections>0 && this.connections.size()>=this.maxConnections){
				break;
			}
			try {
				this.connections.addElement(new PooledConnection(newConnection()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("数据库连接创建失败");
				e.printStackTrace();
			}
			 System.out.println(" 数据库连接己创建 ......");
		}		
	}
	/**
	 * 创建一个数据库连接并返回
	 * @return
	 * @throws SQLException
	 */
	private Connection newConnection() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		if(this.connections.size()==0){
			DatabaseMetaData metaData = conn.getMetaData();
			/*driverMaxConnections 为返回的一个整数，表示此数据库允许客户连接的数目*/
			int driverMaxconnections = metaData.getMaxConnections();
			/*如果连接池中设置的最大连接数量大于数据库允许的连接数目 , 则置连接池的最大,连接数目为数据库允许的最大数目*/
			if(driverMaxconnections>0 && this.maxConnections>driverMaxconnections){
				this.maxConnections=driverMaxconnections;
			}
			System.out.println("--------------:创建一个新的数据库连接");
		}
		return conn;
	}
	/**
	 * 获取一个数据库连接
	 */
	public synchronized Connection getConnection(){
		if(this.connections==null){
			System.out.println("连接池中没有连接,请先创建连接池");
			return null;
		}
		Connection conn = getFreeConnection();
		while(conn==null){
			System.out.println("wait...");
			try {
				wait(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=getFreeConnection();
		}
		return conn;
	}
	/**
	 * 获取一个可用的数据库连接
	 * @return
	 */
	private Connection getFreeConnection(){
		Connection conn = findFreeConnection();
		if(conn==null){
			//创建数据库连接
			createConnections(this.incrementalConnections);
			conn = findFreeConnection();
			if(conn==null){
				return null;
			}
		}
		return conn;
	}
	/**
	 * 查找连接池中所有的连接,找一个可用的数据库连接
	 * @return
	 */
	private Connection findFreeConnection(){
		Connection conn = null;
		PooledConnection pConn = null;
		Enumeration enumeration = this.connections.elements();
		while(enumeration.hasMoreElements()){
			pConn = (PooledConnection)enumeration.nextElement();
			if(!pConn.getBusy()){
				conn=pConn.getConnection();
				pConn.setBusy(true);
				//数据库连接是否可用
				if(!this.testConnection(conn)){
					try {
						conn = newConnection();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("创建连接失败");
						return null;
					}
					pConn.setConnection(conn);
				}
				break;
			}
		}
		System.out.println("--------获得了一个可用的数据库连接");
		return conn;
	}
	/**
	 * 测试数据库连接是否可用true:可用,false:不可用
	 * @param conn
	 * @return
	 */
	private boolean testConnection(Connection conn){
		try {
		if(this.testTable==null){
			/** 如果测试表为空，试着使用此连接的 setAutoCommit() 方法, 来判断连接否可用（此方法只在部分数据库可用，如果不可用 , 抛出异常）。注意：使用测试表的方法更可靠*/
			conn.setAutoCommit(true);
		}else{
			Statement s = conn.createStatement();
			String sql = "select count(1) from "+this.testTable;
				s.execute(sql);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			this.close(conn);
			return false;
		}
		return true;
	}
	/**
	 * 将连接返回到连接池中
	 * @param conn
	 */
	public void returnConnection(Connection conn){
		System.out.println("--将连接返回到连接池中");
		if(this.connections==null){
			System.out.println("连接池不存在,无法返回此连接到连接池");
			return;
		}
		PooledConnection pconn = null;
		Enumeration enumeration = connections.elements();
		while(enumeration.hasMoreElements()){
			pconn = (PooledConnection)enumeration.nextElement();
			if(conn==pconn.getConnection()){
				pconn.setBusy(false);
				break;
			}
		}
	}
	
	/**
	* 返回连接池的初始大小
	* 
	* @return 初始连接池中可获得的连接数量
	*/
	public int getInitialConnections() {
		return this.initialConnections;
	}
	/**
	* 设置连接池的初始大小
	* 
	* @param 用于设置初始连接池中连接的数量
	*/
	public void setInitialConnections(int initialConnections) {
		this.initialConnections = initialConnections;
	}
	/**
	* 返回连接池自动增加的大小 、
	* 
	* @return 连接池自动增加的大小
	*/
	public int getIncrementalConnections() {
		return this.incrementalConnections;
	}
	/**
	* 返回连接池中最大的可用连接数量
	* 
	* @return 连接池中最大的可用连接数量
	*/


	public int getMaxConnections() {
	return this.maxConnections;
	}


	/**
	* 设置连接池中最大可用的连接数量
	* 
	* @param 设置连接池中最大可用的连接数量值
	*/


	public void setMaxConnections(int maxConnections) {
	this.maxConnections = maxConnections;
	}


	/**
	* 设置连接池自动增加的大小
	* 
	* @param 连接池自动增加的大小
	*/


	public void setIncrementalConnections(int incrementalConnections) {
		this.incrementalConnections = incrementalConnections;
	}
	/**
	 * 创建数据库链接
	 * @return
	 */
	public static Connection getConnection_on(){
		if(connection==null){
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	/**
	 * 关闭数据库声明
	 * @param pstmt
	 */
	public static void close(PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				pstmt=null;
			}
		}
	}
	/**
	 * 关闭数据库资源
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
	/**
	 * 关闭数据库数据集
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs=null;
			}
		}
	}
	/**
	 * 关闭数据库数据集和数据库声明
	 * @param pstmt
	 * @param rs
	 */
	public static void close(PreparedStatement pstmt,ResultSet rs){
		close(pstmt);
		close(rs);
	}
	/**
	 * 关闭数据库数据集,声明,资源
	 * @param pstmt
	 * @param rs
	 * @param conn
	 */
	public static void close(PreparedStatement pstmt,ResultSet rs,Connection conn){
		close(pstmt, rs);
		close(conn);
		
	}
	/**
	 * 连接池的单项连接
	 * @author Administrator
	 *
	 */
	class PooledConnection{
		/**
		 * 数据库链接
		 */
		private Connection conn = null;
		/**
		 * 当前数据库链接是否被使用true:使用中,false未使用
		 */
		private boolean busy = false;
		/**
		 * 将创建的链接放入链接集合
		 * @param connection
		 */
		public PooledConnection(Connection connection){
			this.conn = connection;
		}
		/**
		 * 返回数据连接
		 * @return
		 */
		public Connection getConnection(){
			return this.conn;
		}
		/**
		 * 设置当前单项连接中的连接
		 * @param connection
		 */
		public void setConnection(Connection connection ){
			this.conn = connection;
		}
		/**
		 * 返回当前连接是否正忙,ture:正忙 false:空闲
		 * @return
		 */
		public boolean getBusy(){
			return this.busy;
		}
		/**
		 * 设置当前连接是否正忙
		 * @param busy
		 */
		public void setBusy(boolean busy){
			this.busy=busy;
		}
		
	}
}
