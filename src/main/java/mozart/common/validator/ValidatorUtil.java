package mozart.common.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;

import mozart.common.annotation.Email;
import mozart.common.annotation.ExpectParam;
import mozart.common.annotation.HttpParam;
import mozart.common.annotation.IntegerOnly;
import mozart.common.annotation.Length;
import mozart.common.annotation.Max;
import mozart.common.annotation.NotEmpty;
import mozart.common.annotation.NotNull;
import mozart.common.annotation.NumberOnly;
import mozart.common.annotation.Pattern;
import mozart.common.exception.MozartException;

import com.google.common.collect.Maps;

public class ValidatorUtil {

	private static ValidatorUtil instance;
	private static Map<Class<? extends Annotation>, Validator> validators = Maps.newHashMap();
	public static final String REQUIRED_PARAM_MESSAGE = "Expecting parameter %s at URI %s";
	static {
		validators.put(Email.class, new EmailValidator());
		validators.put(IntegerOnly.class, new IntegerOnlyValidator());
		validators.put(Length.class, new LengthValidator());
		validators.put(Max.class, new MaxValidator());
		validators.put(Min.class, new MinValidator());
		validators.put(NotEmpty.class, new NotEmptyValidator());
		validators.put(NotNull.class, new NotNullValidator());
		validators.put(NumberOnly.class, new NumberOnlyValidator());
		validators.put(Pattern.class, new PatternValidator());
	}

	public void validateRequest(ExpectParam expectParam, HttpServletRequest request)
	        throws Exception {

		for (Field field : expectParam.value().getDeclaredFields()) {

			HttpParam httpParam = field.getAnnotation(HttpParam.class);
			if (httpParam == null) {
				continue;
			}

			String httpParamValue = httpParam.value();
			String parameterName = httpParamValue.isEmpty() ? field.getName() : httpParamValue;
			String parameterValue = request.getParameter(parameterName);

			if (parameterValue == null) {
				throw new MozartException(String.format(
				    REQUIRED_PARAM_MESSAGE,
				    parameterName,
				    request.getPathInfo()));
			}

			for (Annotation annot : field.getAnnotations()) {
				if (validators.containsKey(annot.annotationType())) {
					validators.get(annot.annotationType()).validate(
					    annot,
					    parameterName,
					    parameterValue,
					    request);
				}

			}

		}

		for (String opt : expectParam.optional()) {
			String parameterValue = request.getParameter(opt);
			if (parameterValue == null) {
				throw new MozartException(String.format(
				    REQUIRED_PARAM_MESSAGE,
				    opt,
				    request.getPathInfo()));
			}
		}

	}

	public void registerValidator(Class<? extends Annotation> annotationClass, Validator validator) {
		validators.put(annotationClass, validator);
	}

	public static ValidatorUtil instance() {
		if (instance == null) {
			instance = new ValidatorUtil();
		}
		return instance;
	}

}
