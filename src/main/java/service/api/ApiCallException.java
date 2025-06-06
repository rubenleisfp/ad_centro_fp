package service.api;

public class ApiCallException extends Exception {

	/**
	 * Clase envoltorio para  disponer de la informacion necesaria en caso de un error del api
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String responseBody;

	public ApiCallException(String message, int statusCode, String responseBody) {
		super(message);
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}