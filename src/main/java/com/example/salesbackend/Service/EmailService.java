package com.example.salesbackend.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService() {
    }

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public EmailService(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendMail(String to, String token, String userFullName) throws MessagingException, UnsupportedEncodingException {
        String subject = "PASSWORD RESET";
        String resetUrl = "https://mrorian.github.io/sales/reset-password?token=" + token;
        String text = "<p>Xin chào <b>"+ userFullName +"</b></p>"
                + "<p>Bạn đã yêu cầu đặt lại mật khẩu.</p>"
                + "<p>Click vào link bên dưới để đặt lại mật khẩu của bạn:</p>"
                + "<br>"
                + "<p><a href=\"" + resetUrl + "\">ĐẶT LẠI MẬT KHẨU</a></p>"
                + "<br>"
                + "<p>Nếu bạn không yêu cầu thao tác này, hãy bỏ qua email này.</p>";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(new InternetAddress("support@cua.com.vn", "No-Reply"));
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

    public void verifyMail(String to, String token, String userFullName) throws MessagingException, UnsupportedEncodingException{
        String subject = "XÁC THỰC TÀI KHOẢN CUA-STORE";
        String resetUrl = "https://mrorian.github.io/sales/verify?token=" + token;
        String text = "<p>Xin chào <b>"+ userFullName +"</b></p>"
                + "<p>Cảm ơn bạn đã đăng ký tài khoản trên website.</p>"
                + "<p>Click vào link bên dưới để xác thực tài khoản nhé!</p>"
                + "<br>"
                + "<p><a href=\"" + resetUrl + "\">XÁC THỰC TÀI KHOẢN</a></p>"
                + "<br>"
                + "<p>Nếu bạn không yêu cầu thao tác này, hãy bỏ qua email này.</p>";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(new InternetAddress("support@cua.com.vn", "No-Reply"));
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }
}
