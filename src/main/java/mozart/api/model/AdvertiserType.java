package mozart.api.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import mozart.core.api.Model;

@Entity(name = "advertiser_type")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AdvertiserType extends Model {

	@XmlElement
	@Column(name = "name")
	private String name;

	@XmlTransient
	@OneToMany(mappedBy = "type")
	private Set<Advertiser> advertisers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Advertiser> getAdvertisers() {
		return advertisers;
	}

	public void setAdvertisers(Set<Advertiser> advertisers) {
		this.advertisers = advertisers;
	}

}
