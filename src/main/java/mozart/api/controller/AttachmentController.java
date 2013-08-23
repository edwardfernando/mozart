package mozart.api.controller;

import java.util.List;

import mozart.api.model.Attachment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/attachment")
public class AttachmentController extends mozart.api.controller.Controller<Attachment> {

	@Override
	public List<Attachment> loadAll() {
		return null;
	}

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

}
