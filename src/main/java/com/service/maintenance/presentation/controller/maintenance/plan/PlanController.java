package com.service.maintenance.presentation.controller.maintenance.plan;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.maintenance.application.service.PlanService;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.domain.model.maintenance.plan.InspectionMonth;
import com.service.maintenance.domain.model.maintenance.plan.Plan;
import com.service.maintenance.presentation.view.maintenance.plan.PlanRequest;
import com.service.maintenance.presentation.view.maintenance.plan.PlanResponse;

@RestController
@RequestMapping("maintenance/plan")
public class PlanController {

	@Autowired
	PlanService planService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void planning(@RequestBody List<PlanRequest> requests) {
		List<InspectionMonth> months = requests.stream().map(r -> new InspectionMonth(r.month, r.points)).collect(Collectors.toList());
		planService.planning(new ContractId(new Long(1)), months);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public PlanResponse confirm(@PathVariable Long id) {
		Plan plan = planService.confirmTo(new ContractId(id));
		return new PlanResponse(plan);
	}

}