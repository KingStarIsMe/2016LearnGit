package years.year2017.months09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.compiere.Adempiere;
import org.compiere.util.DB;

public class Day19 {
	static String sql = " select au.created,noticesubject from (select created,noticesubject from ad_note au order by au.created desc)au where rownum<=10 ";
	public static void main(String []args){ 
		Adempiere.startup(true); 
		Day19 d = new Day19();
		d.test_20170919();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st=DB.prepareStatement(sql, null);
			rs = st.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DB.close(rs, st);
		}
//		d.test_20170919();
		
	}
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBURL = "jdbc:oracle:thin:@192.168.1.50:1521:eyeshot";
	public static final String DBUSER = "adempiere";
	public static final String DBPASSWORD = "wx45854839";
	public void test_20170919(){
		Connection conn = null; // 鏁版嵁搴撹繛鎺ョ殑鎺ュ彛瀵硅薄
		Statement stmt = null;
		try {
			Class.forName(DBDRIVER); // 鍔犺浇鏁版嵁搴撻┍鍔ㄧ▼搴�
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 杩炴帴
 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int len = stmt.executeUpdate(sql); // 鎵ц鏇存柊鎿嶄綔
		ResultSet rs = null;
		try{
			stmt = conn.createStatement(); // 鍒涘缓Statement鎺ュ彛瀵硅薄
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println("created is "+rs.getString("created"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close(); // 鍏抽棴
				conn.close(); // 鍏抽棴鏁版嵁搴撹繛鎺�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
