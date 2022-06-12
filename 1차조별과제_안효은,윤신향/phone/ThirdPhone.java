package com.phone;

public class ThirdPhone extends SecondPhone {
	private int internet, webtoon;
	int web = 0;
	
	public ThirdPhone() {}
	
	public ThirdPhone(int generation, String color, String model, String state, String channel) {
		super(generation, color, model, state, channel);
	}

	//메소드
	@Override
	public void print() {
		super.print();
	}
	
	@Override
	public void call(int call) {
		if(call == 0) {
			System.out.println("=====================");
			System.out.println("1.전화승인 2.전화끊기");
			System.out.print("▶ ");
		}
		else if(call == 1) {
			if(getState().equals("전원켜짐")) {
				setState("전화중");
				System.out.println("전화가 와서 전화를 받았습니다.");
			}else if(getState().equals("인터넷사용")) {
				setState("전화중");
				System.out.println("전화가 와서 전화를 받았습니다.");
				web = 1;
			}else if(getState().equals("웹툰켜짐")) {
				setState("전화중");
				System.out.println("전화가 와서 전화를 받았습니다.");
				web = 2;
			}else {
				System.out.println("전화를 받을 수 없습니다.");
			}//if
		}else if(call == 2) {
			setState("전원켜짐");
			System.out.println("전화를 끊습니다.");
		}//if
	}
	
	@Override
	public void voice(int voice) {
		if(voice == 0) {
			System.out.println("================================");
			System.out.println("1.음성수신 2.음성송신 3.전화끊기");
			System.out.print("▶ ");
		}else if(voice == 1) {
			System.out.println("나 : 여보세요?");
		}else if(voice == 2) {
			if(internet == 1 && webtoon!=1) {
				System.out.println("상대방 : 뭐하세요?");
				System.out.println("나 : 인터넷 합니다.");
			}else if(webtoon == 1) {
				System.out.println("상대방 : 뭐하세요?");
				System.out.println("나 : 웹툰 봅니다.");
			}else  {
				System.out.println("상대방 : 여보세요?");				
			}//if
		}else if(voice == 3) {
			call(2);
		}//if
	}
	
	public void internet(int internet) {
		this.internet = internet;
		if(internet == 0) {
			System.out.println("=========================");
			System.out.println("1.인터넷켜기 2.인터넷끄기");
			System.out.print("▶ ");			
		}else if(internet == 1) {
			//setState("인터넷사용");
			if(web == 1 || web == 2) {
				System.out.println("이미 인터넷이 켜져있습니다!!");
			}else {
				web = 1;
				System.out.println("인터넷을 켭니다.");				
			}
		}else if(internet == 2) {
			if(web ==1) {
				if(getState().equals("전화중")) {
					System.out.println("인터넷을 끕니다.");
					web = 0;
				}else {
					setState("전원켜짐");
					System.out.println("인터넷을 끕니다.");
					web = 0;
				}//if		
			}else {
				System.out.println("인터넷이 켜져 있지 인터넷 종료 불가!");
			}//if
		}//if
	}//internet()
	
	public void webtoon(int webtoon) {
		this.webtoon = webtoon;
		if(webtoon == 0) {
			System.out.println("=====================");
			System.out.println("1.웹툰켜기 2.웹툰끄기");
			System.out.print("▶ ");
		}else if(webtoon == 1) {
			//setState("웹툰켜짐");
			if(web == 2) {
				System.out.println("이미 웹툰앱이 켜져있습니다.");
			}else {
				web = 2;
				System.out.println("웹툰 앱을 켭니다.");				
			}
		}else if(webtoon == 2) {
			//setState("인터넷사용");
			if(web == 2) {
				web = 0;
				System.out.println("웹툰 앱을 끕니다.");
			}else {
				System.out.println("웹툰앱이 켜져 있지 않아 종료 불가!");
			}//if		
		}//if
	}//if

	//getter&setter
	public int getInternet() {
		return internet;
	}

	public void setInternet(int internet) {
		this.internet = internet;
	}

	public int getWebtoon() {
		return webtoon;
	}

	public void setWebtoon(int webtoon) {
		this.webtoon = webtoon;
	}
		
}//class
