package mozart.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Badge {

	private String id;
	private String name;
	private String description;
	private String iconUrl;
	private Boolean isActive;

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
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

	public String getIconUrl() {
		return iconUrl;
	}

	@XmlElement
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	@XmlElement
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
