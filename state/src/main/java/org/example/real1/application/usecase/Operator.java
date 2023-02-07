package org.example.real1.application.usecase;

import lombok.*;

@Getter
@AllArgsConstructor
public class Operator {
	private OperatorId operatorId;
	private String name;

	public record OperatorId(Integer value) {
	}

}
