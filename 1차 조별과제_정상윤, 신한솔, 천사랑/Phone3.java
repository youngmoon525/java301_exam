public class Phone3 extends Phone2{
	protected int internet;
	protected int webtoon;
	
	public Phone3() {}
	
		public Phone3(String phonename, String color, String model, String state, int channel) {
			super(phonename, color, model, state, channel);
			this.phonename = phonename;
			this.color = color;
			this.model = model;
		}

	
		public void  Internet() {
			if(power == 1 && internet == 1) {
				System.out.println("인터넷을 켭니다");
			}else if(power != 1 && internet == 1 || internet == 2) {
				System.out.println("전원이 꺼져있어 인터넷 사용이 불가능 합니다");
				System.out.println("다시 입력하세요");
			}
		}
		
		public void Webtoon() {
			if(internet == 1 && webtoon == 1) {
				System.out.println("웹툰 앱을 켭니다");
			}else if(internet == 1 && webtoon == 2) {
				System.out.println("웹툰 앱을 끕니다");
			}else if(internet != 1 && webtoon == 1 || webtoon == 2) {
				System.out.println("전원이나 인터넷이 꺼져있어 웹툰앱을 킬 수 없습니다");
			}else {
				System.out.println("다시 입력하세요");
			}
		}
		
//		public int getInternet() {
//			return internet;
//		}
		
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

