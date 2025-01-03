package sp5.sp5chapcboot.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {

	@DateTimeFormat(pattern = "yyyyMMdd")
	private LocalDate from;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private LocalDate to;

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

}
