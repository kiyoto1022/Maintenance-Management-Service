package com.service.maintenance.presentation.view.maintenance.schedule;

public class ScheduleRequest {

	public int month;
	public int inspectionDay;
	public int notifyDay;
	
	public ScheduleRequest() {}
	
	public ScheduleRequest(int month, int inspectionDay, int notifyDay) {
		this.month = month;
		this.inspectionDay = inspectionDay;
		this.notifyDay = notifyDay;
	}
	
	@Override
    public String toString() {
		//TODO: 修正する必要があるってか、共通化でよくない？
        return "ScheduleRequest{" +
                "month=" + month +
                ", inspectionDay='" + inspectionDay + '\'' +
                ", notifyDay='" + notifyDay + '\'' +
                '}';
    }
}