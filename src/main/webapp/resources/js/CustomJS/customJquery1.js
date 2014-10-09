var PRI_AXIS_RETRIEVAL = "primaryAxisRetrieval";
var SEC_AXIS_RETRIEVAL = "secondaryAxisRetrieval";
var DATA_RETRIEVAL = "dataRetrieval";
var SEL_PRIMARY_AXIS = "#selectedPrimaryAxis";
var SEL_SECONDARY_AXIS = "#selectedSecondaryAxis";

$(document).ready(function() {
	initializePage();

});

function initializePage() {
	console.log("initializing application page");

	setDatePicker();

	setButtonActions();

	loadPrimaryAxis();

	disableSubmitButton();

	createMappingTableValues();

}

function loadPrimaryAxis() {
	var primaryAxisURI = "/options/labels.json";
	retrievalAjaxCall(primaryAxisURI, PRI_AXIS_RETRIEVAL);
}

function loadSecondaryAxis(primaryAxisValue) {
	var secondaryAxisURI = "/options/" + primaryAxisValue + "/options.json";
	retrievalAjaxCall(secondaryAxisURI, SEC_AXIS_RETRIEVAL);
}

function retrieveData() {
	var primaryAxisValue = getHiddenValue(SEL_PRIMARY_AXIS);
	var secondaryAxisValue = getHiddenValue(SEL_SECONDARY_AXIS);
	var dateRange = getStartAndEndDates();
	var dataRetrievalURI = "/" + primaryAxisValue + "/" + secondaryAxisValue
			+ ".json" + dateRange;
	retrievalAjaxCall(dataRetrievalURI, DATA_RETRIEVAL);
}

function retrievalAjaxCall(contextURI, task) {

	if (task == PRI_AXIS_RETRIEVAL) {

		$.ajax({
			type : 'GET',
			url : rootURL + contextURI,
			dataType : "json",
			success : function(data) {
				console.log(data);
				processReturnedData(data, '#primaryAxis', false);
			}
		});

	} else if (task == SEC_AXIS_RETRIEVAL) {
		$.ajax({
			type : 'GET',
			url : rootURL + contextURI,
			dataType : "json",
			success : function(data) {
				console.log(data);
				processReturnedData(data, '#secondaryAxis', true);
			}

		});
	} else if (task == DATA_RETRIEVAL) {
		$.ajax({
			type : 'GET',
			url : rootURL + contextURI,
			dataType : "json",
			success : function(data) {
				console.log(data);
				renderChart(data);
			}

		});
	}
}

function processReturnedData(data, dropdownId, isSecondaryAxis) {
	data.forEach(function(element, index, array) {
		$(dropdownId).append(appendAxisItem(element));
		bindElementToEvent(element, isSecondaryAxis);
	});
}

function getStartAndEndDates() {
	var dateOptions = "";

	var startDate = $("#startDate");
	var endDate = $("#endDate");

	var hasEndDate = (endDate != null && endDate.val().length > 1);

	if (startDate != null && startDate.val().length > 1) {
		dateOptions += "?startDate=" + startDate.val();
		if (hasEndDate) {
			dateOptions += "&endDate=" + endDate.val();
		}
	} else if (hasEndDate) {
		dateOptions += "?endDate=" + endDate.val();
	}

	return dateOptions;
}
function bindElementToEvent(element, isSecondaryAxis) {

	$('#' + element.label).bind("click", function() {
		if (!isSecondaryAxis) {
			loadSecondaryAxis(element.label, false);
			setHiddenValue(SEL_PRIMARY_AXIS, element.label);
			$('ul#secondaryAxis > li ').remove();
		} else {
			setHiddenValue(SEL_SECONDARY_AXIS, element.label);
			enableSubmitButton();
		}
	});

}

function appendAxisItem(element) {

	return '<li><a href="#" id=' + element.label + '>' + element.description
			+ '</a></li>';
}

function setButtonActions() {
	$(':button').each(function() {
		var element = $(this);

		if (getElementId(element) == "resetMetrics") {
			element.bind("click", function() {
				$("#dateRangeForm").each(function(event) {
					$("#startDate").val('');
					$("#endDate").val('');
					setHiddenValue(SEL_PRIMARY_AXIS, ' ');
					setHiddenValue(SEL_SECONDARY_AXIS, ' ');
					disableSubmitButton();
				});
			});
		} else if (getElementId(element) == "submitMetrics") {
			element.bind("click", function(event) {
				retrieveData();
			});
		}
	});
}

function setDatePicker() {
	$("input[id*='Date']").each(function(event) {
		$(this).datepicker({
			dateFormat : "dd-mm-yy"
		});

	});
}

function getElementId(element) {
	if (element != null) {
		return element.attr('id');
	} else {
		return null;
	}
}

function alertElement(element) {
	alert(getElementId(element));
}

function setHiddenValue(hiddenId, value) {
	$(hiddenId).val(value);
}

function getHiddenValue(hiddenId) {
	return $(hiddenId).val();
}

function setButtonAttributes(buttonId, isEnabled) {
	if (isEnabled) {
		$(buttonId).removeAttr('disabled');
		$(buttonId).addClass("btn btn-primary");
	} else {
		$(buttonId).attr("disabled", "disabled");
		$(buttonId).removeClass("btn btn-primary").addClass("btn btn-default");
	}
}

function disableSubmitButton() {
	setButtonAttributes('#submitMetrics', false);
}

function enableSubmitButton() {
	setButtonAttributes('#submitMetrics', true);
}