package pack01.ha;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		//UserDTO dto = new UserDTO();
		UserDTO dto = null;
		while(true) {
			if(dto == null || dto.getUser_id() == null) {
				System.out.println("================================================");
				System.out.println("원하시는 메뉴를 선택해주세요");
				System.out.println("1. 로그인\t2. 회원가입\t3. 프로그램 종료");
				System.out.println("================================================");
				int menu1 = Integer.parseInt(sc.nextLine());
				if(menu1 == 1) {
					dto = new UserDTO();
					if(dao.loginUser1(dto)) {
						
					}else {
						System.out.println("다음에 봐용");
						break;
					}sc
					
					
//					for (int i = 1; i < 3; i++) {
//						System.out.print("아이디를 입력해주세요 : ");
//						String id = sc.nextLine();
//						System.out.print("비밀번호를 입력해주세요 : ");
//						String pw = sc.nextLine();
//						dto = dao.loginUser(id, pw);
//						if(i == 3) {
//							System.out.println("프로그램 종료합니다");
//							break label;
//						}//if
//						//if(id.equals(join.getUser_id()) && pw.equals(join.getUser_pw())) {
//						if(dto.getUser_id() != null) {
//							break;
//						}//if
//					}//for
				}else if(menu1 == 2) {
					UserDTO joinDto = new UserDTO();
					System.out.println("회원가입");
					System.out.print("아이디를 입력하세요 : ");
					String a = sc.nextLine();
					joinDto.setUser_id(a);
					if(dao.check(a)==true) {
					}else {
						System.out.print("비밀번호를 입력하세요 : ");
						joinDto.setUser_pw(sc.nextLine());
						System.out.print("성을 입력하세요 : ");
						joinDto.setLast_name(sc.nextLine());
						System.out.print("이름을 입력하세요 : ");
						joinDto.setFirst_name(sc.nextLine());
						dao.joinUser(joinDto);
					}
				}else if(menu1 == 3) {
					System.out.println("프로그램 종료합니다");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다");
				}//if
			}else {
				System.out.println("1. 회원정보 수정\t2. 회원탈퇴\t3. 공지사항 보기\t4. 로그아웃\t5. 프로그램 종료");
				int menu2 = Integer.parseInt(sc.nextLine());
				if(menu2 == 1) {
					System.out.println("회원정보 수정");
					dao.update(dto);
				}else if(menu2 == 2) {
					System.out.println("회원 탈퇴");
					dao.delete(dto);
				}else if(menu2 == 3) {
					System.out.println("공지사항 보기");
					NoticeDAO notidao = new NoticeDAO();
					System.out.println("。。。。。。。。。");
					notidao.viewList(notidao.getnotiList());
				}else if(menu2 == 4) {
					System.out.println("로그아웃 합니다.");
					dto = null;
					
				}else if(menu2 == 5) {
					System.out.println("프로그램 종료합니다");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다");
				}
			}
		}//while
		System.out.println("끝!!!!!!");
		sc.close();
	}//main()
}//class
