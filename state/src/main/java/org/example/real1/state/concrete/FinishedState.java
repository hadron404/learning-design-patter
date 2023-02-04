package org.example.real1.state.concrete;

import org.example.real1.constant.Action;
import org.example.real1.state.Context;
import org.example.real1.state.State;

import java.util.Optional;

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
		return Optional.empty();
	}

	@Override
	public Optional<Action> drop(Context context) {
		return Optional.empty();
	}
}
