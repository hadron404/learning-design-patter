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
		return StatePersistenceMapping.WAITING_FINISH;
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		return StatePersistenceMapping.HANDLING;
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
		System.out.println("the order is handling by financial employee");
		return Optional.of(Action.FINANCIAL_SUBMIT);
	}

	@Override
	public Optional<Action> rejectByFinancial(Context context) {
		System.out.println("the order was rejected by financial employee");
		return Optional.of(Action.FINANCIAL_REJECT);
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
