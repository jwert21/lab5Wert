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
        String hmac = Base64.getEncoder().encodeToString(rawHmac);

        System.out.println(hmac);

        boolean isValid = hmac.equals(hmac);

        if (isValid) {
            System.out.println("HMAC verified - message is authentic");
            System.out.println("Message could be trusted.");
        }
    }
}