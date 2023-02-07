package org.example.real1.application.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.real1.application.domain.Order;
import org.example.real1.application.state.State;
import org.example.real1.application.state.concrete.FinishedState;
import org.example.real1.application.state.concrete.HandlingState;
import org.example.real1.application.state.concrete.WaitingFinishState;
import org.example.real1.application.state.concrete.WaitingPickState;

@Getter
@AllArgsConstructor
public enum StatePersistenceMapping implements EnumConverter {


	FINISHED(new Order.OrderState(3), new FinishedState()),
	WAITING_FINISH(new Order.OrderState(2), new WaitingFinishState()),
	HANDLING(new Order.OrderState(1), new HandlingState()),
	WAITING_PICK(new Order.OrderState(0), new WaitingPickState()),
	;
	private final Order.OrderState code;
	private final State state;


}
