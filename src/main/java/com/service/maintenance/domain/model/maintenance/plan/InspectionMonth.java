package com.service.maintenance.domain.model.maintenance.plan;

import java.util.List;
import java.util.stream.Collectors;

public class InspectionMonth {

	private int value;
	private int inspectionDay;
	private List<InspectionPoint> inspectionPoints;
	
	public InspectionMonth() {}
	
	public InspectionMonth(int value, List<Long> inspectionPoints) {
		this.value = value;
		this.inspectionPoints = inspectionPoints.stream().map(i -> new InspectionPoint(i)).collect(Collectors.toList());
	}
	
	public void toCheckIn(int day) {
		this.inspectionDay = day;
	}
	
	public int value() {
		return value;
	}
	
	public int checkSchedule() {
		return inspectionDay;
	}
	
	public List<InspectionPoint> asPoints() {
		return inspectionPoints;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InspectionMonth))
			return false;

		InspectionMonth inspectionMonth = (InspectionMonth) obj;
		return value == inspectionMonth.value()? true: false;
	}
}