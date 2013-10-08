package mozart.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.common.annotation.HttpParam;

@XmlRootElement
@Entity(name = "advertiser")
public class Advertiser extends Model {

	@Column(name = "organizationName")
	@HttpParam("organization_name")
	private String organizationName;

	@HttpParam
	@ManyToOne
	@JoinColumn(name = "advertiser_type_id")
	private AdvertiserType type;

	@Column
	@HttpParam
	private String address;

	@Column
	@HttpParam
	private String country;

	@Column
	@HttpParam
	private String state;

	@Column
	private String city;

	@Column
	private String phoneCountryCode;

	@Column
	private String phoneAreaCode;

	@Column
	private String phoneNumber;

	@Column
	private String faxCountryCode;

	@Column
	private String faxAreaCode;

	@Column
	private String faxNumber;

	@Column
	private String email;

	@Column
	private String password;

	public String getOrganizationName() {
		return organizationName;
	}

	@XmlElement
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public AdvertiserType getType() {
		return type;
	}

	@XmlElement
	public void setType(AdvertiserType type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
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

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	@XmlElement
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getPhoneAreaCode() {
		return phoneAreaCode;
	}

	@XmlElement
	public void setPhoneAreaCode(String phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@XmlElement
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxCountryCode() {
		return faxCountryCode;
	}

	@XmlElement
	public void setFaxCountryCode(String faxCountryCode) {
		this.faxCountryCode = faxCountryCode;
	}

	public String getFaxAreaCode() {
		return faxAreaCode;
	}

	@XmlElement
	public void setFaxAreaCode(String faxAreaCode) {
		this.faxAreaCode = faxAreaCode;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	@XmlElement
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

}
