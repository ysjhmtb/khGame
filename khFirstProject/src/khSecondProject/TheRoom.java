package khSecondProject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class TheRoom extends JFrame {
	
	int rightAnswer = 0;
	
	JScrollPane scrollPane;
	// textarea 배경
	Image textboxBg = new ImageIcon("img/blur.png").getImage();
	// 이야기 진행 textarea : 클릭시 string 배열 출력.
		JTextArea storyConsol = new JTextArea() {
			public void paintComponent(Graphics g) {
				Dimension sizing = getSize();
				g.drawImage(textboxBg, 0, 0, (int)sizing.getWidth(), (int)sizing.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
	};
	
	
	String startStr = "어서 나가야 해.... ";
	String secondStr = "테이블 위에 무언가가 있다!";
	
	// 클릭할 때마다 카운트 : 한 줄씩 출력
	int clickCnt = 0;
	// 스위치 클릭시 이벤트
	int switchClick = 0;
	// 마우스
	Image mouseImg;
	Cursor mouse;
	
	public TheRoom() {
		// 마우스 커서
		Toolkit tk = Toolkit.getDefaultToolkit();
		mouseImg = new ImageIcon("img/cursor.png").getImage();
		Point point = new Point(0, 0);
		mouse = tk.createCustomCursor(mouseImg, point, "wonder");
		setCursor(mouse);
		
		Image bgImg = new ImageIcon("img/theroom.jpg").getImage();
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension sizing = getSize();
				g.drawImage(bgImg, 0, 0, (int)sizing.getWidth(), (int)sizing.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		
		// 배경음악, 반복재생
		LibraryBGM("bgm/St_Francis.wav");
		
		// 패널 레이아웃 설정
		background.setLayout(null);
		
		// 텍스트 에어리어 이벤트 : 스위치 버튼 클릭 유도
		storyConsol.setBounds(280, 585, 742, 232);
		TextAction textClick = new TextAction();
		storyConsol.addMouseListener(textClick);
		storyConsol.setEditable(false);
		// 폰트 설정
		Font commonFont = new Font("맑은 고딕", Font.BOLD, 30);
		storyConsol.setForeground(Color.white);
		storyConsol.setFont(commonFont);
		storyConsol.setOpaque(true);
				
		storyConsol.setText(startStr);
		background.add(storyConsol);
		
		
		// 테이블 위 500 500 100 70
		ImageIcon blackSwitch = new ImageIcon("img/btn1.png");
		JButton switchBtn = new JButton(blackSwitch);
		switchBtn.setBounds(500, 500, blackSwitch.getIconWidth(), blackSwitch.getIconHeight());
		switchBtn.setBorderPainted(false);
		// 스위치버튼 클릭 이벤트
		switchBtn.addMouseListener(new SwitchAction());
		
		switchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tableMessage = JOptionPane.showInputDialog("1 1 2 ( ) 5 8");

				if (tableMessage.equals("3")) {
					System.out.println("checked");
					setRightAnswer();
					checked();
				}
			}
			
		});
		
		// 버튼 프레임에 추가
		background.add(switchBtn);
		
		
		
		// 책꽂이 545 230 100 70
		ImageIcon bookcase = new ImageIcon("img/btn3.png");
		JButton bookcaseBtn = new JButton(bookcase);
		bookcaseBtn.setBounds(545, 230, bookcase.getIconWidth(), bookcase.getIconHeight());
		bookcaseBtn.setBorderPainted(false);
		bookcaseBtn.addMouseListener(new SwitchAction());
		bookcaseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bookcaseMessage = JOptionPane.showInputDialog("경기에서 한 주자가 2위에 있는 사람을 제쳤다. 이 주자는 이제 몇 위일까?");
				if(bookcaseMessage.equals("2")) {
					System.out.println("checked");
					setRightAnswer();
					checked();
				}
			}
			
		});
		
		background.add(bookcaseBtn);
		
		
		
	}
	
	
	class TextAction implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			clickCnt++;
			switch(clickCnt) {
			case 1 :
				storyConsol.setText(secondStr);
				break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	
	// 스위치 클릭시 마우스 이벤트
	class SwitchAction implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// 버튼 마우스 오프 : 커서 원래대로 돌아오기
			Toolkit tk = Toolkit.getDefaultToolkit();
			mouseImg = new ImageIcon("img/cursor.png").getImage();
			Point point = new Point(0, 0);
			mouse = tk.createCustomCursor(mouseImg, point, "wonder");
			setCursor(mouse);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// 버튼 마우스 온 : 커서 변경
			Toolkit tk = Toolkit.getDefaultToolkit();
			mouseImg = new ImageIcon("img/checked.png").getImage();
			Point point = new Point(20, 20);
			mouse = tk.createCustomCursor(mouseImg, point, "find");
			setCursor(mouse);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
	
	
	public static void  LibraryBGM(String file) {
		try {
			AudioInputStream ais =
					AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void checked() {
		if (this.rightAnswer > 1) {
			JOptionPane.showMessageDialog(this, "이제 이동할 수 있습니다.");
		}
	}

	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer() {
		this.rightAnswer += 1;
	}
	
		

}
