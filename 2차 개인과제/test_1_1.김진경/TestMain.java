import java.util.Scanner;



public class TestMain {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	UserDAO dao = new UserDAO();
	
//	dao.dd(sc); 학생 목록 보여주는거 시험삼아
	UserDTO dto = null;
	
	while(true) {
		
		if(dto == null || dto.getUser_id() == null) { 
			dto = new UserDTO();
			System.out.println("\n============================================================\n");	
			System.out.println("\t\t　　　< 메인 화면 >\n");
			System.out.println("\t　　1.로그인 , 2.회원가입, 3.종료\n");
			System.out.println("============================================================\n");	
			String menu = sc.nextLine();

			 if (menu.equals("1")) {
				 dto = new UserDTO(); //다시 객체 생성
				System.out.println("\t　　　　<로그인 창입니다>");
				if(dao.getLogin(dto)) { 
					System.out.println();
				}else {
					System.out.println("◆ 3회 입력 오류로 페이지가 종료됩니다!\n");
					break;
				}//if

			} else if (menu.equals("2")) { //회원가입
				dao.joinUser(dto);
				
			} else if (menu.equals("3")) { //종료
				if(dao.exit()) {
					break;
				}//if
			}else {
				System.out.println("◆ 잘못 입력하셨습니다!");
			}//안쪽 if끝

	    }else{
	    	
	    	System.out.println("============================================================\n");
	    	System.out.println("\t\t\t<메인 화면>");
	    	System.out.println();
			System.out.println("\t1.수정 ,  2.삭제 ,  3. 공지사항,  4. 로그아웃\n");
			System.out.println("============================================================");
			//int inputMenu = Integer.parseInt(sc.nextLine());
			String inputMenu = sc.nextLine();
			if(inputMenu.equals("1")) {
				dao.updateUser(dto);
			}else if(inputMenu.equals("2")) {
				if(dao.userDelete(dto)) {
					dto = null;
					break;
				}
				
			}else if(inputMenu.equals("3")) {	//공지사항
				dao.noticeSix();
				
			}else if(inputMenu.equals("4")) {
				System.out.println("▶ 로그아웃 성공\n");
					System.out.println(" 메인 화면으로 돌아갑니다!\n");
				dto = null;
			}else {
				System.out.println("◆ 잘못 입력하셨습니다!\n");
			}
	    }//if 끝
	}//while

		sc.close();
  }//main()

}//class
