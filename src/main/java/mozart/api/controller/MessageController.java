package mozart.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mozart.api.model.Message;
import mozart.api.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/message")
public class MessageController extends mozart.api.controller.Controller<Message> {

	@Autowired
	private MessageService service;

	@RequestMapping("/")
	@Override
	public List<Message> loadAll() {
		System.out.println("hoiii");
		return new ArrayList<Message>();
	}

	@Override
	@ResponseBody
	@RequestMapping("/{id}")
	public Message loadById(@PathVariable("id") String id) {
		Message m = service.loadById(id);
		System.out.println("Result from mongo : " + m.getId() + "/" + m.getMessage());
		return m;
	}

	@ResponseBody
	@RequestMapping("/testsave")
	public Message testSave() {
		Message m = new Message();
		m.setDate(new Date());
		m.setMessage("Hello, Folks! Apa kabar?");

		service.save(m);

		return m;
	}

	@ResponseBody
	@RequestMapping("/testupdate/{id}")
	public Message testUpdate(@PathVariable("id") String id) {
		Message m = service.loadById(id);

		m.setMessage("Message baru coiiiiiiiii ");
		service.save(m);
		return m;
	}

	@ResponseBody
	@RequestMapping("/testdelete/{id}")
	public Message testDelete(@PathVariable("id") String id) {
		service.delete(service.loadById(id));

		return new Message();
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
