package mozart.common.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.Expects;
import mozart.common.exception.MozartException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExpectsAOP {

	@Before("@annotation(expects) && args(request,..)")
	public void inspect(Expects expects, HttpServletRequest request) throws MozartException {
		for (String expectedValue : expects.value()) {
			if (request.getParameter(expectedValue) == null) {
				throw new MozartException("Expected " +
				                          request.getMethod() +
				                          " parameter '" +
				                          expectedValue +
				                          "' at URI " +
				                          request.getPathInfo() +
				                          ". Parameter needed for this URI : " +
				                          Arrays.toString(expects.value()));

			}
		}
	}

}
