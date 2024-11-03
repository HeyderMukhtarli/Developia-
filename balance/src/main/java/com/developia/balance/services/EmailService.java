package com.developia.balance.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("haydarmuxtar26@gmail.com");
        msg.setTo(to);
        msg.setText(body);
        msg.setSubject(subject);
        javaMailSender.send(msg);
        System.out.println("Email sent successfully to " + to);
    }

    public void sendHtmlEmail(String to, String subject, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("haydarmuxtar26@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(createHtmlBody(to,body), true); // Set to true to indicate it's HTML
            javaMailSender.send(mimeMessage);
            System.out.println("HTML Email sent successfully to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private String createHtmlBody(String userName, String otp) {
        return "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; color: #333; }" +
                ".otp-container { border: 1px solid #ddd; padding: 20px; border-radius: 5px; }" +
                ".otp { font-size: 24px; font-weight: bold; color: #007BFF; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='otp-container'>" +
                "<h1>OTP Verification</h1>" +
                "<p>Dear " + userName + ",</p>" +
                "<p>Your One-Time Password (OTP) for verification is: <span class='otp'>" + otp + "</span></p>" +
                "<p>Please enter this OTP in the application to proceed.</p>" +
                "<p>Thank you!</p>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
