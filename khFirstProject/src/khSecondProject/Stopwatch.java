package khSecondProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Stopwatch {
	String timerBuffer;
	int flowedTime = 0;
	
//	int oldTime = (int)System.currentTimeMillis()/1000;
//	int secs = (int) System.currentTimeMillis() / 1000 - oldTime;
	
	public void measureFlowed() {
		flowedTime++;
	}
	
	public int getFlowedTime() {
		return flowedTime;
	}

	
	public String secToHHMMSS(int secs) {
        int hour, min, sec;

        sec  = secs % 60;
        min  = secs / 60 % 60;
        hour = secs / 3600;

        timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
        return timerBuffer;
    }
	
	public void timeover() {
		 Image img;
		 JFrame tempFrame = new JFrame();

	      Toolkit tk = Toolkit.getDefaultToolkit();
	      img = tk.getImage("img/timeovermid.gif");

	      JPanel background = new JPanel() {
	         public void paint(Graphics g) {
	            if (img == null)
	               return;

	            g.drawImage(img, 0, 0, tempFrame);
	            setOpaque(false);
	            super.paintComponent(g);
	         }

	      };
	      tempFrame.add(background);
	      JScrollPane scrollPane = new JScrollPane(background);
	      tempFrame.add(scrollPane);

	      tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      // 300 130
	      tempFrame.setLocation(300, 130);			
	      tempFrame.setSize(960, 600);

	      tempFrame.setLocationRelativeTo(null);
	      tempFrame.setResizable(false);
	      tempFrame.setAlwaysOnTop(true);
	      tempFrame.setVisible(true);

	   }
	
	
	
}
