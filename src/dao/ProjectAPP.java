package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProjectAPP {

	public static void main(String[] args) {
//		selectALL();
//		insertProject();
//		deleteProject();
//		searchProject();
		printProject();
		
	}
	private static void printProject() {
		Scanner scanner1 = new Scanner(System.in);
		int number = 0;
		System.out.println("*********************************");
		System.out.println("*\t전화번호 관리 프로그램\t*");
		System.out.println("*********************************");
		do {
		
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료 ");
		System.out.println("---------------------------------");
		System.out.print("메뉴번호: ");
		number = scanner1.nextInt();
		if (number == 1) {
			selectALL();
			System.out.println();
			continue;
		} else if (number == 2) {
			
			insertProject(scanner1);
			
			System.out.println();
			continue;
		} else if (number == 3) {
			deleteProject(scanner1);
			System.out.println();
			continue;
		} else if (number == 4) {
			
			searchProject(scanner1);
			
			System.out.println();
			continue;
		} else if (number ==5) {

		} else {
		
			System.out.println("다시입력해주세요");
			continue;
		}
		
		} while(number != 5);
		scanner1.close();
		System.out.println("*********************************");
		System.out.println("*\t      감사합니다.      \t*");
		System.out.println("*********************************");
	}
	
	private static void searchProject(Scanner scanner) {
		//	Scanner에서 키워드 입력 -> 부분 검색
//		Scanner scanner = new Scanner(System.in);
//		selectALL();
		System.out.println("<4.검색>");
		System.out.print("이름: ");
		String keyword = scanner.next();
		
		ProjectDAO dao = new ProjectDAOimpl();
		List<ProjectVO> list = dao.search(keyword);
		
		Iterator<ProjectVO> it = list.iterator();
		
		while(it.hasNext()) {
			ProjectVO vo = it.next();
			System.out.printf("%d. %s %s\t%s",
							vo.getId(),
							vo.getName(),
							vo.getHp(),
							vo.getTel());
			System.out.println();
		}
//		scanner.close();
	}
	
	private static void deleteProject(Scanner scanner) {
		//	scanner에서 저자 pk 입력 -> delete
//		Scanner scanner = new Scanner(System.in);
		selectALL();
		System.out.print("번호:");
		int id = scanner.nextInt();
		
		ProjectDAO dao = new ProjectDAOimpl();
		boolean success = dao.delete(Long.valueOf(id));
		System.out.println("[" + (success ?"삭제": "실패") + "되었습니다.]");
//		selectALL();
//		scanner.close();
	}
	private static void insertProject(Scanner scanner) {
		//	Scanner에서 이름 입력 -> INSERT
//		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scanner.next();
		System.out.print("휴대전화: ");
		String hp = scanner.next();
		System.out.print("집전화: ");
		String tel = scanner.next();
		
		ProjectVO vo = new ProjectVO(null, name, hp, tel);
		ProjectDAO dao = new ProjectDAOimpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println("[" + (success ? "등록": "실패") + "되었습니다.]");
		
//		selectALL();
//		scanner.close();
	}
	
	private static void selectALL() {
		ProjectDAO dao = new ProjectDAOimpl();
		List<ProjectVO> list = dao.getList();
		
		//	Iterator
		Iterator<ProjectVO> it = list.iterator();
		
		System.out.println("<1.리스트>");
//		System.out.println(it);
		while(it.hasNext()) {
			ProjectVO item = it.next();
//			System.out.println(item);
			System.out.printf("%d. %s %s\t%s%n",
					item.getId(),
					item.getName(),
					item.getHp(),
					item.getTel());
		}
	}

}
