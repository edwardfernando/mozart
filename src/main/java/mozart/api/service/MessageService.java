package mozart.api.service;

import java.util.List;

import mozart.api.model.Message;

import org.springframework.stereotype.Component;

@Component
public class MessageService implements Service<Message> {

	@Override
	public List<Message> loadAll() {
		return null;
	}

	@Override
	public Message loadById(String id) {
		return null;
	}

	@Override
	public void save(Message model) {

	}

	@Override
	public Message update(Message model) {
		return null;
	}

	@Override
	public void delete(Message model) {

	}

}