package org.example;

/**
 * 延期实例化
 * 利与弊
 * 利：采用 synchronized 关键字 对实例化过程加锁，保证多线程环境下该代码段在同一时刻有且只执行一次
 * 弊：被加锁代码每次都会进行上锁，性能大大浪费
 */
public class LazyInstantiationWithSynchronized {

	private LazyInstantiationWithSynchronized() { // <1>
	}

	private static LazyInstantiationWithSynchronized instance = null; // <2>

	@SuppressWarnings("InstantiationOfUtilityClass")
	public static synchronized LazyInstantiationWithSynchronized getInstance() { // <3>
		if (instance == null) { // <5>
			instance = new LazyInstantiationWithSynchronized();
		}
		return instance;
	}
}
