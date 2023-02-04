package org.example.real1.usecase;

import org.example.real1.constant.Action;
import org.example.real1.factory.ContextFactory;
import org.example.real1.persistence.Order;
import org.example.real1.persistence.Repository;
import org.example.real1.state.Context;

public class AfterSaleService {

	private final Repository repo = new Repository();

	public Integer create() {
		Order order = new Order();
		order.setState(0);
		repo.insertOrder(order);
		repo.insertFlow(order.getId(), Action.CREATE);
		return order.getId();
	}

	public void pick(Integer orderIdCommand) {
		Order order = repo.selectById(orderIdCommand);
		Context context = ContextFactory.valueOf(order);
		context.pick().ifPresent((action) -> repo.insertFlow(order.getId(), action));
		context.nextState();
		order.setState(context.getStateCode());
		repo.updateOrder(order);
	}

	public void handle(Integer orderIdCommand) {
		Order order = repo.selectById(orderIdCommand);
		Context context = ContextFactory.valueOf(order);
		context.handle().ifPresent((action) -> repo.insertFlow(order.getId(), action));
		context.nextState();
		order.setState(context.getStateCode());
		repo.updateOrder(order);
	}

	public void complete(Integer orderIdCommand) {
		Order order = repo.selectById(orderIdCommand);
		Context context = ContextFactory.valueOf(order);
		context.complete().ifPresent((action) -> repo.insertFlow(order.getId(), action));
		context.nextState();
		order.setState(context.getStateCode());
		repo.updateOrder(order);
	}
}
