package org.example.real1.state.concrete;

import org.example.real1.state.Context;
import org.example.real1.state.State;

public class FinishedState implements State {

	public FinishedState() {
	}

	@Override
	public void next(Context context) {
		throw new RuntimeException("can not change to next state,because the order was finished");
	}

	@Override
	public void prev(Context context) {
		throw new RuntimeException("can not change to prev state,because the order was finished");
	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "FINISHED");
	}

	@Override
	public void pick(Context context) {

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
