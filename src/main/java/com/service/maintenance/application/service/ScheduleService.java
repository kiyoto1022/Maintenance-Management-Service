package com.service.maintenance.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.maintenance.domain.model.common.DomainEventPublisher;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.plan.Plan;
import com.service.maintenance.domain.model.maintenance.plan.PlanRepository;
import com.service.maintenance.domain.model.maintenance.schedule.Reminded;
import com.service.maintenance.domain.model.maintenance.schedule.Schedule;
import com.service.maintenance.domain.model.maintenance.schedule.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	DomainEventPublisher publisher;
	
	public void scheduling(ContractId id, int month, int inspectionDay, int day) {
		Plan plan = planRepository.findBy(id);
		Schedule schedule = plan.scheduling(month, inspectionDay);
		scheduleRepository.recordRequest(schedule);
		
		Reminded reminded = schedule.toRemind(day);
		publisher.publish(reminded);
	}
}