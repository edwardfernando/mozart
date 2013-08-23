package mozart.api.controller;

import mozart.api.model.Message;
import mozart.api.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	private MessageService service;

	@RequestMapping("/{id}")
	@ResponseBody
	public Message loadById(@PathVariable String id) {
		return new Message();
	}

}
