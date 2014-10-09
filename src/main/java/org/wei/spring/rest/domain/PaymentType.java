package org.wei.spring.rest.domain;

public enum PaymentType {
	
	EFT,
	PAPER,
	CC,
	DC;
	
	public static PaymentType getPaymentType(int i) {
		int size = values().length;
		return values()[i % size]; 
	}

}
