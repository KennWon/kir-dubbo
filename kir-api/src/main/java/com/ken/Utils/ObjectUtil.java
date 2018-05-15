package com.ken.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ObjectUtil是对象相关操作工具类
 * 
 * @Description 对象相关操作工具类，如对象的序列化和反序列化
 * @author lidujun
 * @date 2016-5-19
 * @updateby
 * @updatedate
 * @version 1.0
 * @since 1.0
 */
public class ObjectUtil {
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

	/**
	 * 对象的序列化
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] serialize(Object value) {
		if (value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] rv = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(value);
			os.close();
			bos.close();
			rv = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Serialization exception", e);
		} finally {
			try {
				if (os != null)
					os.close();
				if (bos != null)
					bos.close();
			} catch (Exception e2) {
				logger.error("Serialization exception", e2);
			}
		}
		return rv;
	}

	/**
	 * 对象反序列化
	 * 
	 * @param in
	 * @return
	 */
	public static Object deserialize(byte[] in) {
		Object rv = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				rv = is.readObject();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Exception occurred in the", e);
		} finally {
			try {
				if (is != null)
					is.close();
				if (bis != null)
					bis.close();
			} catch (Exception e2) {
				logger.error("Exception occurred in the", e2);
			}
		}
		return rv;
	}

	public static Object copyBySerialize(Object src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		return in.readObject();
	}

	public static void copy(List src, List dest) {
		for (int i = 0; i < src.size(); i++) {
			Object obj = src.get(i);
			if (obj instanceof List) {
				dest.add(new ArrayList());
				copy((List) obj, (List) ((List) dest).get(i));
			} else {
				dest.add(obj);
			}
		}
	}

	/**
	 * 对象转map 要求必须要有get
	 * 
	 * @param obj
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */


}
