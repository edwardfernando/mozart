package mozart.api.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MediaNetworkProperty {

	private String propertyName;
	private String value;
	private Date createDate;

	public String getPropertyName() {
		return propertyName;
	}

	@XmlElement
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getValue() {
		return value;
	}

	@XmlElement
	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreateDate() {
		return createDate;
	}

	@XmlElement
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
