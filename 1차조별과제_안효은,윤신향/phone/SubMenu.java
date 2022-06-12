package com.phone;

import java.util.Scanner;

public class SubMenu {
	private Scanner scanner;
	public SubMenu(Scanner scanner) {
		this.scanner = scanner;
	}

	public void play(FirstPhone phone) {
		System.out.println("=================================================");
		System.out.println("1.전원 2.전화 3.음성 4.dmb 5.채널 6.인터넷 7.웹툰");
		System.out.print("▶ ");
		String menu = scanner.nextLine();
		//1. 메뉴 전원
		
		if(menu.equals("1")) {
			phone.power(0);
			String power = scanner.nextLine();
			if(power.equals("1")) {
				if(phone.getState().equals("종료") || phone.getState().equals("전원꺼짐")) {
					phone.power(1);
					play(phone);
				}else {
					System.out.println("이미 전원이 켜져있습니다.");
					play(phone);
				}//if
			}else if(power.equals("2")) {
				phone.power(2);
				SuperPhone.main(null);
			}else{
				phone.ng();
				play(phone);
			}//if
		//2. 메뉴 전화
		}else if(!(phone.getState().equals("종료")||phone.getState().equals("전원꺼짐"))){
			if(menu.equals("2")) {
				phone.call(0);
				String call = scanner.nextLine();
				if(call.equals("1")) {
					phone.call(1);
					play(phone);
				}else if(call.equals("2")) {
					if(phone.getState().equals("전화중")) {
						phone.call(2);
						play(phone);
					}else {
						System.out.println("전화중이 아니어서 전화를 끊을 수 없습니다.");
						play(phone);
					}//if
				}else {
					phone.ng();
					play(phone);
				}//if
				
			//3. 메뉴 음성
			}else if(menu.equals("3")) {
				if(phone.getState().equals("전화중")) {
					phone.voice(0);
					String voice = scanner.nextLine();
					if(voice.equals("1")) {
						phone.voice(1);
						play(phone);
					}else if(voice.equals("2")) {
						phone.voice(2);
						play(phone);
					}else if(voice.equals("3")) {
						phone.voice(3);
						play(phone);
					}else {
						phone.ng();
						play(phone);
					}//if
				}else {
					System.out.println("통화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다.");
					play(phone);
				}//if
				
			//4. 메뉴 DMB
			}else if(menu.compareTo("4") >= 0 && menu.compareTo("6") < 0 ) {
				if(phone.getGeneration() == 1) {
					phone.gr();
					play(phone);
				}else if(menu.equals("4")) {
					if(phone.getState().equals("전원켜짐")) {
						((SecondPhone) phone).dmb(0);
						String dmb = scanner.nextLine();
						if(dmb.equals("1")) {
							((SecondPhone) phone).dmb(1);
							play(phone);
						}else if(dmb.equals("2")) {
							if(phone.getState().equals("DMB시청중")) {
								((SecondPhone) phone).dmb(2);					
								play(phone);
							}else {
								((SecondPhone) phone).dmbOff();
								play(phone);
							}//if	
						}else {
							phone.ng();
							play(phone);
						}//if
					}else {
						System.out.println("DMB를 킬 수 없습니다.");
						play(phone);
					}//if
					
				//5. 메뉴 Channel	
				}else if(menu.equals("5")) {
					if(phone.getState().equals("DMB시청중")) {
						System.out.println("채널을 몇 번으로 변경하시겠습니까? 번호입력 ▶ ");
						String x =  ((SecondPhone) phone).getChannel();
						String ch = scanner.nextLine();
						System.out.println( "DMB방송의 채널을 변경합니다 : " + x + " → " + ch + "번으로 변경 됨.");
						((SecondPhone) phone).setChannel(ch);
						play(phone);				
					}else {
						((SecondPhone) phone).dmbOff();
						play(phone);
					}//if	
				}//if
				
			//6. 메뉴 인터넷
			}else if(menu.compareTo("6") >= 0 && menu.compareTo("8") < 0) {
				if(phone.getGeneration() != 3 ) {
					phone.gr();
					play(phone);
				}else if(menu.equals("6")) {
					((ThirdPhone) phone).internet(0);
					String web = scanner.nextLine();
					if(web.equals("1")) {
						((ThirdPhone) phone).internet(1);
						play(phone);
					}else if(web.equals("2")) {
						((ThirdPhone) phone).internet(2);
						play(phone);
					}else {
						phone.ng();
						play(phone);
					}//if
					
				//7.메뉴 웹툰
				}else if(menu.equals("7")) {
					((ThirdPhone) phone).webtoon(0);
					String toon = scanner.nextLine();
					if(toon.equals("1")) {
						if(((ThirdPhone) phone).getInternet() == 1) {						
							((ThirdPhone) phone).webtoon(1);
							play(phone);
						}else {
							System.out.println("인터넷이 켜져 있지 않아 웹툰 앱 접속 불가!");
							play(phone);							
						}//if
					}else if(toon.equals("2")) {
						((ThirdPhone) phone).webtoon(2);
						play(phone);													
					}else {
						phone.ng();
						play(phone);
					}//if	
				}//if
			}else if(menu.compareTo("7") > 0){
				phone.ng();
				play(phone);
			}else {
				phone.ng();
				play(phone);
			}
			//		}else if(menu.equals("4")) {
//			if(phone.getGeneration() == 1) {
//				phone.gr();
//				play(phone);
//			}else if(phone.getState().equals("전원켜짐")) {
//				((SecondPhone) phone).dmb(0);
//				String dmb = scanner.nextLine();
//				if(dmb.equals("1")) {
//					((SecondPhone) phone).dmb(1);
//					play(phone);
//				}else if(dmb.equals("2")) {
//					if(phone.getState().equals("DMB시청중")) {
//						((SecondPhone) phone).dmb(2);					
//						play(phone);
//					}else {
//						((SecondPhone) phone).dmbOff();
//						play(phone);
//					}//if
//				}else {
//					phone.ng();
//					play(phone);
//				}//if
//			}else {
//				System.out.println("DMB를 킬 수 없습니다.");
//				play(phone);
//			}		
//		}else if(menu.equals("5")) {
//			if(phone.getGeneration() == 1) {
//				phone.gr();
//				play(phone);
//			}else if(phone.getState().equals("DMB시청중")) {
//				System.out.println("채널을 몇 번으로 변경하시겠습니까? 번호입력 ▶ ");
//				String x =  ((SecondPhone) phone).getChannel();
//				String ch = scanner.nextLine();
//				System.out.println( "DMB방송의 채널을 변경합니다 : " + x + " → " + ch + "번으로 변경 됨.");
//				((SecondPhone) phone).setChannel(ch);
//				play(phone);				
//			}else {
//				((SecondPhone) phone).dmbOff();
//				play(phone);
//			}//if
//			
//		}else if(menu.equals("6")) {
//			
//		}else if(menu.equals("7")) {
			
		}else {
			phone.poweroff();
			play(phone);
		}
		
	
//			System.out.println("============================");
//			System.out.print("전원을 켜시겠습니까? 1. 전원켜기  2. 전원끄기 ▶ ");
//			int menu = Integer.parseInt(scanner.nextLine());
//			System.out.println("");
//			if(menu == 1) {
//				phone.powerOn();
//					System.out.println("============================");
//					System.out.print("1.전원끄기 2. 전화받기 ▶ ");
//					int num = Integer.parseInt(scanner.nextLine());
//					System.out.println("");
//					
//					if(num == 1) {
//						phone.powerOff();
//						play(phone);
//				
//					}else if(num == 2) {
//						phone.callOn();
//						if(phone.getGeneration() == 1 || phone.getGeneration() == 2) {
//							System.out.println("============================");
//							System.out.print("1.음성송신 2. 전화끊기 ▶ ");
//							num = Integer.parseInt(scanner.nextLine());
//							if(num == 1) {
//									phone.voiceSend("전화중");
//									System.out.println("============================");
//									System.out.print("1.음성수신 2. 전화끊기 ▶ ");
//									num = Integer.parseInt(scanner.nextLine());
//									if(num == 1) {
//										phone.voiceRecive("전화중");
//								}else if(num == 2) {
//										phone.hangUp();
//									}
//							}else if(num == 2) {
//								phone.hangUp();
//								
//							}//if
//						}else {
//							System.out.println("1.음성송신 2. 인터넷연결 3. 전화끊기");
//						}//if
//					}else {
//						System.out.println("잘못 입력하셨습니다.");				
//					}//if
//			
//				
//			}else if (menu == 2) {
//				phone.powerOff();
//				play(phone);
//			}else {
//				System.out.println("잘못 입력하셨습니다.");
//				
//			}
		scanner.close();
	}//play()

	//public void menu2 () {
		
	//}
	 
}//class
