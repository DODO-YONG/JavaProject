package project.start;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
	
		ResultSet rs = null;
		int updateCount = 0;
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			System.out.println("추가");
			System.out.print("이름:");
			String keyword = scanner.next();
			System.out.print("hp:");
			String keyword_2 = scanner.next();
			System.out.print("tel:");
			String keyword_3 = scanner.next();
			
			String sql = "insert into phone_book " +
						"values(seq_phone_book_pk.nextval, '"
						+ keyword + "', '"
						+ keyword_2 + "', '"
						+ keyword_3 + "')"; 
			
			
			System.out.println("query:" + sql);
			
			stmt = conn.createStatement();
			updateCount = stmt.executeUpdate(sql);
			System.out.println(updateCount);
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
