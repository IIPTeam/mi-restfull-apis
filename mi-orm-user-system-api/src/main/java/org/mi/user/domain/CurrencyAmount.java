package org.mi.user.domain;

import java.math.BigDecimal;

import javax.persistence.Column;

public class CurrencyAmount {
	
	@Column(nullable=true,scale=2,precision=11,name="rate")
	private BigDecimal amount;
	
	@Column(length=3)
	private String currency = "RMB";

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	} 

}
