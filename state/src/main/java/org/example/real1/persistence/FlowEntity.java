package org.example.real1.persistence;

import lombok.Data;

@Data
public class FlowEntity {
	private Integer id;

	private Integer orderId;

	private String operation;

	private String operator;

	private String operatedTime;
}
