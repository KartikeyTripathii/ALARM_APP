import java.time.LocalTime;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    AlarmClock(LocalTime alarmtime){
        this.alarmTime=alarmtime;
    }
    @Override
    public void run(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }
}
