package phone.com.model;

import java.util.Scanner;


public class SubMenuMenu {

	//객체 생성
	private Scanner scanner;
	public SubMenuMenu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	public void play(FirstPhonePhone phone) {
		
		
		System.out.println("   •──────────────────•°•❀•°•────────────────•");
		System.out.println();
		System.out.println("　　　　　　　　　　　　　　　　　< 전원부터 킬까요? (◠‿◠) >");
		System.out.println();
		System.out.println("　　　　　　　　　　\t\t1.YES 　　　\t 　　2.No");
		System.out.println();
		System.out.println("•────────────────────────────────────────────•");
		
	int menu1 = Integer.parseInt(scanner.nextLine());
	
	if(menu1 == 1) {
		phone.powerOn();
		
		for(;;) {
		System.out.println();
		System.out.println("   •──────────────────•°•❀•°•────────────────•");
		System.out.println();
		System.out.println(" 　　　　　　　　　　　　　　　< 무엇을 할까요? (•‿•) >　　　　　　　　　　　　　　　　　");
		System.out.println();
		System.out.println("　\t　　1.전원끄기　　2.전화받기　　3.전화끊기　　4.음성전송　　5.음성수신　　");
		System.out.println();
		System.out.println("　　　　　　　　　　　　6.DMB켜기　　　7.DMB채널변경　　　8.DMB끄기");
		System.out.println();
		System.out.println("　　　　　　　9.인터넷연결　　10.인터넷끄기　　11.웹툰켜기　　12.웹툰끄기");
	    System.out.println("•─────────────────────────────────────────────•");
			
		int	menu = Integer.parseInt(scanner.nextLine());
			
			
			//if(phone.getGeneration() ==1) {
				if(menu == 1) {
					phone.powerOff();
					break;
				}else if(menu == 2) {
						if(phone.getState().equals("전화중")|| phone.getState().equals("대화중")) {
							System.out.println("통화중이어서 전화를 받을 수 없습니다!");
						}else if(phone.getState().equals("대기중") || phone.getState().equals("전원켜짐")) {
							phone.answerCall();
						}//메뉴 2번if
				}else if(menu ==3) {
						if(phone.getState().equals("전화중")|| phone.getState().equals("대화중")|| phone.getState().equals("웹툰켜짐")){
							phone.hangUp();
						}else {
							System.out.println("☎전화중이 아니므로 전화 끊기가 불가 합니다!");
						}//메뉴 3번 if
				}else if(menu ==4) {
					if(phone.getGeneration() ==1 || phone.getGeneration() ==2) {
						if(phone.getState().equals("전화중") || phone.getState().equals("대화중")|| phone.getState().equals("웹툰켜짐")) {
							phone.voicSend();
//						}else if(phone.getGeneration() != 1 || phone.getState() =="전화중") {
//							phone.voicSend();
						}else {
							System.out.println("☎전화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다!");
						}//
					}else if(phone.getGeneration() ==3) {
						if(((ThirdPhonePhone)phone).getState().equals("전화중") || ((ThirdPhonePhone)phone).getState().equals("대화중") ||((ThirdPhonePhone)phone).getWebtoon()=="웹툰켜짐"){
							((ThirdPhonePhone)phone).voicSend();
						}else {
							System.out.println("☎전화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다!");	
						}	
					}//if
					
				}else if(menu ==5) {
					if(phone.getGeneration() ==1 || phone.getGeneration() ==2) {
						if(phone.getState().equals("전화중") || phone.getState().equals("대화중") ||phone.getState().equals("웹툰켜짐")) {
							phone.voiceReceive();
//						}else if(phone.getGeneration() != 1 || phone.getState() =="전화중") {
//							phone.voicSend();
						}else {
							System.out.println("☎전화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다!");
						}//
					}else if(phone.getGeneration() ==3) {
						if(((ThirdPhonePhone)phone).getState().equals("전화중") || ((ThirdPhonePhone)phone).getState().equals("대화중") || ((ThirdPhonePhone)phone).getWebtoon().equals("웹툰켜짐")){
							((ThirdPhonePhone)phone).voiceReceive();
						}else {
							System.out.println("☎전화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다!");	
						}	
					}
				}else if(phone.getGeneration() ==1) {
					if(menu >=6 && menu <=12) {
						System.out.println("요정 : ☞☜안타깝지만 1세대에는 없는 기능입니다");
					}else {
						System.out.println("요정 : 없는 번호입니다 다시 입력하세요!");
					}
				
				
				
			//	}else if(phone.getGeneration()==2) {
				}else if(menu ==6) {
					((SecondPhonePhone)phone).dmbOn();
					
				}else if(menu ==7) {
					 if(((SecondPhonePhone)phone).getdmb().equals("켜짐")) {
						 System.out.print("채널을 입력하세요 ▶ ");
						 String ch =scanner.nextLine();
						 System.out.println();
						 System.out.print("DMB방송의 채널을 변경합니다 : " + ((SecondPhonePhone)phone).getChannel());
						 ((SecondPhonePhone)phone).setChannel(ch);
						 System.out.println(" ▶ "+ ch + "번으로 채널이 변경되었습니다!");
					 }else {
						System.out.println("DMB가 꺼져 있어 채널을 바꿀 수 없습니다");
					 }//메뉴 8번안에 if
				}else if(menu ==8) {
						if(((SecondPhonePhone)phone).getdmb().equals("켜짐")) {
							((SecondPhonePhone)phone).dmbOff();
						}else {
							System.out.println("요정 : DMB방송부터 켜주시면 꺼드리겠습니다!");
						}//메뉴9번안에 if
						
				}else if(phone.getGeneration() ==2 ) {
					if(menu >=9 && menu <=12) {
						 System.out.println("요정 : ☞☜안타깝지만 2세대에는 없는 기능입니다");
					}else {
						System.out.println("요정 : 없는 번호 입니다! 다시 입력해주세요!");
					}//if
					
				}else if(menu ==9) {
					if(((ThirdPhonePhone)phone).getWeb().equals("인터넷켜짐")) {
						System.out.println("요정 : 이미 인터넷이 연결되어 있습니다!");
					}else {
						((ThirdPhonePhone)phone).webOn();
						
					}
					
				}else if(menu ==10){
					if(((ThirdPhonePhone)phone).getWeb().equals("인터넷켜짐")) {
						((ThirdPhonePhone)phone).webOff();
					}else {
						System.out.println("요정 : 인터넷부터 켜주시면 꺼드리겠습니다!");
						
					}//if
				}else if(menu == 11){
					if(!((ThirdPhonePhone)phone).getWeb().equals("인터넷켜짐")) {
						System.out.println("요정 : 인터넷이 연결되어 있지 않아 웹툰 실행이 불가합니다!");
					}else if(((ThirdPhonePhone)phone).getWebtoon().equals("웹툰켜짐")) {
						System.out.println("요정 : 이미 웹툰이 켜져있어요! 즐감즐감^^*");
					}else {
						((ThirdPhonePhone)phone).webtoonOn();
						
					}//if
				}else if(menu == 12) {
					if(!((ThirdPhonePhone)phone).getWebtoon().equals("웹툰켜짐") || !((ThirdPhonePhone)phone).getWeb().equals("인터넷켜짐")) {   //&&이걸로 하면 웹툰을 꺼도 다시 끄기 눌렀을때 또 꺼진다.. 암것도 안켰는데... 그래서 || 이걸로 바꾸면 된다...
						System.out.println("요정 : 웹툰부터 켜주시면 꺼드리겠습니다!");
					}else {
						((ThirdPhonePhone)phone).webtoonOff(); 
						
					}//if
				}else {
					System.out.println("요정 : 없는 번호 입니다! 다시 입력해주세요");
				}//menu = if 끝!
		
		}//for 반복문 끝!====================================================================================
		
		
	}else  {
		
		String[] strs = {" ╭┈┈┈┈╯  ╰┈┈┈╮","　╰┳┳╯ 　╰┳┳╯　","　o 　　　o","　o　╰┈┈╯　o"," 　 ╭━━━━━╮ ","다음에 만나요"};
		
		Sleep sl = new Sleep(strs);
		sl.start();
//		System.out.println(" ╭┈┈┈┈╯  ╰┈┈┈╮");
//		System.out.println("　╰┳┳╯ 　╰┳┳╯　");
//		System.out.println("　o 　　　o");
//		System.out.println("　o　╰┈┈╯　o");
//		System.out.println(" 　 ╭━━━━━╮ ");
//		System.out.println();
//		System.out.println("다음에 만나요");
	
	}//yes no if문 끝
		
  }//play
}//class
