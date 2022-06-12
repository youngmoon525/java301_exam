
public class SuperPhone {
	public static void main(String[] args) {
		
		FirstPhone first = new FirstPhone("까망", "sky", "종료");
		first.powerOn();
		first.powerOff();
		first.answerCall();
		first.hangUp();
		first.voiceSend();
		first.powerOn();
		first.answerCall();
		first.voiceSend();
		first.voiceReceive();
		first.hangUp();
		System.out.println();
		
		System.out.println("===================================================================");
		FirstPhone second = new SecondPhone("검정", "LG", "종료", "정보없음");
	      ((SecondPhone)second).dmbOn();
	      second.powerOn();
	      ((SecondPhone)second).dmbOn();
	      ((SecondPhone)second).dmbCh("10");
	      ((SecondPhone)second).dmbOff();
	    System.out.println();
		System.out.println();
		System.out.println("===================================================================");
		System.out.println();
		FirstPhone third = new ThirdPhone("새빨강", "iPhone", "종료", "정보없음");
		((ThirdPhone)third).dmbOn();
		third.powerOn();
		  ((ThirdPhone)third).answerCall();
		  ((ThirdPhone)third).voiceSend();
	      ((ThirdPhone)third).webOn();
	      ((ThirdPhone)third).webtoonOn();
	      ((ThirdPhone)third).voiceReceive();
	      ((ThirdPhone)third).voiceSend();
	      ((ThirdPhone)third).hangUp();
	      
			
	}//main()
	
	
}//class
