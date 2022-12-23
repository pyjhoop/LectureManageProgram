package com.kh.view;

import java.util.Scanner;

public class ManageView {
	Scanner sc = new Scanner(System.in);
	
	
	public void mainPage() {
		System.out.println("\n  == 프로그램 사용을 위해 로그인이 필요합니다 ==");
		
		System.out.print("아이디 입력 : ");
		String managerId = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String managerPwd = sc.nextLine();
		
		// 로그인 기능 구현...
		
		while(true) {
			System.out.println("\n   == 강의관련 관리 프로그램 ==");
		    System.out.println("┌───────────────────────────────┐");
		    System.out.println("│   1.  전체강사 조회     		│");    // 연준
		    System.out.println("│   2.  전체강사와 강의 조회     	│");    // 인호 
		    System.out.println("│   3.  학생전체 조회     		│");    // 진원
		    System.out.println("│   4.  이름으로 강사정보조회	        │");// 인호
		    System.out.println("│   5.  이름으로 강의조회(키워드)  	│");    // 연준
		    System.out.println("│   6.  강사 추가  			│");		// 진원
		    System.out.println("│   7.  강의 추가     		│");		// 연준
		    System.out.println("│   8.  강의 삭제    		│");		// 인호
		    System.out.println("│   9.  입/퇴사여부 변경      	│");	// 진원
		    System.out.println("│  10.  이벤트 개시    		│");		// 연준, 인호, 진원
		    System.out.println("│   0. 프로그램 종료      		│");
		    System.out.println("└───────────────────────────────┘");
		    System.out.print(">> 메뉴 선택 : ");
		    int menu = sc.nextInt();
		    sc.nextLine();
		}
	}
}
