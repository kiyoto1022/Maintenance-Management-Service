package com.service.maintenance.infrastructure.datasource.maintenance.contract;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.service.maintenance.domain.model.maintenance.contract.Contract;
import com.service.maintenance.domain.model.maintenance.contract.ContractId;

public interface ContractMapper {

	Contract findBy(@Param("id") ContractId id);
	List<Contract> list();
	
	void register(@Param("contract") Contract contract);
	
	@Select("select nextval('MAINTENANCE.CONTRACT_REQUEST_ID')")
    long generateRequestId();
	
}