package org.example.usecase;

import org.example.use1.constants.MoviePriceCode;
import org.example.use1.context.MovieStateContext;
import org.example.use1.usecase.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RentalTest {
	@Test
	void useCase1() {
		MovieStateContext movie = new MovieStateContext("", MoviePriceCode.REGULAR);
		int daysRented = 30;
		Rental rental = new Rental(movie, daysRented);
		int result = rental.getFrequentRenterPoints();
		double charge = rental.getCharge();
		Assertions.assertEquals(0, result);
		Assertions.assertEquals(0, charge);
	}
}
