import java.util.Scanner;

import phone.com.model.FirstPhonePhone;
import phone.com.model.SecondPhonePhone;
import phone.com.model.SubMenuMenu;
import phone.com.model.ThirdPhonePhone;

public class SuperSuperPhone {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
		
		

			System.out.println();
			System.out.println("  •────────•°•❀•°•────────•");
			System.out.println();
			System.out.println("  　　① 1세대 폰　② 2세대 폰　③ 3세대 폰");
			System.out.println();
			System.out.println("•───────────────────────•");
			System.out.println();
			System.out.print("요정 : 원하시는 세대 폰 번호를 입력하세요 ▶" );
			
			
			int generation = Integer.parseInt(scanner.nextLine());
			
			FirstPhonePhone phone = null;
			if(generation == 1) {
				phone = new FirstPhonePhone(1, "검정", "SKY", "종료");
				phone.printInfor();
				
			}else if(generation == 2) {
				phone = new SecondPhonePhone(2, "검정", "LG", "종료", "정보없음");
				phone.printInfor();
			}else if(generation ==3) {
				phone = new ThirdPhonePhone(3, "검정", "iPone", "종료", "정보없음");
				phone.printInfor();
				
			}else {
				System.out.println();
				System.out.println("요정 : 잘못입력 하셨습니다! 다시 입력해주세요!");
				System.out.println();
				main(args);
			}
			
			SubMenuMenu sm = new SubMenuMenu(scanner);
			sm.play(phone);
	
			scanner.close();
	}//main()
}//class
