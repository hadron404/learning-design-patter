package org.example.real1.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.real1.application.constant.EnumConverter;
import org.example.real1.application.constant.StatePersistenceMapping;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Setter
	private OrderId id;

	@Setter
	private OrderState state;

	private List<Flow> flows;

	public Order(OrderId orderId, OrderState state) {
		this.id = orderId;
		this.state = state;
		this.flows = new ArrayList<>();
	}

	public Order(Integer orderId, Integer state) {
		this(new OrderId(orderId), new OrderState(state));
	}

	public Order(StatePersistenceMapping state, Flow... flows) {
		this.state = state.getCode();
		this.flows = List.of(flows);
	}

	public record OrderId(Integer value) {
	}

	public record OrderState(Integer value) {
	}


}
