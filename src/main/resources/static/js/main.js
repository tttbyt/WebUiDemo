var showTempChart = false, showSpo2Chart = false, showHrChart = false, showBpChart = false;
var realtimeChart;
var data = new Array(6000).fill(0);
var intervalCurTempature, intervalCurSpo2, intervalCurHeartRate, intervalCurBloodPressure;

function formatDate(date) {
	var hours = date.getHours();
	var minutes = date.getMinutes();
	minutes = minutes < 10 ? '0' + minutes : minutes;
	var strTime = hours + ':' + minutes + ':' + date.getSeconds();
	return date.getDate() + "/" + (date.getMonth() + 1) + "/"
			+ date.getFullYear() + "  " + strTime;
}

function getCurrentTempature() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/get_current_temp/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var obj = JSON.parse(JSON.stringify(data));
			$('#tempature').html(obj.currentTemp.toFixed(2));
		},
		error : function(e) {
			$('#tempature').html(e.responseText);
		}
	});
}

function getCurrentSpo2() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/get_current_spo2/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var obj = JSON.parse(JSON.stringify(data));
			$('#spo2').html(obj.spo2_current.toFixed(2));
		},
		error : function(e) {
			$('#spo2').html(e.responseText);
		}
	});
}

function getCurrentBp() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/get_current_bp/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var obj = JSON.parse(JSON.stringify(data));
			$('#bp').html(obj.high_value.toFixed(0)+ "/"+ obj.low_value.toFixed(0));
		},
		error : function(e) {
			$('#bp').html(e.responseText);
		}
	});
}

function getCurrentHr() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/get_current_hr/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var obj = JSON.parse(JSON.stringify(data));
			$('#hr').html(obj.current_heart_rate.toFixed(0));
		},
		error : function(e) {
			$('#hr').html(e.responseText);
		}
	});
}

function getTempatureAvg() {
	if (!showTempChart) {
		showTempChart = true;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/api/get_avg_temp/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
			dataType : 'json',
			cache : false,
			timeout : 600000,
			success : function(data) {
				var json_data = JSON.parse(JSON.stringify(data));
				var myChart = {
					chart : {
						type : 'line'
					},
					title : {
						text : ' Consumption'
					},
					xAxis : {
						categories : []
					},
					yAxis : {
						title : {
							text : 'Fruit eaten'
						}
					},
					series : []
				};

				var avg = {
					name : 'avg',
					data : []
				};
				var min = {
					name : 'min',
					data : []
				};
				var max = {
					name : 'max',
					data : []
				};
				for (var i = json_data.length - 1; i >= 0; i--) {
					myChart.xAxis.categories.push(json_data[i].daytime);
					avg.data.push(json_data[i].avgTemp);
					max.data.push(json_data[i].maxTemp);
					min.data.push(json_data[i].minTemp);
				}

				// set series: 3 object as min-max-avg
				myChart.series.push(avg);
				myChart.series.push(min);
				myChart.series.push(max);
				$('#tempchart').highcharts(myChart);
				$('#tempchart').show(500);
			},
			error : function(e) {

				var json = "<h4>Ajax Fail</h4><pre>" + e.responseText
						+ "</pre>";
				$('#avg').html(e);
				console.log("ERROR AVG: ", e);
			}
		});
	} else {
		showTempChart = false;
		$('#tempchart').hide(500);
	}
}

function getSpo2Avg() {
	if (!showSpo2Chart) {
		showSpo2Chart = true;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/api/get_avg_spo2/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
			dataType : 'json',
			cache : false,
			timeout : 600000,
			success : function(data) {
				var json_data = JSON.parse(JSON.stringify(data));
				var myChart = {
					chart : {
						type : 'line'
					},
					title : {
						text : ' SPO2'
					},
					xAxis : {
						categories : []
					},
					yAxis : {
						title : {
							text : '%'
						}
					},
					series : []
				};

				var avg = {
					name : 'avg',
					data : []
				};
				var min = {
					name : 'min',
					data : []
				};
				var max = {
					name : 'max',
					data : []
				};
				for (var i = json_data.length - 1; i >= 0; i--) {
					myChart.xAxis.categories.push(json_data[i].daytime);
					avg.data.push(json_data[i].spo2_avg);
					max.data.push(json_data[i].spo2_max);
					min.data.push(json_data[i].spo2_min);
				}

				// set series: 3 object as min-max-avg
				myChart.series.push(avg);
				myChart.series.push(min);
				myChart.series.push(max);
				$('#spo2chart').highcharts(myChart);
				$('#spo2chart').show(500);
			},
			error : function(e) {
				$('#spo2chart').html(e.responseText);
			}
		});
	} else {
		showSpo2Chart = false;
		$('#spo2chart').hide(500);
	}
}

function getHeartRateAvg() {
	if (!showHrChart) {
		showHrChart = true;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/api/get_avg_hr/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
			dataType : 'json',
			cache : false,
			timeout : 600000,
			success : function(data) {
				var json_data = JSON.parse(JSON.stringify(data));
				var myChart = {
					chart : {
						type : 'line'
					},
					title : {
						text : ' Heart Beat'
					},
					xAxis : {
						categories : []
					},
					yAxis : {
						title : {
							text : 'time'
						}
					},
					series : []
				};

				var avg = {
					name : 'avg',
					data : []
				};
				var min = {
					name : 'min',
					data : []
				};
				var max = {
					name : 'max',
					data : []
				};
				for (var i = json_data.length - 1; i >= 0; i--) {
					myChart.xAxis.categories.push(json_data[i].daytime);
					avg.data.push(json_data[i].heart_rate_avg);
					max.data.push(json_data[i].heart_rate_max);
					min.data.push(json_data[i].heart_rate_min);
				}

				// set series: 3 object as min-max-avg
				myChart.series.push(avg);
				myChart.series.push(min);
				myChart.series.push(max);
				$('#hrchart').highcharts(myChart);
				$('#hrchart').show(500);
			},
			error : function(e) {
				$('#hrchart').html(e.responseText);
			}
		});
	} else {
		showHrChart = false;
		$('#hrchart').hide(500);
	}

}

function getBloodPresureAvg() {

	if (!showBpChart) {
		showBpChart = true;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/api/get_avg_bp/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
			dataType : 'json',
			cache : false,
			timeout : 600000,
			success : function(data) {
				var json_data = JSON.parse(JSON.stringify(data));
				var myChart = {
					chart : {
						type : 'line'
					},
					title : {
						text : 'Blood Pressure'
					},
					xAxis : {
						categories : []
					},
					yAxis : {
						title : {
							text : 'mmHg'
						}
					},
					series : []
				};

				var high = {
					name : 'high_avg',
					data : []
				};
				var low = {
					name : 'low_min',
					data : []
				};

				for (var i = json_data.length - 1; i >= 0; i--) {
					myChart.xAxis.categories.push(json_data[i].daytime);
					high.data.push(json_data[i].high_avg);
					low.data.push(json_data[i].low_avg);
				}

				// set series: 3 object as min-max-avg
				myChart.series.push(high);
				myChart.series.push(low);
				$('#bpchart').highcharts(myChart);
				$('#bpchart').show(500);
			},
			error : function(e) {
				$('#bpchart').html(e.responseText);
			}
		});
	} else {
		showBpChart = false;
		$('#bpchart').hide(500);
	}

}

function drawChart() {
	var myChart = Highcharts.chart('avg', {
		chart : {
			type : 'line'
		},
		title : {
			text : ' Consumption'
		},
		xAxis : {
			categories : [ 'Apples', 'Bananas', 'Oranges' ]
		},
		yAxis : {
			title : {
				text : 'Fruit eaten'
			}
		},
		series : [ {
			name : 'Jane',
			data : [ 1, 0, 4 ]
		}, {
			name : 'John',
			data : [ 5, 7, 3 ]
		} ]
	});
}
function openCity(evt, cityName) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(cityName).style.display = "block";
	evt.currentTarget.className += " active";
	if (cityName == "Current") {
		intervalCurTempature = setInterval(getCurrentTempature, 1000);
		intervalCurSpo2 = setInterval(getCurrentSpo2, 1000);
		intervalCurHeartRate = setInterval(getCurrentHr, 1000);
		intervalCurBloodPressure = setInterval(getCurrentBp, 1000);
	} else {
		clearInterval(intervalCurTempature);
		clearInterval(intervalCurSpo2);
		clearInterval(intervalCurHeartRate);
		clearInterval(intervalCurBloodPressure);
		// realtimeChart.events.load = null;
	}
}

function requestData() {
	console.log("request data");
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/get_ecg_point/3d4b9a48-dab6-4dd0-9d98-65c334fbd161",
		dataType : 'json',
		success : function(listData) {
			// var json_data = JSON.parse(JSON.stringify(listData));
			// var series = realtimeChart.series[0];
			console.log(listData);
			var j = 0;
			for (; j < 6000 - listData.length; j++) {
				data[j] = data[j + listData.length];
			}

			for (var i = 0; i < listData.length; i++, j++) {
				// realtimeChart.series[0].data[0].remove(false, false);
				realtimeChart.series[0].addPoint(listData[i], false, true,
						false, true);
				// data[j] = listData[i];
			}
			// console.log(series.data);
			// realtimeChart.series[0].setData(data, true, false, true);
			// console.log(realtimeChart.series[0].data);
			realtimeChart.redraw();
		},
		error : function(e) {
			$('#realtime').html(e.responseText);
		},
		cache : false

	});
}

realtimeChart = Highcharts.stockChart('realtime', {
	chart : {
		type : 'spline',
		events : {
			load : setInterval(requestData, 1000)
		}
	/**/
	},
	time : {
		useUTC : true
	},
	legend : {
		enabled : false
	},
	title : {
		text : 'Live random data'
	},
	rangeSelector : {
		buttons : [ {
			count : 2,
			type : 'second',
			text : '2s'
		}, {
			count : 4,
			type : 'second',
			text : '4s'
		}, {
			count : 8,
			type : 'second',
			text : '8s'
		} ],
		inputEnabled : false,
		selected : 0
	},
	xAxis : {
		gridLineWidth : 1,
		tickPixelInterval : 50,
		labels : {
			enabled : true
		}
	},
	exporting : {
		enabled : true
	},
	yAxis : {
		title : {
			text : 'Value'
		},
		min : -100,
		max : 100,
		plotLines : [ {
			value : 0,
			width : 1,
			color : '#FF0000'
		} ]
	},

	series : [ {
		name : 'Random data',
		data : (function() {
			var list = [];
			for (var index = 0; index < 15000; index++) {
				list.push(0);
			}
			return list;
		})()
	} ]
});
