package org.example.real1.state.concrete;

import org.example.real1.constant.Action;
import org.example.real1.constant.StatePersistenceMapping;
import org.example.real1.state.Context;
import org.example.real1.state.State;

import java.util.Optional;

public class HandlingState implements State {

	public HandlingState() {
	}

	@Override
	public void next(Context context) {
	// 	 如果工单需要退款，则下个状态为 财务处理中
	// 	 否则为 待完结
		context.setState(StatePersistenceMapping.WAITING_FINISH);
	}

	@Override
	public void prev(Context context) {
		context.setState(StatePersistenceMapping.WAITING_PICK);
	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "HANDLING");
	}

	@Override
	public Optional<Action> pick(Context context) {
		return Optional.empty();
	}

	@Override
	public Optional<Action> handle(Context context) {
		System.out.println("the order is handling");
	// 	 客服补充工单一些信息
		return Optional.of(Action.SUBMIT);
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
