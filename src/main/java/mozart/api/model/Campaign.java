package mozart.api.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import mozart.core.annotation.HttpParam;
import mozart.core.api.Model;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "campaign")
public class Campaign extends Model {

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "advertiser_id")
	private Advertiser advertiser;

	@Column
	@XmlElement
	@HttpParam
	private String name;

	@Column
	@XmlElement
	@HttpParam
	private String description;

	@Column
	@XmlElement
	@HttpParam
	private String hashTags;

	@Column(name = "logo_url")
	@XmlElement
	@HttpParam
	private String logoUrl;

	@Column(name = "banner_url")
	@XmlElement
	@HttpParam
	private String bannerUrl;

	@Column(name = "start_date")
	@XmlElement
	@HttpParam
	private Date startDate;

	@Column(name = "end_date")
	@XmlElement
	@HttpParam
	private Date endDate;

	@XmlElement
	@OneToMany(mappedBy = "campaign")
	private Set<CampaignCategory> campaignCategories;

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHashTags() {
		return hashTags;
	}

	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<CampaignCategory> getCampaignCategories() {
		return campaignCategories;
	}

	public void setCampaignCategories(Set<CampaignCategory> campaignCategories) {
		this.campaignCategories = campaignCategories;
	}

}
