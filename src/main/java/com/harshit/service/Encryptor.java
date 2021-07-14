package com.harshit.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class Encryptor {
	private static KeyPairGenerator keyPairGenerator;
	private static KeyPair keyPair;
	private static Cipher cipher;
	
	
	public static Cipher initialise() throws Exception {


		// Creating KeyPair generator object
		keyPairGenerator = KeyPairGenerator.getInstance("RSA");

		// initialising the keypair generator
		keyPairGenerator.initialize(2048);

		// Generating the pair of keys
		keyPair = keyPairGenerator.generateKeyPair();

		// Creating a cipher object
		cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		// Initializing a Cipher object
		cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
		
		return cipher;
		// Adding data to the cipher
	}
	
	public static String encryptString(String str) {
		try {
		byte[] input = str.getBytes();
		cipher = initialise();
		
		cipher.update(input);
		
		byte[] cipherText = cipher.doFinal();
		System.out.println(new String(cipherText, "UTF8"));
		return new String(cipherText, "UTF8");
		} catch(Exception e) {
			System.out.println("Couldn't encrypt!");
			return str;
		}
	}
}
