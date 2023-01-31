package org.example.use1.concretes;

import org.example.use1.AbstractPriceState;
import org.example.use1.constants.MoviePriceCode;

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
