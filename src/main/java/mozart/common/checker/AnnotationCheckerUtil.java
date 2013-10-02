package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import mozart.common.annotation.Date;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import com.google.common.collect.Maps;

public class AnnotationCheckerUtil {

	private static String EMPTY_SPACE = "  ";
	private static Map<Class<? extends Annotation>, Checker> checkers = Maps.newHashMap();
	static {
		checkers.put(Date.class, new DateChecker());
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("Scanning Annotation ...");
		Set<Class<? extends Object>> classList = new Reflections(
		                                                         "mozart",
		                                                         new SubTypesScanner(false),
		                                                         ClasspathHelper.forClassLoader())
		    .getSubTypesOf(Object.class);

		for (Class<? extends Object> klass : classList) {
			System.out.println(EMPTY_SPACE + "[CLASS] " + klass.getName());

			for (Field field : klass.getDeclaredFields()) {
				for (Annotation annot : field.getAnnotations()) {
					if (checkers.containsKey(annot.annotationType())) {
						checkers.get(annot.annotationType()).check(field, annot);
					}
				}
			}

		}

	}
}
