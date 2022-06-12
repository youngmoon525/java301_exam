package phone.com.model;

public class FirstPhonePhone {
	protected String color, model, state;
	protected int power, call, voice, generation;
	
	
	
	public FirstPhonePhone(int generation, String color, String model, String state) {
		super();
		this.generation = generation;
		this.color = color;
		this.model = model;
		this.state = state;
		
	}//FirstPhonePhone
	
	
	public void printInfor() {
		System.out.println();
		System.out.println("요정 : "+ generation + "세대 폰 (색상 :" + color +", 모델명 : " + model +", 상태 :" + state+")가 지급되었습니다." );
		System.out.println();
	}//printInfor


	
	
	public void powerOn() {
		state = "전원켜짐";
		System.out.println(model + "폰의 전원이 켜졌습니다!");
		
	}//powerOn
	
	public void powerOff() {
		state = "전원꺼짐";
		System.out.println("요정 : " + model+"폰의 전원이 꺼졌습니다!");
		
	}//powerOff
	
	public void answerCall() {
		state = "전화중";
		System.out.println("요정 : 전화를 받았습니다!");
		
	}//전화받기

	public void hangUp() {
		state = "대기중";
		System.out.println("요정: 전화를 끊습니다.");
	}//전화끊기
	
	
	public void voicSend() {
		if(state =="전화중"){
			System.out.println("나: 여보세요~");
		}else if(state =="대화중") {
			System.out.println("나 : 배구 봐요!");
			state ="전화중";
		}//if
	}//음성전송
	
//	public void voicSend2() {
//		
//		System.out.println("나 : 웹툰봐요~!");
//		System.out.println("- 상대가 전화를 끊었습니다.");
//	}//음성전송
//	
	
	public void voiceReceive() {
		if(state =="전화중") {
			state ="대화중";
			System.out.println("김연경 : 뭐해?");
		}
	}//음성수신
	
	
	//getter setter
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


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public int getCall() {
		return call;
	}


	public void setCall(int call) {
		this.call = call;
	}


	public int getVoice() {
		return voice;
	}


	public void setVoice(int voice) {
		this.voice = voice;
	}


	public int getGeneration() {
		return generation;
	}


	public void setGeneration(int generation) {
		this.generation = generation;
	}

	
	
	
	
}//class
