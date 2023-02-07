package org.example.real1.application.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.real1.application.constant.Action;
import org.example.real1.application.usecase.Operator;

@Getter
@NoArgsConstructor
public class Flow {

	private FlowId id;

	private Operator operator;

	private Action action;

	public Flow(Operator operator, Action action) {
		this.operator = operator;
		this.action = action;
	}

	public record FlowId(Integer value) {
	}


}
