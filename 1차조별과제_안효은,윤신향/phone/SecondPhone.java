package com.phone;

public class SecondPhone extends FirstPhone {
	private int dmb;
	private String channel;

	public SecondPhone() {}
	
	public SecondPhone(int generation, String color, String model, String state, String channel) {
		super(generation, color, model, state);
		this.channel = "정보없음";
		this.dmb = 0;
		
		
	}
	
	
	//메소드
	@Override
	public void print() {
		System.out.println("=================================================");
		System.out.println(getGeneration() + "세대폰이 지급되었습니다.");
		System.out.println("색상 : " + getColor() + ", 모델명 : " + getModel() + ", 상태 : " + getState() + ", 채널:정보없음");
	}
	
	public void dmbOff() {
		System.out.println("DMB 시청 중이 아닙니다.");
	}
	
	public void dmb(int dmb) {
		if(dmb == 0) {
			System.out.println("===================");
			System.out.println("1.DMB켜기 2.DMB끄기");
			System.out.print("▶ ");
		}else if(dmb == 1) {
			setState("DMB시청중");
			System.out.println("DMB방송을 켭니다 : 현재 채널 : " + channel);
		}else if(dmb == 2) {
			setState("전원켜짐");
			System.out.println("DMB방송을 끕니다.");
		}//if		
	}
	
	//getter&setter
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public int getDmb() {
		return dmb;
	}

	public void setDmb(int dmb) {
		this.dmb = dmb;
	}
	
}//class
