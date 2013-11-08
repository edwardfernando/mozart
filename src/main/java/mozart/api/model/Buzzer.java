package mozart.api.model;

import java.util.Date;
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

import mozart.core.annotation.Email;
import mozart.core.annotation.HttpParam;
import mozart.core.annotation.IntegerOnly;
import mozart.core.annotation.Length;
import mozart.core.api.Model;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "buzzer")
public class Buzzer extends Model {

	@Column
	@XmlElement
	@HttpParam
	@Email
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
	private Boolean isEmailPublic;

	@Column
	@XmlElement
	@HttpParam
	private String firstName;

	@Column
	@XmlElement
	@HttpParam
	private String middleName;

	@Column
	@XmlElement
	@HttpParam
	private String lastName;

	@Column
	@XmlElement
	@HttpParam
	@mozart.core.annotation.Date
	private Date birthdate;

	@Column
	@XmlElement
	@HttpParam
	private String addressLine1;

	@Column
	@XmlElement
	@HttpParam
	private String addressLine2;

	@Column
	@XmlElement
	@HttpParam
	@Length(minLength = 2, maxLength = 2)
	private String country;

	@Column
	@XmlElement
	@HttpParam
	@IntegerOnly
	private String zipCode;

	@Column
	@XmlElement
	@HttpParam
	private String mobileNumber;

	@Column
	@XmlElement
	@HttpParam
	private String phoneNumber;

	@Column
	@XmlElement
	@HttpParam
	private String faxNumber;

	@Column
	@XmlElement
	@HttpParam
	private String state;

	@OneToMany(mappedBy = "buzzer")
	private Set<BankAccount> bankAccounts;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean isEmailPublic() {
		return isEmailPublic;
	}

	public void setIsEmailPublic(Boolean isEmailPublic) {
		this.isEmailPublic = isEmailPublic;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}
