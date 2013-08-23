package mozart.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Attachment {

	private String name;
	private String url;
	private Message message;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}

	public Message getMessage() {
		return message;
	}

	@XmlElement
	public void setMessage(Message message) {
		this.message = message;
	}

}
