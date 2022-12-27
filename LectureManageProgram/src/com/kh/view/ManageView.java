package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.InstructorController;
import com.kh.controller.ManageController;
import com.kh.controller.StudentController;
import com.kh.model.vo.Student;

public class ManageView {
	Scanner sc = new Scanner(System.in);

	ManageController mc = new ManageController();
	StudentController scon = new StudentController();
	InstructorController ic = new InstructorController();

	/**
	 * 로그인 메뉴
	 * @author 조진원
	 */
	public void loginPage() {
		
		while (true) {
			System.out.println("\n  == 프로그램 사용을 위해 로그인이 필요합니다 ==");
			System.out.print("(0) 종료\n");
			System.out.print("(1) 로그인\n");
			int menu = inputMenu();
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else if(menu == 1) {
				loginMenu();
			} else {
				System.out.println("다시 입력해 주세요");
				continue;
			}
			
		}
		
		
	}
	
	private void loginMenu() {
		System.out.print("아이디 입력 : ");
		String managerId = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String managerPwd = sc.nextLine();
		
		mc.login(managerId, managerPwd);
	}

	/**
	 * 메인 메뉴
	 * @author 조진원
	 */
	public void mainPage() {

		// 로그인 기능 구현...

		while (true) {
			System.out.println("\n   == 강의관련 관리 프로그램 ==");
			System.out.println("┌───────────────────────────────┐");
			System.out.println("│   1.  전체강사 조회     		│"); // 연준
			System.out.println("│   2.  전체강사와 강의 조회     	│"); // 인호
			System.out.println("│   3.  학생전체 조회     		│"); // 진원
			System.out.println("│   4.  이름으로 강사정보조회	        │");// 인호
			System.out.println("│   5.  이름으로 강의조회(키워드)  	│"); // 연준
			System.out.println("│   6.  강사 추가  			│"); // 진원
			System.out.println("│   7.  강의 추가     		│"); // 연준
			System.out.println("│   8.  강의 삭제    		│"); // 인호
			System.out.println("│   9.  입/퇴사여부 변경      	│"); // 진원
			System.out.println("│  10.  이벤트 개시    		│"); // 연준, 인호, 진원
			System.out.println("│   0.  로그아웃      		│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(">> 메뉴 선택 : ");
			int menu = inputMenu();

			if (menu == 0) {
				System.out.println("로그아웃");
				return;
			} else if (menu == 3) {
				boardStudent();
			} else if (menu == 6) {
				insertInstructorMenu(); // 강사 추가
			} else if (menu == 9) {
				updateInstructorMenu(); // 입/퇴사여부 변경
			}
		}
	}

	/**
	 * 강사 퇴사처리 후 연봉 0으로 설정 (트리거)
	 * @author 조진원
	 */
	private void updateInstructorMenu() {
		System.out.println();
		System.out.print("퇴사 처리할 강사번호 입력 : ");
		int insNo = sc.nextInt();

		ic.updateInstructor(insNo);
	}

	/**
	 * 강사 정보 추가
	 * @author 조진원
	 */
	private void insertInstructorMenu() {

		System.out.print("강사명 : ");
		String name = sc.nextLine();

		System.out.print("연봉 : ");
		int salary = sc.nextInt();
		sc.nextLine();

		System.out.print("강의번호 : ");
		int lecNo = sc.nextInt();
		sc.nextLine();

		System.out.print("입/퇴사 여부(입사 or 퇴사) : ");
		String resi = sc.nextLine();

		ic.insertInstructor(name, salary, lecNo, resi);

	}

	private void insertLectureMenu() {

		System.out.print("강의 타입(수능/내신) : ");
		String type = sc.nextLine();

		System.out.print("강의명 : ");
		String lecName = sc.nextLine();

		System.out.print("강의 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("수강 시간(??분 : ");
		String courseTime = sc.nextLine();

		System.out.print("할인율(1 ~ 100 사이 입력) : ");
		float disCount = sc.nextFloat();

		// 할인가
		int resultPrice = (int) (price * ((100 - disCount) / 100));

		//mc.insertLecture(type, lecName, price, courseTime, resultPrice);
	}

	/**
	 * 학생 페이지 전체조회
	 * @author user
	 * @param list
	 */
	public void displayList(ArrayList<Student> list) {
		System.out.println();
		System.out.println(list);
	}

	/**
	 * 학생 페이징
	 * @author 조진원
	 */
	public void boardStudent() {
		
		int page = 1; // 현재 페이지 
		int countlist = 5; // 한 페이지에 출력할 게시물 수
		int count = 0; // 총 개시글 수
		int totalPage = 0; // 총 페이지 수
		
		while (true) {
			ArrayList<Student> lists = new ArrayList<>();
			
			lists = scon.pasingStudentList(page); // 페이징한 게시물 받아오기
			
			count = scon.getCount(); // 총 게시물 받아오기
			
			totalPage = count / 5; // 총 페이지 수 구하기
			
			if (totalPage % countlist > 0) { // 게시물 초과하면 페이지수 보정
				totalPage++;
			}
			
			System.out.println();
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.printf("현재 페이지 (%d/%d)\n", page, totalPage);
			
			// 리스트 출력
			for (Student student : lists) {
				System.out.println(student);
			}

			int menu = inputBoardMenu();

			switch (menu) {
			case 1:
				// 이전 페이지 이동
				if (page == 1) {
					System.out.println("첫번째 페이지 입니다.");
				} else {
					page--;
				}
				break;
			case 2:
				// 다음 페이지 이동
				if (page == totalPage) {
					System.out.println("마지막 페이지 입니다.");
				} else {
					page++;
				}
				break;
			case 3:
				System.out.println("메인 메뉴로 이동합니다.");
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}
		}

	}

	/**
	 * 학생 페이지 이동 하는 메뉴
	 * @author 조진원
	 * @return
	 */
	public int inputBoardMenu() {

		int menu = 0;

		while (true) {
			try {
				System.out.println(
						"─────────────────────────────────────────────────────────────────────────────────────────────");
				System.out.printf("1) 이전 페이지  2) 다음페이지  3)종료 :");
				menu = sc.nextInt();
				if (menu > 0 && menu < 4) {
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				System.out.println("잘못된 형식 입니다.");
			} finally {
				sc.nextLine();
			}
		}
		return menu;
	}
	
	/**
	 * 메뉴 입력 받는 메소드
	 * @author 조진원
	 * @return
	 */
	public int inputMenu() {
		int menu = 0;
		
		try {
			System.out.print("메뉴를 입력해 주세요 : ");
			menu = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("잘못된 형식입니다.");
			menu = 3;
		} finally {
			sc.nextLine();
		}
		
		return menu;
	}
	
	public void displayFails(String msg) {
		System.out.println();
		System.out.println(msg);
	}

	public void displaySuccess(String msg) {
		System.out.println();
		System.out.println(msg);
	}
}
