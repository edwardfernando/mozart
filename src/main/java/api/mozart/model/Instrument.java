package api.mozart.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlRootElement(name = "instrument")
@XmlType(propOrder = { "name", "key", "quality", "brands" })
public class Instrument {
	@Id
	String id;
	String name;
	String key;
	int quality;
	List<Brand> brands = new ArrayList<Brand>();

	public String getId() {
		return id;
	}

	@XmlAttribute
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

	public List<Brand> getBrands() {
		return brands;
	}

	@XmlElement
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

}
