package org.example.use2.context;

import org.example.use2.state.TCPState;
import org.example.use2.concretestate.TCPClosed;

public class TCPConnection {
	private TCPState _state;

	/**
	 * 初始为 关闭状态
	 */
	public TCPConnection() {
		this._state = new TCPClosed();
	}


}
