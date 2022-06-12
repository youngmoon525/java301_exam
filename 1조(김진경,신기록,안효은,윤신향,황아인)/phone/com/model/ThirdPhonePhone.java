package phone.com.model;

public class ThirdPhonePhone extends SecondPhonePhone{

	private String web , webtoon;
	
	
	public ThirdPhonePhone(int generation, String color, String model, String state, String channal) {
		super(generation, color, model, state, channal);
		web = "인터넷꺼짐";
		webtoon = "웹툰꺼짐";
		
	}
	
	
	public void printInfor() {
		System.out.println();
		System.out.println("요정 : "+ generation + "세대 폰 (색상 :" + color +", 모델명 : " + model +", 상태 :" + state + " 채널 : "+channel+")가 지급되었습니다." );
		System.out.println();
	}//printInfor

	
	
	public void webOn() {
		web = "인터넷켜짐";
		System.out.println("요정 : 인터넷을 킵니다!");
		
	}//인터넷 켜기
	
	
//	@Override
//	public void voicSend() {
//		
//		if(webtoon !="웹툰꺼짐" || web != "인터넷꺼짐") {
//			System.out.println("나 : 웹툰봐요!");
//		}//if
//	}//voiceSend 오버라이드


	@Override
	public void voicSend() {
		 if (state == "전화중") {
			 System.out.println("나 : 여보세요!");
		 }else if(webtoon.equals("웹툰켜짐")) {
			System.out.println("나 : 넵, 웹툰봐요!");
			state = "전화중";
		}else if(state =="대화중") {
			System.out.println("나: 넵! 배구 봐요!");
			state = "전화중";
		}//if
		
	}//voiceSend


	@Override
	public void voiceReceive() {	
		if(state =="전화중") {
			System.out.println("김연경 : 뭐해??");
		state ="대화중";
		}
		
//		}else if(webtoon == "웹툰켜짐" ){
//			System.out.println("김연경 : 뭐해? 만화?");
//		}
	}//voiceRecive


	public void webOff() {
		web = "인터넷꺼짐";
		System.out.println("요정 : 인터넷을 끕니다!");
	}//인터넷 끄기
	
	public void webtoonOn() {
		web = "인터넷켜짐";
		webtoon = "웹툰켜짐";
		System.out.println("요정 : 웹툰을 켭니다!");
		
	}//웹툰 켜기
	
	public void webtoonOff() {
		webtoon = "웹툰꺼짐";
		System.out.println("요정 : 웹툰을 끕니다!");
	}//웹툰 끄기
	
	
	//getter setter

	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	public String getWebtoon() {
		return webtoon;
	}


	public void setWebtoon(String webtoon) {
		this.webtoon = webtoon;
	}

	
	
	
}//class
