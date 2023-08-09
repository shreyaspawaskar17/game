package p1;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class StartStopTimer {
	//Class members
	 Timer timer; 
	 int min ,sec;    
	 int pausedmin;
	 int pausedsec;
	 boolean isPaused;
	 JLabel timedisplayer = new JLabel();
	//The constructor
	public StartStopTimer()  
	{  
//		min = 0;
//		sec = 30;
		timer = new Timer(true); 
		isPaused = false;
	} 
	
	//class methods
	public void startRinging()   
	{ 
		timer.scheduleAtFixedRate(
			new TimerTask() {
			 @Override
			 public void run() {
				 
				 if(!isPaused){
//				 System.out.println(min + ":" + sec);
				 timedisplayer.setText("Time Remaining : " + min + ":" + sec);

				 sec--;					
				 if(sec == -1) {
					 min --;
					 sec = 59;
				 }
			 }
				 
			 }

			
		}, 0, 1000);  
	}
	
	public void pauseTimer() {
		if(!isPaused) {
			pausedmin = min;
			pausedsec = sec;
			isPaused = true;
			System.out.println("Timer is paused");
		}
	}
	
	public void resumeTimer() {
		if(isPaused) {
			min = pausedmin;
			sec = pausedsec;
			isPaused = false;
			System.out.println("Timer is resumed");
		}
	}
	
	
}
