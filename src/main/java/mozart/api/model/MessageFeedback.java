package mozart.api.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.core.db.model.Model;

@XmlRootElement
public class MessageFeedback extends Model {

	enum FeedbackType {
		upvote, downvote, badMessage
	}

	private FeedbackType feedbackType;
	private User member;
	private Date date;

	public FeedbackType getFeedbackType() {
		return feedbackType;
	}

	@XmlElement
	public void setFeedbackType(FeedbackType feedbackType) {
		this.feedbackType = feedbackType;
	}

	public User getMember() {
		return member;
	}

	@XmlElement
	public void setMember(User member) {
		this.member = member;
	}

	public Date getDate() {
		return date;
	}

	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}

}
