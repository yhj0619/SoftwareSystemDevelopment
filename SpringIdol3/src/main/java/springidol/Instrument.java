package springidol;

public interface Instrument {
	default public void tune() {
		System.out.println("악기 조율");
	};

	default public void clean() {
		System.out.println("악기 청소");
	};
	
	public void play();	
}
