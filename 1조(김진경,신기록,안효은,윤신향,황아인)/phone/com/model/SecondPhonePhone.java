package phone.com.model;



public class SecondPhonePhone extends FirstPhonePhone{
	
	protected String dmb, channel;
	
	
	public SecondPhonePhone(int generation, String color, String model, String state, String channel) {
		super(generation, color, model, state);

		this.channel = channel;
		dmb = "꺼짐";
	}//

	
	
	
	@Override
	public void printInfor() {
		System.out.println();
		System.out.println("요정 : "+generation + "세대 폰 (색상 :" + color +", 모델명 : " + model +", 상태 :" + state +"채널 :" +channel+ ")가 지급되었습니다." );
		System.out.println();
	}




	public void dmbOn() {
		dmb = "켜짐";
		System.out.println("dmb방송을 시작합니다 ▶ " + "현재 채널 :" + channel);
		
	}//디엠피 켜
	public void dmbOff() {
		dmb = "켜짐";
		System.out.println("dmb방송이 종료되었습니다!");
		
	}//디엠피 꺼
	
	
	public void dmbCh() {
		dmb ="시청중";
		System.out.println("채널을 입력하세요 ▶");
		
	}//채널변경


 //getter setter

	public String getChannel() {
		return channel;
	}




	public void setChannel(String channel) {
		this.channel = channel;
	}




	public String getdmb() {
		return dmb;
	}




	public void setdmb(String dmb) {
		dmb = dmb;
	}
	
	
	
	
}//class
