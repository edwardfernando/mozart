package mozart.api.model;

import javax.persistence.Column;
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
@Table(name = "advertiser")
public class Advertiser extends Model {

	@Column(name = "organizationName")
	@XmlElement
	@HttpParam
	private String organizationName;

	@XmlElement
	@HttpParam
	@ManyToOne
	@JoinColumn(name = "advertiser_type_id")
	private AdvertiserType type;

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
	private String city;

	@Column
	@XmlElement
	private String phoneCountryCode;

	@Column
	@XmlElement
	private String phoneAreaCode;

	@Column
	@XmlElement
	private String phoneNumber;

	@Column
	@XmlElement
	private String faxCountryCode;

	@Column
	@XmlElement
	private String faxAreaCode;

	@Column
	@XmlElement
	private String faxNumber;

	@Column
	@XmlElement
	private String email;

	@Column
	@XmlElement
	private String password;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public AdvertiserType getType() {
		return type;
	}

	public void setType(AdvertiserType type) {
		this.type = type;
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

}
