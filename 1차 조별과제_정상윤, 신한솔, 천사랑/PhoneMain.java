import java.util.Scanner;

public class PhoneMain {
	/* 제목 : 개선 사항 
	 * 작성 일자:2022.06.12
	 * 작성자 : 김영문
	 * 내용 : 
	 * (_정상윤, 신한솔, 천사랑)
	 * 1.클래스의 이름의 경우 좀 더 명확하게 목적을 구분할수있는 네이밍 룰을 추천함.=>1세대 OnePhone,OriginPhone,DmbPhone 등등 후에 문제가 될 가능성이 있음
	 * 
	 * 2.int menu = Integer.parseInt(scanner.nextLine()); 등 숫자 데이터 입력 시
	 * 캐스팅이 들어가는 구간의 경우 try catch 블럭을 통해 사용자가 입력한값이 숫자가 아닐경우의 예외처리가 필요
	 * 자바 응용 과제 중 rtnInt메소드를 활용하면 반복적으로 숫자입력이 필요한경우 재사용이 가능함
	 * => ex) 숫자가 필요한 구간 int menu = rtnInt();<=반드시 숫자를 입력하고 리턴하는 메소드를 구현해서 사용
	 * 
	 * 3.Scanner의 경우 사용 후 반드시 close해줄것
	 * 
	 * 4.메뉴 1~3외에 숫자값을 입력 시 else 처리를 통해 잘못 입력된부분에 대해서 체크해줄필요가있음
		(4입력 시 루프가 계속 되어서 메뉴는 출력 되나 어떤 잘못을 했는지 사용자가 인지하기에 어려움이 있음)
	 * 
	 * 5.전원~전화까지의 기능은 대부분 재사용이되고 되풀이되므로 1세대 폰에서 구현해놓은 기능을 재황용하는게 더 효율적.
	 * 
	 * 6.((Phone2) p2) 등으로 캐스팅을 통한 클래스처리를 한것은 매우 인상적이고 응용력이 있어보이고 잘했으나 , 각각 다른 블럭킹에서 Phone1클래스를 다른이름으로 사용했기때문에
	 * 사용한 이유가 불분명함.
	 * 
	 * ex) 전역변수 Phone1클래스를 phone이라는 이름으로 선언 해놓고 menu가 선택 될때 마다 생성자를 이용.
	 * static Phone1 phone ;
	 * menu == 1 => phone = new Phone1("1세대 폰" ,"검정", "이니셜-1", "정보없음");
	 * menu == 2 => phone = new Phone2("2세대 폰", "검정", "이니셜-2", "종료", 1);
	 * 
	 * 
	 * 
	 * 처음 하는 프로젝트지만 전체적으로 우수하게 완성되었으며 객체의 다형성까지 연습해본것은 아주 훌륭하다고 생각합니다.
	 * 
	 * 다소 아쉬운 점은 위의 6가지와 더불어, 전체적으로 프로그램을 완성하고 테스트를 좀 더 꼼꼼하게 하여
	 * 개발자의 입장에서가 아니라 사용자의 입장에서 해보면 더 좋은 프로그램을 만들수있을거라고 생각합니다.
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. 1세대 2. 2세대 3. 3세대 중 고르세요");
		int menu = Integer.parseInt(scanner.nextLine());
		if(menu == 1) {
			Phone1 p1 = new Phone1("1세대 폰" ,"검정", "이니셜-1", "정보없음");
			p1.info();
			while(true) {
				System.out.println("1.전원\t2.전화\t3.음성");
				int go = Integer.parseInt(scanner.nextLine());
				if(go == 1) {
					System.out.println("1.전원켜기\t2.전원끄기");
					p1.setPower(Integer.parseInt(scanner.nextLine()));
					p1.powerCheck();
				}else if(go == 2){
					System.out.println("1.전화받기\t2.전화끊기");
					int call = Integer.parseInt(scanner.nextLine());
					p1.setCall(call);
					p1.send();
				}else if(go == 3) {
					System.out.println("1.음성 송신\t2.음성 수신");
					int voice = Integer.parseInt(scanner.nextLine());
					if(voice == 1) {
						p1.send();
					}else if(voice == 2) {
						p1.receive();
				}//if go
			}//while
		}
		}else if(menu == 2) {
			Phone1 p2 = new Phone2("2세대 폰", "검정", "이니셜-2", "종료", 1);
			p2.info();
			while(true) {
				System.out.println("1.전원\t2.전화\t3.음성\t4.DMB\t5.인터넷\t6.웹툰");
				int go = Integer.parseInt(scanner.nextLine());
				if(go == 1) {
					System.out.println("1.전원켜기\t2.전원끄기");
					p2.setPower(Integer.parseInt(scanner.nextLine()));
					p2.powerCheck();
				}else if(go == 2){
					System.out.println("1.전화받기\t2.전화끊기");
					int call = Integer.parseInt(scanner.nextLine());
					p2.setCall(call);
					p2.send();
				}else if(go == 3){
					System.out.println("1.음성 송신\t2.음성 수신");
					int voice = Integer.parseInt(scanner.nextLine());
					if(voice == 1) {
						p2.send();
					}else if(voice == 2) {
						p2.receive();
					}
				}else if(go == 4) {
					System.out.println("1.DMB켜기\t2.DMB끄기");
					int dmb = Integer.parseInt(scanner.nextLine());
					((Phone2) p2).setDmb(dmb);
					((Phone2) p2).Dmb();
					
				}//if go
			}//while
		}else if(menu == 3) {
			Phone1 p3 = new Phone3("3세대 폰", "검정", "이니셜-3", "종료", 1);
			p3.info();
			while(true) {
				System.out.println("1.전원\t2.전화\t3.음성\t4.DMB\t5.인터넷\t6.웹툰");
				int go = Integer.parseInt(scanner.nextLine());
				if(go == 1) {
					System.out.println("1.전원켜기\t2.전원끄기");
					p3.setPower(Integer.parseInt(scanner.nextLine()));
					p3.powerCheck();
				}else if(go == 2){
					System.out.println("1.전화받기\t2.전화끊기");
					int call = Integer.parseInt(scanner.nextLine());
					p3.setCall(call);
					((Phone1) p3).send();
				}else if(go == 3){
						System.out.println("1.음성 송신\t2.음성 수신");
						int voice = Integer.parseInt(scanner.nextLine());
						if(voice == 1) {
							p3.send();
						}else if(voice == 2) {
							p3.receive();
				}
				}else if(go == 4) {
					System.out.println("1.DMB켜기\t2.DMB끄기");
					int dmb = Integer.parseInt(scanner.nextLine());
					((Phone2) p3).setDmb(dmb);
					((Phone2) p3).Dmb();
				}else if(go == 5) {
					System.out.println("1.인터넷 켜기\t2.인터넷 끄기");
					int internet = Integer.parseInt(scanner.nextLine());
					((Phone3)p3).setInternet(internet);
					((Phone3)p3).Internet();;
				}else if(go == 6) {
					System.out.println("1.웹툰앱 켜기\t2.웹툰앱 끄기");
					int webtoon = Integer.parseInt(scanner.nextLine());
					((Phone3)p3).setWebtoon(webtoon);
					((Phone3)p3).Webtoon();
				}//if go
			}
		}
	}//main()
}//class
