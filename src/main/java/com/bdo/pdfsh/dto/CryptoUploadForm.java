package com.bdo.pdfsh.dto;

public class CryptoUploadForm extends UploadForm{
	
	private boolean isEncrypt;
	private String userPassword;
	
	public boolean isEncrypt() {
		return isEncrypt;
	}
	public void setEncrypt(boolean isEncrypt) {
		this.isEncrypt = isEncrypt;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
