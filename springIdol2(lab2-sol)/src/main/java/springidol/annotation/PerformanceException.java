package springidol.annotation;

@SuppressWarnings("serial")
public class PerformanceException extends RuntimeException {
	public PerformanceException() {
		super();
	}

	public PerformanceException(String message) {
		super(message);
	}
}
