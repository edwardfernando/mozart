package mozart.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private String id;
	private String message;
	private Date date;
	private Campaign campaign;
	private List<Attachment> attachments = new ArrayList<Attachment>();

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	@XmlElement
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	@XmlElement
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

}
