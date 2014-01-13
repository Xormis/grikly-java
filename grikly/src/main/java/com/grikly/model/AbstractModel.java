package com.grikly.model;

public abstract class AbstractModel {
	private String error_description,error;

	
	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "[error_description=" + error_description + ", error=" + error + "]";
	}

	
}
