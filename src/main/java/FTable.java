import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class FTable {
    public FTable() {}
    public FTable(Object[][] playerInfo,String[] Names,String title) {
        final JFrame f = new JFrame();
        // 以Names和playerInfo为参数，创建一个表格
        JTable table = new JTable(playerInfo, Names);
        // 设置此表视图的首选大小
        f.setLocation(550,250);
        table.setRowHeight(50);
        table.setFont(new Font("微软雅黑", Font.BOLD, 15));
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,cr);
        table.setPreferredScrollableViewportSize(new Dimension(800, 450));
        // 将表格加入到滚动条组件中
        JScrollPane scrollPane = new JScrollPane(table);
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);
        // 再将滚动条组件添加到中间容器中
        f.setTitle(title);
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
