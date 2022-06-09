package phone;

import java.util.Scanner;

public class SmartPhone extends DMBPhone{
	public SmartPhone(String phonename, String color, String model, String state) {
		super(phonename, color, model, state);
		
	}

	@Override
	public void printInfo() {
		super.printInfo();
	}

	@Override
	public void menuBar() {
		System.out.println("===================================================================================================================================================");
		System.out.println("1.전화받기\t2.전화끊기\t3.음성메세지 수신&송신\t4.DMB방송켜기\t5.인터넷켜기\t6.인터넷끄기");
		System.out.println("===================================================================================================================================================");
	}

	@Override
	public void powerOn(Scanner scanner) {
		System.out.println(model + "가 켜졌습니다");
		menuBar();
		int menubar = Integer.parseInt(scanner.nextLine());
		if(menubar == 1) {
			receive(scanner);
		}else if(menubar == 2) {
			System.out.println("전화를 끊습니다");
		}else if(menubar == 3) {
			System.out.println("통화중인 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다.");
		}else if(menubar == 4) {
			System.out.println("현재 채널 : 정보없음");
			while(true) {
			System.out.println("1.채널변경\t2.DMB끄기");
			int DMBMenu = Integer.parseInt(scanner.nextLine());
			if(DMBMenu == 1) {
				System.out.println("변경할 채널수를 입력하세요!");
				int channel = Integer.parseInt(scanner.nextLine());
				System.out.println("DMB방송의 채널을 변경합니다 : 정보없음 ==>" +channel+"번으로 변경됨");
				continue;
			}else if(DMBMenu == 2) {
				System.out.println("DMB방송을 끕니다.");
				break;
			}
			}//while
		}else if(menubar == 5){
			System.out.println("상태정보 : 인터넷 켜짐");
			System.out.println("1. 웹툰 앱 켜기 2.웹툰 앱 끄기");
			int webtoon = Integer.parseInt(scanner.nextLine());
			if(webtoon == 1) {
				System.out.println("상대방:뭐하세요?\r\n"
						+ "나:웹툰 봅니다.\r\n"
						+ "전화를 끊습니다.");
			}else if(webtoon ==2 ) {
				System.out.println("웹툰 앱이 꺼져있는 상태");
			}
		}else if(menubar == 6){
			System.out.println("상태정보 : 인터넷 꺼짐");
		}{
			System.out.println("다시 입력하세요");
		}//if
	}

	@Override
	public void powerOff(Scanner scanner) {
		System.out.println("전원이 꺼졌습니다");
		menuBar();
		int menubar = Integer.parseInt(scanner.nextLine());
		if(menubar == 1) {
			System.out.println("전원이 꺼져있어 전화 받기가 불가 합니다.");
		}else if(menubar == 2) {
			System.out.println("전원이 꺼져있어 전화 끊기가 불가 합니다.");
		}else if(menubar == 3) {
			System.out.println("전원이 껴져있어 음성 전송 & 수신이 불가합니다");
		}else if (menubar == 4) {
			System.out.println("전원이 꺼져있어 DMB방송을 켤수가 없습니다.");
		}else {
			System.out.println("다시 입력하세요");
		}//if
	}
	
	
	

}//class