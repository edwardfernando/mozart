package mozart.api.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "campaign_category")
public class CampaignCategory extends Model {

	@XmlElement
	@HttpParam
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;

	@XmlElement
	@HttpParam
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
