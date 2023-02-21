package org.example;

/**
 * 延期实例化，也称懒汉式
 * 不同于饿汉式的类被初始化时就已经在内存中创建对象，而是在方法被调用后才创建对象
 * 以时间换空间，在多线程环境下存在风险
 * */
public class LazyInstantiation {
	private LazyInstantiation() { // <1>

	}

	private static LazyInstantiation instance = null;

	public static LazyInstantiation getInstance() {
		if (instance == null) {
			//noinspection InstantiationOfUtilityClass
			instance = new LazyInstantiation();
		}
		return instance;
	}

}
