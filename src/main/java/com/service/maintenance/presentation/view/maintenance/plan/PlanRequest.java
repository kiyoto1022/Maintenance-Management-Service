package com.service.maintenance.presentation.view.maintenance.plan;

import java.util.List;

public class PlanRequest {

	public int month;
	public List<Long> points;
	
	public PlanRequest() {}
	
	public PlanRequest(int month, List<Long> points) {
		this.month = month;
		this.points = points;
	}
	
	@Override
    public String toString() {
		//TODO: 修正する必要があるってか、共通化でよくない？
        return "PlanRequest{" +
                "month=" + month +
                ", points='" + points.toString() + '\'' +
                '}';
    }
}