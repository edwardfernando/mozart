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
	private Message rootMessage;
	private User member;
	private Campaign campaign;
	private List<MediaNetwork> mediaNetworks = new ArrayList<MediaNetwork>();
	private List<Attachment> attachments = new ArrayList<Attachment>();
	private List<MessageFeedback> feeedbacks = new ArrayList<MessageFeedback>();

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

	public User getMember() {
		return member;
	}

	@XmlElement
	public void setMember(User member) {
		this.member = member;
	}

	public Message getRootMessage() {
		return rootMessage;
	}

	@XmlElement
	public void setRootMessage(Message rootMessage) {
		this.rootMessage = rootMessage;
	}

	public List<MessageFeedback> getFeeedbacks() {
		return feeedbacks;
	}

	@XmlElement
	public void setFeeedbacks(List<MessageFeedback> feeedbacks) {
		this.feeedbacks = feeedbacks;
	}

	public List<MediaNetwork> getMediaNetworks() {
		return mediaNetworks;
	}

	@XmlElement
	public void setMediaNetworks(List<MediaNetwork> mediaNetworks) {
		this.mediaNetworks = mediaNetworks;
	}

}
