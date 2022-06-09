package phone;

import java.util.Scanner;

/* 제목 : 개선 사항 
 * 작성 일자:2022.06.08
 * 작성자 : 김영문
 * 내용 : 
 * (박가인 , 신기록 , 한재민)
 * ===========================공통 == ( OnePhone , DMBPhone , SmartPhone ) ================
 * 1.Scanner의 경우 PhonePlay()에서 생성해서 사용되고 Power On & Off 메소드에서도 계속 해서 사용되게 때문에
 * 인스턴스 멤버로 한번 초기화 하거나 메인에서만 생성 후 사용하는게 좀더 가독성이 높고 효율적.
 * 
 * 2.int menu = Integer.parseInt(scanner.nextLine()); 등 숫자 데이터 입력 시
 * 캐스팅이 들어가는 구간의 경우 try catch 블럭을 통해 사용자가 입력한값이 숫자가 아닐경우의 예외처리가 필요
 * 
 * 3.Scanner 사용 후 close()를 안함.
 * 
 * 4.휴대폰의 전원상태가 바뀌었을때는 state를 이용해서 상태정보를 바꾼 후 이용하는것이 편리함.state이용안됨.
 * 
 * 5. 4와 연계되어 전체적인 flow가 매끄럽지 못함 => 시작시 전원을 켜지 않은상태에서 테스트(인터넷 ,DMB등)하면 아무 문구없이 다시입력하라는
 * 메세지가 나오거나 하는 등등.
 * 
 * 처음 하는 프로젝트지만 전체적으로 우수하게 완성하였습니다.
 * 
 * 다소 아쉬운 점은 위의 5가지와 더불어, 전체적으로 프로그램을 완성하고 테스트를 좀 더 꼼꼼하게
 * 개발자의 입장에서가 아니라 사용자의 입장에서 해보면 더 좋은 프로그램을 만들수있을거라고 생각합니다.
 * 
 * 
 * */

public class SuperPhoneMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("원하는 폰을 선택하세요!");
			System.out.println("============================================");
			System.out.println("1.1세대Phone\t2.DMBPhone\t3.SmartPhone");
			System.out.println("============================================");

			int cho = Integer.parseInt(scanner.nextLine());
			OnePhone onephone = null;
			if (cho == 1) {
				onephone = new OnePhone("1세대 폰", "검정", "이니셜-1", "종료");
				onephone.phonePlay();
				break;
			} else if (cho == 2) {
				onephone = new DMBPhone("2세대 폰", "검정", "이니셜-2", "종료");
				onephone.phonePlay();
				break;
			} else if (cho == 3) {
				onephone = new SmartPhone("3세대 폰", "검정", "이니셜-3", "종료");
				onephone.phonePlay();
				break;
			} else {
				System.out.println("다시 선택해 주세요");
			}
		} // while

	}// main()
}