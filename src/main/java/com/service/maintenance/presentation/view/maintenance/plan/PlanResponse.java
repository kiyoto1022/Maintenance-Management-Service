package com.service.maintenance.presentation.view.maintenance.plan;

import java.util.List;
import java.util.stream.Collectors;

import com.service.maintenance.domain.model.maintenance.plan.Plan;

public class PlanResponse {

	public List<InspectionMonthResponse> months;
	
	public PlanResponse() {}
	
	public PlanResponse(Plan model) {
		this.months = model.asList().stream().map(p -> new InspectionMonthResponse(p)).collect(Collectors.toList());
	}
}
