package org.example.real1.application.usecase;

import lombok.*;

@Getter
@AllArgsConstructor
public class Operator {
	private OperatorId operatorId;
	private String name;

	public Operator(Integer operatorId, String name) {
		this.operatorId = new OperatorId(operatorId);
		this.name = name;
	}

	public record OperatorId(Integer value) {
	}

}
