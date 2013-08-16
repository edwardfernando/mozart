package api.mozart.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "instrument")
public class Instrument {
	String name;
	String key;
	int quality;

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
