package springidol.javaconf3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Encore;
import springidol.Instrumentalist;
import springidol.OneManBand;
import springidol.Performer;
import springidol.PoeticJuggler;
import springidol.SpringIdol;
import springidol.Singer;

@Configuration
public class SpringConf4 {
	@Autowired
	private PoeticJuggler duke;			// PoeticJuggler 타입 bean이 자동 주입됨
	
	@Autowired
	private Instrumentalist kenny;		// Instrumentalist bean이 자동 주입됨
	
	@Autowired
	private OneManBand hank;			// OneManBand 타입 bean이 자동 주입됨
	
	@Autowired @Qualifier("lena")
	private Singer lena;				// lena bean이 자동 주입됨
	
	@Autowired @Qualifier("suhyun")
	private Singer suhyun;				// suhyun bean이 자동 주입됨
	
	
	@Bean
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		Performer[] perf = new Performer[]{duke, kenny, hank, lena, suhyun};
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