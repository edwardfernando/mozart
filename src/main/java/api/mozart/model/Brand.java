package api.mozart.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brand")
@XmlType(propOrder = { "name", "manufacture" })
public class Brand {

	private String name;
	private String manufacture;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	@XmlElement
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

}
