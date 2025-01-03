package com.example.springidol;

import org.springframework.beans.factory.BeanNameAware;

public class Juggler implements Performer, BeanNameAware {
	private int beanBags = 3;

	public Juggler() {
	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public String perform() throws PerformanceException {
		return ("JUGGLING " + beanBags + " BEANBAGS" + "\n");
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
