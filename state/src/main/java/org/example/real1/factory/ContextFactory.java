package org.example.real1.factory;

import org.example.real1.state.Context;
import org.example.real1.state.State;
import org.example.real1.state.concrete.FinishedState;
import org.example.real1.state.concrete.HandlingState;
import org.example.real1.state.concrete.WaitingFinishState;
import org.example.real1.state.concrete.WaitingPickState;
import org.example.real1.usecase.entity.WorkOrder;

import java.util.HashMap;

public class ContextFactory {
	public static final HashMap<Integer, State> STATE_MAP = new HashMap<>();


	static {
		initStateMap();
	}


	private static  void initStateMap() {
		STATE_MAP.put(0, new WaitingPickState());
		STATE_MAP.put(1, new HandlingState());
		STATE_MAP.put(2, new WaitingFinishState());
		STATE_MAP.put(3, new FinishedState());
		System.out.println("all states have complete init.");
		// STATE_MAP.put(4, new WaitingPickState());
		// STATE_MAP.put(5, new WaitingPickState());
	}

	private ContextFactory() {
	}

	public static Context valueOf(WorkOrder order) {
		State state = STATE_MAP.get(order.getState());
		if (state == null) {
			throw new RuntimeException("unknown state" + order.getState());
		}
		return new Context(state);
	}
}
