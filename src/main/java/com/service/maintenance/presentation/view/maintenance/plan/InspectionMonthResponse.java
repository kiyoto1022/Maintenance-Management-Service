package com.service.maintenance.presentation.view.maintenance.plan;

import java.util.List;
import java.util.stream.Collectors;

import com.service.maintenance.domain.model.maintenance.plan.InspectionMonth;

public class InspectionMonthResponse {

	public int month;
	public List<Long> ids;
	
	public InspectionMonthResponse() {}
	
	public InspectionMonthResponse(InspectionMonth model) {
		this.month = model.value();
		this.ids = model.asPoints().stream().map(i -> i.id().longValue()).collect(Collectors.toList());
	}
}