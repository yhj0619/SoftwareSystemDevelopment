package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan	// (basePackages={"springidol.annotation"}) 생략 가능
public class SpringConfig {
	@Autowired
	@Qualifier("lena")	// Singer 클래스에서 정의된 lena bean 주입 				
	private Singer lena;		
	
	@Autowired 
	private Piano piano;		
	
	@Bean				 
	public Song springDay() {
		Song song = new Song();
		song.setTitle("Spring Day");	
		song.setArtist("BTS");		// Setter-based DI
		return song;
	} 
	
	@Bean
	public Singer suhyun() {
		// return new Singer("Suhyun", springDay(), piano);
		return new Singer("Suhyun", lena.getSong(), piano);  // lena bean의 song 객체 참조
	} 
}