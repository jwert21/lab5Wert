import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACReceiver {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.out);
        String key = "Secret Key";

        // Simulated received data
        String receivedMessage = "Hello World!";
        String receivedHmacBase64 = "PASTE_SENDER_OUTPUT_HERE";

        Mac mac = Mac.getInstance();

        boolean isValid = verifyHMAC(receivedMessage, receivedHmacBase64, key);

        if (isValid) {
            System.out.println("Message is authentic");
            System.out.println("Message: " + message);
        } else {
            System.out.println("Message has been tampered");
        }
    }

    public static boolean verifyHMAC(String message, String receivedHmacBase64, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        mac.init(keySpec);

        byte[] computedHmac = mac.doFinal(message.getBytes());
        String computedHmacBase64 = Base64.getEncoder().encodeToString(computedHmac);

        return computedHmacBase64.equals(receivedHmacBase64);
    }
}
