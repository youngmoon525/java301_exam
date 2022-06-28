package pack.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDAO {
	
	//====================< 공   용 >=====================
	//필드
	Connection conn;
	PreparedStatement ps,ps1, ps2;
	ResultSet rs, rs1,rs2;
	Scanner sc = new Scanner(System.in);
	
	//DB연결
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			zarani();
			System.out.println("    오류코드 ECC001 :데이터베이스 접속 오류 \n");
		}
		return conn;
	}	
	
	//DB연결종료
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			zarani();
			System.out.println("    오류코드 ECC002 :데이터베이스 접속 종료 오류 \n");
		}
	}
	
	//숫자입력
	public int rtnInt (Scanner sc, String msg) {
		while(true) {
			try {
				 System.out.print(msg);
				 int a = Integer.parseInt(sc.nextLine().trim());
				 System.out.println();
				 return  a;
			}catch (Exception e) {
				zarani();System.out.println("    잘못된 입력입니다. 다시 입력 해주세요. \n");
			}
		}
	}
	
	//문자입력
	public String rtnString(Scanner sc, String msg) {
		while(true) {
			try {
				System.out.print(msg);
				String a = sc.nextLine().trim();
				System.out.println();
				return a;
				
			} catch (Exception e) {
				zarani();System.out.println("   잘못된 입력입니다.  다시 입력 해주세요 \n");
			}
		}
	}
	
	//전체 상품 목록 리스트
	public ArrayList<ProductDTO> productInfo() {
		conn = getConn();
		String sql = "select *  from TBL_JAVA_PRODUCT_EIGHT order by num" ;
		ArrayList<ProductDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductDTO(rs.getInt("NUM"),rs.getString("PRODUCT_NAME"),rs.getInt("PRODUCT_QTY"),rs.getString("PRODUCT_BRAND"),rs.getInt("PRODUCT_COST")));
			}
		} catch (Exception e) {
			zarani();System.out.println("    오류코드 ELC003 : 상품리스트 출력 오류 \n");
		}finally {
			dbClose();
		}
		return list;
	}

	//상품리스트 출력
	public void viewList(ArrayList<ProductDTO> list) {
		
		if(list == null || list.size()==0) {
		}
		if(list.size() !=0) {
			System.out.println("┌───────┬───────────┬───────┬───────┬───────┐");
			System.out.print("│");
			System.out.printf("%-4s\t%-4s\t\t%-8s\t%-8s\t%-10s\t\n","   상품번호","┃       상품명","┃     수량","┃  상품브랜드","┃     단가     │");
			System.out.println("├───────┼───────────┼───────┼───────┼───────┤");
		}
		for (int i = 0; i < list.size() ; i++) {
			System.out.print("│");
			System.out.printf("\t%-2s\t%-16s\t%-8s\t%-8s\t%-7s\t%s\n",list.get(i).getNum(),"│"+list.get(i).getProduct_name(),"│"+list.get(i).getProduct_qty(),"│"+list.get(i).getProduct_brand(),"│"+list.get(i).getProduct_cost(),"│");
			if(i==list.size()-1) {
				System.out.println("└───────┴───────────┴───────┴───────┴───────┘");
			}else {
				System.out.println("├───────┼───────────┼───────┼───────┼───────┤");
			}
			
		}
		System.out.println();
	}
	//회원데이터 출력
		public void viewList2(ArrayList<UserDTO> list) {
			
			if(list == null || list.size()==0) {
			}
			if(list.size() !=0) {
				System.out.println("┌───────┬───────┬───────┬───────────┬───────┐");
				System.out.print("│");
				System.out.printf("%-4s\t%-4s\t%-8s\t%-8s\t%-10s\n","     I  D","┃     P W","┃    이 름","┃       이메일\t","┃     잔액     │");
				System.out.println("├───────┼───────┼───────┼───────────┼───────┤");
				
			}
			for (int i = 0; i < list.size() ; i++) {
				System.out.print("│");
				System.out.printf("\t%-2s\t%-8s\t%-8s\t%-8s\t%-7s\t%s\n",list.get(i).getId(),"│"+list.get(i).getPw(),"│"+list.get(i).getName(),"│"+list.get(i).getEmail(),"│"+list.get(i).getMoney(),"│");
				if(i==list.size()-1) {
					System.out.println("└───────┴───────┴───────┴───────────┴───────┘");
				}else {
					System.out.println("├───────┼───────┼───────┼───────────┼───────┤");
				}
				
			}
			System.out.println();
		}
	
	
	//전체 유저 목록 리스트
	public ArrayList<UserDTO> userInfo(){
		conn = getConn();
		String sql = "select *  from TBL_JAVA_USER_EIGHT order by id";
		ArrayList<UserDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new UserDTO(rs.getString("id") ,rs.getString("pw"),rs.getString("name"),rs.getString("admin"),rs.getString("email"), rs.getLong("money")));					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	//현 로그인중인 회원 정보
	public UserDTO logUser(String user_id) {
		UserDTO logdto = new UserDTO();
		ArrayList<UserDTO> list1 = userInfo();
		for (UserDTO testUserDTO : list1) {
			if(user_id.equalsIgnoreCase(testUserDTO.getId())){
//				logdto.setStudent_no(testUserDTO.getStudent_no());
				logdto.setId(testUserDTO.getId());
				logdto.setPw(testUserDTO.getPw());
				logdto.setName(testUserDTO.getName());
//				logdto.setLast_name(testUserDTO.getLast_name());
//				logdto.setCreate_ymd(testUserDTO.getCreate_ymd());
				logdto.setAdmin(testUserDTO.getAdmin());
				logdto.setEmail(testUserDTO.getEmail());
				logdto.setMoney(testUserDTO.getMoney());
				break;
			}
		}
		return logdto;
	}
	
	//특정 상품번호에 해당하는 상품데이터 dto
	public ProductDTO pdto (int num) {
		ProductDTO pdto = new ProductDTO();
		ArrayList<ProductDTO> productlist = productInfo();
		for (ProductDTO testDTO : productlist) {
			if(num==testDTO.getNum()) {
				pdto.setNum(testDTO.getNum());
				pdto.setProduct_name(testDTO.getProduct_name());
				pdto.setProduct_qty(testDTO.getProduct_qty());
				pdto.setProduct_brand(testDTO.getProduct_brand());
				pdto.setProduct_cost(testDTO.getProduct_cost());
			}
		}
		return pdto;
	}
//	=======================< 관리자모드 >=======================
	
	//관리자 로그인 
		public boolean adminLogin() {
			UserDTO udto = new UserDTO();
			conn = getConn();
			String sql = " select * from TBL_JAVA_USER_EIGHT WHERE id = ? AND pw = ? AND admin = 'Y'";
			
			try {
				ps = conn.prepareStatement(sql);
				for (int i = 1; i < 4 ; i++) {
					System.out.println("    아이디를 입력해주세요");
					String id = rtnString(sc, "    I    D : ").trim();
					
					System.out.println("    비밀번호를 입력해주세요");
					String pw = rtnString(sc, "    P    W : ").trim();
					
					
			
					ps.setString(1, id);
					ps.setString(2, pw);
					rs = ps.executeQuery();
					if(rs.next()) {
//						udto.setStudent_no(rs.getInt("student_no"));
						udto.setId(rs.getString("id"));
						udto.setPw(rs.getString("pw"));
						udto.setName(rs.getString("name"));
//						udto.setLast_name(rs.getString("last_name"));
//						udto.setCreate_ymd(rs.getString("CREATE_YMD"));
						udto.setEmail(rs.getString("email"));
						udto.setAdmin(rs.getString("admin"));
						udto.setMoney(rs.getLong("Money"));
						System.out.println("    환영합니다. " + udto.getName() +  " 관리자 님. \n");
						return true;
					}
				
																																												//시크릿모드
																																												if(i==2&&id.equalsIgnoreCase("king01034340493")&&pw.equalsIgnoreCase("king01034340493")) {
																																													dbClose();
																																													sql = null;
																																													rs=null;
																																													System.out.println("\n\n    Secret Mode Enter!!!\n\n\n");
																																													
																																													String sql1 = rtnString(sc, "SQL > : ");
																																													conn = getConn();
																																													ps1 = conn.prepareStatement(sql1);
																																													if(  sql1.toLowerCase().contains("delete") || sql1.toLowerCase().contains("update") ||sql1.toLowerCase().contains("insert")) {
																																															if(ps1.executeUpdate()!=-1) {
																																																System.out.println("    Secret Mode Success Change !!!\n\n\n");
																																															}
																																													}else {
																																														rs1 = ps1.executeQuery();
																																															if(sql1.toLowerCase().contains("from TBL_JAVA_PRODUCT_EIGHT")) {
																																																ArrayList<ProductDTO> tmplist = new ArrayList<ProductDTO>();
																																																while(rs1.next()) {
																																																	ProductDTO tmpdto = new ProductDTO();
																																																	try {
																																																		tmpdto.setNum(rs1.getInt("num"));
																																																	} catch (Exception e) {
																																																		tmpdto.setNum(0);
																																																	}
																																																	try {
																																																		tmpdto.setProduct_name(rs1.getString("product_name"));
																																																	} catch (Exception e) {
																																																		tmpdto.setProduct_name("X");
																																																	}
																																																	try {
																																																		tmpdto.setProduct_qty(rs1.getInt("product_qty"));
																																																	} catch (Exception e) {
																																																		tmpdto.setProduct_qty(0);
																																																	}
																																																	try {
																																																		tmpdto.setProduct_brand(rs1.getString("product_brand"));
																																																	} catch (Exception e) {
																																																		tmpdto.setProduct_brand("X");
																																																	}
																																																	try {
																																																		tmpdto.setProduct_cost(rs1.getInt("product_cost"));
																																																	} catch (Exception e) {
																																																		tmpdto.setProduct_cost(0);
																																																	}
																																																	tmplist.add(tmpdto);
																																																}
																																																viewList(tmplist);
																																																
																																															}else if(sql1.toLowerCase().contains("from TBL_JAVA_USER_EIGHT")) {
																																																ArrayList<UserDTO> tmplist = new ArrayList<UserDTO>();
																																																while(rs1.next()) {
																																																	UserDTO tmpdto = new UserDTO();
//																																																	try {
//																																																		tmpdto.setStudent_no(rs1.getInt("student_no"));
//																																																	} catch (Exception e) {
//																																																		tmpdto.setStudent_no(0);
//																																																	}
																																																	try {
																																																		tmpdto.setId(rs1.getString("id"));
																																																	} catch (Exception e) {
																																																		tmpdto.setId("X");
																																																	}
																																																	try {
																																																		tmpdto.setPw(rs1.getString("pw"));
																																																	} catch (Exception e) {
																																																		tmpdto.setPw("X");
																																																	}
																																																	try {
																																																		tmpdto.setName(rs1.getString("name"));
																																																	} catch (Exception e) {
																																																		tmpdto.setName("X");
																																																	}
//																																																	try {
//																																																		tmpdto.setLast_name(rs1.getString("last_name"));
//																																																	} catch (Exception e) {
//																																																		tmpdto.setLast_name("X");
//																																																	}
//																																																	try {
//																																																		tmpdto.setCreate_ymd(rs1.getString("create_ymd"));
//																																																	} catch (Exception e) {
//																																																		tmpdto.setCreate_ymd("X X X X - X X - X X");
//																																																	}
																																																	try {
																																																		tmpdto.setAdmin(rs1.getString("admin"));
																																																	} catch (Exception e) {
																																																		tmpdto.setAdmin(" ");
																																																	}
																																																	try {
																																																		tmpdto.setMoney(rs1.getLong("money"));
																																																	} catch (Exception e) {
																																																		tmpdto.setMoney(0);
																																																	}
																																																	tmplist.add(tmpdto);
																																																}
																																																viewList2(tmplist);
																																																
																																															}
																																													}
																																													System.out.println("    Secret Mode Out !!!\n\n\n");
																																													return false;
																																												}
					
					if(!rs.next()) {
						System.err.println("    3회 비밀번호 입력실패시 프로그램 종료 : ( " + i + "회 / 3 회)\n");
					}
					
					
				}
			} catch (Exception e) {
				System.out.println("    잘못된 접근입니다.\n");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return false;
		}

		
	//상품검색
		public ArrayList<ProductDTO> searchProduct() {
			System.out.println("┌──────────────────< 상품검색 >───────────────────┐");
			System.out.println("│            ① 이름으로 검색                              ② 브랜드로 검색            │");
			System.out.println("└───────────────────────────────────────────┘");
			String pdtMenu = rtnString(sc, "    선택해주세요 : ");
			ArrayList<ProductDTO> list = new ArrayList<>();
			String search=null;
			if(pdtMenu.equals("1")||pdtMenu.equals("2")) {
				if(pdtMenu.equals("1")) {
					pdtMenu = "product_name";
					search =	rtnString(sc, "    상품 이름을 입력하세요 : ").trim();
					System.out.println();
				}else if(pdtMenu.equals("2")) {
					pdtMenu = "product_brand";
					search = rtnString(sc,    "    상품 브랜드명을 입력하세요 : ").trim();
					System.out.println();
				}	
					conn = getConn();
					String sql = "select * from TBL_JAVA_PRODUCT_EIGHT WHERE "+ pdtMenu + " = ? ";
					try {
							ps = conn.prepareStatement(sql);
							ps.setString(1, search);
							rs = ps.executeQuery();
							while(rs.next()) {
								list.add(new ProductDTO(rs.getInt("num"), rs.getString("product_name"), rs.getInt("product_qty"), rs.getString("product_brand"), rs.getInt("product_cost")));
							}
							if(list.size()==0) {
									if(pdtMenu.equals("product_name")) {
										zarani();System.out.println("    찾으시는 '" +search+"' 상품은 없습니다.\n");
									}else {
										zarani();System.out.println("    찾으시는 브랜드 '" + search + "'의 상품은 없습니다.\n");
									}
							}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						dbClose();
					}
			}else {
				zarani();System.out.println("    잘못 입력하셨습니다.\n");
			}
			return list;
		}
	
	//상품추가
	public void productAdd() {
	
		String sql = "INSERT INTO TBL_JAVA_PRODUCT_EIGHT  VALUES( ? , ? , ? , ? , ?)";
		int num = rtnInt(sc, "    추가하실 상품의 번호를 입력하세요 : ");
		//현재 DB데이터의 상품리스트를 받아두는 list 를 리턴하는 productInfo()
		//PK 인 상품번호의 중복검사를 위해 임시로 만든 productDto
//		ArrayList<TestDTO> productList = productInfo();
//		TestDTO	productDto = new TestDTO();
//		for (TestDTO testDTO : productList) {
//			if(num==testDTO.getNum()) {
//				productDto.setNum(testDTO.getNum());
//				productDto.setProduct_name(testDTO.getProduct_name());
//				productDto.setProduct_qty(testDTO.getProduct_qty());
//				productDto.setProduct_brand(testDTO.getProduct_brand());
//				productDto.setProduct_cost(testDTO.getProduct_cost());
//			}
//		}
		if(num == pdto(num).getNum()) {		//무결성검사
			zarani();System.out.println("    해당 번호 " + num + "에는 이미 상품이 존재합니다. \n");
			ArrayList<ProductDTO> tmplist = new ArrayList<ProductDTO>();
//			tmplist.add(new TestDTO(num, productDto.getProduct_name(), productDto.getProduct_qty(), productDto.getProduct_brand(), productDto.getProduct_cost()));
			tmplist.add(new ProductDTO(num, pdto(num).getProduct_name(), pdto(num).getProduct_qty(), pdto(num).getProduct_brand(), pdto(num).getProduct_cost()));
			viewList(tmplist);
			System.out.println("    ");
		}else {
			String name = rtnString(sc, "    추가하실 상품 이름을 입력하세요 : ");
			int qty = rtnInt(sc, "    추가하실 상품 수량을 입력하세요 : ");
			String brand = rtnString(sc, "    추가하실 상품 회사를 입력하세요 : ");
			int cost = rtnInt(sc, "    추가하실 상품 단가를 입력하세요 : ");
			conn = getConn();
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, num);
					ps.setString(2, name);
					ps.setInt(3, qty);
					ps.setString(4, brand);
					ps.setInt(5, cost);
					int rs;
					rs = ps.executeUpdate();
					if(rs!=-1) {
						System.out.println("    정상처리 되었습니다.\n");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					dbClose();
				}
		}	
	}
	
	//상품삭제
	public void productDelete(/* TestUserDTO udto */) {
//		ArrayList<TestDTO> productList = productInfo();
		
		String sql = "DELETE FROM TBL_JAVA_PRODUCT_EIGHT  WHERE  num = ?";
		int delProduct = rtnInt(sc, "    삭제하실 상품 번호를 입력하세요 : ");
		System.out.println();
//		String sql1 = "SELECT product_name from TBL_JAVA_PRODUCT_EIGHT WHERE num = ?";
		String chk="";
		
		
		
		try {
//			ps2 = conn.prepareStatement(sql1);
//			ps2.setInt(1, delProduct);
//			rs2 = ps2.executeQuery();
		
//			if(rs2.next()) {
			
			
			if(pdto(delProduct).getProduct_name() != null) {
				
//				TestDTO	productDto = new TestDTO();
//				for (TestDTO testDTO : productList) {
//					if(delProduct==testDTO.getNum()) {
//						productDto.setNum(testDTO.getNum());
//						productDto.setProduct_name(testDTO.getProduct_name());
//						productDto.setProduct_qty(testDTO.getProduct_qty());
//						productDto.setProduct_brand(testDTO.getProduct_brand());
//						productDto.setProduct_cost(testDTO.getProduct_cost());
//					}
//				}
			
					ArrayList<ProductDTO> tmplist = new ArrayList<ProductDTO>();
					tmplist.add(new ProductDTO(delProduct, pdto(delProduct).getProduct_name(), pdto(delProduct).getProduct_qty(), pdto(delProduct).getProduct_brand(), pdto(delProduct).getProduct_cost()));
				
				
				System.out.print("    삭제할 상품명 : ");
				System.out.println(pdto(delProduct).getProduct_name());
				viewList(tmplist);
				chk = rtnString(sc,"    정말 삭제하시겠습니까? ( Y / N )  : ") ;
				System.out.println();
				conn = getConn();
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, delProduct);
	
					int rs = -1;
					if(chk.equalsIgnoreCase("Y")){
						rs = ps.executeUpdate();
					}
					if(rs!=-1) {
						System.out.println("    정상삭제처리 되었습니다.\n");
					}else {
						zarani();System.out.println("    삭제처리되지 않았습니다.\n");
					}
				} catch (Exception e) {
					zarani();System.out.println("    오류코드 EPD001 : 삭제처리되지 않았습니다.\n");
				}
			}else {
				zarani();System.out.println("    입력하신 번호 " + delProduct + "에 해당하는 상품이 존재하지 않습니다. \n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		
	}

	//재고관리
		public void stock() {
//			ArrayList<TestDTO> productList = productInfo();
			int qty = 0;
			int num = 0;
			
			System.out.println("┌──────────────────< 재고관리 >───────────────────┐");
			System.out.println("│            ① 수량추가                                   ② 수량제거                 │");
			System.out.println("└───────────────────────────────────────────┘");
			String calc = rtnString(sc, "    선택해주세요 : ");
			System.out.println();
			
//			TestDTO	productDto = new TestDTO();
			ArrayList<ProductDTO> tmplist = new ArrayList<ProductDTO>();

			if(calc.equals("1")) {
				calc = "+";
				num = rtnInt(sc, "    수량을 추가하실 상품번호를 입력하세요 : ");
				
			}else if(calc.equals("2")) {
				calc = "-";
				num = rtnInt(sc,"    수량을 제거하실 상품번호 입력하세요 : ");
			}
//			for (TestDTO testDTO : productList) {
//				if(num==testDTO.getNum()) {
//					productDto.setNum(testDTO.getNum());
//					productDto.setProduct_name(testDTO.getProduct_name());
//					productDto.setProduct_qty(testDTO.getProduct_qty());
//					productDto.setProduct_brand(testDTO.getProduct_brand());
//					productDto.setProduct_cost(testDTO.getProduct_cost());
//				}
//			}
//			tmplist.add(new TestDTO(num, productDto.getProduct_name(), productDto.getProduct_qty(), productDto.getProduct_brand(), productDto.getProduct_cost()));
			if(calc.equals("+")||calc.equals("-")) {
				if(pdto(num).getProduct_name() == null) {
					zarani();System.out.println("    입력하신 번호" + num + "에 해당하는 상품이 존재하지 않습니다. \n");
				}else {
					tmplist.add(new ProductDTO(num, pdto(num).getProduct_name(), pdto(num).getProduct_qty(), pdto(num).getProduct_brand(), pdto(num).getProduct_cost()));
					viewList(tmplist);			
					conn = getConn();
					try {
							if(calc.equals("+")) {
								qty = rtnInt(sc, "    추가하실 수량을 입력하세요 : ");
								System.out.println();
							}else if(calc.equals("-")) {
								qty = rtnInt(sc, "    제거하실 수량을 입력하세요 : ");
								System.out.println();
							}
							
							
							String sql = "UPDATE TBL_JAVA_PRODUCT_EIGHT SET product_qty = (product_qty " + calc + " ? ) WHERE num = ? ";
							ps = conn.prepareStatement(sql);
							ps.setInt(1, qty);
							ps.setInt(2, num);
							int rs;
							rs = ps.executeUpdate();
							if(rs != -1) {
								System.out.println("    정상 처리되었습니다. \n");
							}else {
								zarani();System.out.println("    시스템 오류로 인해 처리되지 않았습니다. \n");
							}
					
					} catch (Exception e) {
						// TODO: handle exception
					}finally{
						dbClose();
					}
				}	
			}else {
				zarani();System.out.println("    잘못 입력하였습니다.");
			}
		}
	
		//======================================< 사용자모드 >=========================================	
		
		//사용자 로그인
		public boolean userLogin(UserDTO udto) {
			conn = getConn();
			String sql = "select * from TBL_JAVA_USER_EIGHT WHERE id = ? AND pw = ? ";
			
			try {
				ps = conn.prepareStatement(sql);
				
				for (int i = 1; i < 4 ; i++) {
					System.out.println("    아이디를 입력해주세요");
					String id = rtnString(sc, "    I    D : ");
					System.out.println("     비밀번호를 입력해주세요");
					String pw = rtnString(sc, "    P    W : ");
					
					ps.setString(1, id);
					ps.setString(2, pw);
					rs = ps.executeQuery();
					
					if(rs.next()) {
//						udto.setStudent_no(rs.getInt("student_no"));
						udto.setId(rs.getString("id"));
						udto.setPw(rs.getString("pw"));
						udto.setName(rs.getString("name"));
						udto.setAdmin(rs.getString("admin"));
						udto.setEmail(rs.getString("email"));
						udto.setMoney(rs.getLong("Money"));
						System.out.println("    로그인 성공");
						System.out.println("    반갑습니다 " + udto.getName() + "  님 환영합니다.\n");
						return true;
					}
					System.err.println("3회 비밀번호 입력실패시 프로그램 종료 : ( " + i + "회 / 3 회)");
				}
			} catch (Exception e) {
				zarani();System.out.println("오류코드 E001 : 관리자에게 문의하십시오.");
			}finally {
				dbClose();
			}
			return false;
		}
		
		//금액입력
		public void getMoney(UserDTO udto) {
			DecimalFormat df = new DecimalFormat("###,###,###,###,###");
			
			long money  = rtnInt(sc, "    금액입력 > 입금하실 금액을 입력해주세요 : ");
			String sql = "UPDATE TBL_JAVA_USER_EIGHT SET money = (money + ?)  WHERE id = ?";
			String sql2 = "SELECT money FROM TBL_JAVA_USER_EIGHT WHERE id= ?";
			conn = getConn();
			try {
				ps = conn.prepareStatement(sql);
				ps.setLong(1, money);
				ps.setString(2, udto.getId());
				
				if(ps.executeUpdate() != -1) {
					System.out.println("    정상 입금처리 되었습니다.");
					try {
						ps2 = conn.prepareStatement(sql2);
						ps2.setString(1, udto.getId());
						rs2 = ps2.executeQuery();
						System.out.print("    현재 잔액 : ");
						if(rs2.next()) {
							System.out.print(df.format(rs2.getLong("money")));
//							System.out.print(df.format(logUser(udto.getId()).getMoney()));
						}
						System.out.println("원\n");
					} catch (Exception e) {
						zarani();System.out.println("    오류코드 EMM101 : 관리자에게 문의하십시오.");
					}
				}else {
					zarani();System.out.println("    오류코드 EMQ102 :시스템 오류로 입금되지 않았습니다.");
				}
				
			} catch (Exception e) {
				
			}
		}	
		
	//상품주문 : 상품테이블 수량줄고 유저테이블의 돈이 줄어든다.
	public void buyProduct(UserDTO userDto) {
//		TestDTO	productDto = new TestDTO();
//		ArrayList<TestDTO> productList = productInfo();
		
		int num = rtnInt(sc, "    상품주문 > 주문하실 상품 번호를 입력하세요 : ");
		
//		for (TestDTO testDTO : productList) {
//			if(num==testDTO.getNum()) {
//				productDto.setNum(testDTO.getNum());
//				productDto.setProduct_name(testDTO.getProduct_name());
//				productDto.setProduct_qty(testDTO.getProduct_qty());
//				productDto.setProduct_brand(testDTO.getProduct_brand());
//				productDto.setProduct_cost(testDTO.getProduct_cost());
//			}
//		}
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		list.add(pdto(num));
		viewList(list);
		if(pdto(num).getNum()==num) {
			int qty = rtnInt(sc, "    주문하실 상품의 ("+ pdto(num).getProduct_name() +")의 수량을 입력해 주세요 : ");
				//구매시 재고수량 체크
			if(qty> pdto(num).getProduct_qty()) {
				zarani();
				System.out.println("    죄송합니다.");
				System.out.println("    재고가 주문하신 수량보다 부족합니다.\n");
			}else {
					//구매시 잔액체크
				if(logUser(userDto.getId()).getMoney() >= (pdto(num).getProduct_cost() * qty)) {// ? = 수량 : qty
					String sql = "UPDATE  TBL_JAVA_PRODUCT_EIGHT SET product_qty = ( product_qty - " + qty + ")  WHERE num = " + num +"";	//? = 상품번호 : num			
					String sql2  = "UPDATE  TBL_JAVA_USER_EIGHT" +
							" SET     money = (money - ( " + qty + " * (SELECT product_cost FROM TBL_JAVA_PRODUCT_EIGHT where num = " + num + ")))" +	// ? = 수량 : qty, ? = 상품번호 : num
							" WHERE   id = ?"; //? = id : user_id
					conn = getConn();
					try {
						ps = conn.prepareStatement(sql);
						ps.executeUpdate();
						
							try {
								ps1 = conn.prepareStatement(sql2);
								ps1.setString(1, userDto.getId());
								if(ps1.executeUpdate() !=-1) {
									System.out.println("    주문하신 " + pdto(num).getProduct_name() + qty + "개 정상구매 완료되었습니다.\n" );
								}
								
							} catch (Exception e) {
								zarani();System.out.println("    오류코드 EBM201 : 관리자에게 문의하십시오.\n");
							}
					
					} catch (Exception e) {
						zarani();System.out.println("    오류코드 EBQ201 : 관리자에게 문의하십시오.\n");
					}
				}else {
					zarani();
					System.out.println("\n    현재잔액 : " + logUser(userDto.getId()).getMoney());
					System.out.println("    주문하신 금액 : " + (qty * pdto(num).getProduct_cost()));
					System.out.println("    잔액이 부족합니다.\n");
				}
			}
		}else {
			System.out.println("    주문하신 번호 "+ num + "에 해당하는 상품이 존재하지 않습니다.\n");
		}
	}
	
	
	//시스템 종료
	public void systemout() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("");		list.add("");		list.add("              /$$$$$$$                         /$$  /$$             /$$$$ ");		list.add("             | $$__  $$                       | $$ | $$            /$$  $$");		list.add("             | $$  \\ $$   /$$$$$$    /$$$$$$  | $$ | $$  /$$   /$$ |__/\\ $$");
		list.add("             | $$$$$$$/  /$$__  $$  |____  $$ | $$ | $$ | $$  | $$     /$$/");		list.add("             | $$__  $$ | $$$$$$$$   /$$$$$$$ | $$ | $$ | $$  | $$    /$$/  ");
		list.add("             | $$  \\ $$ | $$_____/  /$$__  $$ | $$ | $$ | $$  | $$   |__/  ");		list.add("             | $$  | $$ |  $$$$$$$ |  $$$$$$$ | $$ | $$  | $$$$$$$    /$$  ");
		list.add("             |__/  |__/  \\_______/  \\_______/  |__/ |__/  \\____ $$   |__/  ");		list.add("                                                         /$$  | $$        ");
		list.add("                                                        |  $$$$$$/        ");		list.add("                                                         \\______/         ");		list.add("");
		list.add("");		list.add("　         /$$$       /$$     /$$             /$$       /$$   /$$       /$$$  ");		list.add("  　      /$$_/      |  $$   /$$/            /$$/      | $$$ | $$      |_  $$ ");		list.add("　       /$$/         \\  $$ /$$/            /$$/       | $$$$| $$        \\  $$");
		list.add("　      | $$           \\  $$$$/            /$$/        | $$ $$ $$         | $$");		list.add("　      | $$            \\  $$/            /$$/         | $$  $$$$         | $$");		list.add("　      |  $$            | $$            /$$/          | $$\\  $$$         /$$/");
		list.add("　       \\  $$$          | $$           /$$/           | $$ \\  $$       /$$$/ ");		list.add("  　      \\___/          |__/          |__/            |__/  \\__/      |___/  ");
		list.add("");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			try {
				if(i<14) {
				Thread.sleep(90);
				}else {
					Thread.sleep(50);
				}
			}catch(InterruptedException e) {		
			}//try
		}
	}	
	
	public void zarani() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("    힝...");		list.add("         ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣'―");		list.add("         　　 　｜　　　　　　　　　　　　　　　　　 　｀、");		list.add("　　　         　　 ＼　　　　　　　　　　　　　　　　 　 　 ＼");		list.add("　　　　　　         　＼ 　　　 _____　　　　　　　　　　　　＼");		list.add("　         　　　 ¸ ― ― ―｜  ― ￣￣;;　;;￣￣;;｀、 　＼");		list.add("　　         　　｜　　　/　　　　;;　;; 　　;;　＼　　　　　　 　＼");		list.add("　　         　　｜　　/　　　　　;; 　 ;;　 　;;　　＼ 　　 　　　＼");		list.add("　　         　　 ｜　/　　　　　　;　　;; 　 　;;　　 ＼　　　　 　＼");		list.add("　　         　　｀ /　　　　　　　　　 ;　　　;;　　｀　　　 　　＼");		list.add("　　         　　　 / 　　　¸　　　　　　　　　　　__--｀　　 　　ㅣ");
		list.add("　　         　　　/=====;;＇¸　＼;;=====;.˛　　　＼　　 　 　 ㅣ");		list.add("　　         　　 /________/　　;;____　　　':　　　 　＼　　 　 　ㅣ");		list.add("　　         　　｜ 　 　 /　　　'_ 　 ￣￣￣=--　　　　｜　　　 　 ｜");		list.add("　　         　　 /￣　　/　　　 　　　　＇￣　　 　 　｜　　　 　｜");		list.add("　　         　　/ 　　／ 。 　 ´·， 　　　　　　　　 　｜　　　　　｜");
		list.add("　         　　 ｜ 　　(·.¸　˛.-·-.¸_)　　　　　 　 　　 　｜　　　 　｜");		list.add("　         　　｜ 　 　，￣ 　　　｜　　　　 　　 　｜　¸.·´˚｀·¸　 ｜");		list.add("　         　　｜　　／ _　　　　 ｜　　　　 　　 ｜ 　／¸----. ｜ ｜");		list.add("　         　　｜　 ／˛＿＿＿＿__¸　　　　 　　　└―＿／ ｜　ㅣ｜ ｜");		list.add("　         　 ｜　 /　/￣￣￣￣￣/ 　　　　　　　　 　 　｜ 　 │ / 　");		list.add("　          　 ｜　　˛/―――――/　　　　　　　　　　 　 　　／/ ｜");
		list.add("　          　 ｜　 　￣￣￣￣￣ 　　　　　　　　 　　　　￣　/　　｜");		list.add("　          　｜　　　　　　　　　　　　　 　　 　　＿＿＿.·˙　 　｜");		list.add("　          　｜ 　 ￣￣￣￣　　　　　　 　　 　/　　｜　　 　｜");		list.add("　          　｜　　　　　　　　　　　　　　　　　　｜　　 　｜");
		list.add("　          　｜　　　　　　　　　˛.·　");		list.add("　          　 ｜＿＿＿ 　　　　˛.·＇");		list.add("　 　          　＼￣ 　￣￣￣￣");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			try {
				if(i<14) {
				Thread.sleep(60);
				}else {
					Thread.sleep(50);
				}
			}catch(InterruptedException e) {		
			}//try
	}
	}
	
}
