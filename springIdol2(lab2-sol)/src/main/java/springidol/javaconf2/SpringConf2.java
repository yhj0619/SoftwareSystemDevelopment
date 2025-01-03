package springidol.javaconf2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Encore;
import springidol.Performer;
import springidol.SpringIdol;

@Configuration
public class SpringConf2 {
	@Autowired
	private SpringConf1 conf1;			// 다른 설정 클래스 SpringConf1 객체가 자동 주입됨
	
	@Bean
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		Performer[] perf = new Performer[]{conf1.duke(), conf1.instr(), conf1.hank(), conf1.lena(), conf1.suhyun()};
		si.setPerformers(perf);
		return si;		
	}
	
	@Bean
	public Encore encore() {
		Performer[] performers = springIdol().getPerformers();
		Performer encorePerformer = performers[(int)(Math.random()*performers.length)];
		Encore encore = new Encore();
		encore.setEncorePerformer(encorePerformer);	
		return encore;		
	}
}