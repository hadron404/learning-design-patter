package org.example.real1.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.real1.application.constant.StatePersistenceMapping;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Order {

	@Setter
	private OrderId id;

	@Setter
	private OrderState state;

	private OrderRefundCost refundCost;

	private List<Flow> flows;

	public Order(OrderId orderId, OrderState state) {
		this.id = orderId;
		this.state = state;
		this.flows = new ArrayList<>();
		this.refundCost = new OrderRefundCost();
	}

	public Order(Integer orderId, Integer state) {
		this(new OrderId(orderId), new OrderState(state));
	}

	private Order(StatePersistenceMapping state, Flow... flows) {
		this(null, state.getCode());
		this.flows.addAll(List.of(flows));
	}

	public static Order withDefault() {
		return new Order(StatePersistenceMapping.CREATED);
	}

	public boolean isReturnCashOrder () {
		return this.refundCost.isRefundCashGreaterZero();
	}

	public record OrderId(Integer value) {
	}

	public record OrderState(Integer value) {
	}


}
