package org.example.chains;

import org.example.TaskCommand;

import java.util.Optional;

public class BarTaskChain extends AbstractTaskChain {
	@Override
	public Optional<String> execute(TaskCommand command) {
		return Optional.of("bar");
	}
}
