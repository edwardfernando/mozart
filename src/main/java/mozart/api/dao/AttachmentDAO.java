package mozart.api.dao;

import mozart.api.model.Attachment;

import org.springframework.stereotype.Component;

@Component
public class AttachmentDAO extends AbstractDAO<Attachment> {

	@Override
	public Class<Attachment> getModel() {
		return Attachment.class;
	}

}
