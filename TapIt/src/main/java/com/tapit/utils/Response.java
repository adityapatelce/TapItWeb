package com.tapit.utils;



public class Response {
	
	public final static int SUCCESS_STATUS = 200;
	public final static int FAIL_STATUS    = 100;
	
	
	private int status ;
	
	private String message ;
	
	private Object data;
	
	
	
	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Object getData() {
		return data;
	}



	public void setData(Object data) {
		this.data = data;
	}



	public static Response getCorrectResponse() {
		Response reposnse = new Response();
		
		return reposnse;
	}
	
}
