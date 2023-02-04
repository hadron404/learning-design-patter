package org.example.real1.state;

public interface State {

	void next(Context context);

	void prev(Context context);

	void printCurrentState(Context context);

	void pick(Context context);

	void handle(Context context);

	void handleByFinancial(Context context);

	void rejectByFinancial(Context context);

	void complete(Context context);

	void drop(Context context);
}
