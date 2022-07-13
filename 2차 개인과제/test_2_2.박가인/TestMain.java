import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDTO userdto = new UserDTO();
		UserDAO userdao = new UserDAO();
		NoticeDTO noticeDto = new NoticeDTO();
		NoticeDAO noticeDao = new NoticeDAO();
		//userdto =null; //아직 로그인 안한 상태
		while(true) {
			System.out.println("1.로그인  2.회원가입 3.로그아웃 4.프로그램 종료");
			int inputmenu = Integer.parseInt(sc.nextLine());
			if(!userdao.userLogin(null, null)) {
				
				if(inputmenu == 1) {//로그인
					int cnt = 0;
					while(true){
					System.out.println("로그인하세요");
					System.out.println("아이디를 입력해주세요");
					String id = sc.nextLine().trim();
					System.out.println("패스워드를 입력해주세요");
					String pw = sc.nextLine().trim();
					userdao.userLogin(id, pw);
					if(!userdao.userLogin(id, pw)) {
						System.out.println("다시 로그인해주세요");
						cnt++;
						if(cnt ==3){System.out.println("프로그램을 종료합니다.");}
						continue;
						
					}else if(userdao.userLogin(id,pw)){
						userdto.setUser_id(id);
						System.out.println("1.회원정보수정 2. 회원탈퇴 3. 공지사항보기");
						int menu= Integer.parseInt(sc.nextLine());
						if(menu ==1) {	//회원정보수정

							noticeDto.setUser_id(userdto.getUser_id());
							noticeDto.setStudent_no(userdto.getStudent_no());
							System.out.println("회원정보를 수정합니다.");
							System.out.println("아무것도 입력하지 않으면 기존값을 유지합니다.");
							System.out.println("비밀번호를 입력해주세요");
							String pw2 = sc.nextLine();
							noticeDto.setUser_pw(pw2);
							System.out.println("FIRST_NAME을 입력하세요.");
							String fn = sc.nextLine();
							noticeDto.setFirst_name(fn);
							System.out.println("Last_NAME을 입력하세요");
							String ln = sc.nextLine();
							noticeDto.setLast_name(ln);
							noticeDao.updateUser(noticeDto);
						}else if(menu ==2) {	//회원탈퇴
							noticeDao.delUser(userdto);
						}else if(menu == 3) {	//공지사항보기
							noticeDao.readBoard();
						}
					}
					}	
				}else if(inputmenu == 2) {//회원가입
					System.out.println("회원가입");
					System.out.println("학생번호를 입력하세요");
					int num = Integer.parseInt(sc.nextLine());
					userdto.setStudent_no(num);
					System.out.println("아이디를 입력하세요.");
					String id = sc.nextLine();
					userdto.setUser_id(id);
					System.out.println("패스워드를 입력하세요");
					String pw = sc.nextLine();
					userdto.setUser_pw(pw);
					System.out.println("이름(first name)을 입력하세요");
					String fm = sc.nextLine();
					userdto.setFirst_name(fm);
					System.out.println("성(last name)을 입력하세요");
					String lm = sc.nextLine();
					userdto.setLast_name(lm);
					userdao.userJoin(userdto);
					
				}else if(inputmenu == 3) {//로그아웃
					userdao.userLogin(null, null);
				}else if(inputmenu == 4) { //프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘 못 입력하셨습니다!");
				}
			}else {	//로그인한 상태
				int menu= Integer.parseInt(sc.nextLine());
				System.out.println("1.회원정보수정 2. 회원탈퇴 3. 공지사항보기");
			if(menu ==1) {	//회원정보수정

				noticeDto.setUser_id(userdto.getUser_id());
				noticeDto.setStudent_no(userdto.getStudent_no());
				System.out.println("회원정보를 수정합니다.");
				System.out.println("아무것도 입력하지 않으면 기존값을 유지합니다.");
				System.out.println("비밀번호를 입력해주세요");
				String pw2 = sc.nextLine();
				noticeDto.setUser_pw(pw2);
				System.out.println("FIRST_NAME을 입력하세요.");
				String fn = sc.nextLine();
				noticeDto.setFirst_name(fn);
				System.out.println("Last_NAME을 입력하세요");
				String ln = sc.nextLine();
				noticeDto.setLast_name(ln);
				noticeDao.updateUser(noticeDto);
				
			}else if(menu ==2) {	//회원탈퇴
				noticeDao.delUser(userdto);
			}else if(menu == 3) {	//공지사항보기
				noticeDao.readBoard();
			}else {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
		}//if
		
		}
		sc.close();
		}//main
}