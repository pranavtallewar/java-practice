import java.util.Timer;
import java.util.TimerTask;

public class IndThread {
	public static void main(String[] args) {
		Counter c = new Counter();
		c.startTimer();
	}

}

class Counter {
	boolean flag = false;
	
	static int time = 10;
	final Timer timer = new Timer();
	void stopTimer() {
		timer.cancel();
	}
	void startTimer(){
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = time;

			public void run() {
				System.out.println(i--);
				if (i < 0)
					timer.cancel();
			}
		}, 0, 1000);
	}
}
