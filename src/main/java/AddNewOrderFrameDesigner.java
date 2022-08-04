import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Aug 04 11:46:52 CST 2022
 */



/**
 * @author unknown
 */
public class AddNewOrderFrameDesigner extends JFrame {
    public AddNewOrderFrameDesigner() {
        initComponents();
    }

    private void addNewProductMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void submitOrderMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void deleteProductMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ProductTablescrollPane = new JScrollPane();
        ProductTable = new JTable();
        OrderTableScrollPane = new JScrollPane();
        OrderTable = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        addNewProduct = new JButton();
        submitOrder = new JButton();
        deleteProduct = new JButton();

        //======== this ========
        setTitle("\u4ea7\u54c1\u8ba2\u8d2d");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== ProductTablescrollPane ========
        {
            ProductTablescrollPane.setViewportView(ProductTable);
        }
        contentPane.add(ProductTablescrollPane);
        ProductTablescrollPane.setBounds(5, 50, 450, 580);

        //======== OrderTableScrollPane ========
        {
            OrderTableScrollPane.setViewportView(OrderTable);
        }
        contentPane.add(OrderTableScrollPane);
        OrderTableScrollPane.setBounds(545, 50, 450, 580);

        //---- label1 ----
        label1.setText("\u4ea7\u54c1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label1);
        label1.setBounds(185, 0, 90, 45);

        //---- label2 ----
        label2.setText("\u8ba2\u5355");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(725, 0, 90, 45);

        //---- addNewProduct ----
        addNewProduct.setText("\u52a0\u5165\u8ba2\u5355");
        addNewProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addNewProductMouseClicked(e);
            }
        });
        contentPane.add(addNewProduct);
        addNewProduct.setBounds(165, 655, 130, addNewProduct.getPreferredSize().height);

        //---- submitOrder ----
        submitOrder.setText("\u63d0\u4ea4\u8ba2\u5355");
        submitOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitOrderMouseClicked(e);
            }
        });
        contentPane.add(submitOrder);
        submitOrder.setBounds(625, 655, 130, 30);

        //---- deleteProduct ----
        deleteProduct.setText("\u5220\u9664");
        deleteProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteProductMouseClicked(e);
            }
        });
        contentPane.add(deleteProduct);
        deleteProduct.setBounds(790, 655, 130, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane ProductTablescrollPane;
    private JTable ProductTable;
    private JScrollPane OrderTableScrollPane;
    private JTable OrderTable;
    private JLabel label1;
    private JLabel label2;
    private JButton addNewProduct;
    private JButton submitOrder;
    private JButton deleteProduct;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
