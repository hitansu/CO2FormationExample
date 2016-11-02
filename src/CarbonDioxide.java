/**
 * Class that takes 1 carbon & 2 oxygen to form CO2
 * 
 * @author hitansu
 *
 */

public class CarbonDioxide extends Thread {
	
	public static final String COPYRIGHT = "Copyright (c) 2015  Pegasystems Inc.";
	
	private final long INTERVAL= 30;
	
	private boolean isRunning= false;
	
	private final Carbon cThread;
	private final Oxygen oThread;
	
	public CarbonDioxide(Carbon cThread, Oxygen oThread) {
		this.cThread= cThread;
		this.oThread= oThread;
		this.isRunning= true;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			super.run();
			formCO2();
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

	private void formCO2() {
	   try {
		   System.out.println("Forming CO2");
		   // first get the 'C' atom. If not there it will block here
			Character carbon= cThread.get();
			System.out.println("got C ");
			// Then get the 'O2' atom. If not there it will block here
			Character oxygen_1= oThread.get();
			System.out.println("got O 1");
			Character oxygen_2= oThread.get();
			System.out.println("got O 2");
			
			if(carbon!= null || oxygen_1!= null || oxygen_2!= null) {
				System.out.println("CO2 formed");
			} else {
				System.out.println("CO2 not formed");
			}
	   } catch(InterruptedException e) {
		   e.printStackTrace();
		   System.out.println("getting exception");
	   }
		
	}

	public void startProduction() {
		cThread.start();
		oThread.start();
		this.start();
		
	}

	public void stopThread() {
		isRunning= false;
		cThread.stopThread();
		oThread.stopThread();
	}

}
