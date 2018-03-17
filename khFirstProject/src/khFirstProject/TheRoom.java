package khFirstProject;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import javazoom.jl.player.Player;

public class TheRoom  {

	int rightAnswer = 0;
	JFrame frame;
	Image imageIcon;
	JLabel label;
	JToggleButton btn1;
	JToggleButton btn2;
	JToggleButton btn3;

	ImageIcon bim1;
	ImageIcon bim2;
	ImageIcon bim3;

	public TheRoom() {

		frame = new JFrame("THE ROOM");
		frame.setBounds(200, 200, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		imageIcon = new ImageIcon("theroom.jpg").getImage().getScaledInstance(1280, 800, 0);
		label = new JLabel(new ImageIcon("theroom.jpg"));
		label.setLocation(0, 0);
		label.setSize(1280, 800);
		frame.add(label, "Center");
		
		

		// 테이블 위 500 500 100 70
		bim1 = new ImageIcon("btn1.png");
		btn1 = new JToggleButton(bim1);
		btn1.setBounds(500, 500, 100, 70);

		// 오른쪽 의자 위 855 430 100 70
		bim2 = new ImageIcon("btn2.png");
		btn2 = new JToggleButton(bim2);
		btn2.setBounds(855, 430, 100, 70);

		// 책꽂이 545 230 100 70
		bim3 = new ImageIcon("btn3.png");
		btn3 = new JToggleButton(bim3);
		btn3.setBounds(545, 230, 100, 70);
		
		MouseProcess mp = new MouseProcess();
		
		btn1.addMouseListener(mp);
		btn1.addMouseMotionListener(mp);
		btn2.addMouseListener(mp);
		btn2.addMouseMotionListener(mp);
		btn3.addMouseListener(mp);
		btn3.addMouseMotionListener(mp);

		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String firstMessage = JOptionPane.showInputDialog("One");

				if (firstMessage.equals("1")) {
					System.out.println(firstMessage);
					setRightAnswer();
					checked();
				}

			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String secondMessage = JOptionPane.showInputDialog("Two");

				if (secondMessage.equals("2")) {
					System.out.println(secondMessage);
					setRightAnswer();
					checked();
				}

			}

		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String thirdMessage = JOptionPane.showInputDialog("Three");

				if (thirdMessage.equals("3")) {
					System.out.println(thirdMessage);
					setRightAnswer();
					checked();
				}

			}

		});

		frame.setVisible(true);

	}

	public void checked() {
		if (this.rightAnswer > 2) {
			JOptionPane.showMessageDialog(frame, "확인 메세지 출력");
		}
	}

	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer() {
		this.rightAnswer += 1;
	}

	public static void playingMusic(String file) {

		try {
			String path = file;
			Player p = new Player(new FileInputStream(path));
			p.play();
			p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}

/*
 * setBorderPainted(false); // 버튼의 테두리 안 보이게 함 setFocusPainted(false); // 버튼에
 * 마우스를 눌렀을 때 테두리 안 보이게 함 setContentAreaFilled(false); // 버튼의 여백 안 보이게 함
 */


class MouseProcess implements MouseListener, MouseMotionListener{

	@Override
	public void mouseDragged(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
	
		
		// TODO Auto-generated method stub
		// 테이블 위 500 500 100 70
		// 오른쪽 의자 위 855 430 100 70
		// 책꽂이 545 230 100 70
		System.out.println("hovering");
			

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
