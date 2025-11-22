
import java.time.LocalTime;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    final String filePath;
    private final Scanner scanner;
    AlarmClock(LocalTime alarmtime, String filePath, Scanner scanner){
        this.alarmTime=alarmtime;
        this.filePath=filePath;
        this.scanner=scanner;
    }
    
    @Override
    public void run(){
        while(LocalTime.now().isBefore(alarmTime)){
            try{
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d",
                                            now.getHour(),
                                            now.getMinute(),
                                            now.getSecond());

            }
            catch(InterruptedException e){
                System.out.println("Thread was intrrupted");

            }
        }
        System.out.println("*Alarm Noises*");
        playSound(filePath);
    }
    

    private void playSound(String filePath){
        File audiofile = new File(filePath);

        try(AudioInputStream audiostream= AudioSystem.getAudioInputStream(audiofile)) {
            Clip clip= AudioSystem.getClip();
            clip.open(audiostream);
            clip.start();
            System.out.println("press *Enter* to stop the alarm");
            scanner.nextLine();
            clip.stop();


            scanner.close();
        } 
        catch (UnsupportedAudioFileException e) {
            System.out.println("audio file system is not supported");
        }
        catch(LineUnavailableException e){
            System.err.println("other program is using the file");
        }
        catch(IOException e){
            System.err.println("something went wrong");
        }
    }
}
