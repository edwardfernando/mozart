package api.mozart.insertdata;

import java.net.URISyntaxException;

import mozart.api.controller.UserController;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;

public class TestInsertData {

	public void testInsertUserData() throws URISyntaxException {

		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
		dispatcher.getRegistry().addSingletonResource(new UserController());

		MockHttpRequest request = MockHttpRequest.get("/user/save?id=FIRST_USER_ID");

		dispatcher.invoke(request, new MockHttpResponse());

	}
}
