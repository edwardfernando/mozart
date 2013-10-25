package mozart.api.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.core.annotation.HttpParam;
import mozart.core.api.Model;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "category")
public class Category extends Model {

	@Column
	@XmlElement
	@HttpParam
	private String name;

	@Column
	@XmlElement
	@HttpParam
	private String code;

	@OneToMany(mappedBy = "category")
	private Set<CampaignCategory> campaignCategories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<CampaignCategory> getCampaignCategories() {
		return campaignCategories;
	}

	public void setCampaignCategories(Set<CampaignCategory> campaignCategories) {
		this.campaignCategories = campaignCategories;
	}

}
