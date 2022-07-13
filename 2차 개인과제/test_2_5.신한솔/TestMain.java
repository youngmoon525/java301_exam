package test.last;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		UserDTO dto = null;
		NoticeDAO noticeDao = new NoticeDAO();
		
		label: while (true) {
			if (dto == null || dto.getUser_id() == null) {
				System.out.println("=====================================================================");
				System.out.println("메뉴를 선택하세요.");
				System.out.println("① 로그인\t\t② 회원가입\t\t③프로그램 종료");
				int mainMenu = Integer.parseInt(scn.nextLine());

				//로그인 ▶ 3회 불일치시 프로그램 종료
				if (mainMenu == 1) {
					for (int i = 1; i <= 3; i++) {
						System.out.println("=====================================================================");
						dto = new UserDTO();
						System.out.println("ID와 비밀번호를 입력해주세요");
						dto.setUser_id(dao.scnMsg(scn, "ID : "));
						dto.setUser_pw(dao.scnMsg(scn, "비밀번호 : "));
						if(dao.login(dto) == true) {
							break;
						}else {
							System.out.println("=====================================================================");
							System.out.println("⚠ 존재하지 않는 ID입니다.");
						}//if
						if (i == 3) {
							System.out.println("=====================================================================");
							System.out.println("⚠ 로그인 3회 실패로 프로그램을 종료합니다.");
							break label;
						}//if
					}//for
					
					/*for (int i = 1; i <= 3; i++) {
						System.out.println("ID와 비밀번호를 입력해주세요");
						System.out.print("ID : ");
						String id = scn.nextLine();
						System.out.print("비밀번호 : ");
						String pw = scn.nextLine();
						dto = dao.login_2(id, pw);
						if (dto.getUser_id() != null) {
							break;
						} // if
						System.out.println("=====================================================================");
						if (i == 3) {
							System.out.println("존재하지 않는 ID입니다. 프로그램을 종료합니다.");
							break label;
						} // if
					} // for
					*/
					
				//가입 ▶ 존재하는 아이디일 경우 재입력
				} else if (mainMenu == 2) {
					System.out.println("=====================================================================");
					System.out.println("회원가입을 진행합니다.");
					System.out.println("=====================================================================");
					UserDTO joinDto = new UserDTO();
					joinDto.setUser_id(dao.scnMsg(scn, "ID를 입력하세요 : "));
					if(dao.eqauls(joinDto.getUser_id()) == 1) {
						System.out.println("=====================================================================");
						System.out.println("⚠ 존재하는 ID입니다");
					}else {
						joinDto.setUser_pw(dao.scnMsg(scn, "비밀번호를 입력하세요 : "));
						joinDto.setLast_name(dao.scnMsg(scn, "성을 입력하세요 : "));
						joinDto.setFirst_name(dao.scnMsg(scn, "이름을 입력하세요 : "));
						dto = dao.join(joinDto);
					}//if
					
				//종료
				} else if (mainMenu == 3) {
					System.out.println("=====================================================================");
					System.out.println("프로그램을 종료합니다.");
					break;

				//그외
				} else {
					System.out.println("=====================================================================");
					System.out.println("잘못 입력하셨습니다 💢💢");
				}//if

			} else {
				System.out.println("=====================================================================");
				System.out.println("🎁 로그인 중 🎁\n");
				System.out.println("① 회원 정보 수정\t② 회원탈퇴\t\t③ 공지사항보기\n④ 로그아웃\t\t⑤ 종료");
				int loginMenu = Integer.parseInt(scn.nextLine());

				//회원 정보 수정 ▶ 비밀번호 입력받고 비교
				if (loginMenu == 1) {
					System.out.println("=====================================================================");
					System.out.println("본인확인을 위해 비밀번호를 입력해주세요.");
					String pw = dao.scnMsg(scn, "비밀번호 : ");
					if (pw.equals(dto.getUser_pw())) {
						System.out.println("=====================================================================");
						System.out.println("아무것도 입력하지 않으면 기존값을 유지합니다.");
						System.out.println("새 정보를 입력하세요.");
						String last_name = dao.scnMsg(scn, "성 : ");
						String first_name = dao.scnMsg(scn, "이름 : ");
						if(last_name.trim().length() == 0) {
							last_name = dto.getLast_name();
							dto.setFirst_name(first_name);
						}else if(first_name.trim().length() == 0) {
							first_name = dto.getFirst_name();
							dto.setLast_name(last_name);
						}else {
							dto.setLast_name(last_name);
							dto.setFirst_name(first_name);
						}//if
						dao.update(dto);
					} else {
						System.out.println("=====================================================================");
						System.out.println("비밀번호를 다시 입력해주세요 💢💢");
					}//while

				//회원 탈퇴 ▶ 아이디, 비밀번호 입력받고 비교
				} else if (loginMenu == 2) {
					String flag = dao.scnMsg(scn, "정말 삭제하시겠습니까? \nY. 삭제\tN.취소\n");
					if(flag.toUpperCase().endsWith("Y")) {
						System.out.println("=====================================================================");
						System.out.println("회원탈퇴를 진행합니다.");
						System.out.println("=====================================================================");
						System.out.println("본인확인을 위해 ID와 비밀번호를 입력해주세요");
						String id = dao.scnMsg(scn, "ID : ");
						String pw = dao.scnMsg(scn, "비밀번호 : ");
						if(id.equals(dto.getUser_id()) && pw.equals(dto.getUser_pw())) {
							System.out.println("탈퇴되었습니다.");
							dao.quit(dto);
							dto = null;
						}else {
							System.out.println("=====================================================================");
							System.out.println("잘못 입력하셨습니다 💢💢");
						}//if
					}else if(flag.toUpperCase().endsWith("N")) {
						System.out.println("=====================================================================");
						System.out.println("회원 탈퇴가 취소되었습니다.");
					}else {
						System.out.println("=====================================================================");
						System.out.println("잘못 입력하셨습니다 💢💢");
					}//if

				//공지사항보기
				} else if (loginMenu == 3) { // 공지사항 보기
					System.out.println("=====================================================================");
					System.out.println("❗ 공지사항 ❗");
					System.out.println("=====================================================================");
					//noticeDao.notice();
					noticeDao.notice_2ver();
					
				//로그아웃
				} else if (loginMenu == 4) {
					dto = null;

				} else if (loginMenu == 5) {
					System.out.println("=====================================================================");
					System.out.println("프로그램을 종료합니다.");
					break;

				//잘못 눌렀습니다
				} else {
					System.out.println("=====================================================================");
					System.out.println("잘못 입력하셨습니다 💢💢");
				} // if
			} // if
		} // while
		scn.close();
	}// main()
}// class