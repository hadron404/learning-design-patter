package org.example.chains.lambda;

import org.example.TaskCommand;

import java.util.Optional;
import java.util.function.BiFunction;

public class TaskChains {

	public static BiFunction<TaskCommand, Optional<String>, Optional<String>> fooTask =
		(TaskCommand taskCommand, Optional<String> previousOpt) -> Optional.of("foo");

	public static BiFunction<TaskCommand, Optional<String>, Optional<String>> barTask =
		(TaskCommand taskCommand, Optional<String> previousOpt) -> Optional.of("bar");
}
