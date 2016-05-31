package com.service.maintenance.domain.model.maintenance.plan;

import java.util.List;

import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.schedule.Schedule;

public class Plan {

	private ContractId id;
	private List<InspectionMonth> months;
	
	public Plan() {}
	
	public Plan(ContractId id, List<InspectionMonth> months) {
		this.id = id;
		this.months = months;
	}
	
	public ContractId id() {
		return id;
	}
	
	public List<InspectionMonth> asList() {
		return months;
	}
	
	public void changeOf(InspectionMonth month) {
		if (months.contains(month))
			months.remove(month);
		months.add(month);
	}
	
	public Schedule scheduling(int month, int day) {
		return new Schedule(id, month, day);
	}
}