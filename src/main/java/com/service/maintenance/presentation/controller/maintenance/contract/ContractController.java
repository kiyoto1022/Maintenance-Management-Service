package com.service.maintenance.presentation.controller.maintenance.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.maintenance.application.service.ContractService;
import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;
import com.service.maintenance.presentation.view.maintenance.contract.ContractRequest;
import com.service.maintenance.presentation.view.maintenance.contract.ContractResponse;

@RestController
@RequestMapping("maintenance/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void regist(@RequestBody ContractRequest request) {
		Contract contract = contractService.generate(request.name, request.fiscalYear, request.amount, request.maintenanceRate);
		contractService.recordRequest(contract);
	}
	
	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public ContractResponse get(@PathVariable Long id) {
		Contract contract = contractService.confirmTo(new ContractId(id));
		return new ContractResponse(contract);
	}
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public List<ContractResponse> list() {
		return ContractResponse.from(contractService.list());
	}

}