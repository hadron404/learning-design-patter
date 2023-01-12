package org.example;

/**
 * 静态内部类式
 * 1. 延迟单例的实例化
 * 2. 保证线程安全
 *
 * 由于是静态内部类的形式去创建单例的，故外部无法传递参数进去。
 * */
public class LazyInstantiationByInnerClass {

	private LazyInstantiationByInnerClass() {// <1>

	}

	private static final class LazyHolder { // <2>
		@SuppressWarnings("InstantiationOfUtilityClass")
		private static final LazyInstantiationByInnerClass lazy = new LazyInstantiationByInnerClass();
	}

	public static LazyInstantiationByInnerClass getInstance() { // <3>
		return LazyHolder.lazy;
	}
}
