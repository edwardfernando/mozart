package mozart.common.transformer;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.HttpParam;
import mozart.common.exception.MozartException;

public class TransformerUtil {

	private static TransformerUtil instance;
	static {

	}

	private TransformerUtil() {
	}

	public <T> T fromRequest(HttpServletRequest request, Class<T> clazz) throws MozartException {
		T object = null;
		try {
			object = clazz.newInstance();

			for (Field field : clazz.getDeclaredFields()) {
				HttpParam httpParam = field.getAnnotation(HttpParam.class);
				String parameterName = httpParam == null ? field.getName() : httpParam.value();
				String parameterValue = request.getParameter(parameterName);

			}

		} catch (Exception e) {
			throw new MozartException(e);
		}

		return null;
	}

	public static TransformerUtil instance() {
		if (instance == null) {
			instance = new TransformerUtil();
		}
		return instance;
	}
}
