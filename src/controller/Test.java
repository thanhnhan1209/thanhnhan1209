package controller;

public class Test {

    public static void main(String[] args) {
        testBCrypt();
        testSendEmail();
    }

    private static void testBCrypt() {
        String password = "admin";
        String storedHash = "$2a$12$z4LV6HekAKa8mgywwiZtQO29YnXRRPx38TxEGOQNMT411TsUuFSYO";

        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println("✅ Tạo BCrypt hash mới: " + hash);

        boolean isMatch = BCrypt.checkpw(password, storedHash);
        System.out.println("✅ Kiểm tra mật khẩu: " + (isMatch ? "Khớp!" : "Không khớp!"));
    }

    private static void testSendEmail() {
        try {
            String email = "nhantt.24ic@vku.udn.vn";
            String otp = "12345";
            System.out.println("📧 Đang gửi OTP đến: " + email);
            SendEmailSMTP.sendOTP(email, otp);
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi gửi email: " + e.getMessage());
        }
    }
}
