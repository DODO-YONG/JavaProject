package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProjectAPP {

	public static void main(String[] args) {
//		selectALL();
		insertProject();

	}
	private static void insertProject() {
		//	Scanner에서 이름 입력 -> INSERT
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scanner.next();
		System.out.print("hp: ");
		String hp = scanner.next();
		System.out.print("tel: ");
		String tel = scanner.next();
		
		ProjectVO vo = new ProjectVO(name, hp, tel);
		ProjectDAO dao = new ProjectDAOimpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println("INSERT" + (success ? "성공": "실패"));
		
		selectALL();
		scanner.close();
	}
	
	private static void selectALL() {
		ProjectDAO dao = new ProjectDAOimpl();
		List<ProjectVO> list = dao.getList();
		
		//	Iterator
		Iterator<ProjectVO> it = list.iterator();
		
		System.out.println("====Project List");
//		System.out.println(it);
		while(it.hasNext()) {
			ProjectVO item = it.next();
//			System.out.println(item);
			System.out.printf("%s\t%s\t%s%n",
					item.getName(),
					item.getHp(),
					item.getTel());
		}
	}

}
