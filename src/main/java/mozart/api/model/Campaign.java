package mozart.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.core.db.model.Model;

@XmlRootElement
public class Campaign extends Model {

	private String caption;
	private String name;
	private String description;
	private Date validFrom;
	private Date validUntil;
	private String token;
	private String status;
	private List<Message> messages = new ArrayList<Message>();

	public String getCaption() {
		return caption;
	}

	@XmlElement
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	@XmlElement
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	@XmlElement
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public String getToken() {
		return token;
	}

	@XmlElement
	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Message> getMessages() {
		return messages;
	}

	@XmlElement
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
