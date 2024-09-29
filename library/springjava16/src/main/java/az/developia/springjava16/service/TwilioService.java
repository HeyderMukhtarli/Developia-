package az.developia.springjava16.service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    @Value("${twilio.account_sid}")
    private String ACCOUNT_SID;
    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;

   public void sendWhatsAppMessage(String to,String message2){
        // Initialize Twilio with your credentials
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

       try {
           // Initialize Twilio with your credentials
           Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

           // Create and send a WhatsApp message
           Message message = Message.creator(
                           new PhoneNumber("whatsapp:"+to), // To phone number
                           new PhoneNumber("whatsapp:+14155238886"), // From Twilio WhatsApp number
                           message2) // Message content
                   .create();

           // Output the message SID (unique identifier for the message)
           System.out.println(message.getSid());

       } catch (ApiException e) {
           // Handle specific Twilio API exceptions
           if (e.getCode() == 21610) { // Error code for "Not a valid WhatsApp number"
               System.err.println("Error: The recipient is not subscribed to the service. " + e.getMessage());
           } else {
               System.err.println("API Exception: " + e.getMessage());
           }
       } catch (AuthenticationException e) {
           // Handle authentication errors
           System.err.println("Authentication error: " + e.getMessage());
       } catch (Exception e) {
           // Handle general exceptions
           System.err.println("An error occurred: " + e.getMessage());
       }

        // Create and send a WhatsApp message

    }
}
