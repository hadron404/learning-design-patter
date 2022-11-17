package org.example;

import org.example.chains.AbstractTaskChain;
import org.example.chains.BarTaskChain;
import org.example.chains.FooTaskChain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class AbstractTaskChainTest {


	@Test
	void test() {
		TaskCommand command = new TaskCommand();
		Optional<String> result = AbstractTaskChain.Builder.builder()
			.andThen(new BarTaskChain())
			.andThen(new FooTaskChain())
			.build()
			.execute(command);
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals("foo", result.get());
	}
}
