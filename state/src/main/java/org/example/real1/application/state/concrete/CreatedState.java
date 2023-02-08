package org.example.real1.application.state.concrete;

import org.example.real1.application.constant.Action;
import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;
import org.example.real1.application.state.State;

import java.util.Optional;

public class CreatedState implements State {
	@Override
	public StatePersistenceMapping next(Order order) {
		return StatePersistenceMapping.WAITING_PICK;
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		throw new IllegalStateException("the order can not switch to previous state.");
	}

	@Override
	public Optional<Action> create(Context context) {
		return Optional.of(Action.CREATE);
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
