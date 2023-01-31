package org.example.use1.concretestate;

import org.example.use1.state.AbstractPriceState;
import org.example.use1.constants.MoviePriceCode;

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
