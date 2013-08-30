package mozart.api.dao;

import mozart.api.model.Attachment;

public class AttachmentDAO extends AbstractDAO<Attachment> {

	@Override
	public Class<Attachment> getModel() {
		return Attachment.class;
	}

}
