
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
public class Main{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime=null;
        String filePath = "D:\\ALARM\\file_example_WAV_1MG.wav";
        while(alarmtime==null){
            try{
                System.out.print("enter an alarm time (HH:MM:SS): ");
                String inputTime=scanner.nextLine();
        
                alarmtime= LocalTime.parse(inputTime, dtf);
                System.out.println("alarm set for "+ alarmtime);
    
            }
            catch(DateTimeParseException e){
                System.out.println("invalid format");
            }

        }

        AlarmClock alarmclock= new AlarmClock(alarmtime, filePath, scanner);
        Thread alarmThread=new Thread(alarmclock);
        alarmThread.start();



        
    }


}