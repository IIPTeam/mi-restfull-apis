package org.mi.user.vo;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;

public class LevelInfo {
	private Level level;

	// as the same may have different rate, e.g TSE testor and TSE java
	// developer, the rate is not the same.
	@Length(min = 0, max = 30)
	private String cat;

	@Valid
	private CurrencyAmount rate;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public CurrencyAmount getRate() {
		return rate;
	}

	public void setRate(CurrencyAmount rate) {
		this.rate = rate;
	}

}
