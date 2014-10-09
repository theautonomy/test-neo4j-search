package org.wei.spring.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wei.spring.rest.domain.PaymentInformation;
import org.wei.spring.rest.utils.PaymentDataService;

@Controller
@RequestMapping(value = "/restapi/charts")
public class PaymentInformationRestServiceController {

	@RequestMapping(value = "/payments.json", method = RequestMethod.GET)
	@ResponseBody
	public List<PaymentInformation> getPayments() {
		return PaymentDataService.getPayments();
	}

}
