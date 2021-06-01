package project.start;

import java.sql.*;

public class ConnectionTest {

	public static void main(String[] args) {
		String dbuser = "bituser";
		String dbpass = "bituser";
		Connection conn = null;
		
		try {
		// Driver load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//	connection 생성
		conn = DriverManager.getConnection(DBConfig.DBURL,
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
