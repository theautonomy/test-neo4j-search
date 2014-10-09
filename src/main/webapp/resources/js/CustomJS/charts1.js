var rootURL = "restapi/charts";

var CHART_TYPE_COLUMN = "columnChart";
var CHART_TYPE_PIE = "pieChart";
var CHART_TYPE_GEO = "geoChart";

var CHART_X_AXIS_PAYMENT_TYPE = "paymentType";
var CHART_X_AXIS_DATE = "date";
var CHART_X_AXIS_STATE_CODE = "stateCode";

var CHART_Y_AXIS_VOLUME = "volume";
var CHART_Y_AXIS_AMOUNT = "paymentAmount";

var mappingTable = [];

function createMappingTableValues() {

	var mappingValues = new Object();
	mappingValues.label = CHART_X_AXIS_PAYMENT_TYPE;
	mappingValues.description = "Payment Type";
	mappingTable.push(mappingValues);

	var mappingValues1 = new Object();
	mappingValues1.label = CHART_X_AXIS_DATE;
	mappingValues1.description = "Transaction Date";
	mappingTable.push(mappingValues1);

	var mappingValues2 = new Object();
	mappingValues2.label = CHART_X_AXIS_STATE_CODE;
	mappingValues2.description = "State Code";
	mappingTable.push(mappingValues2);

	var mappingValues3 = new Object();
	mappingValues3.label = CHART_Y_AXIS_VOLUME;
	mappingValues3.description = "Transaction Volume";
	mappingTable.push(mappingValues3);

	var mappingValues4 = new Object();
	mappingValues4.label = CHART_Y_AXIS_AMOUNT;
	mappingValues4.description = "Transaction Amounts";
	mappingTable.push(mappingValues4);

}

function returnMappingDescription(axisLabel) {
	var returnValue = "";
	mappingTable.forEach(function(d, i) {
		if (d.label == axisLabel) {
			returnValue = d.description;
		}
	});

	return returnValue;
}

function renderChart(data1) {

	var primaryAxisValue = getHiddenValue(SEL_PRIMARY_AXIS);
	var secondaryAxisValue = getHiddenValue(SEL_SECONDARY_AXIS);
	var xAxisDescription = returnMappingDescription(primaryAxisValue);
	var yAxisDescription = returnMappingDescription(secondaryAxisValue);
	var isPieChart = (primaryAxisValue == CHART_X_AXIS_PAYMENT_TYPE);
	var newData = formatData(primaryAxisValue, secondaryAxisValue, data1,
			isPieChart);
	var indexLabelValue = null;
	if (secondaryAxisValue != CHART_Y_AXIS_AMOUNT) {
		indexLabelValue = "{y}";
	}

	var chart = null;

	if (primaryAxisValue != null && secondaryAxisValue != null) {
		$('#container').remove();
		$('#chartHolder').append('<div id="container"></div>');
	}

	if (isPieChart) {
		chart = new CanvasJS.Chart("container", {
			title : {
				text : yAxisDescription + " vs " + xAxisDescription
			},
			axisX : {
				title : xAxisDescription
			},
			axisY : {
				title : yAxisDescription
			},
			data : [ {
				type : "pie",
				indexLabel : indexLabelValue,
				indexLabelFontColor : "black",
				dataPoints : newData
			} ]
		});
	} else {
		chart = new CanvasJS.Chart("container", {
			title : {
				text : yAxisDescription + " vs " + xAxisDescription
			},
			axisX : {
				title : xAxisDescription
			},
			axisY : {
				title : yAxisDescription
			},
			data : [ {
				type : "column",
				indexLabel : indexLabelValue,
				indexLabelFontColor : "black",
				dataPoints : newData
			} ]
		});
	}

	chart.render();

}

function formatData(xAxis, yAxis, data, isPieChart) {
	var formattedData = new Array();

	if (data != null) {
		data.forEach(function(d, i) {
			var newData = new Object();
			newData.index = i;
			if (yAxis == CHART_Y_AXIS_AMOUNT) {
				newData.y = d.paymentAmount;
			} else if (yAxis == CHART_Y_AXIS_VOLUME) {
				newData.y = d.count;
			}

			if (xAxis == CHART_X_AXIS_DATE) {
				if (isPieChart) {
					newData.indexLabel = d.date;
				} else {
					newData.label = d.date;
				}

			} else if (xAxis == CHART_X_AXIS_STATE_CODE) {
				if (isPieChart) {
					newData.indexLabel = d.stateCode;
				} else {
					newData.label = d.stateCode;
				}

			} else if (xAxis == CHART_X_AXIS_PAYMENT_TYPE) {
				if (isPieChart) {
					newData.indexLabel = d.paymentType;
				} else {
					newData.label = d.paymentType;
				}
			}
			formattedData.push(newData);
		});
	}
	return formattedData;

}