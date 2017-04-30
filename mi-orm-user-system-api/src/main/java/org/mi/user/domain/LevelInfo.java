package org.mi.user.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class LevelInfo {
	private Level level;	
	
	// as the same may have different rate, e.g TSE testor and TSE java developer, the rate is not the same.
	@Column(name="rate_level_cat",length=30)
	private String cat;
	
	@Embedded
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
