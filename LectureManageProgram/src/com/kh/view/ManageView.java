package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.InstructorController;
import com.kh.controller.ManageController;
import com.kh.controller.StudentController;
import com.kh.model.vo.Instructor;
import com.kh.model.vo.Lecture;
import com.kh.model.vo.Student;

public class ManageView {
	Scanner sc = new Scanner(System.in);

	ManageController mc = new ManageController();
	StudentController scon = new StudentController();
	InstructorController ic = new InstructorController();

	public void mainPage() {
		

		while (true) {
//			System.out.println("\n  == 프로그램 사용을 위해 로그인이 필요합니다 ==");
//			
//			System.out.print("아이디 입력 : ");
//			String managerId = sc.nextLine();
//			
//			System.out.print("비밀번호 입력 : ");
//			String managerPwd = sc.nextLine();
//			
//			int num = mc.login(managerId, managerPwd);
//			if(num == 1) {
//				System.out.println("\n == 로그인 성공 ==");
//			}else {
//				System.out.println("\n == 로그인 실패 ==");
//				continue;
//			}
			
			
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
			case 2:selectAll();
				break;
			case 3:boardStudent();
				break;
			case 4:selectName();
				break;
			case 5:
				mc.selectLectureByKeyword(inputLectureName());
				break;
			case 6:insertInstructorMenu();
				break;
			case 7:
				mc.insertLecture(inputLecture());
				break;
			case 8:deleteLecture();
				break;
			case 9:updateInstructorMenu();
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
			System.out.println("===================================");
			
			if(choice == 2) {
				list = mc.selectAllInstructor(++num);
				
				if(list.isEmpty()) {
					displayFail("마지막 페이지 입니다.");
					--num;
					list = mc.selectAllInstructor(num);
					continue;
				}
				
			}else if(choice == 3) {
				System.out.println("메인으로 돌아갑니다.");
				return;
			}else if(choice ==1 ) {
				if(num <= 1) {
					System.out.println("\n현재 첫 페이지입니다.");
					list = mc.selectAllInstructor(num);
					continue;
				}
				list = mc.selectAllInstructor(--num);
			}
		}
	}
	
	public String inputLectureName() {
		System.out.println("\n == 이름 키워드로 강의 조회 == ");
		System.out.print("이름 : ");
		return sc.nextLine();
	}
	
	public Lecture inputLecture() {
		System.out.println("\n == 강의 추가 ==");
		System.out.print("강의 타입 : ");
		String type = sc.nextLine();
		
		System.out.print("강의 명 : ");
		String name = sc.nextLine();
		
		System.out.print("가격 : ");
		String price = sc.nextLine();
		
		System.out.print("수강시간 : ");
		String courseTime = sc.nextLine();
		
		System.out.print("할인된 금액 : ");
		int discount = sc.nextInt();
		sc.nextLine();
		
		Lecture l = new Lecture(type, name, Integer.parseInt(price), courseTime, discount);
		return l;
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
	
	public void displayLecList(ArrayList<Lecture> list) {
		for(Lecture l: list) {
			System.out.println(l);
		}
	}
	
	public void displaySuccess(String message) {
		System.out.println("\n" + message);
	}
	
	
	//-======================인호========================
	public void selectAll() {
		System.out.println("== 강사와 강의 조회 결과 ==");
		mc.selectAll();
	}
	
	public void selectName() {
		System.out.println("== 이름으로 강사 조회 == ");
		System.out.print("강사 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		mc.selectName(name);
	}
	
	public void deleteLecture() {
		System.out.println("== 강의 삭제 메뉴 == ");
		System.out.println("강의 번호를 입력하세요 : ");
		int lNo = sc.nextInt();
		sc.nextLine();
		mc.deleteLecture(lNo);
	}
	
	
	//===========================================응답메소드==============================
	
	public void displayNodate(String message) {
		System.out.println(message);
	}
	
	public void displayList(ArrayList list) {
		page(list);
	
	}
	
	public void page(ArrayList list) {
	      int count = 0;
	      int sum = 0;
	      while(true) {
	         if(count<5) {
	         System.out.println("page 1");
	         }else {
	            System.out.println("page " + (count/5+1));
	         }
	      while(true) {
	         boolean flag = true;
	         System.out.println(list.get(count));
	         count++;
	         if(count% 5==0 || count == list.size()) {
	            while(flag) {
	            System.out.println("1) 이전 페이지 2) 다음 페이지 3) 메인메뉴로 가기 ");
	            int num = sc.nextInt();
	            sc.nextLine();
	            if(num == 1) {
	               if(count <= 5) {
	                  System.out.println("현재 첫 페이지입니다.");
	                  continue;
	               } else if(count > 5) {
	                  flag = false;
	                  sum = 1;
	               }
	               
	            }else if(num == 2) {
	               if(count == list.size()) {
	                  System.out.println("마지막 페이지입니다.");
	                  continue;
	               } else {
	                  System.out.println("page " + (count/5+1));
	                  flag = false;
	                  sum = 2;
	               }
	            } else if(num == 3) {
	               return;
	            } else {
	               System.out.println("잘못 입력했습니다.");
	            }
	         }
	      }
	         if(sum == 1) {
	            if(count == list.size()) {
	               if(list.size()%5==0) {
	                  count = count - 10;
	                  sum = 0;
	                 break;
	               }else {
	               count = count-(list.size()%5+5);
	               sum = 0;
	               break;
	               }
	            }else {
	               count = count - 10;
	               sum = 0;
	              break;
	            }
	         } else if(sum ==2){
	            sum =0;
	            continue;
	         }
	   }
	   }
	   }
	
	
	
	//====================진원=======================
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
			
			if (count % countlist > 0) { // 게시물 초과하면 페이지수 보정
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

}
