package org.example.real1.persistence;

import org.example.real1.application.domain.Order;
import org.example.real1.application.domain.OrderRefundCost;

public class RefundCostMapper {


	OrderRefundCostEntity mapToEntity(Order.OrderId orderId, OrderRefundCost cost) {
		OrderRefundCostEntity result = new OrderRefundCostEntity();
		result.setOrderId(orderId.value());
		result.setByGoods(cost.getByGoods().value());
		result.setByFreight(cost.getByFreight().value());
		result.setByPrepaid(cost.getByPrepaid().value());
		return result;
	}

	public OrderRefundCost mapToDomain(OrderRefundCostEntity cost) {
		OrderRefundCost result = new OrderRefundCost();
		result.setByFreight(new OrderRefundCost.RefundCash(cost.getByFreight()));
		result.setByGoods(new OrderRefundCost.RefundCash(cost.getByGoods()));
		result.setByPrepaid(new OrderRefundCost.RefundCash(cost.getByPrepaid()));
		return result;
	}
}
