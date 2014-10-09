package org.wei.spring.rest.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.wei.spring.rest.domain.PaymentInformation;
import org.wei.spring.rest.domain.PaymentType;
import org.wei.spring.rest.domain.StateCode;

public class DummyDataGeneratorUtils {
	
	private static Random RANDOM = new Random(System.currentTimeMillis());
	
	private static Long ID = 0L;
	
	private DummyDataGeneratorUtils() {
		
	}
	
	public static List<PaymentInformation> generateDummyPaymentInformationList() {
		
		List<PaymentInformation> payments = new ArrayList<PaymentInformation>();
		
		for (int i = 0; i < 100; i++) {
			payments.add(createDummyPayment());
		}
		
		return payments;
	}
	
	private static String getPaymentType() {
		return PaymentType.getPaymentType(RANDOM.nextInt(100)).toString();
	}
	
	private static String getStateCode() {
		return StateCode.getStateCode(RANDOM.nextInt(50)).toString(); 
	}
	
	private static BigDecimal getPaymentAmount() {
		return new BigDecimal(RANDOM.nextInt(100000) / 100.00).setScale(2, RoundingMode.CEILING);
	}
	
	private static PaymentInformation createDummyPayment() {
		PaymentInformation payment = new PaymentInformation();
		payment.setId(ID++);
		payment.setCreateDate(new Date());
		payment.setUpdateDate(new Date());
		payment.setCreateUser("Hackathon User");
		payment.setUpdateUser("Hackathon User");
		int i = RANDOM.nextInt(15);
		payment.setTransactionDate(new Date (System.currentTimeMillis() -  i * 24 * 60 * 60 * 1000));
		payment.setPaymentAmmount(getPaymentAmount());
		payment.setPaymentType(getPaymentType());
		payment.setStateCode(getStateCode());
		
		return payment;
	}

}

