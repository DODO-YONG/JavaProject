package project.mini;

import java.sql.Connection;//	JDBC API
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		String dbuser = "hr";
		String dbpass = "hr";
		Connection conn = null;
		
		try {
		// Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// connection 생성
		conn = DriverManager.getConnection(DBConfig.DBURL,	//	db 접속 rul
											dbuser,
											dbpass);
		System.out.println(conn);
		System.out.println("연결성공");
		
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.err.println("SQLError!");
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
}
