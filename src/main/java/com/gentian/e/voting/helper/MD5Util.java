package com.gentian.e.voting.helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gentian
 */
public class MD5Util {
    
    public static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
    
    public static String md5Hex(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex(md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            
        }
        return null;
    }
    
}
