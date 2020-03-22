package kr.domi.udonsari.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256PasswordEncoder {
    public static String encrypt(String str, byte[] salt){

        String sha = "";

        byte[] a = str.getBytes();
        byte[] bytes = new byte[a.length + salt.length];

        try{
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(bytes);

            byte byteData[] = sh.digest();

            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            sha = sb.toString();
        }catch(NoSuchAlgorithmException e){
            //e.printStackTrace();
            System.out.println("Encrypt Error - NoSuchAlgorithmException");
            sha = null;
        }
        return sha;
    }

    public static String generateSalt() {
        Random random = new Random();

        byte[] salt = new byte[8];
        random.nextBytes(salt);

        StringBuffer sb = new StringBuffer();

        for(int i =0; i < salt.length; i++) {
            //byte 값 -> Hex 값
            sb.append(String.format("%02x", salt[i]));
        }

        return sb.toString();
    }
}
