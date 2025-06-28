package controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;

public class SendEmailSMTP {

    private static final String USERNAME = "inet.nhannhan.v3@gmail.com";
    private static final String APP_PASSWORD = "ccvc lyuk mioj xwtq";

    private static Session getEmailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, APP_PASSWORD);
            }
        });
    }

    // Gửi OTP bất đồng bộ
    public static void sendOTPAsync(String recipientEmail, String otpCode) {
        new Thread(() -> {
            try {
                sendOTP(recipientEmail, otpCode);
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null,
                                "❌ Lỗi khi gửi mã OTP: " + ex.getMessage(),
                                "Lỗi gửi email",
                                JOptionPane.ERROR_MESSAGE));
                Logger.getLogger(SendEmailSMTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    // Gửi OTP đồng bộ
    public static void sendOTP(String recipientEmail, String otpCode) throws AddressException {
        try {
            Session session = getEmailSession();
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Yêu cầu thay đổi mật khẩu");

            String content = String.format("""
                    Xin chào!

                    Ai đó đã yêu cầu đặt lại mật khẩu cho tài khoản của bạn.
                    Nếu không phải bạn, vui lòng bỏ qua email này.

                    🔐 Mã OTP để đặt lại mật khẩu của bạn là: %s

                    Trân trọng,
                    Hệ thống quản lý kho
                    """, otpCode);

            message.setContent(content, "text/plain; charset=UTF-8");

            Transport.send(message);

            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "✅ Gửi mã OTP thành công đến: " + recipientEmail));
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmailSMTP.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(null,
                            "❌ Không thể gửi mã OTP. Vui lòng kiểm tra lại địa chỉ email.",
                            "Lỗi gửi email",
                            JOptionPane.ERROR_MESSAGE));
        }
    }
}
