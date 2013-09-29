package mozart.common.exception;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "exception_message")
public class ErrorWrapper {

	private List<Error> errors = Lists.newArrayList();
	private String pathLocation;
	private String httpMethod;

	public ErrorWrapper() {
	}

	public ErrorWrapper(List<Error> errors) {
		this.errors = errors;
	}

	public ErrorWrapper(String error) {
		this(Collections.singletonList(new Error(error)));
	}

	public List<Error> getErrors() {
		return errors;
	}

	@XmlElement(name = "error")
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public boolean hasError() {
		return !errors.isEmpty();
	}

	public void registerError(Error error) {
		errors.add(error);
	}

	public String getPathLocation() {
		return pathLocation;
	}

	@XmlElement(name = "path")
	public void setPathLocation(String pathLocation) {
		this.pathLocation = pathLocation;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	@XmlElement
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

}
