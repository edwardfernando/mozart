package mozart.api.service;

import javax.servlet.http.HttpServletRequest;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.MessageDAO;
import mozart.api.model.Message;
import mozart.common.exception.MozartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService extends Service<Message> {

	@Autowired
	private MessageDAO dao;

	@Override
	protected AbstractDAO<Message> getDao() {
		return dao;
	}

	@Override
	public void save(HttpServletRequest request) throws MozartException {
		Message msg = new Message();
		msg.setMessage(request.getParameter("message"));
		dao.save(msg);
	}

}
