package main.java.nine.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utdid {
    private byte[] getBytes(int val) {
        byte[] data = new byte[4];
        data[3] = (byte) (val % 0x100);
        int tmp = val >> 8;
        data[2] = (byte) (tmp % 0x100);
        tmp >>= 8;
        data[1] = (byte) (tmp % 0x100);
        data[0] = (byte) ((tmp >> 8) % 0x100);
        return data;
    }

    private int hashCode(String str) {
        int hashCode = 0;
        if(str.length() > 0) {
            char[] chars = str.toCharArray();
            int val = 0;
            while(hashCode < chars.length) {
                val = val * 0x1F + chars[hashCode];
                ++hashCode;
            }

            hashCode = val;
        }

        return hashCode;
    }



    public String generateUtdid(String imei) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int time = (int) (System.currentTimeMillis() / 1000);

        int random = new Random().nextInt();
        byte[] timeBytes = getBytes(time);
        byte[] randomBytes = getBytes(random);
        try {
            baos.write(timeBytes, 0, 4);
            baos.write(randomBytes, 0, 4);
            baos.write(3);
            baos.write(0);
            baos.write(getBytes(hashCode(imei)), 0, 4);
            baos.write(getBytes(hashCode(calcHmac(baos.toByteArray()))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encode(baos.toByteArray());
    }
    private String calcHmac(byte[] data) {

        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        assert mac != null;
        return Base64.encode(mac.doFinal(data));
    }

}
