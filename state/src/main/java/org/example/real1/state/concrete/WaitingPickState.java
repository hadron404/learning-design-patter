package org.example.real1.state.concrete;

import org.example.real1.constant.Action;
import org.example.real1.constant.StatePersistenceMapping;
import org.example.real1.state.Context;
import org.example.real1.state.State;

import java.util.Optional;

public class WaitingPickState implements State {

	public WaitingPickState() {
	}

	@Override
	public void next(Context context) {
		context.setState(StatePersistenceMapping.HANDLING);
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
	public Optional<Action> pick(Context context) {
		System.out.println("the order is picking");
		return Optional.of(Action.PICK);
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
