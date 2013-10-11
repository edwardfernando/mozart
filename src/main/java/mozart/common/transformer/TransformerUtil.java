package mozart.common.transformer;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.HttpParam;
import mozart.common.exception.MozartException;
import mozart.common.pagination.FilterCriteria;
import mozart.common.pagination.FilterableQuery;

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

	public FilterableQuery toFilterableQuery(FilterCriteria filterCriteria,
	        Class<? extends FilterableQuery> filterableQuery) throws MozartException {
		FilterableQuery instance = null;
		try {

			instance = filterableQuery.newInstance();
			instance.setFilterCriteria(filterCriteria);

		} catch (InstantiationException e) {
			throw new MozartException(e);
		} catch (IllegalAccessException e) {
			throw new MozartException(e);
		} catch (Exception e) {
			throw new MozartException(e);
		}
		return instance;
	}

	public FilterCriteria toFilterCriteria(HttpServletRequest request,
	        Class<? extends FilterCriteria> filterCriteria) throws MozartException {
		FilterCriteria instance = null;
		try {

			instance = filterCriteria.newInstance();
			for (Field field : filterCriteria.getDeclaredFields()) {
				field.setAccessible(true);
				field.set(instance, transform(request, field, field.getName()));
			}

			String page = request.getParameter("page");
			if (StringUtils.isBlank(page)) {
				page = "1";
			}

			instance.setMax(10);
			instance.setPage(Integer.valueOf(page));

		} catch (MozartException e) {
			throw e;
		} catch (InstantiationException e) {
			throw new MozartException(e);
		} catch (IllegalAccessException e) {
			throw new MozartException(e);
		} catch (Exception e) {
			throw new MozartException(e);
		}

		return instance;
	}

	public <T> T toModel(HttpServletRequest request, Class<T> clazz) throws MozartException {
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

				field.setAccessible(true);
				field.set(newInstance, transform(request, field, parameterName));
			}

		} catch (MozartException e) {
			throw e;
		} catch (InstantiationException e) {
			throw new MozartException(e);
		} catch (IllegalAccessException e) {
			throw new MozartException(e);
		} catch (Exception e) {
			throw new MozartException(e);
		}

		return newInstance;
	}

	private Object transform(HttpServletRequest request, Field field, String parameterName)
	        throws MozartException {

		String value = request.getParameter(parameterName);

		Transformer<?> transformer = transformers.get(field.getType());
		if (transformer == null) {
			throw new MozartException(String.format(
			    "Transformer for %s type not found. Parameter : %s",
			    field.getType().getName(),
			    parameterName));
		}

		Object fieldValue = transformer.transform(field, value);
		return fieldValue;
	}

	public void registerTransformer(Class<?> type, Transformer<?> transformer) {
		transformers.put(type, transformer);
	}

	public void setTransformers(Map<String, Transformer<?>> transformers)
	        throws ClassNotFoundException {
		for (Map.Entry<String, Transformer<?>> entry : transformers.entrySet()) {
			registerTransformer(Class.forName(entry.getKey()), entry.getValue());
		}
	}

	public static TransformerUtil instance() {
		if (instance == null) {
			instance = new TransformerUtil();
		}
		return instance;
	}
}
