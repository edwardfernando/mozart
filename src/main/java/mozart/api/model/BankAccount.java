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
import javax.xml.bind.annotation.XmlTransient;

import mozart.core.annotation.HttpParam;
import mozart.core.api.Model;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
@Table(name = "bank_account")
public class BankAccount extends Model {

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "buzzer_id")
	private Buzzer buzzer;

	@Column
	@XmlElement
	@HttpParam
	private String bankName;

	@Column
	@XmlElement
	@HttpParam
	private String accountNumber;

	@Column
	@XmlElement
	@HttpParam
	private String holderName;

	@Column
	@XmlElement
	@HttpParam
	private Boolean isDefault;

	public Buzzer getBuzzer() {
		return buzzer;
	}

	public void setBuzzer(Buzzer buzzer) {
		this.buzzer = buzzer;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

}
