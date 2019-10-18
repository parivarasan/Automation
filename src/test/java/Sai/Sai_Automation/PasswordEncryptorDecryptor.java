package com.resources;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordEncryptorDecryptor {
	public static String encryptorDecryptorPassword = "motorola";

	public static void main(String args[]) {
		
		//String aemPassword = "Confidential!1";
		//String occPassword = "Confidential!4";
		String newPassword = "Test1234";

		//System.out.println("Encrypted AEM password is : " + EncryptPassword(aemPassword));
		//System.out.println("Encrypted OCC password is : " + EncryptPassword(occPassword));
		System.out.println("Encrypted OCC password is : " + EncryptPassword(newPassword));
		
		
		//System.out.println("Decrypted AEM password is : " + DecryptPassword(EncryptPassword(aemPassword)));
		//System.out.println("Decrypted OCC password is : " + DecryptPassword(EncryptPassword(occPassword)));
		System.out.println("Decrypted OCC password is : " + DecryptPassword(EncryptPassword(newPassword)));

	}

	public static String EncryptPassword(String pwd) {

		BasicTextEncryptor encr = new BasicTextEncryptor();
		encr.setPassword(encryptorDecryptorPassword);
		return encr.encrypt(pwd);
	}

	public static String DecryptPassword(String encryptedPwd) {
		BasicTextEncryptor encr = new BasicTextEncryptor();
		encr.setPassword(encryptorDecryptorPassword);
		return encr.decrypt(encryptedPwd);
	}
}
