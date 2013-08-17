package api.mozart.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlRootElement(name = "instrument")
public class Instrument {
	@Id
	String id;
	String name;
	String key;
	int quality;

	public String getId() {
		return id;
	}

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

	public String getKey() {
		return key;
	}

	@XmlElement
	public void setKey(String key) {
		this.key = key;
	}

	public int getQuality() {
		return quality;
	}

	@XmlElement
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
