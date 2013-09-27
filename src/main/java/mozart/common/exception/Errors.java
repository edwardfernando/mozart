package mozart.common.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Errors {
	private List<String> errors;

	public Errors() {
	}

	public Errors(List<String> errors) {
		this.errors = errors;
	}

	public Errors(String error) {
		this(Collections.singletonList(error));
	}

	public Errors(String... errors) {
		this(Arrays.asList(errors));
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
