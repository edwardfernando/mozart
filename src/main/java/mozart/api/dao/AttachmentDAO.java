package mozart.api.dao;

import mozart.api.model.Attachment;

public class AttachmentDAO extends AbstractDAO<Attachment> {

	@Override
	protected Class<Attachment> getModel() {
		return Attachment.class;
	}

}
