package org.example.real1.application.domain;


import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@ToString
@Setter
public class OrderRefundCost {

	private RefundCash byGoods;

	private RefundCash byFreight;

	private RefundCash byPrepaid;

	private static final BigDecimal ZERO = new BigDecimal(0);

	public OrderRefundCost(RefundCash byGoods, RefundCash byFreight) {
		this.byGoods = byGoods;
		this.byFreight = byFreight;
		this.byPrepaid = new RefundCash(ZERO);
	}

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

	public record RefundCash(BigDecimal value) {
		public RefundCash {
			value = value.setScale(4, RoundingMode.HALF_UP);
		}
	}
}
