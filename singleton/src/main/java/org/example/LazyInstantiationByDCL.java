package org.example;

/**
 * 懒汉式：双重检查锁（Double Check Lock）
 * 只有在对象需要被使用才创建，第一次判断 {@code instance == null} 为了避免非必要加锁
 * 当第一次加载时才对实例进行加锁再实例化，这样既可以节约内存空间，又可以保证线程安全。
 * 但是，由于 JVM 存在乱序执行功能，DCL 也会出现线程不安全的情况
 * */
public class LazyInstantiationByDCL {

	private LazyInstantiationByDCL() { // <1>
	}

	private static LazyInstantiationByDCL instance = null; // <2>

	@SuppressWarnings("InstantiationOfUtilityClass")
	public static LazyInstantiationByDCL getInstance() { // <3>
		if (instance == null) { // <4>
			synchronized (LazyInstantiationByDCL.class) { // <5>
				if (instance == null) { // <6>
					instance = new LazyInstantiationByDCL();
				}
			}
		}
		return instance;
	}
}
