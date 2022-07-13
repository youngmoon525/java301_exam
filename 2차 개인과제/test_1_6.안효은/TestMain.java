package test_1_6;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		//로그인과 회원가입 구현
		UserDAO dao = new UserDAO();
		UserDTO dto = null;
		
		NoticeDAO ntDao = new NoticeDAO();
		
		Scanner sc = new Scanner(System.in);
		String id = null;
		String pw = null;
		
		//User_TBL 테이블을 만들어야 할듯
		//Notice_TBL도 만들어야 할 듯
		//그니까 자바로 데이터베이스를 이리저리 해야함
		
		boolean b = true;
		label : while(b) {
			if (dto == null || dto.getUser_id() == null) {
				System.out.println("===================================");
				System.out.println("1.로그인 2.회원가입 3.프로그램 종료");
				System.out.println("===================================");
				System.out.print("▶ ");
				String menu = sc.nextLine();
				if(menu.equals("1")) {
					//방법1
//					System.out.println("로그인 창으로 이동합니다. 3회 오류시 종료!");
//					for(int i=1; i<6; i++) {
//						System.out.print("아이디를 입력해주세요 ▶ ");// <=inputType
//						id = sc.nextLine();
//						System.out.print("패스워드를 입력해주세요 ▶ ");// <=input type='password'
//						pw = sc.nextLine();
//						dto = dao.login(id, pw);
//						if(dto.getUser_id() != null) break;
//						if(i==3) {
//							System.out.println("종료됩니다.");
//							//break label;
//							b = false;
//							break;
//						}//if
//					}//for
					//방법2
					dto = new UserDTO();
					System.out.println("로그인 창으로 이동합니다. 3회 오류시 종료!");
					for(int i=1; i<6; i++) {
						dto.setUser_id(dao.rtnStrMsg(sc, "아이디를 입력하세요 ▶ "));// <=inputType
						dto.setUser_pw(dao.rtnStrMsg(sc, "패스워드를 입력해주세요 ▶ "));// <=input type='password'
						if(dao.login1(dto) == true) break;
						if(i==3) {
							System.out.println("종료됩니다.");
							//break label;
							b = false;
							break;
						}//if
					}//for
					//방법 3 - 사랑님 방법
//					dto = new UserDTO();
//					if(dao.loginUser1(dto)) {
//					}else {
//						break;
//					}
				}else if(menu.equals("2")) {
					System.out.println("회원가입 창으로 이동합니다.");
					UserDTO joinDto = new UserDTO();
					joinDto.setUser_id(dao.rtnStrMsg(sc, "아이디를 입력하세요 ▶ "));
					//true면 굳이 안써도 된다. ==은 주로 숫자에 쓴다.
					if(dao.checkId(joinDto.getUser_id())) {
					//if(dao.check(joinDto.getUser_id()) == true) {
						System.out.println("중복된 아이디입니다.");
						continue;
					}else {
						joinDto.setUser_pw(dao.rtnStrMsg(sc, "비밀번호 입력하세요 ▶ "));
						joinDto.setFirst_name(dao.rtnStrMsg(sc, "성 입력하세요 ▶ "));
						joinDto.setLast_name(dao.rtnStrMsg(sc, "이름 입력하세요 ▶ "));
						dao.join(joinDto);
					}
				}else if(menu.equals("3")) {
					dao.exit();
					break;
				}else {
					dao.error();
					System.out.println("1번을 누르시면 다시 시작하고, 나머지 키를 누르시면 종료합니다 ▶ ");
					String num = sc.nextLine();
					if(num.equals("1")) {
						main(args);
					}else{
						dao.exit();
						break label;
					}//if
				}//if
			
			}else {//로그인 성공 후
				System.out.println("======================================================================================");
				System.out.println("0.회원정보 보기 1.회원정보 수정 2.회원 탈퇴 3.공지사항 확인 4.로그아웃 5.프로그램 종료");
				System.out.println("======================================================================================");
				System.out.print("▶ ");
				String number = sc.nextLine();
				//UserDTO joinDto = new UserDTO();
				if(number.equals("0")) {
					dao.viewList(dto);
				}else if(number.equals("1")) {
					String pc = dao.rtnStrMsg(sc, "비밀번호를 다시 입력해주세요 ▶ ");
					if(pc.equals(dto.getUser_pw())) {
						String ck =  dao.rtnStrMsg(sc, "변경할 회원정보 1.비밀번호 2.이름 3.성 ▶ ");
						if(!ck.equals("1") && !ck.equals("2") && !ck.equals("3")) {
							dao.error();
						}else{
							if(ck.equals("1")) {
								dto.setUser_pw(dao.rtnStrMsg(sc, "변경할 비밀번호를 입력해주세요 ▶ "));
							}else if(ck.equals("2")) {
								dto.setFirst_name(dao.rtnStrMsg(sc, "변경할 이름을 입력해주세요 ▶ "));
							}else if(ck.equals("3")) {
								dto.setLast_name(dao.rtnStrMsg(sc, "변경할 성을 입력해주세요 ▶ "));
							}//if
							dao.userUpdate(dto);						
						}//if	
					}else {
						System.out.println("비밀번호가 틀렸습니다.");
					}//if
				}else if(number.equals("2")) {
					dto.setUser_id(dao.rtnStrMsg(sc, "아이디를 다시 한번 더 입력해주세요 ▶ "));
					dto.setUser_pw(dao.rtnStrMsg(sc, "비밀번호를 다시 한번 더 입력해주세요 ▶ "));
					dao.userDelete(dto);
					dto = null;
				}else if(number.equals("3")) {
					//공지사항 보기
					System.out.println("++++++++++++++++++++++++++++++++++++++++++");
					ntDao.notice(ntDao.noticeList());
					System.out.println("++++++++++++++++++++++++++++++++++++++++++");
				}else if(number.equals("4")) {
					System.out.println("로그아웃 합니다.");
					dto = null;// 로그아웃 ( Web == Session );
				}else if(number.equals("5")) {
					dao.exit();
					break;
				}else {
					dao.error();
				}
			}//if
		}//while
		sc.close();
	}//main()
}//class
