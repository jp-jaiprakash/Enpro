package in.jaiprakash.models;

import java.io.Serializable;

import javax.validation.Valid;

public class Request<T> implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private HeaderModel header;
	
	
	private T payload;

	public HeaderModel getHeader() {
		return header;
	}

	public void setHeader(HeaderModel header) {
		this.header = header;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	
	

}
