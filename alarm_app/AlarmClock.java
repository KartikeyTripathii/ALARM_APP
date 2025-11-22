
import java.time.LocalTime;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    AlarmClock(LocalTime alarmtime){
        this.alarmTime=alarmtime;
    }
    @Override
    public void run(){
        while(LocalTime.now().isBefore(alarmTime)){
            try{
                Thread.sleep(1000);
                int hour=LocalTime.now().getHour();
                int min=LocalTime.now().getMinute();
                int sec=LocalTime.now().getSecond();
                System.out.println(hour+":"+min+":"+sec);
            }
            catch(InterruptedException e){
                System.out.println("Thread was intrrupted");

            }
        }
    }
}
