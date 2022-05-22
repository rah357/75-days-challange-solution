import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.Formatter;

public class sec {
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static void main(String[] args) {
        try {
            String message = "theNameIsPrakhar";
            String key = "xZr19Q8lbMWLWhM67Tuz7Q==";
            String HMACAuthToken;
            HMACAuthToken = calculateHMACWithSHA256(message, key);
            System.out.println(HMACAuthToken);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static String calculateHMACWithSHA256(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);

        return toHexString(mac.doFinal(data.getBytes()));
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }
}
