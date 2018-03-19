package khSecondProject;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheRoom start = new TheRoom();
		start.setTitle("서재");
		start.setLocation(300, 130);
		start.setSize(1280, 800);
		start.setResizable(false);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setIconImage(new ImageIcon("img/favicon.jpg").getImage());
		start.setVisible(true);

	}

}
