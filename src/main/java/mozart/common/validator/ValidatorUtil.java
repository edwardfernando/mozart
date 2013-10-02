package mozart.common.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;

import mozart.common.annotation.Date;
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
import mozart.common.exception.Error;
import mozart.common.exception.ErrorWrapper;
import mozart.common.exception.MozartException;

import com.google.common.collect.Maps;

public class ValidatorUtil {

	private static ValidatorUtil instance;
	public static final String REQUIRED_PARAM_MESSAGE = "NOT-FOUND : Parameter %s";

	private static Map<Class<? extends Annotation>, Validator> validators = Maps.newHashMap();
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
		validators.put(Date.class, new DateValidator());
	}

	private ValidatorUtil() {
	}

	public void validateRequest(ExpectParam expectParam, HttpServletRequest request)
	        throws Exception {

		ErrorWrapper wrapper = new ErrorWrapper();

		// Validate mandatory parameters
		for (Field field : expectParam.value().getDeclaredFields()) {

			HttpParam httpParam = field.getAnnotation(HttpParam.class);
			if (httpParam == null) {
				continue;
			}

			String httpParamValue = httpParam.value();
			String parameterName = httpParamValue.isEmpty() ? field.getName() : httpParamValue;
			String parameterValue = request.getParameter(parameterName);

			if (parameterValue == null) {
				wrapper.registerError(new Error(parameterName, String.format(
				    REQUIRED_PARAM_MESSAGE,
				    parameterName)));
			} else {
				// If not null, then check for annotation
				for (Annotation annot : field.getAnnotations()) {
					if (validators.containsKey(annot.annotationType())) {
						validators.get(annot.annotationType()).validate(
						    wrapper,
						    annot,
						    parameterName,
						    parameterValue);
					}
				}
			}
		}

		// Validate optional parameteres
		for (String opt : expectParam.optional()) {
			String parameterValue = request.getParameter(opt);
			if (!opt.isEmpty() && parameterValue == null) {
				wrapper.registerError(new Error(opt, String.format(REQUIRED_PARAM_MESSAGE, opt)));
			}
		}

		wrapper.setHttpMethod(request.getMethod());
		wrapper.setPathLocation(request.getPathInfo());

		if (wrapper.hasError()) {
			throw new MozartException(wrapper);
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
