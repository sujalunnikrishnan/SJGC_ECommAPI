package com.pojo;

public class GetAddedProduct_Response 
{
	GetAddedProduct_Sub_Response data;
	String message;
	
	public GetAddedProduct_Sub_Response getData() {
		return data;
	}
	public void setData(GetAddedProduct_Sub_Response data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
