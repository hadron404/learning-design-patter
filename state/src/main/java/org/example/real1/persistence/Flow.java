package org.example.real1.persistence;

import lombok.Data;

@Data
public class Flow {
	private Integer id;

	private Integer orderId;

	private String operatorName;

	private String operator;

	private String operatorTime;
}
