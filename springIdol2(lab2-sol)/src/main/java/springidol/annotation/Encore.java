package springidol.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Encore {
	private Performer performer;

	@Value("#{springIdol.performers[T(java.lang.Math).random()*springIdol.performers.length]}")
	public void setPerformer(Performer p) {
		this.performer = p;
	}

	public void execute() {
		System.out.println("Encore Performance");
		performer.perform();
	}
}
