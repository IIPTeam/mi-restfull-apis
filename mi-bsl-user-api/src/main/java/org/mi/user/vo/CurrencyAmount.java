package org.mi.user.vo;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class CurrencyAmount {
	
	@DecimalMin(value="0")
	@DecimalMax(value="999999999")
	private BigDecimal amount;
	
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
