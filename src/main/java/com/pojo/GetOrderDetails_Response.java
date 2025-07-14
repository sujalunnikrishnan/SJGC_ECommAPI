package com.pojo;

public class GetOrderDetails_Response 
{
	GetOrderDetails_Sub_Response data;
	String message;

	
	public GetOrderDetails_Sub_Response getData() {
		return data;
	}
	public void setData(GetOrderDetails_Sub_Response data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
