package org.wei.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wei.spring.rest.domain.OptionField;

@Controller
@RequestMapping(value = "/restapi/charts")
public class UIOptionController {

	@RequestMapping(value = "/options/labels.json", method = RequestMethod.GET)
	@ResponseBody
	public List<OptionField> getUILables() {
		List<OptionField> lables  = new ArrayList<OptionField> ();
		
		OptionField of = new OptionField("paymentType", "Payment Type");
		lables.add(of);
		of = new OptionField("date", "Transaction Date");
		lables.add(of);
		of = new OptionField("stateCode", "State Code");
		lables.add(of);
		
		return lables;
	}

	@RequestMapping(value = "/options/{label}/options.json", method = RequestMethod.GET)
	@ResponseBody
	public List<OptionField> getUIOptions1(@PathVariable String label) {
		List<OptionField> options  = new ArrayList<OptionField> ();
		
		OptionField of =  new OptionField("volume", "Transaction Volume"); 
		options.add(of);
		of =  new OptionField("paymentAmount", "Transaction Amount"); 
		options.add(of);
		
		return options;
	}
	
}