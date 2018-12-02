package in.jaiprakash.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HeaderModel header;
	
	@JsonProperty(value="responseBody")
	private T response;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(HeaderModel header, T response) {
		super();
		this.header = header;
		this.response = response;
	}

	public HeaderModel getHeader() {
		return header;
	}

	public void setHeader(HeaderModel header) {
		this.header = header;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	

}
