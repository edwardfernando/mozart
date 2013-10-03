package mozart.common.transformer;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.HttpParam;
import mozart.common.exception.MozartException;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class TransformerUtil {

	private static TransformerUtil instance;
	private static Map<Class<?>, Transformer<?>> transformers = Maps.newHashMap();
	static {
		transformers.put(Boolean.class, new BooleanTransformer());
		transformers.put(Date.class, new DateTransformer());
		transformers.put(Integer.class, new IntegerTransformer());
		transformers.put(Long.class, new LongTransformer());
		transformers.put(String.class, new StringTransformer());
	}

	private TransformerUtil() {
	}

	public <T> T fromRequest(HttpServletRequest request, Class<T> clazz) throws MozartException {
		T newInstance = null;
		try {
			newInstance = clazz.newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				HttpParam httpParam = field.getAnnotation(HttpParam.class);

				if (httpParam == null) {
					continue;
				}

				String parameterName = StringUtils.isEmpty(httpParam.value()) ? field.getName() : httpParam
				    .value();
				String value = request.getParameter(parameterName);

				Object fieldValue = null;

				Transformer<?> transformer = transformers.get(field.getType());
				if (transformer != null) {
					fieldValue = transformer.transform(field, value);
				}

				field.setAccessible(true);
				field.set(newInstance, fieldValue);
			}

		} catch (Exception e) {
			throw new MozartException(e);
		}

		return newInstance;
	}

	public void registerTransformer(Class<?> type, Transformer<?> transformer) {
		transformers.put(type, transformer);
	}

	public static TransformerUtil instance() {
		if (instance == null) {
			instance = new TransformerUtil();
		}
		return instance;
	}
}
