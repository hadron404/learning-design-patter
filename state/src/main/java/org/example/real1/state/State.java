package org.example.real1.state;

import org.example.real1.constant.Action;

import java.util.Optional;

public interface State {

	void next(Context context);

	void prev(Context context);

	void printCurrentState(Context context);

	Optional<Action> pick(Context context);

	Optional<Action> handle(Context context);

	Optional<Action> handleByFinancial(Context context);

	Optional<Action> rejectByFinancial(Context context);

	Optional<Action> complete(Context context);

	Optional<Action> drop(Context context);
}
