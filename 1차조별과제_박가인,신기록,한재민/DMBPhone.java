package phone;

import java.util.Scanner;

public class DMBPhone extends OnePhone{

	
	public DMBPhone(String phonename, String color, String model, String state) {
		super(phonename,color, model, state);
		
	}//DMBPhone
	
	@Override
	public void printInfo() {
		System.out.println(phonename +"(색상 :" + color + ", 모델명 : " + model + ", 상태 : " + state + " 채널: 정보없음)가 지급 되었습니다");
	}

	@Override
	public void menuBar() {
		System.out.println("===================================================================================");
		System.out.println("1.전화받기\t2.전화끊기\t3.음성메세지 수신&송신\t4.DMB방송켜기");
		System.out.println("===================================================================================");
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
		}else {
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