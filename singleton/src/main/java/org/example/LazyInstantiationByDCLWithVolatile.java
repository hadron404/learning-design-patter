package org.example;

/**
 * 懒汉式：正确的双重检查锁（Double Check Lock）实现方式
 * */
public class LazyInstantiationByDCLWithVolatile {

	private LazyInstantiationByDCLWithVolatile() { // <1>
	}

	private static
	volatile // <7>
    LazyInstantiationByDCLWithVolatile instance = null; // <2>

	@SuppressWarnings("InstantiationOfUtilityClass")
	public static LazyInstantiationByDCLWithVolatile getInstance() { // <3>
		if (instance == null) { // <4>
			synchronized (LazyInstantiationByDCLWithVolatile.class) { // <5>
				if (instance == null) { // <6>
					instance = new LazyInstantiationByDCLWithVolatile();
				}
			}
		}
		return instance;
	}
}
