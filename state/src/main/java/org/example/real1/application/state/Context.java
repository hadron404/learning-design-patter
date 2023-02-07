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

	public void previousState() {
		this.getState().prev(this._order);
	}

	public void nextState() {
		this.setState(this.getState().next(this._order));
		this._order.setState(this._state.getCode());
	}

	public void printState() {
		this.getState().printCurrentState();
	}

	public Order pick(Operator operator) {
		this.getState()
			.pick(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		this.nextState();
		return this._order;
	}

	public Order submit(Operator operator) {
		this.getState()
			.submit(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		this.nextState();
		return this._order;
	}

	public Order complete(Operator operator) {
		this.getState()
			.complete(this)
			.ifPresent((action) -> this._order.getFlows().add(new Flow(operator, action)));
		this.nextState();
		return this._order;

	}
}
