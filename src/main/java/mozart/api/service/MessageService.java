package mozart.api.service;

import java.util.List;

import mozart.api.dao.MessageDAO;
import mozart.api.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService implements Service<Message> {

	@Autowired
	private MessageDAO dao;

	@Override
	public List<Message> loadAll() {
		return null;
	}

	@Override
	public Message loadById(String id) {
		return dao.loadById(id);
	}

	@Override
	public void save(Message model) {
		dao.save(model);
	}

	@Override
	public void delete(Message model) {
		dao.delete(model);
	}

	@Override
	public Message update(Message model) {
		// TODO Auto-generated method stub
		return null;
	}

}
