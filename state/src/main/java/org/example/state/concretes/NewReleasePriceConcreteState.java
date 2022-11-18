package org.example.state.concretes;

import org.example.state.AbstractPriceState;
import org.example.state.constants.MoviePriceCode;

public class NewReleasePriceConcreteState extends AbstractPriceState {
	@Override
	public MoviePriceCode getPriceCode() {
		return MoviePriceCode.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
}
