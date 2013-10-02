package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class Checker {

	public abstract void check(Field field, Annotation annot) throws Throwable;

}
