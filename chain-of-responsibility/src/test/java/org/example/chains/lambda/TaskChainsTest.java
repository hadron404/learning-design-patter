package org.example.chains.lambda;

import org.example.TaskCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class TaskChainsTest {

	@Test
	void testChainByLambda() {
		TaskCommand taskCommand = new TaskCommand();
		Optional<String> result = TaskChains.fooTask
			.andThen((previous) -> TaskChains.barTask.apply(taskCommand, previous))
			.apply(taskCommand, Optional.empty());
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals("bar", result.get());
	}
}
