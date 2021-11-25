package com.greatlearning.service;

public class OtpGenerator {
	public static int generateOtp() {
		return 1000 + (int)(Math.random() * 9000); // 4 digit number
	}
}
