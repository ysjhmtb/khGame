package khFirstProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable task1 = () -> {
			TheRoom.playingMusic("St_Francis.mp3");
		};

		Runnable task2 = () -> {
			TheRoom tr = new TheRoom();
		};

		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.shutdown();

	}

}
