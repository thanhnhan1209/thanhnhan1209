/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dao.AccountDAO;
import dao.ChiTietPhieuNhapDAO;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.NhaCungCapDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ChiTietPhieu;
import model.SanPham;
import model.PhieuNhap;
import model.PhieuXuat;


// (các import giữ nguyên)

public class WritePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writePhieuNhapAsync(String mapn) {
        new Thread(() -> writePhieuNhap(mapn)).start();
    }

    public void writePhieuXuatAsync(String mapn) {
        new Thread(() -> writePhieuXuat(mapn)).start();
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi mở file: " + ex.getMessage());
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    public void writePhieuNhap(String mapn) {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) return;

            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            setTitle("THÔNG TIN PHIẾU NHẬP");

            PhieuNhap pn = PhieuNhapDAO.getInstance().selectById(mapn);

            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Mã phiếu: " + pn.getMaPhieu());
            para1.add("\nThời gian tạo: " + formatDate.format(pn.getThoiGianTao()));
            para1.setIndentationLeft(40);

            Paragraph para2 = new Paragraph();
            para2.setSpacingBefore(30f);
            para2.setFont(fontData);
            para2.add("Người tạo: " + AccountDAO.getInstance().selectById(pn.getNguoiTao()).getFullName());
            para2.add("\nNhà cung cấp: " + NhaCungCapDAO.getInstance().selectById(pn.getNhaCungCap()).getTenNhaCungCap() + "  -  " + pn.getNhaCungCap());
            para2.setIndentationLeft(40);

            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);

            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});

            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (ChiTietPhieu ctpn : ChiTietPhieuNhapDAO.getInstance().selectAll(mapn)) {
                SanPham sp = SanPhamDAO.getInstance().selectById(ctpn.getMaSP());
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaSP(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(sp.getTenSP(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(sp.getGia()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getSoLuong() * sp.getGia()) + "đ", fontData)));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTong = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTien()) + "đ", fontData));
            paraTong.setIndentationLeft(300);
            document.add(paraTong);
            document.close();

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    public void writePhieuXuat(String mapx) {
        String url = "";
        try {
            fd.setTitle("In phiếu xuất");
            fd.setLocationRelativeTo(null);
            url = getFile(mapx);
            if (url == null) return;

            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            setTitle("THÔNG TIN PHIẾU XUẤT");

            PhieuXuat pn = PhieuXuatDAO.getInstance().selectById(mapx);

            Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + mapx, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + formatDate.format(pn.getThoiGianTao()), fontData));
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + AccountDAO.getInstance().selectById(pn.getNguoiTao()).getFullName(), fontData));

            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);

            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(Chunk.NEWLINE);

            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

           // Ép kiểu về đúng class để gọi phương thức selectAll(String maPhieu)
ChiTietPhieuXuatDAO dao = (ChiTietPhieuXuatDAO) ChiTietPhieuXuatDAO.getInstance();
for (ChiTietPhieu ctpn : dao.selectAll(mapx)) {
    SanPham sp = SanPhamDAO.getInstance().selectById(ctpn.getMaSP());
    pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaSP(), fontData)));
    pdfTable.addCell(new PdfPCell(new Phrase(sp.getTenSP(), fontData)));
    pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(sp.getGia()) + "đ", fontData)));
    pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
    pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getSoLuong() * sp.getGia()) + "đ", fontData)));
}

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTong = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTien()) + "đ", fontData));
            paraTong.setIndentationLeft(300);
            document.add(paraTong);
            document.close();

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
