package org.example.use3.context;

import org.example.use3.state.OrderState;
import org.example.use3.state.concrete.ReviewingState;

public class OrderContext {

	/**
	 * 维护一个 ConcreteState - OrderState 的实例，这个实例定义当前状态
	 */
	private OrderState _state;

	public OrderState getState() {
		return _state;
	}

	public void setState(OrderState state) {
		this._state = state;
	}

	public OrderContext() {
		this._state = new ReviewingState();
	}


	public void previousState() {
		this._state.prev(this);
	}

	public void nextState() {
		this._state.next(this);
	}

	public void printStatus() {
		this._state.printStatus();
	}
}
