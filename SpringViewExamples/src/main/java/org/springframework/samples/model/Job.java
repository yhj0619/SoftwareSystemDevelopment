package org.springframework.samples.model;

public class Job {

	private String code;
	private String label;
	
	public Job() {
	}
	
	public Job(String code, String value) {
		this.code = code;
		this.label = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String value) {
		this.label = value;
	}

}
