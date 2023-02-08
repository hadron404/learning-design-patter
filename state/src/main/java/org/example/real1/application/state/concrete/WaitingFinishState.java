package org.example.real1.application.state.concrete;

import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;
import org.example.real1.application.state.State;
import org.example.real1.application.constant.Action;
import org.example.real1.application.constant.StatePersistenceMapping;

import java.util.Optional;

public class WaitingFinishState implements State {


	public WaitingFinishState() {
	}

	@Override
	public StatePersistenceMapping next(Order order) {
		return StatePersistenceMapping.FINISHED;
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		throw new IllegalStateException("the order can not switch to previous state,because the order was in wait-finish state");
	}

	@Override
	public Optional<Action> create(Context context) {
		return Optional.empty();
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
		System.out.println("the order is completing");
		return Optional.of(Action.FINISH);
}

	@Override
	public Optional<Action> drop(Context context) {
		return Optional.empty();
}
}
