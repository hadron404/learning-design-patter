package org.example.state.context;

import org.example.state.AbstractPriceState;
import org.example.state.concretes.ChildrenPriceConcreteState;
import org.example.state.concretes.NewReleasePriceConcreteState;
import org.example.state.concretes.RegularPriceConcreteState;
import org.example.state.constants.MoviePriceCode;

public class MovieStateContext {
	private final String _title;

	public MovieStateContext(String title, MoviePriceCode priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	private AbstractPriceState _price;

	public MoviePriceCode getPriceCode() { // 取得价格代号
		return _price.getPriceCode();
	}

	public void setPriceCode(MoviePriceCode priceCode) {
		switch (priceCode) {
			case REGULAR -> _price = new RegularPriceConcreteState();
			case CHILDREN -> _price = new ChildrenPriceConcreteState();
			case NEW_RELEASE -> _price = new NewReleasePriceConcreteState();
			default -> throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}
}
