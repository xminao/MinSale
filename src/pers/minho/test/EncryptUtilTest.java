package pers.minho.test;

import pers.minho.util.EncryptUtil;

public class EncryptUtilTest {
	public static void main(String args[]) {
		String email = "xminao@yeah.net";
		String token = EncryptUtil.DESencode(email);
		String decodeEmail = EncryptUtil.DESdecode(token);
		System.out.println(token + " " + decodeEmail);
	}
}
