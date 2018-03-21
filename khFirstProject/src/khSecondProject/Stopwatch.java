package khSecondProject;

public class Stopwatch {
	String timerBuffer;
//	int oldTime = (int)System.currentTimeMillis()/1000;
//	int secs = (int) System.currentTimeMillis() / 1000 - oldTime;
	
	public String secToHHMMSS(int secs) {
        int hour, min, sec;

        sec  = secs % 60;
        min  = secs / 60 % 60;
        hour = secs / 3600;

        timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
        return timerBuffer;
    }
	

	public static void main(String[] args){
		Stopwatch sw = new Stopwatch();
		int sec = 600;
		while(sec>0){
			System.out.println(sw.secToHHMMSS(sec));
			sec--;
		}
		
	}

}
