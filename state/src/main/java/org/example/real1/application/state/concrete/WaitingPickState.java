package org.example.real1.application.state.concrete;

import org.example.real1.application.constant.Action;
import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;
import org.example.real1.application.state.State;

import java.util.Optional;

public class WaitingPickState implements State {

	public WaitingPickState() {
	}

	@Override
	public StatePersistenceMapping next(Order order) {
		return StatePersistenceMapping.HANDLING;
	}

	@Override
	public StatePersistenceMapping prev(Order order) {
		throw new RuntimeException("the order can not switch to previous state,because it is in root state.");
	}

	@Override
	public void printCurrentState() {
		System.out.println("the order's current state is " + "WAITING_PICK");
	}

	@Override
	public Optional<Action> pick(Context context) {
		System.out.println("the order is being picked");
		return Optional.of(Action.PICK);
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
