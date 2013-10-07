package mozart.common.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Error {

	private String parameter;
	private String errorMessage;

	public Error() {
	}

	public Error(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Error(String parameter, String errorMessage) {
		this.parameter = parameter;
		this.errorMessage = errorMessage;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "Error [parameter=" + parameter + ", errorMessage=" + errorMessage + "]";
	}

}
