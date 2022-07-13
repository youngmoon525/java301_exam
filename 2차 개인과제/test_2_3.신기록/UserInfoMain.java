package pack05.ojdbc2;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserInfoDAO userDao = new UserInfoDAO();
		UserInfoDTO dto = null; 

		while (true) {

			if (dto == null || dto.getUser_id() == null) {

				System.out.println("0.전체 학생 조회 , 1.로그인 , 2.회원가입 3.종료");

				String menu =sc.nextLine();

				if (menu.equals("1")) {
					dto = new UserInfoDTO();
					if(userDao.loginUser(dto)  ) {
						
					}else{
						System.out.println("종료합니다");
						break;
					}
				} else if (menu.equals("2")) {
					System.out.println("회원가입");

					UserInfoDTO joinDto = new UserInfoDTO();
							
					while(true) {
							joinDto.setUser_id(userDao.rtnStrMsg(sc, "아이디를 입력하세요."));
						
						if (userDao.checkUser(joinDto)) {
							System.out.println("중복된 아이디입니다");
							continue;
						} else {
							joinDto.setUser_pw(userDao.rtnStrMsg(sc, "비밀번호 입력하세요."));
							joinDto.setFirst_name(userDao.rtnStrMsg(sc, "성 입력하세요."));
							joinDto.setLast_name(userDao.rtnStrMsg(sc, "이름 입력하세요."));
							userDao.joinUser(joinDto);
							System.out.println(" 회원가입이 완료되었습니다.");
							break;
						}
					}
				} else if (menu.equals("3")) {
					System.out.println("종료");

					break;
				} else {

					System.out.println(" 잘못 된 입력 입니다.");
				}

			} else {

				System.out.println("1.회원정보수정, 2.탈퇴 , 3.공지사항 , 4.로그아웃");
				String menu2 =sc.nextLine();
				// 작업.
				if (menu2.equals("1")) {
					System.out.print("정보수정위해 현재 비밀번호를 입력하세요 : ");
					String input = sc.nextLine();
					while (true) {
						if (input.equals(dto.getUser_pw())) {
							System.out.println("수정하기");
							break;
						} else {
							System.out.print("다시 입력해주세요 : ");
							input = sc.nextLine();
						}
					}

					dto.setUser_pw(userDao.rtnStrMsg(sc, "비밀번호 입력하세요."));
					dto.setFirst_name(userDao.rtnStrMsg(sc, "성 입력하세요."));
					dto.setLast_name(userDao.rtnStrMsg(sc, "이름 입력하세요."));
					userDao.upUser(dto);

				} else if (menu2.equals("2")) {
					System.out.println("삭제하기");
					dto.setUser_id(userDao.rtnStrMsg(sc, "아이디를 입력하세요."));
					dto.setUser_pw(userDao.rtnStrMsg(sc, "비밀번호 입력하세요."));
					userDao.deUser(dto);

				} else if (menu2.equals("3")) {

					System.out.println("공지사항 보기");

					ArrayList<UserInfoDTO> list = userDao.notiUser();
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).getPage() + " " + list.get(i).getSubject() + " "
								+ list.get(i).getMemo() + "\n");
					}

				} else if (menu2.equals("3")) {
					dto = null;// 로그아웃 ( Web == Session )
				}

			}
		}

		sc.close();
	}
}
