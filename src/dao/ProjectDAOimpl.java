package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOimpl implements ProjectDAO {
	//	공통 접속 메서드
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//	드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521/orcl";
			conn = DriverManager.getConnection(dburl,
					"bituser",
					"bituser");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		
		return conn;
	}

	@Override
	public List<ProjectVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		//	SELECT
		ResultSet rs = null;
		//	결과 객체
		List<ProjectVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			//	쿼리
			String sql = "select name, hp, tel " +
						"from phone_book";
			//	쿼리 실행
			rs = stmt.executeQuery(sql);
			
			// ResultSet -> JAVA 객체로 변환
			while(rs.next()) {
				String name = rs.getString(1);
				String hp = rs.getString(2);
				String tel = rs.getString(3);
				
				// DTO객체
				ProjectVO vo = new ProjectVO(name, hp, tel);
				//	DTO 객체 -> list 추가
				list.add(vo);
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
		return list;
	}

	@Override
	public List<ProjectVO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectVO get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ProjectVO vo) {
		//	.executeUpdate 메서드 -> int ( 삽입된 레코드 수)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			//	실행 계획
			String sql = "insert into phone_book " +
					"values(seq_phone_book_pk.nextval, ?, ?, ?)"; 
			pstmt = conn.prepareStatement(sql);
			//	파라미터 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			//	쿼리 수행
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
