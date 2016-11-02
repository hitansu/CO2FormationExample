import java.util.Scanner;

/**
 * Driver program to produce CO2.
 * 
 * @author hitansu
 *
 */
public class CarbonDioxideDriver {
	public static final String COPYRIGHT = "Copyright (c) 2015  Pegasystems Inc.";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carbon cThread= new Carbon();
		Oxygen oThread= new Oxygen();
		CarbonDioxide co2Thread= new CarbonDioxide(cThread, oThread);
		co2Thread.startProduction();
		
		Scanner scanner = new Scanner(System.in);
		String command = scanner.next();
		if(command.equalsIgnoreCase("yes") || command.equalsIgnoreCase("y")) {
			co2Thread.stopThread();
		}
		scanner.close();

	}

}
