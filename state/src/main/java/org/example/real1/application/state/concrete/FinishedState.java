package org.example.real1.application.state.concrete;

import org.example.real1.application.constant.Action;
import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;
import org.example.real1.application.state.State;

import java.util.Optional;

public class FinishedState implements State {

	public FinishedState() {
	}

	@Override
	public StatePersistenceMapping next(Order order) {
		throw new IllegalStateException("the order can not switch to next state,because the order was finished");
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		throw new IllegalStateException("the order can not switch to prev state,because the order was finished");
	}

	@Override
	public void printCurrentState() {
		System.out.println("the order's current state is " + "FINISHED");
	}

	@Override
	public Optional<Action> pick(Context context) {
		return Optional.empty();
	}

	@Override
	public Optional<Action> submit(Context context) {
		return Optional.empty();
	}

	@Override
	public Optional<Action> submitByFinancial(Context context) {
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
