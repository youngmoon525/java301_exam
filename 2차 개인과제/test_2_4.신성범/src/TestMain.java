import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestDAO dao = new TestDAO();
		TestDAO testDao = new TestDAO();
		TestDTO dto = null;// 아직 로그인하기전
		while (true) {
			if (dto == null || dto.getUser_id() == null) {
				System.out.println("===============================================");
				System.out.println("1번.로그인\t2번.회원가입\t3.프로그램 종료");
				System.out.println("===============================================");
				int inputMenu = Integer.parseInt(sc.nextLine());

				if (inputMenu == 1) {
					dto = testDao.loginUser(sc);
					continue;
				} else if (inputMenu == 2) {
					System.out.println("회원가입");
					TestDTO joinDto = new TestDTO();
					joinDto.setUser_id(testDao.rtnStrMsg(sc, "아이디를 입력하세요."));
					joinDto.setUser_pw(testDao.rtnStrMsg(sc, "비밀번호 입력하세요."));
					joinDto.setFirst_name(testDao.rtnStrMsg(sc, "성 입력하세요."));
					joinDto.setLast_name(testDao.rtnStrMsg(sc, "이름 입력하세요."));
					// testDao.doublecheck(joinDto.getUser_id());
					testDao.joinUser(joinDto);
				} else if (inputMenu == 3) {
					System.out.println("종료");
					break;
				} else {
					System.out.println(" 잘못 된 입력 입니다.");
				}

				// 로그인 됐을 때
			} else {
				System.out.println("1.회원정보 수정\t2.삭제\t3.공지사항 보기\t4.로그아웃");
				int inputMenu2 = Integer.parseInt(sc.nextLine());
				if (inputMenu2 == 1) {
					String check = testDao.rtnStrMsg(sc, "비밀번호를 입력해주세요");
					if (check.equals(dto.getUser_pw())) {
						testDao.UpdateUser(dto);
						System.out.println("변경되었습니다");
						continue;
					} else {
						System.out.println("비밀번호가 틀립니다");
						continue;
					}
				} else if (inputMenu2 == 2) {
					String flag = testDao.rtnStrMsg(sc, "정말 삭제 하시겠습니까? Y.삭제 , 그외입력 취소");
					if (flag.toUpperCase().equals("Y")) {
						testDao.deleteUser(dto, sc);
						break;
					}
					continue;
				} else if (inputMenu2 == 3) {
					System.out.println("오늘의 공 지 사 항 !!!");
					testDao.viewList(testDao.Notice());
					continue;
				} else if (inputMenu2 == 4) {
					dto = null;
					continue;
				} else {
					System.out.println("잘못 된 입력");
					continue;
				}
			} // if
		} // while
		sc.close();
	}
}
