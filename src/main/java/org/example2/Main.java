package org.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);

/* Variant 1, good: all beans from context */
		MusicPlayer musicPlayer = context.getBean("myplayer", MusicPlayer.class);

/* Variant 2, worse: only 1 bean is from context */
		Music music2 = context.getBean("mymusic", ClassicalMusic.class);
		MusicPlayer musicPlayer2 = new MusicPlayer(music2);

/* Variant 3, the worst: no beans - no soup */
		Music music3 = new ClassicalMusic();
		MusicPlayer musicPlayer3 = new MusicPlayer(music3);

/* Start the music */
		musicPlayer.playMusic();
		musicPlayer2.playMusic();
		musicPlayer3.playMusic();

		context.close();
	}
}
