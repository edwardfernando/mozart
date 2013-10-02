package mozart.common.checker;

import java.util.Date;

public class DateChecker extends Checker {

	@Override
	public Class<?>[] expectedType() {
		return new Class<?>[] { Date.class };
	}

}
