package mozart.api.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.api.model.Message;

@XmlRootElement()
public class MessageWrapper {
	private List<Message> messages = new ArrayList<Message>();
	private int count;

	public MessageWrapper() {
	}

	public MessageWrapper(List<Message> messages) {
		this.messages = messages;
		this.count = messages.size();
	}

	public List<Message> getMessages() {
		return messages;
	}

	@XmlElement(name = "message-list")
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getCount() {
		return count;
	}

	@XmlElement(name = "messages-count")
	public void setCount(int count) {
		this.count = count;
	}

}
