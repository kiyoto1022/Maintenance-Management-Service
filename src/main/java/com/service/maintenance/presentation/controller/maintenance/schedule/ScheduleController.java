package com.service.maintenance.presentation.controller.maintenance.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.maintenance.application.service.ScheduleService;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.presentation.view.maintenance.schedule.ScheduleRequest;

@RestController
@RequestMapping("maintenance/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void scheduling(@PathVariable Long id, @RequestBody ScheduleRequest request) {
		scheduleService.scheduling(new ContractId(id), request.month, request.inspectionDay, request.notifyDay);
	}

}