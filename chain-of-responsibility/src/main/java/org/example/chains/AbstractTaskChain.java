package org.example.chains;


import org.example.TaskCommand;

import java.util.Optional;

public abstract class AbstractTaskChain {

	protected AbstractTaskChain nextChain;

	public void setNextChain(AbstractTaskChain taskChain) {
		this.nextChain = taskChain;
	}

	public abstract Optional<String> execute(TaskCommand command);

	public static class Builder {
		private AbstractTaskChain head;
		private AbstractTaskChain tail;

		public Builder andThen(AbstractTaskChain taskChain) {
			if (this.head == null) {
				this.head = this.tail = taskChain;
				return this;
			}
			this.tail.setNextChain(taskChain);
			this.tail = taskChain;
			return this;
		}

		public static Builder builder() {
			return new Builder();
		}

		public AbstractTaskChain build() {
			return this.head;
		}
	}
}
