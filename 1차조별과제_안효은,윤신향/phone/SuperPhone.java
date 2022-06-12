package com.phone;
import java.util.Scanner;

public class SuperPhone {
	/* 제목 : 개선 사항 
	 * 작성 일자:2022.06.12
	 * 작성자 : 김영문
	 * 내용 : 
	 * (_안효은,윤신향)
	 * 1.int menu = Integer.parseInt(scanner.nextLine()); 등 숫자 데이터 입력 시
	 * 캐스팅이 들어가는 구간의 경우 try catch 블럭을 통해 사용자가 입력한값이 숫자가 아닐경우의 예외처리가 필요
	 * 자바 응용 과제 중 rtnInt메소드를 활용하면 반복적으로 숫자입력이 필요한경우 재사용이 가능함
	 * => ex) 숫자가 필요한 구간 int menu = rtnInt();<=반드시 숫자를 입력하고 리턴하는 메소드를 구현해서 사용
	 * 
	 * 2.1세대에 없는 기능인 dmb~여러가지 메뉴가 노출되는 부분은 개선이 필요하나 예외처리가 잘 되어있음.
	 * 
	 * 3.전체적인 메뉴가 SubMenu로 재사용 되면서 3세대인지 2세대인지를 비교식은 generation 필드 보다는		
	 * if(phone instanceof FirstPhone) 로 비교하는게 가독성도 높고 효과적.
	 * 
	 * 
	 * 처음 하는 프로젝트지만 전체적으로 우수하게 완성되었으며 객체의 다형성과 main에서 사용할수있는 args 배열을 이용하거나 SubMenu클래스를 별도로 구현하신것은
	 * 매우 인상적인것같습니다.
	 * 
	 * 다소 아쉬운 점은 위의 3가지와 더불어, 전체적으로 프로그램을 완성하고 테스트를 좀 더 꼼꼼하게 하여
	 * 개발자의 입장에서가 아니라 사용자의 입장에서 해보면 더 좋은 프로그램을 만들수있을거라고 생각합니다.
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FirstPhone phone = null;

//		while(true) {
			System.out.println("=============================");
			System.out.println("원하시는 핸드폰을 선택하세요!");
			System.out.println("=============================");			
			System.out.println("1. 1세대  2. 2세대  3. 3세대 ");
			System.out.print("▶ ");
			int menu = Integer.parseInt(scanner.nextLine());
			
			if (menu == 1) {
				phone = new FirstPhone(1, "검정", "SKY", "종료");
				phone.print();
//				break;
				//continue;
			}else if (menu == 2) {
				phone = new SecondPhone(2, "검정", "LG", "종료", "정보없음");
				phone.print();
//				break;
				//continue;
			}else if (menu == 3) {
				phone = new ThirdPhone(3, "검정", "iPhone", "종료", "정보없음");
				
			
				//phone.print();
				
				
//				break;
				//continue;
			}else {
				System.out.println("=====================");
				System.out.println("잘못 선택하셨습니다! ");
				System.out.println("다시 입력해주세요!");
				System.out.println("=====================");
//				break;
				//continue;
				main(args);
			}//if
			
//		}//while
		
		SubMenu sm = new SubMenu(scanner);		
		sm.play(phone);
	
	}//main()
}//class