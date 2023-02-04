package org.example.real1.state.concrete;

import org.example.real1.state.Context;
import org.example.real1.state.State;

public class HandlingState implements State {

	public HandlingState() {
	}

	@Override
	public void next(Context context) {
	// 	 如果工单需要退款，则下个状态为 财务处理中
	// 	 否则为 待完结
		context.setState(new WaitingFinishState());
	}

	@Override
	public void prev(Context context) {
		context.setState(new WaitingPickState());
	}

	@Override
	public void printCurrentState(Context context) {
		System.out.println("the order's current state is " + "HANDLING");
	}

	@Override
	public void pick(Context context) {

	}

	@Override
	public void handle(Context context) {
		System.out.println("the order is handling");
	// 	 客服补充工单一些信息
	}

	@Override
	public void handleByFinancial(Context context) {

	}

	@Override
	public void rejectByFinancial(Context context) {

	}

	@Override
	public void complete(Context context) {

	}

	@Override
	public void drop(Context context) {

	}
}
