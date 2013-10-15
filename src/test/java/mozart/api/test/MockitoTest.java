package mozart.api.test;

import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class MockitoTest extends TestCase {

	@Test
	public void testMockitor() throws URISyntaxException {
		LoggerFactory.getLogger(this.getClass()).debug("ini test aja : {}", "AHAHAHA");
	}
}
