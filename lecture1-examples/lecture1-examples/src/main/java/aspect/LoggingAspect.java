package aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	private Log log = LogFactory.getLog(getClass());
	
	public Object logging(ProceedingJoinPoint  joinPoint) 
			throws Throwable {
		log.info("기록 시작");
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			return joinPoint.proceed();
		} catch (Throwable e) {   
			throw e;
		} finally {
			stopWatch.stop();
			log.info("기록 종료");
			log.info( joinPoint.getSignature().getName() +
				    "메서드 실행 시간:" + stopWatch.getTotalTimeMillis() );
		}
	}  
}
