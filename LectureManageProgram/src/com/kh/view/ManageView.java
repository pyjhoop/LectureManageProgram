package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ManageController;
import com.kh.model.vo.Instructor;

public class ManageView {
	Scanner sc = new Scanner(System.in);

	ManageController mc = new ManageController();

	public void mainPage() {
//		System.out.println("\n  == 프로그램 사용을 위해 로그인이 필요합니다 ==");
//		
//		System.out.print("아이디 입력 : ");
//		String managerId = sc.nextLine();
//		
//		System.out.print("비밀번호 입력 : ");
//		String managerPwd = sc.nextLine();

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
			System.out.println("│   0. 프로그램 종료      		│");
			System.out.println("└───────────────────────────────┘");
			System.out.print(">> 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				selectAllInstructor();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 0:
				return;
			default:
				System.out.println("0~10 사이의 숫자만 입력하세요!!");
			}

		}
	}
	
	public void selectAllInstructor() {
		int num = 1;
		ArrayList<Instructor> list = mc.selectAllInstructor(num);
		
		while(true) {
			displayList(list, num);
			
			System.out.println("1 ) 이전 페이지  2) 다음 페이지  3) 메인메뉴로 가기");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			
			if(choice == 2) {
				list = mc.selectAllInstructor(++num);
				
				if(list.isEmpty()) {
					displayFail("마지막 페이지 입니다.");
					--num;
					list = mc.selectAllInstructor(num);
					continue;
				}
				
				list.stream().forEach(System.out::println);
			}else if(choice == 3) {
				System.out.println("메인으로 돌아갑니다.");
				return;
			}else if(choice ==1 ) {
				if(num <= 1) {
					System.out.println("\n현재 첫 페이지입니다.");
					continue;
				}
				list = mc.selectAllInstructor(--num);
				list.stream().forEach(System.out::println);
			}
			
			
			
		}
	}
	

	// ==========================display method===================

	public void displayList(ArrayList<Instructor> list, int num) {
		
		System.out.println("\n == 강사 조회 결과 ==");
		System.out.println("page "+num);
		
		for(Instructor i: list) {
			System.out.println(i);
		}
		

	}

	public void displayFail(String message) {
		System.out.println("\n" + message);
	}
}
