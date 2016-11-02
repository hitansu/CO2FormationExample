import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Thread that produces Carbon atom
 * 
 * @author hitansu
 *
 */
public class Carbon extends Thread {
	
	public static final String COPYRIGHT = "Copyright (c) 2015  Pegasystems Inc.";
	
	BlockingQueue<Character> blockingQueue= null;
	
	private static final Character CARBON_ATOM= 'C';
	
	private final long INTERVAL= 10;
	
	private boolean isRunning= false;
		
	public Carbon() {
		this.blockingQueue= new LinkedBlockingQueue<Character>(1024);
		isRunning= true;
	}

	@Override
	public void run() {
		while(isRunning) {
			super.run();
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sleep();
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(INTERVAL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private  void produce() throws InterruptedException {
    	  blockingQueue.put(new Character(CARBON_ATOM));
	}

	public  Character get() throws InterruptedException {
		return blockingQueue.take();
	}
	
	public synchronized void stopThread() {
		this.isRunning= false;
	}

}
