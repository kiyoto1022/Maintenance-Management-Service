package com.service.maintenance.domain.model.maintenance.schedule;

import com.service.maintenance.domain.model.common.DomainEvent;

public class Reminded implements DomainEvent {

	private int inspectionDay;
	private int notifyDay;
	
	public Reminded(int inspectionDay, int notifyDay) {
		this.inspectionDay = inspectionDay;
		this.notifyDay = notifyDay;
	}

	@Override
	public String getMessage() {
		return "Test Messaging";
	}
	
}