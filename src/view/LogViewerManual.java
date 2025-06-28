package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LogViewerManual extends JDialog {
    private JTextArea txtLog;
    private JButton btnReload;

    public LogViewerManual(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadLog();
    }

    private void initComponents() {
        txtLog = new JTextArea();
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtLog.setLineWrap(true);
        txtLog.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtLog);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        btnReload = new JButton("Tải lại");
        btnReload.addActionListener(e -> loadLog());

        setTitle("Nhật ký hệ thống");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(btnReload)
                .addComponent(scrollPane)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(10)
                .addComponent(btnReload)
                .addGap(10)
                .addComponent(scrollPane)
                .addGap(10)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void loadLog() {
        txtLog.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader("logs/app.log"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txtLog.append(line + "\n");
            }
        } catch (IOException e) {
            txtLog.setText("Không thể đọc file log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LogViewerManual viewer = new LogViewerManual(new JFrame(), true);
            viewer.setVisible(true);
        });
    }
}