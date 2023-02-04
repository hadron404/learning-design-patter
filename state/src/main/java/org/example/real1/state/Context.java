package org.example.real1.state;

import org.example.real1.state.concrete.WaitingPickState;

/**
 * after-sale order context
 */
public class Context {

	private State _state;

	public Context() {
		this._state = new WaitingPickState();
	}

	public Context(State state) {
		this._state = state;
	}

	public void setState(State state) {
		this._state = state;
	}

	public State getState() {
		return _state;
	}

	public void previousState() {
		this._state.prev(this);
	}

	public void nextState() {
		this._state.next(this);
	}
}
