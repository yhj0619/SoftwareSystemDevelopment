package springidol;

public interface Performer {
	public void perform() throws PerformanceException;
	
	default public String getBeanName() {
		return null;
	};
}
