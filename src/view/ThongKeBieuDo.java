package view;

import model.ThongKeDoanhThuPhanLoai;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ThongKeBieuDo extends JDialog {

    public ThongKeBieuDo(Window parent, List<ThongKeDoanhThuPhanLoai> data) {
        super(parent, "Biểu đồ doanh thu theo phân loại", ModalityType.APPLICATION_MODAL);
        setSize(600, 400);
        setLocationRelativeTo(parent);

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (ThongKeDoanhThuPhanLoai tk : data) {
            dataset.setValue(tk.getPhanLoai(), tk.getTongTien());
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Doanh thu theo phân loại sản phẩm",
                dataset,
                true, true, false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(580, 360));
        setContentPane(chartPanel);
    }
}