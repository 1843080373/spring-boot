package com.zimadai.boot.utils;

public class RestData {

	private boolean success;
	private Object data;
	private String message;

	public static class Builder {
		private boolean success;
		private Object data;
		private String message;

		public Builder() {

		}

		public Builder success(boolean success) {
			this.success = success;
			return this;
		}

		public Builder data(Object data) {
			this.data = data;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public RestData build() {
			return new RestData(this);
		}
	}

	// 私有化
	private RestData(Builder builder) {
		success = builder.success;
		data = builder.data;
		message = builder.message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
