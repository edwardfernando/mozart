package mozart.common.checker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import mozart.common.exception.MozartException;

public abstract class Checker {

	public abstract void check(Field field, Annotation annot) throws MozartException;

}
