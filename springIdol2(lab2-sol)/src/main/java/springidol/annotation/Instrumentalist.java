package springidol.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//import jakarta.inject.Inject;
//import jakarta.inject.Named;

@Component("kenny")
//또는 @Named("kenny")
public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}

	@Value("Jingle Bells")
	private String song;

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return this.song;
	}

	@Resource(name="piano") 
	// 또는 @Autowired @Qualifier("guitar")
	// 또는 @Inject @Named("guitar")    
	private Instrument instrument;

	// 또는 아래의 setter에 위 annotation들을 붙여도 됨 (@Qualifier와 @Named는 파라미터에도 적용 가능)
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}
}
