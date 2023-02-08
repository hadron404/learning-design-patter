package org.example.real1.application.state;

import org.example.real1.application.constant.EnumConverter;
import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Flow;
import org.example.real1.application.domain.Order;
import org.example.real1.application.usecase.Operator;

/**
 * after-sale order context
 */
public class Context {

	private final Order _order;
	private StatePersistenceMapping _state;

	public Context(Order order) {
		StatePersistenceMapping stateMapping = EnumConverter
			.codeOf(StatePersistenceMapping.class, order.getState())
			.orElseThrow(() -> {
				throw new IllegalStateException("unknown state: " + order.getState());
			});
		this._order = order;
		this._state = stateMapping;
	}

	private void setState(StatePersistenceMapping state) {
		this._state = state;
	}

	public State getState() {
		return this._state.getState();
	}

	public Order prevState() {
		this.setState(this.getState().prev(this._order));
		this._order.setState(this._state.getCode());
		return this._order;
	}

	public Order nextState() {
		this.setState(this.getState().next(this._order));
		this._order.setState(this._state.getCode());
		return this._order;
	}

	@SuppressWarnings("unused")
	public void printPreviousState() {
		System.out.println("the order's previous state is " + this.getState().prev(this._order).toString());
	}

	@SuppressWarnings("unused")
	public void printState() {
		System.out.println("the order's current state is " + this._state.toString());
	}

	public Order create(Operator operator) {
		this.getState()
			.create(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.nextState();
	}

	public Order pick(Operator operator) {
		this.getState()
			.pick(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.nextState();
	}

	public Order submit(Operator operator) {
		this.getState()
			.submit(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.nextState();
	}

	public Order financialSubmit(Operator operator) {
		this.getState()
			.submitByFinancial(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.nextState();
	}

	public Order financialReject(Operator operator) {
		this.getState()
			.rejectByFinancial(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.prevState();
	}

	public Order complete(Operator operator) {
		this.getState()
			.complete(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		return this.nextState();
	}
}
