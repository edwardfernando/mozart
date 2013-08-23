package mozart.api.controller;

import java.util.List;

import mozart.api.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/message")
public class MessageController extends mozart.api.controller.Controller<Message> {

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
