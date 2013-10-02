package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import mozart.common.annotation.Date;
import mozart.common.annotation.IntegerOnly;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import com.google.common.collect.Maps;

public class AnnotationCheckerUtil {

	private static String PACKAGE = "mozart";
	private static String THRESHOLD_MESSAGE = "[Class]";
	private static String EMPTY_SPACE = "  ";
	private static Map<Class<? extends Annotation>, Checker> checkers = Maps.newHashMap();
	static {
		checkers.put(Date.class, new DateChecker());
		checkers.put(IntegerOnly.class, new IntegerOnlyChecker());
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("Scanning Annotation ...");
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
}
