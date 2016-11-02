import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Thread that produces Oxygen atom
 * 
 * @author hitansu
 *
 */
public class Oxygen extends Thread {
	
	public static final String COPYRIGHT = "Copyright (c) 2015  Pegasystems Inc.";
	
	BlockingQueue<Character> blockingQueue= null;
	
	private static final Character OXYGEN_ATOM= 'O';
	
	private final long INTERVAL= 10;
	
	private boolean isRunning= false;
		
	public Oxygen() {
		this.blockingQueue= new LinkedBlockingQueue<Character>(1024);
		this.isRunning= true;
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

	private synchronized void produce() throws InterruptedException {
    	blockingQueue.put(new Character(OXYGEN_ATOM));
	}
	
	public  Character get() throws InterruptedException {
		return blockingQueue.take();
	}

	public void stopThread() {
		this.isRunning= false;
	}
}
