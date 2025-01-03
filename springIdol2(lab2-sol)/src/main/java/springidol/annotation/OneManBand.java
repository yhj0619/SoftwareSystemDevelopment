package springidol.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hank")
public class OneManBand implements Performer {  
  @Autowired
  @Qualifier("forHank")
  private Map<String, Instrument> instruments; // Map 타입 property
  
  public OneManBand() {}
  
  // 또는 아래의 setter에 @Autowired와 @Qualifier("forHank")를 사용해도 됨  
  // @Qualifier("forHank")는 파라미터 앞에도 적용 가능 
  public void setInstruments(Map<String, Instrument> instruments) {
	this.instruments = instruments;
  }

  @Override
  public void perform() throws PerformanceException {
  	for (String key : instruments.keySet()) {
  		System.out.print(key + ": ");
  		Instrument instrument = instruments.get(key);
  		instrument.play();
  	}
  } 
}
