package com.service.maintenance.domain.model.common;

public interface DomainEventPublisher {
	public void publish(DomainEvent event);
}