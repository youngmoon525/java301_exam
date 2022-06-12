
public class SecondPhone extends FirstPhone {
	//멤버
	private String dmb, channel;
	
	
	//생성자
	public SecondPhone(String color, String model, String state, String channel) {
		super(color, model, state);
		this.channel = channel;
		
	}//

	
	@Override
	public void printInfo() {
		System.out.println("2세대 폰 (색상:" + color + "모델명:" + model + ", 상태 : " + state + "채널 : 정보없음)가 지급되었습니다.");
		System.out.println("(1세대폰 모든 기능을 점검합니다.)");
		System.out.println();
		
	}
	
	public void dmbOn() {
		if(state!="poweron") {
			System.out.println("전원이 꺼져 있어 DMB방송을 켤수가 없습니다.");
		}else {
			System.out.println("DMB방송을 켭니다: 현재채널 : 정보없음");
			dmb ="on";
		}//
	}//dmbOn
	
	public void dmbOff() {
		System.out.println("DMB방송을 끕니다.");
	}//dmbOff
	
	public void dmbCh(String channel) {
		if(dmb == "on") {
			System.out.println("DMB방송의 채널을 변경합니다 : 정보없음 =>" + channel + "번으로 변경 되었습니다.");
		}else if(dmb =="off") {
			System.out.println("DMB방송 시청중이 아니라 변경이 불가합니다.");
		}
	}//dmbCh
	
	@Override
	public String getState() {
		return super.getState();
	}

	@Override
	public void setState(String state) {
		super.setState(state);
	}

	@Override
	public void powerOn() {
			super.powerOn();
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		super.powerOff();
	}

	@Override
	public void answerCall() {
		// TODO Auto-generated method stub
		super.answerCall();
	}

	@Override
	public void hangUp() {
		// TODO Auto-generated method stub
		super.hangUp();
	}

	@Override
	public void voiceSend() {
		// TODO Auto-generated method stub
		super.voiceSend();
	}

	@Override
	public void voiceReceive() {
		// TODO Auto-generated method stub
		super.voiceReceive();
	}

	
	

	
}//class
