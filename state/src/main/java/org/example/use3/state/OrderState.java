package org.example.use3.state;

import org.example.use3.context.OrderContext;

/**
 * 封装与 OrderContext 的一个特定状态的行为
 */
public interface OrderState {

	void next(OrderContext context);

	void prev(OrderContext context);

	void printStatus();
}
