package mozart.api.controller;

import javax.validation.Valid;

import mozart.api.model.CollectionWrapper;
import mozart.api.model.Message;
import mozart.api.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message/*")
public class MessageController extends mozart.api.controller.Controller<Message> {

	@Autowired
	private MessageService service;

	@RequestMapping("/")
	@Override
	public CollectionWrapper loadAll() {
		CollectionWrapper wrapper = new CollectionWrapper();
		service.loadAll();
		return wrapper;
	}

	@RequestMapping("/byid")
	@Override
	@ResponseBody
	public Message loadById(@RequestParam("id") String id) {
		Message m = service.loadById(id);
		System.out.println("Result from mongo : " + m.getId() + "/" + m.getMessage());
		return m;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Message testSave(@RequestBody @Valid Message message) {
		return message;
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
