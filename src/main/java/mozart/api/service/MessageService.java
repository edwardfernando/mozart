package mozart.api.service;

import mozart.api.dao.AbstractDAO;
import mozart.api.dao.MessageDAO;
import mozart.api.model.Message;

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

}
