package org.example.state;

import org.example.state.constants.MoviePriceCode;

public abstract class AbstractPriceState {
	public abstract MoviePriceCode getPriceCode();

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}

