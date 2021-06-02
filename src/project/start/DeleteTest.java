package project.start;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
	
		ResultSet rs = null;
//		int updateCount = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			System.out.println("삭제");
			System.out.print("번호:");
			String keyword = scanner.next();
			String sql = "DELETE FROM phone_book " +
						"WHERE id = " + keyword; 
			System.out.println("query:" + sql);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
//			String sql2 = "COMMIT";
//			System.out.println("query:" + sql2);
//			stmt2 = conn.createStatement();
//			rs2 = stmt.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				
			}
		}

	}

}
