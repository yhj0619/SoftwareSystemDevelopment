package com.example.springidol;

import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hank")
public class OneManBand implements Performer, BeanNameAware {
	@Autowired
	@Qualifier("forHank")
	private Map<String, Instrument> instruments; // Map 타입 property

	public OneManBand() {
	}

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

	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public String getBeanName() {
		return beanName;
	}
}
