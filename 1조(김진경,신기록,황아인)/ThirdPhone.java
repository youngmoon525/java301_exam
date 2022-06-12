   
public class ThirdPhone extends SecondPhone {

	public static final String first = null;
	private String web, webtoon;
	
	
	public ThirdPhone(String generation, String color, String model, String state) {
		super(generation, color, model, state);
	}	
	
	@Override
	public void printInfo() {
		System.out.println("3세대 폰 (색상:" + color + "모델명:" + model + ", 상태 : " + state + ", 채널 : 정보없음)가 지급되었습니다.");
		System.out.println(model + "(3세대폰 모든 기능을 점검합니다.)");	
		
	}
	
	public void webOn() {
		if(state == "poweroff") {
			System.out.println("전원이 꺼져있어 web을 켤수가 없습니다.");
		}else {
			web = "on"; 
			System.out.println("web 켭니다 ");
		}//if
	}//web
	
	public void webOff() {
		System.out.println("web을 끕니다.");
		web ="off";
	}//webOff
	
	public void webtoonOn() {
		if(state == "poweroff") {
			System.out.println("전원이 꺼져있어 웹툰을 켤수가 없습니다.");
		}else {
			webtoon = "on";
			
			System.out.println("웹툰 켭니다");
		}//if
	}//webtoOn
	
	public void webtoonOff() {
		System.out.println("웹툰을 끕니다.");
		webtoon ="off";
	}//webtoonOff
	
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
		if (getState().equals("answercall")) {
			System.out.println("나: 여보세요?");
		} else if(getState().equals("voiceReceive2") )  {
			System.out.println("나:웹툰을 본단다");
			state = "answercall";
		}//if
		
	}

	@Override
	public void voiceReceive() {
		System.out.println("상대방:뭐하세요?");
		state = "voiceReceive2";
	}

	
	
}
