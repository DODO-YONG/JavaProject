package dao;

import java.util.List;

public interface ProjectDAO {
	public List<ProjectVO> getList();	//	단순select
	public List<ProjectVO> search(String keyword);	// like 검색
	public ProjectVO get(String name);	//	name으로 가져오기
	public boolean insert(ProjectVO vo);	//	insert
	public boolean delete(String name);	//	

}
