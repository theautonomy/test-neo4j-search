package org.wei.spring.rest.domain;

import java.math.BigDecimal;

public class AmountMetrics extends BaseMetrics {
	
	private BigDecimal paymentAmount;

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}
