package com.service.maintenance.infrastructure.message.common;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.service.maintenance.domain.model.common.DomainEvent;
import com.service.maintenance.domain.model.common.DomainEventPublisher;

@Component
public class ActiveMqBaseDomainEventPublisher implements DomainEventPublisher {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;
	
	@Override
	public void publish(DomainEvent event) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, event.getMessage());
	}

}