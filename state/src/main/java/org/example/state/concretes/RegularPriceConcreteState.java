package org.example.state.concretes;

import org.example.state.AbstractPriceState;
import org.example.state.constants.MoviePriceCode;

public class RegularPriceConcreteState extends AbstractPriceState {
	@Override
	public MoviePriceCode getPriceCode() {
		return MoviePriceCode.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		if (daysRented > 2) {
			return (daysRented - 2) * 1.5;
		}
		return 2;
	}
}
