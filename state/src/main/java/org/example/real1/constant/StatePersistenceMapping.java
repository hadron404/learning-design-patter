package org.example.real1.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.real1.state.State;
import org.example.real1.state.concrete.FinishedState;
import org.example.real1.state.concrete.HandlingState;
import org.example.real1.state.concrete.WaitingFinishState;
import org.example.real1.state.concrete.WaitingPickState;

@Getter
@AllArgsConstructor
public enum StatePersistenceMapping implements EnumConverter {



	FINISHED(3, new FinishedState()),
	WAITING_FINISH(2, new WaitingFinishState()),
	HANDLING(1, new HandlingState()),
	WAITING_PICK(0, new WaitingPickState()),
	;
	private final Integer code;
	private final State state;


}
