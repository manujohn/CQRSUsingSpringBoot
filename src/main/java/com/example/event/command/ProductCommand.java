package com.example.event.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.stereotype.Component;

@Component
public class ProductCommand {
	
	@TargetAggregateIdentifier
	private String productOrderId;
	private long productId;
	private String productName;

	
	public String getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(String productOrderId) {
		this.productOrderId = productOrderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductCommand [productOrderId=" + productOrderId + ", productId=" + productId + ", productName="
				+ productName + "]";
	}
	
}
