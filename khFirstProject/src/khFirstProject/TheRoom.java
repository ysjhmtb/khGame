package khFirstProject;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class TheRoom {
	
	int rightAnswer = 0;
	JFrame frame;
	Image imageIcon;
	JLabel label;
	JToggleButton btn1;
	JToggleButton btn2;
	JToggleButton btn3;
	
	
	public TheRoom(){
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
		btn1 = new JToggleButton(new ImageIcon("CLASH ROYALE ROCKET.jpg"));
		btn1.setBounds(500, 500, 100, 70);
		
		// 오른쪽 의자 위 855 430 100 70
		btn2 = new JToggleButton(new ImageIcon("CLASH ROYALE ROCKET.jpg"));
		btn2.setBounds(855, 430, 100, 70);
		
		// 책꽂이	545 230 100 70
		btn3 = new JToggleButton(new ImageIcon("CLASH ROYALE ROCKET.jpg"));
		btn3.setBounds(545, 230, 100, 70);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				String firstMessage = JOptionPane.showInputDialog("One");
				
				if(firstMessage.equals("1")) {
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
				
				if(secondMessage.equals("2")) {
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
				
				if(thirdMessage.equals("3")) {
					System.out.println(thirdMessage);
					setRightAnswer();
					checked();
				}
				
				
				
				
			}
			
		});
		

		
		frame.setVisible(true);
		
		
	}
	
	
	public void checked() {
		if(this.rightAnswer>2) {
			JOptionPane.showMessageDialog(frame, "확인 메세지 출력");
		}
	}


	public int getRightAnswer() {
		return rightAnswer;
	}


	public void setRightAnswer() {
		this.rightAnswer += 1;
	}
	
	

	
	
	
	
	

}


/*
 1280 800
 

우리 조 미니 프로젝트에 대해서 정리합니다
[게임시작☞인트로☞이름 입력받음]
까지의 구성은 그대로예요

이 다음의 게임 진행방식이 바뀌었습니다

기존의 진행방식이

방 진입
이곳에서 여러 이벤트(문제) 발생
☞ 각 문제에서 번호 취합하기
☞ 암호입력
☞ 탈출 혹은 복귀

였었다면



변경된 방식은

-방 5개를 연달아 탈출해야함
🍀팀원들 모두 방 1개씩 맡아서 이벤트(문제) 발생시키기
☞즉 팀원마다 패키지 1개씩 만듭니다.
☞ 이벤트가 발생하는 공간은 꼭 방이 아니어도 됩니다.. 복도... 신발장.. 부엌..다락방..


👏👏조건도 있어요~
🍀 이벤트 개수는 2개(+a)
🍀 bgm 출력
🍀 실행용 클래스와 기능제공용 클래스 구분합니다.
😲실행용 클래스(Run)에는 메소드 쓰지말기*


참고)
* 방 구현에 참고할만한 소스
여기에서 이벤트 버튼 추가하고 출력시키면 끝이라고는 하는데요..!
http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140173265821

* 웹 포토샵 : 좌표값 등 이미지 편집 유용!
https://pixlr.com/editor/

* 카카오 오븐 : UI 구상에 좋습니다. 회원가입하면 사용가능합니다



👇👇👇👇👇👇👇👇👇👇👇
팀 과제
일요일(18일)까지 각자 방 1개씩 구현해오기
👆👆👆👆👆👆👆👆👆👆👆


그런데 당장 해야할 일이 있어요😂
🙏목요일(15일) 학원 테스트(필기/실기)
🙏금요일(16일) 컬렉션 실습문제 과제


예.. 틈틈히 새로 배운 내용 공부도 해야하고 과제도 해야하고 알바도 해야하고..
실질적으로는 금요일 저녁부터 주말 내내 구현을 하셔야하는데
사실 시간이 너무 촉박합니다.


따라서
🍀일요일까지 구현을 다 못하더라도 여러분이 하고자하는 이벤트에 대해서는 확정을 해주세요

☞ PPT/UML 다이어그램에 반영시킬 예정입니다.
☞ 28일 최종발표날에는 우리 모두 발표해요^^!
각자 만든 기능 위주로 직접 소개하면 됩니다.
 

🍀그래서 각자 과제는
🍀다음주 수요일(21일)까지🍀해오도록 하고자 하는데
총무님 괜찮으신가요?


👏👏 패키지 모아서 다듬는 것은 총무님이 해주시기로 했습니다 👏👏



27일 화요일에는 우리반 모두 테스터가 되어서 각 조의 프로젝트를 테스트해보는 시간이 있다고 하구요

28일에는 최종 발표입니다.

실질적으로는 2주도 채 남지 않으니
다음주부터는 다들 밤새서 구현과 발표 연습에 매진해봐요....


🍀
그리고 다음주부터 1-2시간씩 일찍 와서
회의+스터디하는 것 어떠세요

플레이어 정보 출력창/인벤토리 디자인이나 소스가 어떻게 들어갈지 아직 미정이어서요



*/