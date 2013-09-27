package mozart.common.aop;

import javax.servlet.http.HttpServletRequest;

import mozart.common.annotation.ExpectParam;
import mozart.common.validator.ValidatorUtil;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ExpectsAOP {

	@Before("@annotation(expects) && args(request,..)")
	public void inspect(ExpectParam expects, HttpServletRequest request) throws Exception {
		ValidatorUtil.instance().validateRequest(expects, request);
	}

}
