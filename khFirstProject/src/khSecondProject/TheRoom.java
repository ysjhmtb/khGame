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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TheRoom extends JFrame {
	

	
	// time
	public JTextArea timeBox = new JTextArea();
	Font commonFont = new Font("맑은 고딕", Font.BOLD, 15);
	
	// hint frame
	JFrame hintframe;
	// hint label
	JLabel hintlabel;
	Image hintimg;

	
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
		
		try{
			introFrame();
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
		
		// 시계
		timeBox.setBounds(0,0,70,20);
		timeBox.setFont(commonFont);
		background.add(timeBox);
		
		
		
		
		
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
				
				
				JFrame tqframe = new JFrame();
				tqframe.setTitle("RUNE");
				tqframe.setBounds(10,10,900,604);
				tqframe.setResizable(false);
				JLabel runelabel = new JLabel();
				Image runeimg = new ImageIcon("img/runequiz.jpg").getImage();
				runelabel.setIcon(new ImageIcon(runeimg));
				runelabel.setLocation(0,0);
				tqframe.add(runelabel);
				tqframe.setVisible(true);

				String tableMessage = JOptionPane.showInputDialog("그림 속에 있는 ?에 들어갈 숫자는?");
				if(!(tableMessage.isEmpty())){
					tqframe.setVisible(false);
				}
				
				if (tableMessage.equals("13")) {
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
				
				
				
				JFrame montyhallFrame = new JFrame();
				Image montyhallImg = new ImageIcon("img/dicewall.jpg").getImage();
				JPanel montyhallPanel = new JPanel() {
							public void paintComponent(Graphics g) {
								Dimension sizing = getSize();
								g.drawImage(montyhallImg, 0, 0, (int)sizing.getWidth(), (int)sizing.getHeight(), null);
								setOpaque(false);
								super.paintComponent(g);
							}
						};

				
//				montyhallFrame.setContentPane(montyhallScroll);
				montyhallPanel.setLayout(null);
//				montyhallFrame.setLayout(null);

				

				
				montyhallFrame.setTitle("세 개의 문중 염소가 들어있을  하나를 선택하시오.");
				montyhallFrame.setLocation(300,130);
				montyhallFrame.setSize(1200,750);
				montyhallFrame.setResizable(false);
//				montyhallFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				montyhallFrame.setIconImage(new ImageIcon("img/favicon.jpg").getImage());
				
				
				// 문 세개의 변수
				JButton door1Btn=null;
				JButton door2Btn=null;
				JButton door3Btn=null;
				
				// 100 350 500 350 950 350
				
				JLabel door1Label = new JLabel();
				JLabel door2Label = new JLabel();
				JLabel door3Label = new JLabel();
				ImageIcon doorIcon = new ImageIcon("img/closeddoor.jpg");
				Image closedDoorImg = new ImageIcon("img/closeddoor.jpg").getImage();
				door1Label.setIcon(new ImageIcon(closedDoorImg));
				door2Label.setIcon(new ImageIcon(closedDoorImg));
				door3Label.setIcon(new ImageIcon(closedDoorImg));
				
				door1Label.setBounds(100, 350, doorIcon.getIconWidth(), doorIcon.getIconHeight());
				door2Label.setBounds(500, 350, doorIcon.getIconWidth(), doorIcon.getIconHeight());
				door3Label.setBounds(870, 350, doorIcon.getIconWidth(), doorIcon.getIconHeight());
				
				montyhallPanel.add(door1Label);
				montyhallPanel.add(door2Label);
				montyhallPanel.add(door3Label);
				
				
				
				// 1번 문 버튼
				ImageIcon door1Icon = new ImageIcon("img/closeddoor.jpg");
				door1Btn = new JButton("1번 문");
				door1Btn.setBounds(150,650,80,20);
				door1Btn.setBorderPainted(false);
				door1Btn.setOpaque(false);
				
				door1Btn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						door2Label.setIcon(new ImageIcon("img/openeddoor.jpg"));		
						String door1answer = JOptionPane.showInputDialog("2번 문 뒤에 염소가 없습니다. 문의 선택을 바꾸는게 유리할까요? Y/N");
						if(door1answer.equals("Y")){
							setRightAnswer();
							checked();	
							montyhallFrame.setVisible(false);
						}
								
						
					}
					
				});
				
				// 2번 문 버튼
				ImageIcon door2Icon = new ImageIcon("img/closeddoor.jpg");
				door2Btn = new JButton("2번 문");
				door2Btn.setBounds(550,650,80,20);
				door2Btn.setBorderPainted(false);
				door2Btn.setOpaque(false);
				
				door2Btn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						door3Label.setIcon(new ImageIcon("img/openeddoor.jpg"));	
						String door2answer = JOptionPane.showInputDialog("3번 문 뒤에 염소가 없습니다. 문의 선택을 바꾸는게 유리할까요? Y/N");
						if(door2answer.equals("Y")){
							setRightAnswer();
							checked();		
							montyhallFrame.setVisible(false);
						}
								
						
					}
					
				});
				
				// 3번 문 버튼
				ImageIcon door3Icon = new ImageIcon("img/closeddoor.jpg");
				door3Btn = new JButton("3번 문");
				door3Btn.setBounds(950,650,80,20);
				door3Btn.setBorderPainted(false);
				door3Btn.setOpaque(false);
				
				door3Btn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						door1Label.setIcon(new ImageIcon("img/openeddoor.jpg"));	
						String door3answer = JOptionPane.showInputDialog("1번 문 뒤에 염소가 없습니다. 문의 선택을 바꾸는게 유리할까요? Y/N");
						if(door3answer.equals("Y")){
							setRightAnswer();
							checked();		
							montyhallFrame.setVisible(false);
						}
						
						
								
						
					}
					
				});
			
				montyhallPanel.add(door1Btn);
				montyhallPanel.add(door2Btn);
				montyhallPanel.add(door3Btn);
				montyhallFrame.add(montyhallPanel, "Center");
				montyhallFrame.setVisible(true);



				
//				String bookcaseMessage = JOptionPane.showInputDialog("검어졌다, 붉어졌다, 희어지는것은?");
//				if(bookcaseMessage.equals("숯")) { 
//					System.out.println("checked");
//					setRightAnswer();
//					checked();
//				
//				}
				
				
			}
			
		});
		
		background.add(bookcaseBtn);
		
		
		// hint 
		ImageIcon hint = new ImageIcon("img/hint.png");
		JButton hintBtn = new JButton(hint);
		hintBtn.setBounds(1100, 100, hint.getIconWidth(), hint.getIconHeight());
		hintBtn.setBorderPainted(false);
		hintBtn.setContentAreaFilled(false);
		hintBtn.setFocusPainted(false);
		hintBtn.setOpaque(false);
		hintBtn.addMouseListener(new SwitchAction());
		hintBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JButton btn1inhint = new JButton("TABLE");
				btn1inhint.setBounds(45, 130, 80, 35);
				btn1inhint.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, "13 21 34 55 89 ");
					}
					
				});
				
				JButton btn2inhint = new JButton("BOOK");
				btn2inhint.setBounds(230, 130, 80, 35);
				btn2inhint.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, "기댓값을 생각해 보세요 ");
					}
					
				});
		
				
				hintframe = new JFrame();
				hintframe.setTitle("Hint");
		
				hintframe.setBounds(1050,210,350,221);
				hintframe.setResizable(false);
//				hintframe.setUndecorated(true);

				hintlabel = new JLabel();
				hintimg = new ImageIcon("img/fibonacci_hint.jpg").getImage();
				hintlabel.setIcon(new ImageIcon(hintimg));
				hintlabel.setLocation(0,0);
				hintframe.add(hintlabel);
				
				hintlabel.add(btn1inhint);
				hintlabel.add(btn2inhint);

				hintframe.setVisible(true);
				
				
				

				
			}
		});
		
		background.add(hintBtn);
			
		
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
	
	public void flowtime(JTextArea timeBox, int sec){
		Stopwatch sw = new Stopwatch();
		for(int i=sec;i>=0;i--){
			
			
			try {
				timeBox.setText(sw.secToHHMMSS(i));
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			if(i==1){
				try{
					System.out.println("test");
//					setVisible(false);
					sw.timeover();
					Thread.sleep(10000);					
					System.out.println("test");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public void introFrame() {
	      Image img;

	      Toolkit tk = Toolkit.getDefaultToolkit();
	      img = tk.getImage("img/rendering.gif");

	      JPanel background = new JPanel() {
	         public void paint(Graphics g) {
	            if (img == null)
	               return;

	            g.drawImage(img, 0, 0, this);
	            setOpaque(false);
	            super.paintComponent(g);
	         }

	      };
	      this.add(background);
	      scrollPane = new JScrollPane(background);
	      this.add(scrollPane);

	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setLocation(300, 130);
	      this.setSize(1280, 800);

	      this.setLocationRelativeTo(null);
	      this.setResizable(false);
	      this.setVisible(true);

	   }		
	
	
	


}
