package mozart.common.exception;

public class MozartException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorWrapper error = new ErrorWrapper();

	public MozartException(ErrorWrapper error) {
		this.error = error;
	}

	public MozartException(String error) {
		this.error.registerError(new Error(error));
	}

	public MozartException(Throwable throwable) {
		this.error.registerError(new Error(throwable.getMessage()));
	}

	public ErrorWrapper getError() {
		return error;
	}

	public void setError(ErrorWrapper error) {
		this.error = error;
	}

}
