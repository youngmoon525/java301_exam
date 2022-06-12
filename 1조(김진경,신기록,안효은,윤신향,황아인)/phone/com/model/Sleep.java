package phone.com.model;

public class Sleep extends Thread{
	
	private String[] strs;
	
	public Sleep() {}

	public Sleep(String[] strs) {
		super();
		this.strs = strs;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}//class
