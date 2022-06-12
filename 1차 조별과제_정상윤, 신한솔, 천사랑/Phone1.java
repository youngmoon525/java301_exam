import java.util.Scanner;

public class Phone1{
	protected int power, call, voice;
	protected String phonename, color, model, state, info, send, receive;
	

	public Phone1() {}
	
	public Phone1(String phonename, String color, String model, String state) {
		this.color = color;
		this.model = model;
		this.state = state;
		this.phonename = phonename;
	}
	
	public void info() {
		System.out.println(phonename + "(색상:" + color + ", 모델명:" + model + ", 상태:" + state + ")가 지급되었습니다.");
	}
	
	public void powerCheck() {
		if(power ==1) {
			System.out.println(model + "전원이 켜졌습니다");
		}else if(power == 2) {
			System.out.println(model + "전원이 꺼졌습니다");
			
		}else {
			System.out.println("잘못눌렀습니다!");
		}
	}
	

	public void send() {
		Scanner scanner = new Scanner(System.in);
		if(power == 1 && call == 1) {
			System.out.println("전화가 와서 전화를 받았습니다");
			System.out.println("전송할 말을 입력하세요");
			String str1 = scanner.nextLine();
			System.out.println("나 : " + str1);
		}else if(power == 1 && call == 2) {
			System.out.println("전화를 끊습니다");
		}else if(power != 1 && call == 2) {
			System.out.println("전원이 꺼져있어 전화끊기가 불가 합니다.");
		}else if(power != 1 && call == 1)
			System.out.println("전원이 꺼져있어 전화받기가 불가 합니다.");
	}//send()
	
	public void receive() {
		Scanner scanner = new Scanner(System.in);
		if(power == 1 && call == 1) {
			System.out.println("전송받을말을 입력하세요");
			String str2 = scanner.nextLine();
			System.out.print("상대방 : ");
			System.out.println(str2);
		}
	}

	public void voice() {
		if(power == 1 && call == 1 && voice == 1) {
			System.out.println("나 : 여보세요?");
		}else if(power == 1 && call == 1 && voice == 2) {
			System.out.println("상대방 : 여보세요?");
		}else if(call == 2 || power == 2) {
			System.out.println("통화중 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다.");
		}
	}
	
	public int getVoice() {
		return voice;
	}
	
	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	public String getSend() {
		return send;
	}
	
	public void setSend(String send) {
		this.send = send;
	}
	
	public String getReceive() {
		return receive;
	}
	
	public void setReceive(String receive) {
		this.receive = receive;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhonename() {
		return phonename;
	}

	public void setPhonename(String phonename) {
		this.phonename = phonename;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCall() {
		return call;
	}
	
	public void setCall(int call) {
		this.call = call;
	}

}//class
