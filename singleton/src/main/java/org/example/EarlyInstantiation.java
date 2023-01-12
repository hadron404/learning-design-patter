package org.example;

/**
 * 单例模式饿汉式实现代码示例
 * 饿汉式单例模式在类加载时就立即初始化，并且创建单例对象。
 * 它是绝对的线程安全、在线程还没出现以前就实现了，不可能存在访问安全问题
 * 利与弊
 * 利： 没有增加任何锁，执行效率高，用户体验较懒汉式好
 * 弊：类加载的时候就初始化了，用不用都进行，会浪费内存
 * 已知的应用场景
 * Spring中的 IOC 容器 ApplicationContext
 * 适用场景
 * 适用于单例对象较少的情况
 * */
public class EarlyInstantiation {
	// 该警告原因：由于类中无非静态变量或方法（IDEA 认为一个类中只包含了静态变量、静态方法，没有必要 new 一个对象）
	@SuppressWarnings("InstantiationOfUtilityClass")
	private static final EarlyInstantiation SOLE_INSTANCE = new EarlyInstantiation(); // <1>

	private EarlyInstantiation() {// <2>
	}

	public static EarlyInstantiation getInstance() { // <3>
		return SOLE_INSTANCE;
	}
}
