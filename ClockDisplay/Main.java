import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This is the class that execute main method
 * it scans inputs from the user
 *
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Main {
    public static void main(String[]args) throws InterruptedException {
        //Scan inputs  ==>>
	clearScreen();
        System.out.println("Please enter the start time: (in format hh:mm:ss) ");
	String inputTime=new Scanner(System.in).next();
        int hour=Integer.parseInt(""+inputTime.charAt(0)+inputTime.charAt(1));
        int minute=Integer.parseInt(""+inputTime.charAt(3)+inputTime.charAt(4));
        int second=Integer.parseInt(""+inputTime.charAt(6)+inputTime.charAt(7));

        //Send start time Information to ClockDisplay class
        ClockDisplay clock=new ClockDisplay(hour,minute,second);
        while(true){
            clearScreen();
	    System.out.println(clock.showDisplay());
            TimeUnit.SECONDS.sleep(1);
        }

    }
    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
    }
}
