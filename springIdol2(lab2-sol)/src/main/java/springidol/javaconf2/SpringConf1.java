package springidol.javaconf2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Cymbal;
import springidol.Guitar;
import springidol.Harmonica;
import springidol.Instrument;
import springidol.Instrumentalist;
import springidol.OneManBand;
import springidol.Piano;
import springidol.Poem;
import springidol.PoeticJuggler;
import springidol.Saxophone;
import springidol.Singer;
import springidol.Song;
import springidol.Sonnet29;

@Configuration
public class SpringConf1 {
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	
	@Bean
	public Harmonica harmonica() {	    
		return new Harmonica();		
	}
	
	@Bean
	public Cymbal cymbal() {	    
		return new Cymbal();		
	}
	
	@Bean
	public Guitar guitar() {	    
		return new Guitar();		
	}
		
	@Bean
	public Piano piano() {	    
		return new Piano();		
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(5, sonnet29());
	}
	
	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");	
		instr.setInstrument(guitar());		// Setter-based DI
		return instr;
	} 
	
	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instr = new HashMap<String, Instrument>(); 
		instr.put("HARMONICA", harmonica());
		instr.put("CYMBAL", cymbal());
		instr.put("SAXOPHONE", saxophone());
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instr);
		return omb;
	}		
	
	@Bean				 
	public Song someone() {
		Song song = new Song();
		song.setTitle("Someone Like You");	
		song.setArtist("Adele");		// Setter-based DI
		return song;
	} 
		
	@Bean				 
	public Song springDay() {
		Song song = new Song();
		song.setTitle("Spring Day");	
		song.setArtist("BTS");		// Setter-based DI
		return song;
	} 
	
	@Bean
	public Singer lena() {
		return new Singer("Lena Park", someone()); 
	} 
	
	@Bean
	public Singer suhyun() {
		// return new Singer("Suhyun", springDay(), piano);
		return new Singer("Suhyun", lena().getSong(), piano());  // lena bean의 song 객체 참조
	}	
}