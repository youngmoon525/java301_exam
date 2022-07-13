package pack.project;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String[] args) {
		
		TestDAO dao = new TestDAO();
		Scanner sc = new Scanner(System.in);
		UserDTO udto = new UserDTO();
		while(true) {
			
//			if(udto == null || udto.getUser_id() == null) {
				ArrayList<ProductDTO> list = dao.productInfo();
				System.out.println("\n┌───────────┬──────< 로 그 인 >──────┬────────────┐");
				System.out.println("│   ① 관리자모드      │           ② 사용자모드            │        ③ 종료         │ ");
				System.out.println("└───────────┴──────────────────┴────────────┘");
				int inputMenu = dao.rtnInt(sc,"    선택해주세요 >  : ");
				
//======================================< 관리자모드 >=========================================
				if(inputMenu==1) {
					System.out.println("┌───────────────────────────────────────────┐");
					System.out.println("│                                    관리자로그인                                      │ ");
					System.out.println("└───────────────────────────────────────────┘");
					if (dao.adminLogin()) {
						
						System.out.println("┌───────────────────────────────────────────┐");
						System.out.println("│                                   전체상품리스트                                     │ ");
						dao.viewList(list);							//전체 상품 목록 출력
						while(true) { 		
							System.out.println("┌──────────────────<사용자메뉴>───────────────────┐");
							System.out.println("│                   ① 상품리스트                     ② 회원리스트                    │\n│   ③ 상품검색     ④ 상품추가      ⑤ 상품삭제      ⑥ 재고관리       ⑦ 로그아웃    │"); 
							System.out.println("└───────────────────────────────────────────┘");
							int adminMenu = dao.rtnInt(sc,"    선택해주세요 > : ");
							if(adminMenu==1) {					//1. 상품리스트
								dao.viewList(dao.productInfo());
							}else if(adminMenu==2) {			//2. 회원리스트
								dao.viewList2(dao.userInfo());
							}else if(adminMenu==3) {			//3. 상품검색
								dao.viewList(dao.searchProduct());
							}else if(adminMenu==4) {			//4. 상품추가
								dao.productAdd();
							}else if(adminMenu==5) {			//5. 상품삭제	
								dao.productDelete();
							}else if(adminMenu==6) {			//6. 재고관리	
								dao.stock();
							}else if(adminMenu==7) {			//7. 로그아웃	
								System.out.println("    로그아웃 되었습니다.\n");
								dao.dbClose();
								break;
							}
						}
					}else {
						dao.zarani();
						System.out.println("     시스템을 종료합니다.");
						break;
					}
				
//======================================< 사용자모드 >=========================================
				}else if(inputMenu==2){
					System.out.println("┌───────────────────────────────────────────┐");
					System.out.println("│                                    사용자로그인                                      │ ");
					System.out.println("└───────────────────────────────────────────┘");
					if(dao.userLogin(udto)) {
					
						//사용자모드 진입 : 전체 상품 목록 출력
						dao.viewList(list);
						while(true) {
							ArrayList<UserDTO> tlist = new ArrayList<UserDTO>();
							tlist.add(dao.logUser(udto.getId()));
							dao.viewList2(tlist);
							System.out.println("┌───────────┬──────<사용자메뉴>───────┬───────────┐");
							System.out.println("│     ① 금액입력      │            ② 상품주문               │     ③ 로그아웃      │ ");
							System.out.println("└───────────┴───────────────────┴───────────┘");
							int userMenu = dao.rtnInt(sc, "    선택해주세요 > : ");
							
							//금액입력
							if(userMenu == 1) {
								dao.getMoney(udto);
								
							//상품주문	
							}else if(userMenu == 2) {
								dao.buyProduct(udto);
							//로그아웃	
							}else if(userMenu == 3) {
								System.out.println("    로그아웃 되었습니다.");
								udto.setId(null);
								break;
							}
							
						}
					}else{
						dao.zarani();
						System.out.println("    시스템을 종료합니다.");
						dao.dbClose(); 
						break;
					}
					
				}else if(inputMenu==3){	
					dao.systemout();
					String select = dao.rtnString(sc, "    선택해주세요 > : ");
					if(select .equalsIgnoreCase("y")) {
						System.out.println("\n    시스템을 종료합니다.");
						dao.dbClose();
						break;
					}else {
						System.out.println("    메인화면으로 돌아갑니다.\n");
					}
				}else {
					dao.zarani(); System.out.println("    잘못된 입력입니다. 다시 입력해주세요.\n");
				}
				
//			}//if 
			
		}//while
		sc.close();
		
	}//main()
}//class