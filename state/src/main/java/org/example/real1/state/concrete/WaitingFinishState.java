package org.example.real1.state.concrete;

import org.example.real1.state.Context;
import org.example.real1.state.State;

public class WaitingFinishState implements State {


	public WaitingFinishState() {
	}

	@Override
	public void next(Context context) {
		context.setState(new FinishedState());
	}

	@Override
	public void prev(Context context) {

	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "WAITING_FINISH");
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
		System.out.println("the order is completing");
	}

	@Override
	public void drop(Context context) {

	}
}
