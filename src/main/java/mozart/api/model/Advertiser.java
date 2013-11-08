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
import javax.xml.bind.annotation.XmlTransient;

import mozart.core.annotation.HttpParam;
import mozart.core.annotation.Length;
import mozart.core.api.Model;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "advertiser")
public class Advertiser extends Model {

	@Column
	@XmlElement
	@HttpParam
	private String organizationName;

	@Column
	@XmlElement
	@HttpParam
	private String address;

	@Column
	@XmlElement
	@HttpParam
	private String country;

	@Column
	@XmlElement
	@HttpParam
	private String state;

	@Column
	@XmlElement
	@HttpParam
	private String city;

	@Column
	@XmlElement
	@HttpParam
	private String phoneCountryCode;

	@Column
	@XmlElement
	@HttpParam
	private String phoneAreaCode;

	@Column
	@XmlElement
	@HttpParam
	private String phoneNumber;

	@Column
	@XmlElement
	@HttpParam
	private String faxCountryCode;

	@Column
	@XmlElement
	@HttpParam
	private String faxAreaCode;

	@Column
	@XmlElement
	@HttpParam
	private String faxNumber;

	@Column
	@XmlElement
	@HttpParam
	private String email;

	@Column
	@XmlTransient
	@HttpParam
	private String password;

	@XmlTransient
	@Column
	private String salt;

	@Column
	@XmlElement
	@HttpParam
	@Length(minLength = 3, maxLength = 3)
	private String advertiserType;

	@XmlTransient
	@OneToMany(mappedBy = "advertiser")
	private Set<Campaign> campaigns;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getPhoneAreaCode() {
		return phoneAreaCode;
	}

	public void setPhoneAreaCode(String phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxCountryCode() {
		return faxCountryCode;
	}

	public void setFaxCountryCode(String faxCountryCode) {
		this.faxCountryCode = faxCountryCode;
	}

	public String getFaxAreaCode() {
		return faxAreaCode;
	}

	public void setFaxAreaCode(String faxAreaCode) {
		this.faxAreaCode = faxAreaCode;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Set<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getAdvertiserType() {
		return advertiserType;
	}

	public void setAdvertiserType(String advertiserType) {
		this.advertiserType = advertiserType;
	}

}
