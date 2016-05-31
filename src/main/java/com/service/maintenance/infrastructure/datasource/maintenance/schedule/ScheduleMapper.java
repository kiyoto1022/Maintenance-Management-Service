package com.service.maintenance.infrastructure.datasource.maintenance.schedule;

import org.apache.ibatis.annotations.Param;

import com.service.maintenance.domain.model.maintenance.schedule.Schedule;

public interface ScheduleMapper {
	
	void register(@Param("schedule") Schedule schedule);

}