package com.ken.Utils;

/**
 * @author admin@devwang.cn
 * @version 1.0
 * @Description 线程本地StringBuilder
 * @date 2017年5月6日 下午4:01:21
 * @since 1.0
 */
public class ThreadLocalStringBuilder {

	public static final ThreadLocal<StringBuilder> threadLocalStringBuilder = new ThreadLocal<StringBuilder>();

	/**
	 * @author admin@devwang.cn
	 * @Description 无参构造获取30字节长度的StringBuilder
	 * @date 2017年5月6日 下午4:12:18
	 * @return StringBuilder
	 */
	public static StringBuilder get() {
		return get(30);
	}

	/**
	 * @author admin@devwang.cn
	 * @Description 获取自定义长度的StringBuilder
	 * @date 2017年5月6日 下午4:12:46
	 * @param length
	 * @return StringBuilder
	 */
	public static StringBuilder get(int length) {
		StringBuilder builder = threadLocalStringBuilder.get();
		if (builder == null) {
			builder = new StringBuilder(length);
			threadLocalStringBuilder.set(builder);
		} else {
			builder.delete(0, builder.length());
		}
		return builder;
	}
}
