package org.example.real1.persistence;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRefundCostEntity {

	private Integer id;

	private Integer orderId;

	private BigDecimal byGoods;

	private BigDecimal byFreight;

	private BigDecimal byPrepaid;
}
