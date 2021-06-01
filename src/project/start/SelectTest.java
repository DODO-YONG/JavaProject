package project.start;

import java.sql.*;
// test 테이블로부터 모든 레코드를 불러와서 출

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//	레코드 객체
		
		try {
		//	커넥션 획득
		conn = DBConfig.getConnection();
		//	statement 생성
		stmt = conn.createStatement();	//	connection -> statement
		//  쿼리 실행
		String sql = "SELECT name, hp, tel " +
					" FROM phone_book";
		rs = stmt.executeQuery(sql);	// Select - executeQuery -> ResultSet 반환
		//	결과 객체 받아오기
		//  결과 출력
//		System.out.println(rs);
//		System.out.println(rs.next());
		while (rs.next()) {	//	한개 레코드 받아오기
			//	값 받아오기: 컬럼의 타입별 get 메서드 있음 
			String name = rs.getString("name");	//	1번째 컬럼의 Long데이터
			String hp = rs.getString("hp");
			String tel = rs.getString("tel");
			
			System.out.printf("%s:%s:%s%n", name, hp, tel);
			
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		

	}

}
