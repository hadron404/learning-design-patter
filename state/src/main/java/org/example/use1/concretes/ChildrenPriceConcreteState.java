package org.example.use1.concretes;

import org.example.use1.AbstractPriceState;
import org.example.use1.constants.MoviePriceCode;

public class ChildrenPriceConcreteState extends AbstractPriceState {
	@Override
	public MoviePriceCode getPriceCode() {
		return MoviePriceCode.CHILDREN;
	}

	@Override
	public double getCharge(int daysRented) {
		if (daysRented > 3) {
			return 3 * 1.5;
		}
		return 1.5;
	}
}
