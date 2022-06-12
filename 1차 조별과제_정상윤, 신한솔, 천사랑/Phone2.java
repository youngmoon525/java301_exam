import java.util.Scanner;

public class Phone2 extends Phone1{
	protected int channel;
	protected int dmb;
	public Phone2() {}
	
		public Phone2(String phonename, String color, String model, String state, int channel) {
			super(phonename, color, model, state);
			this.phonename = phonename;
			this.color = color;
			this.model = model;
			this.channel = channel;
		}
	
	public int getChannel() {
			return channel;
		}

		public void setChannel(int channel) {
			this.channel = channel;
		}

		public int getDmb() {
			return dmb;
		}

		public void setDmb(int dmb) {
			this.dmb = dmb;
		}

	@Override
	public void info() {
		System.out.println(phonename + "(색상:" + color + ", 모델명:" + model + ", 상태:" + state + ", 채널: 정보없음)가 지급되었습니다");
	}
	
	public void Dmb() {
		if(power == 1 && dmb == 1) {
			System.out.println("DMB방송을 켭니다 : 현재채널 : 정보없음");
			System.out.println("채널을 변경하시겠습니까? ▶ 1번");
			Scanner scanner = new Scanner(System.in);
			channel = Integer.parseInt(scanner.nextLine());
			if(channel == 1) {
				System.out.println("변경할 채널을 입력하세요.");
				channel = Integer.parseInt(scanner.nextLine());
				System.out.println("DMB 방송의 채널을 변경합니다 : " + channel + "으로 변경 됨");
				System.out.println("DMB 방송을 끕니다");
			}else {
				System.out.println("다시 입력하세요");
			}
		}else if(power != 1 && dmb == 1) {
			System.out.println("전원이 꺼져있어 DMB방송을 켤수가 없습니다.");
		}else {
			System.out.println("다시 입력하세요");
			return;
		}
	}//Dmb()
}//class
