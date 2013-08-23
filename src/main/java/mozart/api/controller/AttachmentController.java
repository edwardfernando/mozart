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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attachment loadById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Attachment model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Attachment update(Attachment model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Attachment model) {
		// TODO Auto-generated method stub

	}

}
