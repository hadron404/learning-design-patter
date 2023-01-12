package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

	private ContainerSingleton() {

	}

	private static final Map<String, Object> CONTAINER = new ConcurrentHashMap<>();

	public static Object getInstance(String className) {
		synchronized (CONTAINER) {
			if (!CONTAINER.containsKey(className)) {
				Object o = null;
				try {
					o = Class.forName(className).getDeclaredConstructor().newInstance();
					CONTAINER.put(className, o);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return o;
			} else {
				return CONTAINER.get(className);
			}
		}
	}
}
