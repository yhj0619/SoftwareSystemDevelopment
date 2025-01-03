package springidol;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
// @PropertySource({"classpath:app.properties"})
public class SpringConfig {	
	@Autowired 
	private Environment env;	    

	@Autowired private Saxophone saxophone;		// bean-scan으로 생성된 bean들을 주입
	@Autowired private Harmonica harmonica;
	@Autowired private Cymbal cymbal;
	@Autowired private Guitar guitar;
	@Autowired private Piano piano;
	@Autowired private Poem sonnet29;

	@Bean(name="kenny")					 
	public Instrumentalist instr() {
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");			// 외부 설정 property 이용
		instr.setInstrument(saxophone);		
		return instr;
	} 
	
	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(sonnet29);
	}
	
	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instr = new HashMap<String, Instrument>(); 
		instr.put("GUITAR", guitar);
		instr.put("CYMBAL", cymbal);
		instr.put("HARMONICA", harmonica);
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instr);
		return omb;
	}		
	
	@Bean
	public Song songForLena() {
		Song song = new Song();
		song.setTitle("Someone Like You");	 // "Chandelier" 로 변경 
		song.setArtist("Adele");			 // "Sia" 로 변경  				
		return song;
	}
	
	// @Value("${lena.name}")		// 외부 설정 property 이용
	// private String lena_name;	
		
	@Bean
	public Singer lena() {		
		return new Singer(env.getProperty("lena.name"), songForLena());
		// return new Singer(lena_name, songForLena());
	}
	
	@Bean
	public SpringIdol springIdol() {		
		SpringIdol si = new SpringIdol();
		// si.setPerformers(new Performer[]{...});	// 생략(auto-wiring by @Autowired)
		return si;		
	}
}