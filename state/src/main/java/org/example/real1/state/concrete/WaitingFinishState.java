package org.example.real1.state.concrete;

import org.example.real1.constant.Action;
import org.example.real1.constant.StatePersistenceMapping;
import org.example.real1.state.Context;
import org.example.real1.state.State;

import java.util.Optional;

public class WaitingFinishState implements State {


	public WaitingFinishState() {
	}

	@Override
	public void next(Context context) {
		context.setState(StatePersistenceMapping.FINISHED);
	}

	@Override
	public void prev(Context context) {

	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "WAITING_FINISH");
	}

	@Override
	public Optional<Action> pick(Context context) {
		return Optional.empty();
	}

	@Override
	public Optional<Action> handle(Context context) {
		return Optional.empty();
	}

	@Override
	public Optional<Action> handleByFinancial(Context context) {
		return Optional.empty();
}

	@Override
	public Optional<Action> rejectByFinancial(Context context) {
		return Optional.empty();
}

	@Override
	public Optional<Action> complete(Context context) {
		System.out.println("the order is completing");
		return Optional.of(Action.FINISH);
}

	@Override
	public Optional<Action> drop(Context context) {
		return Optional.empty();
}
}
