package mozart.api.controller;

import mozart.api.model.Attachment;
import mozart.api.model.CollectionWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attachment")
public class AttachmentController extends mozart.api.controller.Controller<Attachment> {

	@Override
	public Attachment loadById(String id) {
		return null;
	}

	@Override
	public void save(Attachment model) {

	}

	@Override
	public Attachment update(Attachment model) {
		return null;
	}

	@Override
	public void delete(Attachment model) {
	}

	@Override
	public CollectionWrapper loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
