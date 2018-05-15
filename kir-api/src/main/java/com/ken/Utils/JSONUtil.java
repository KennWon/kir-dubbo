package com.ken.Utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JSONUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	private static final JsonFactory jsonFactory = new JsonFactory();

	private static final Logger log = LoggerFactory.getLogger(JSONUtil.class);

	static {
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.getSerializerProvider().setNullValueSerializer(new JsonNullSerializer());
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		// mapper.enableDefaultTyping();
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * 是不是json格式
	 * 
	 * @param json
	 * @return
	 */
	public static boolean isJson(String json) {
		Object obj = fromJson(json, Object.class);
		if (obj != null) {
			return true;
		}
		return false;
	}

	public static <T> T fromJson(String jsonAsString, Class<T> pojoClass) {
		try {
			return mapper.readValue(jsonAsString, pojoClass);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static <T> T fromJson(String jsonAsString, TypeReference<T> typeRef) {
		try {
			return mapper.readValue(jsonAsString, typeRef);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * json反序列到集合
	 * 
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> json2List(String json, Class<T> clazz) {
		List<T> list = null;
		if (json != null) {
			try {
				list = mapper.readValue(json,
						TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz));
			} catch (IOException e) {
				log.error("json to List exception. json:" + json, e);
			}
		}
		return list;
	}

	public static String toJson(Object pojo) {
		return toJson(pojo, false);
	}

	public static String toJson(Object pojo, boolean prettyPrint) {
		try {
			StringWriter sw = new StringWriter();
			JsonGenerator jg = jsonFactory.createJsonGenerator(sw);
			if (prettyPrint) {
				jg.useDefaultPrettyPrinter();
			}
			mapper.writeValue(jg, pojo);
			return sw.toString();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static void writeJson(Object pojo, Writer writer) {
		try {
			JsonGenerator jg = jsonFactory.createJsonGenerator(writer);
			mapper.writeValue(jg, pojo);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Description:移除Json中不需要的字段信息
	 */
	public static String removeColumn(List<?> list, SimplePropertyPreFilter filter) {

		return JSON.toJSONString(list, filter);
	}

	/**
	 * 自定义的null序列化，把null转为空字符串
	 */
	public static final class JsonNullSerializer extends JsonSerializer<Object> {

		@Override
		public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException {
			gen.writeString(StringUtils.EMPTY);
		}

	}

	public static Map<String, Object> toMap(String json) throws IOException {
		return mapper.readValue(json, Map.class);
	}
}
