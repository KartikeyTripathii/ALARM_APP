import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;;
public class Main{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime;
        try{
            System.out.print("enter an alarm time (HH:MM:SS): ");
            String inputTime=scanner.nextLine();
    
            alarmtime= LocalTime.parse(inputTime, dtf);
            System.out.println("alarm set for "+ alarmtime);

        }
        catch(DateTimeParseException e){
            System.out.println("invalid format");
        }




        scanner.close();
    }
}