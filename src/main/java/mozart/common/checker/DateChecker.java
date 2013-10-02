package mozart.common.checker;

import java.util.Date;
import java.util.Set;

public class DateChecker extends Checker {

	@Override
	public Set<Class<?>> supportedTypes() {
		return addSupportedType(Date.class);
	}
}
