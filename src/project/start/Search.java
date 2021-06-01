package project.start;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) {
		Connection conn = null;	//	커넥션
		PreparedStatement pstmt = null;
		ResultSet rs = null;	//	결과 셋
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			
			System.out.print("검색어:");
			String keyword = scanner.next();
			
			String sql = "SELECT name, hp, tel " +
						" FROM phone_book " + 
						"WHERE lower(name) LIKE ?";
			System.out.println("Template:" + sql);
			//	실행 계획 마련 -C> LIKE 검색시의 tip
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword.toLowerCase() + "%");
			
			//	쿼리 수행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");
				
				//	출력
				System.out.printf("%s, %s, %s%n", name, hp, tel);
			}
			
			scanner.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}

	}

}
