package mozart.api.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.common.annotation.HttpParam;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlRootElement
public class Advertiser extends Model {

	@HttpParam("organization_name")
	private String organizationName;

	@HttpParam
	private String organizationType;

	@HttpParam
	private String address;

	@HttpParam
	private String country;

	@HttpParam
	private String state;

	private String city;

	private String phoneCountryCode;

	private String phoneAreaCode;

	private String phoneNumber;

	private String faxCountryCode;

	private String faxAreaCode;

	private String faxNumber;

	private String email;

	private String password;

	public String getOrganizationName() {
		return organizationName;
	}

	@XmlElement
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	@XmlElement
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
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
