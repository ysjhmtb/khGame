package khSecondProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheRoom start = new TheRoom();
		
		Runnable task1 = ()->{
			
			start.setTitle("서재");
			start.setLocation(300, 130);
			start.setSize(1280, 800);
			start.setResizable(false);
			start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			start.setIconImage(new ImageIcon("img/favicon.jpg").getImage());
			start.setVisible(true);
		};
		
		Runnable task2 = ()->{
			start.flowtime(start.timeBox, 600);
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.shutdown();
		
		

	}

}
