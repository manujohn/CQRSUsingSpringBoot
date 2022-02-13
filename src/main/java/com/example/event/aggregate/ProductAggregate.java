package com.example.event.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.event.command.ProductCommand;
import com.example.event.events.ProductOrderEvent;

@Aggregate
public class ProductAggregate {

	@AggregateIdentifier
	String productOrderId;
	long productId;
	String productName;

	@CommandHandler
	public ProductAggregate(ProductCommand productCommand) {

		ProductOrderEvent productOrderEvent = new ProductOrderEvent();
		BeanUtils.copyProperties(productCommand, productOrderEvent);

		AggregateLifecycle.apply(productOrderEvent);

	}

	public ProductAggregate() {
	}

	@EventSourcingHandler
	public void on(ProductOrderEvent productOrderEvent) {
		this.productId = productOrderEvent.getProductId();
		this.productName = productOrderEvent.getProductName();
		this.productOrderId = productOrderEvent.getProductOrderId();

	}

}
