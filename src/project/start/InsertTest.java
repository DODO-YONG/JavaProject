package project.start;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			System.out.println("삭제");
			System.out.print("번호:");
			String keyword = scanner.next();
			String sql = "DELETE FROM phone_book " +
						"WHERE id = ?";
			System.out.println("query:" + sql);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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
