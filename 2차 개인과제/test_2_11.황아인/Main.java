package Last_Project_11;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		String id;
		String pw;
		String name;
		int inputMenu = 0;
		while (true) {
			if (dto == null || dto.getUser_id() == null) {
				System.out.println("어서오세요. 원하시는 메뉴를 선택하세요.");
				System.out.println("1. 로그인		2. 회원가입		3. 프로그램종료");
				inputMenu = Integer.parseInt(sc.nextLine());
				if (inputMenu == 1) {
					System.out.println("로그인 페이지입니다");
					System.out.println("아이디와 패스워드를 입력해주세요");
					int cnt = 0;
					while (cnt < 3) {

						id = dao.rtnStrMsg(sc, "아이디 : ");
						pw = dao.rtnStrMsg(sc, "패스워드 : ");
						if (dao.loginUser(id, pw)) {
							dto.setUser_id(id);
							dto.setUser_pw(pw); // 회원정보 수정 키값
							dto.setFirst_name(dao.dto.getFirst_name()); // 필요없을 수도 있음 확인필
							dto.setLast_name(dao.dto.getLast_name());
							cnt = 0; // 추후 로그인 시도를 위한 초기화
							break;
						} else {
							cnt++;
							System.out.println("아이디 또는 패스워드가 맞지 않습니다. 다시 입력해주세요.");
						}
					} // while
					if (cnt == 3) {
						System.out.println("아이디 또는 패스워드 확인 후 다시 로그인해주세요.");
						break;
					} // if b
				}else if (inputMenu == 2) {
					System.out.println("회원가입 페이지입니다.");
					UserDTO joinDto = new UserDTO();

					joinDto.setUser_id(dao.rtnStrMsg(sc, "사용하실 아이디를 입력해주세요."));
					joinDto.setUser_pw(dao.rtnStrMsg(sc, "사용하실 패스워드를 입력해주세요."));
					joinDto.setFirst_name(dao.rtnStrMsg(sc, "이름을 입력해주세요."));
					joinDto.setLast_name(dao.rtnStrMsg(sc, "성을 입력해주세요."));

					dao.joinUser(joinDto);		
						
				}else if (inputMenu == 3) {
					String system = dao.rtnStrMsg(sc, "Y. 종료	 N. 취소");
					if (system.toUpperCase() == "Y") {
						System.out.println("프로그램을 종료합니다. ");
						dto = null;
					} else {
						System.out.println("이용해주셔서 감사합니다.");
					} // if system
						
						
						
				}		
						
			}else {
				System.out.println("원하시는 메뉴를 선택하세요.");
				inputMenu = Integer.parseInt(dao.rtnStrMsg(sc, "4. 로그아웃		5. 회원정보수정 	6. 회원탈퇴 	7. 공지사항 보기"));
				if (inputMenu == 4) {
					String logout = null;
					System.out.println("로그아웃하시겠습니까?");
					logout = dao.rtnStrMsg(sc, "Y. 로그아웃		N. 취소");

					if (logout.toUpperCase() == "Y") {
						System.out.println("로그아웃되었습니다. 다시 로그인해주세요.");
						dto = null;

					} else {
						main(args);
					} // if logout
				} else if (inputMenu == 5) {
					int cnt2 = 0;
					System.out.println("회원정보 수정 페이지입니다.");
					while (cnt2 < 3) {
						pw = dao.rtnStrMsg(sc, "패스워드를 입력해주세요.");
						id = dto.getUser_id();
						boolean check = dao.updateCheck(id, pw);
						if (check) {
							dto.setUser_id(id);
							dto.setUser_pw(pw);
							int cnt = 0;
							break;
						} else {
							cnt2++;
							System.out.println("패스워드가 맞지않습니다. 다시 입력해주세요.");
						} // if check
					} // while
					if (cnt2 == 3) {
						System.out.println("패스워드가 맞지않아 초기화면으로 돌아갑니다.");
						break;
					} // if b
					System.out.println("수정을 원하시는 정보를 선택해주세요.\n입력하지않으시면 기존 정보를 유지합니다.");
					System.out.println("패스워드 : ****");
					System.out.print("이름 : " + dto.getLast_name());
					System.out.println(dto.getFirst_name());
					UserDTO updateDto = new UserDTO();
					updateDto.setUser_id(dto.getUser_id());
					updateDto.setUser_pw(dto.getUser_pw()); // 기존 키값 가지고 오기
					String userPw = dao.rtnStrMsg(sc, "비밀번호 : ");
					if (userPw.trim().length() == 0) {
						updateDto.setUser_pw(dto.getUser_pw());
					} else {
						updateDto.setUser_pw(userPw);
					}
					String lastName = dao.rtnStrMsg(sc, "성 :");
					if (lastName.trim().length() == 0) {
						updateDto.setLast_name(dto.getLast_name());
					} else {
						updateDto.setLast_name(lastName);
					}
					String firstName = dao.rtnStrMsg(sc, "이름 :");
					if (firstName.trim().length() == 0) {
						updateDto.setFirst_name(dto.getFirst_name());
					} else {
						updateDto.setFirst_name(firstName);
					}
					dao.updateUser(updateDto);
					System.out.println("수정이 완료되었습니다. 메인으로 돌아갑니다.");
				}else if(inputMenu == 6) {
					System.out.println("회원탈퇴 페이지입니다.");
					String flag = dao.rtnStrMsg(sc,
							"정말 탈퇴하시겠습니까?" + "\n" + "탈퇴를 원하시면 Y를 입력하세요." + "\n" + "그외 입력시 처음화면으로 돌아갑니다.");
					if ( flag.toUpperCase().equals("Y") ) {
						int cnt3 = 0;
						String loginId, loginPw;
						while ( cnt3 < 3 ) {
							loginId = dto.getUser_id();
							loginPw = dto.getUser_pw();
							
							id = dao.rtnStrMsg(sc, "아이디를 입력해주세요.");
							pw = dao.rtnStrMsg(sc, "비밀번호를 입력해주세요.");
							
							if ( id.toUpperCase().equals(loginId) || pw.toUpperCase().equals(loginPw) ) {
								boolean check = dao.deleteUser(id);
								if ( check ) {// 탈퇴 완료시 dto의 값을 비워줌
									System.out.println("저희 서비스를 이용해주셔서 감사합니다.");
									cnt3 = 0;
									dto = null;
									break;
								} else {
									System.out.println("정상적인 처리가 이루어지지 않았습니다. 입력한 정보를 다시 확인해주세요.");
								}//check if
							} else {
								cnt3++;
								System.out.println("패스워드가 맞지않습니다. 다시 입력해주세요.");
								if ( cnt3 == 3 ) {
									System.out.println("패스워드가 맞지않아 초기화면으로 돌아갑니다.");
									break;
								}//if
							}//check if
						}//while	
					}//delete if
				}else if (inputMenu == 7) {
					System.out.println("공지사항 페이지입니다.");
					System.out.println("=====< 공지사항 >======");
					NoticeDAO dao2 = new NoticeDAO();
					
					dao2.viewList(dao2.noticeList());
				}//if
			}//큰 if
		} // while
	}// m
}// c

