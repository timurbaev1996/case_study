package com.db.demomidtier;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

public class Cookie {
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static Cipher cipher;
    public Cookie () throws Exception {
        final int keySize = 512; // 2048
        final String algorithm = "RSA";
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm); // Once generated must be saved to file
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        cipher = Cipher.getInstance(algorithm);
    }
    public String GenerateCookie (String data) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return byteArrayToHex(cipher.doFinal(data.getBytes()));
    }
    public String decryptCookie(String encrypted) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(hexToByteArray(encrypted)));
    }
    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
    private static byte[] hexToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
