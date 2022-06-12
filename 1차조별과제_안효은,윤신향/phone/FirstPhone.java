package com.phone;

import java.util.Scanner;

public class FirstPhone {
	private String color, model, state;
	private int generation, power, call, voice;
	
	private Scanner scanner;

	public FirstPhone() {}
	
	public FirstPhone(int generation, String color, String model, String state) {
		super();
		this.generation = generation;
		this.color = color;
		this.model = model;
		this.state = state;
	}


	//메소드
	public void print() {
		System.out.println("=================================================");
		System.out.println(generation  + "세대폰이 지급되었습니다.");
		System.out.println("색상 : " + color + ", 모델명 : " + model + ", 상태 : " + state);
	}
	
	
	public void ng() {
		System.out.println("제대로 눌러주세요");
	}
	
	public void poweroff() {
		System.out.println("전원이 꺼져있어 작동 되지 않습니다.");
	}
	
	public void gr() {
		System.out.println(generation + "세대는 이용할 수 없습니다.");
	}
	
	//메뉴 1번 전원
	public void power(int power) {
		if(power == 0) {
			System.out.println("=====================");
			System.out.println("1.전원켜기 2.전원끄기");
			System.out.print("▶ ");
		}else if(power == 1) {
			state = "전원켜짐";
			System.out.println(model + " 전원이 켜졌습니다★");
			
		}else if(power == 2) {
			//if(state.equals("전원꺼짐")) {
			//	System.out.println("이미 전원이 꺼져있습니다.");
			//}else {
				state = "전원꺼짐";
				System.out.println(model + " 전원이 꺼졌습니다.");
			//}
		}//if
	}//power()

	
	//메뉴 2번 전화
	public void call(int call) {
		if(call == 0) {
			System.out.println("=====================");
			System.out.println("1.전화승인 2.전화끊기");
			System.out.print("▶ ");
		}
		else if(call == 1) {
			if(state.equals("전원켜짐")) {
				state = "전화중";
				System.out.println("전화가 와서 전화를 받았습니다.");
			}else {
				System.out.println("전화를 받을 수 없습니다.");
			}//if
		}else if(call == 2) {
			state = "전원켜짐";
			System.out.println("전화를 끊습니다.");
		}//if
		
	}//call()
	
	//메뉴 3번 음성
	public void voice(int voice) {
		if(voice == 0) {
			System.out.println("================================");
			System.out.println("1.음성수신 2.음성송신 3.전화끊기");
			System.out.print("▶ ");
		}else if(voice == 1) {
			System.out.println("나 : 여보세요?");
		}else if(voice == 2) {
			System.out.println("상대방 : 여보세요?");
		}else if(voice == 3) {
			call(2);
		}//if
	}//voice
	


	
	//getter&setter
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

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
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







}//class