import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACSender {
    public static void main(String[] args) throws Exception {
        String key = "Secret Key";
        String message = "Hello World!";

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(keySpec);

        byte[] rawHmac = mac.doFinal(message.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(rawHmac));

        if (MessageDigest)
    }
}
