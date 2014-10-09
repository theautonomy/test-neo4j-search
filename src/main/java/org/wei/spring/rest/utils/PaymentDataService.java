package org.wei.spring.rest.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wei.spring.rest.domain.AmountMetrics;
import org.wei.spring.rest.domain.PaymentInformation;
import org.wei.spring.rest.domain.VolumeMetrics;

public class PaymentDataService {

	private static final List<PaymentInformation> DUMMY_PAYMENTS;

	private static SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

	static {
		DUMMY_PAYMENTS = DummyDataGeneratorUtils.generateDummyPaymentInformationList();
	}

	public static List<PaymentInformation> getPayments() {
		return DUMMY_PAYMENTS;
	}

	public static List<VolumeMetrics> getVolumeMetrics(String startDate, String endDate, String option) {
		Map<String, VolumeMetrics> metricsMap = new HashMap<String, VolumeMetrics>();
		for (PaymentInformation payment : DUMMY_PAYMENTS) {
			if (isDateWithRange(startDate, endDate, payment.getTransactionDate())) {
				String key = getKey(payment, option); 
				VolumeMetrics vm = metricsMap.get(key);
				if (null == vm) {
					vm = new VolumeMetrics();
					setKeyValue(vm, option, key);
					vm.setCount(1);
					metricsMap.put(key, vm);
				} else {
					vm.setCount(vm.getCount() + 1);
				}
			}
		}
		return new ArrayList<VolumeMetrics>(metricsMap.values());
	}
	
	private static void setKeyValue(VolumeMetrics metrics, String option, String key) {
		if (option.equalsIgnoreCase("date")) {
			metrics.setDate(key);	
		} else if (option.equalsIgnoreCase("stateCode")) {
			metrics.setStateCode(key);
		} else if (option.equalsIgnoreCase("paymentType")) {
			metrics.setPaymentType(key);
		}
	}
	
	private static void setKeyValue(AmountMetrics metrics, String option, String key) {
		if (option.equalsIgnoreCase("date")) {
			metrics.setDate(key);	
		} else if (option.equalsIgnoreCase("stateCode")) {
			metrics.setStateCode(key);
		} else if (option.equalsIgnoreCase("paymentType")) {
			metrics.setPaymentType(key);
		}
	}

	private static String getKey(PaymentInformation payment, String option) {
		String key = "date";
		
		if (option.equalsIgnoreCase("date")) {
				key = SDF.format(payment.getTransactionDate());
		} else if (option.equalsIgnoreCase("stateCode")) {
				key = payment.getStateCode(); 
		} else if (option.equalsIgnoreCase("paymentType")) {
				key = payment.getPaymentType();
		}
		
		return key;
	}
	
	public static List<AmountMetrics> getAmountMetrics() {
		Map<String, AmountMetrics> metricsMap = new HashMap<String, AmountMetrics>();

		for (PaymentInformation payment : DUMMY_PAYMENTS) {
			String key = SDF.format(payment.getTransactionDate());
			AmountMetrics am = metricsMap.get(key);
			if (null == am) {
				am = new AmountMetrics();
				am.setDate(key);
				am.setPaymentAmount( new BigDecimal (payment.getPaymentAmmount().toPlainString()));
				metricsMap.put(key, am);
			} else {
				am.setPaymentAmount( new BigDecimal (payment.getPaymentAmmount().toPlainString()));
			}
		}

		return new ArrayList<AmountMetrics>(metricsMap.values());
	}

	public static List<AmountMetrics> getAmountMetrics(String startDate, String endDate, String option) {
		Map<String, AmountMetrics> metricsMap = new HashMap<String, AmountMetrics>();

		for (PaymentInformation payment : DUMMY_PAYMENTS) {
			if (isDateWithRange(startDate, endDate, payment.getTransactionDate())) {
				String key = getKey(payment, option); 
				AmountMetrics am = metricsMap.get(key);
				if (null == am) {
					am = new AmountMetrics();
					am.setPaymentAmount(payment.getPaymentAmmount());
					setKeyValue(am, option, key);
					metricsMap.put(key, am);
				} else {
					BigDecimal newAmount = payment.getPaymentAmmount().add(am.getPaymentAmount());
					am.setPaymentAmount(newAmount);
				}
			}
		}

		return new ArrayList<AmountMetrics>(metricsMap.values());
	}

	private static boolean isDateWithRange(String startDate, String endDate, Date date) {
		if (startDate.isEmpty()) {
			startDate = "01-01-2010";
		}

		if (endDate.isEmpty()) {
			endDate = "01-01-2020";
		}
		
		Date sDate;
		Date eDate;

		try {
			Date newDate = SDF.parse(SDF.format(date));
			sDate = SDF.parse(startDate);
			eDate = SDF.parse(endDate);

			int i = newDate.compareTo(sDate);
			int j = newDate.compareTo(eDate);
			
			if (i < 0 || j > 0) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return true;
		}
	}

}
