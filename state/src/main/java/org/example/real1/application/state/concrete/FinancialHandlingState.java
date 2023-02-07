package org.example.real1.application.state.concrete;

import org.example.real1.application.constant.Action;
import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;
import org.example.real1.application.state.State;

import java.util.Optional;

public class FinancialHandlingState implements State {
	@Override
	public StatePersistenceMapping next(Order order) {
		return null;
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		return null;
	}

	@Override
	public void printCurrentState() {

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
