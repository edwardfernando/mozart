package mozart.common.annotation.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import mozart.common.annotation.Date;

import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import com.google.common.collect.Maps;

public class AnnotationCheckerUtil {

	private static AnnotationCheckerUtil instance;
	private static String PACKAGE = "mozart";
	private static String THRESHOLD_MESSAGE = "[Class]";
	private static String EMPTY_SPACE = "  ";
	private static Map<Class<? extends Annotation>, Checker> checkers = Maps.newHashMap();
	static {
		checkers.put(Date.class, new DateChecker());
	}

	private AnnotationCheckerUtil() {

	}

	public void registerChecker(Class<? extends Annotation> annotationClass, Checker checker) {
		checkers.put(annotationClass, checker);
	}

	public void check() throws Throwable {
		Set<Class<? extends Object>> classList = new Reflections(
		                                                         PACKAGE,
		                                                         new SubTypesScanner(false),
		                                                         ClasspathHelper.forClassLoader())
		    .getSubTypesOf(Object.class);

		for (Class<? extends Object> klass : classList) {
			System.out.println(EMPTY_SPACE + THRESHOLD_MESSAGE + klass.getName());

			for (Field field : klass.getDeclaredFields()) {
				for (Annotation annot : field.getAnnotations()) {
					if (checkers.containsKey(annot.annotationType())) {
						checkers.get(annot.annotationType()).check(klass, field, annot);
					}
				}
			}

		}
	}

	public static AnnotationCheckerUtil instance() {
		if (instance == null) {
			instance = new AnnotationCheckerUtil();
		}
		return instance;
	}

	public static void main(String[] args) throws Throwable {
		if (StringUtils.isBlank(PACKAGE)) {
			System.out.println("No package to scan. Skip scanning.");
			return;
		}
		System.out.println("Scanning Annotation ...");
		AnnotationCheckerUtil.instance().check();
	}
}
