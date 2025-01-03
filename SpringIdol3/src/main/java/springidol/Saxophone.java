package springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {
	@Value("${saxophone.sound}")	// 외부 설정 property 값 주입
	String sound;
	
	public Saxophone() {
	}

	public void play() {
		// System.out.println("TOOT TOOT TOOT");
		System.out.println(sound);
	}
}
