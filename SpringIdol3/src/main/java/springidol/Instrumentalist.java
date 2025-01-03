package springidol;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Instrumentalist implements Performer, BeanNameAware, InitializingBean, DisposableBean  {
	private String song;
	private Instrument instrument;
	private String beanName;
	
	public Instrumentalist() {}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override			// from BeanNameAware
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override			// from Performer
	public String getBeanName() {
		return this.beanName;
	}
		
	@Override			// from Performer
	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}
	
	@Override			// from InitializingBean
	public void afterPropertiesSet() throws Exception {
		if (instrument == null) throw new IllegalArgumentException();
		System.out.print("Instrumentalist#afterPropertiesSet() -> ");
		instrument.tune();				// 악기 조율 실행
	}
	
	@Override			// from DisposableBean
	public void destroy() throws Exception {
		System.out.print("Instrumentalist#destroy() -> ");
		instrument.clean();				// 악기 청소 실행
	}
}
