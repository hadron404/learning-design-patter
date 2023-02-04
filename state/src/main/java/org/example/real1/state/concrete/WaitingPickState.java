package org.example.real1.state.concrete;

import org.example.real1.state.Context;
import org.example.real1.state.State;

public class WaitingPickState implements State {

	public WaitingPickState() {
	}

	@Override
	public void next(Context context) {
		context.setState(new HandlingState());
	}

	@Override
	public void prev(Context context) {
		throw new RuntimeException("can not change to prev state,because it already in its root state.");
	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "WAITING_PICK");
	}

	@Override
	public void pick(Context context) {
		System.out.println("the order is picking");
	}

	@Override
	public void handle(Context context) {

	}

	@Override
	public void handleByFinancial(Context context) {

	}

	@Override
	public void rejectByFinancial(Context context) {

	}

	@Override
	public void complete(Context context) {

	}

	@Override
	public void drop(Context context) {

	}
}
