package mozart.api.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mozart.api.model.Instrument;


@XmlRootElement(name = "instrumentsList")
public class InstrumentsWrapper {

	private Date createdDate = new Date();
	private List<Instrument> instruments = new ArrayList<Instrument>();

	public List<Instrument> getInstruments() {
		return instruments;
	}

	@XmlElement
	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
