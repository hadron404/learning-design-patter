package org.example.real1.persistence;

import org.example.real1.application.domain.Flow;
import org.example.real1.application.domain.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlowMapper {

	public FlowEntity mapToFlowEntity(Order.OrderId orderId, Flow flow) {
		FlowEntity result = new FlowEntity();
		result.setOrderId(orderId.value());
		result.setOperator(flow.getOperator().getName());
		result.setOperation(flow.getAction().toString());
		result.setOperatedTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return result;
	}
}
