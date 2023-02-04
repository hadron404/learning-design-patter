package org.example.real1.state;

import org.example.real1.constant.Action;
import org.example.real1.constant.StatePersistenceMapping;

import java.util.Optional;

/**
 * after-sale order context
 */
public class Context {

	private StatePersistenceMapping _state;

	public Context() {
		this._state = StatePersistenceMapping.WAITING_PICK;
	}

	public Context(StatePersistenceMapping state) {
		this._state = state;
	}

	public void setState(StatePersistenceMapping state) {
		this._state = state;
	}

	public Integer getStateCode() {
		return this._state.getCode();
	}
	public State getState() {
		return this._state.getState();
	}


	public void previousState() {
		this.getState().prev(this);
	}

	public void nextState() {
		this.getState().next(this);
	}

	public void printState() {
		this.getState().printCurrentState(this);
	}

	public Optional<Action> pick() {
		return this.getState().pick(this);
	}

	public Optional<Action> handle() {
		return this.getState().handle(this);
	}

	public Optional<Action> complete() {
		return this.getState().complete(this);
	}
}
