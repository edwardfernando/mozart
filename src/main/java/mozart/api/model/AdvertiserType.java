package mozart.api.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "advertiser_type")
@XmlRootElement
public class AdvertiserType extends Model {

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "type")
	private Set<Advertiser> advertisers;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Set<Advertiser> getAdvertisers() {
		return advertisers;
	}

	@XmlElement
	public void setAdvertisers(Set<Advertiser> advertisers) {
		this.advertisers = advertisers;
	}

}
