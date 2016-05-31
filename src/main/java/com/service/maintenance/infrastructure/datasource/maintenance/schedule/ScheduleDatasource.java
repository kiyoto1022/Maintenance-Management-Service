package com.service.maintenance.infrastructure.datasource.maintenance.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.maintenance.domain.model.maintenance.schedule.Schedule;
import com.service.maintenance.domain.model.maintenance.schedule.ScheduleRepository;

@Repository
public class ScheduleDatasource implements ScheduleRepository {

	@Autowired
	private ScheduleMapper mapper;
	
	@Override
	public void recordRequest(Schedule schedule) {
		mapper.register(schedule);
	}

}
