
public class FirstPhone {
	protected String color, model, state;
	protected int power, call, voice;
	
	
	//생성자
	public FirstPhone(String color, String model, String state) {
		this.color = color;
		this.model = model;
		this.state = state;
		printInfo();
	}
	
	public void printInfo() {
		System.out.println("1세대 폰 (색상:" + color + "모델명:" + model + ", 상태 : " + state + ")가 지급되었습니다.");
		System.out.println("(1세대폰 모든 기능을 점검합니다.)");
	}//printInfo()


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void powerOn () {
		state = "poweron";
			System.out.println(model + "전원이 켜졌습니다.");
	}//powerOn()
	
	public void powerOff() {
		state = "poweroff";
		System.out.println(model + "전원을 끕니다.");
	}//powerOff()
	
	public void answerCall() {
		if (getState().equals("poweron")) {
			System.out.println("전화가 와서 전화를 받았습니다.");
			state = "answercall";
		} else if(getState().equals("poweroff")||getState().equals("종료")){
			System.out.println("전원이 꺼져있어 전화 받기가 불가 합니다.");
			state = "poweroff";
		}//if
	}//answerCall()
	
	public void hangUp() {
		if (getState().equals("answercall")) {
			System.out.println("전화를 끊습니다.");
			state = "hangup";
		}else if(getState().equals("poweroff")||getState().equals("종료")){
			System.out.println("전원이 꺼져있어 전화 끊기가 불가 합니다.");
		}//if
	}//hangUp()
	
	public void voiceSend() {
		if (getState().equals("answercall")) {
			System.out.println("나: 여보세요?");
		} else {
			System.out.println("통화중 상태가 아닙니다. 음성 전송&수신이 불가합니다.");
		}//if
	}//voiceSend()
	
	public void voiceReceive() {
		if (getState().equals("answercall")) {
			System.out.println("상대방: 여보세요?");
		} else {
			System.out.println("통화중 상태가 아닙니다. 음성 전송&수신이 불가합니다.");
		}//if
	}//voiceReceive()
}//class
