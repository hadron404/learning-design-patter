package org.example.real1.application.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderRefundCost {

	private RefundCash byGoods;

	private RefundCash byFreight;

	private RefundCash byPrepaid;

	private static final BigDecimal ZERO = new BigDecimal(0);

	public OrderRefundCost() {
		this.byGoods = new RefundCash(ZERO);
		this.byFreight = new RefundCash(ZERO);
		this.byPrepaid = new RefundCash(ZERO);
	}

	public boolean isRefundCashGreaterZero() {
		return this.byGoods.value.compareTo(ZERO) > 0
			|| this.byFreight.value.compareTo(ZERO) > 0
			|| this.byPrepaid.value.compareTo(ZERO) > 0;
	}

	record RefundCash(BigDecimal value) {
	}
}
