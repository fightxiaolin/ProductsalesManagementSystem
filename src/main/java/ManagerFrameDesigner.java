import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 10:59:42 CST 2022
 */

//只是给设计界面用的而已，真正的界面代码在ManagerFrame

/**
 * @author unknown
 */
public class ManagerFrameDesigner extends JFrame {
    public ManagerFrameDesigner() {
        initComponents();
    }

    private void ProductManageMouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void modifyMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void OrderManageMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void CostomerManageMouseClicked(MouseEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        modify = new JButton();
        label5 = new JLabel();
        Address = new JLabel();
        PhoneNumber = new JLabel();
        label4 = new JLabel();
        label3 = new JLabel();
        UserName = new JLabel();
        UserNum = new JLabel();
        label2 = new JLabel();
        label1 = new JLabel();
        label6 = new JLabel();
        SelectText = new JLabel();
        OrderManage = new JButton();
        CostomerManage = new JButton();
        ProductManage = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- modify ----
        modify.setText("\u4fee\u6539\u8d44\u6599");
        modify.setFont(modify.getFont().deriveFont(modify.getFont().getSize() + 4f));
        modify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modifyMouseClicked(e);
            }
        });
        contentPane.add(modify);
        modify.setBounds(20, 335, 145, 30);

        //---- label5 ----
        label5.setText("\u516c\u53f8\uff1a");
        label5.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label5);
        label5.setBounds(20, 300, 55, 25);

        //---- Address ----
        Address.setText("\u505a\u4e0d\u51fa\u6570\u636e\u5e93\u7684\u79d1\u6280\u6709\u9650\u516c\u53f8");
        Address.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Address);
        Address.setBounds(75, 300, 175, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText("18988888888");
        PhoneNumber.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(75, 260, 135, 25);

        //---- label4 ----
        label4.setText("\u7535\u8bdd\uff1a");
        label4.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label4);
        label4.setBounds(20, 260, 55, 25);

        //---- label3 ----
        label3.setText("\u7ba1\u7406\u5458\uff1a");
        label3.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label3);
        label3.setBounds(20, 220, 55, 25);

        //---- UserName ----
        UserName.setText("\u6797\u603b");
        UserName.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserName);
        UserName.setBounds(75, 220, 135, 25);

        //---- UserNum ----
        UserNum.setText("666666");
        UserNum.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNum);
        UserNum.setBounds(75, 180, 135, 25);

        //---- label2 ----
        label2.setText("\u804c\u5de5\u53f7\uff1a");
        label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label2);
        label2.setBounds(20, 180, 55, 25);
        contentPane.add(label1);
        label1.setBounds(65, 75, 70, 80);

        //---- label6 ----
        label6.setText("\u7ba1\u7406\u5458\u64cd\u4f5c\u5e73\u53f0");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 48));
        contentPane.add(label6);
        label6.setBounds(290, 20, 540, 85);

        //---- SelectText ----
        SelectText.setText("\u8bf7\u9009\u62e9\u60a8\u8981\u8fdb\u884c\u7684\u64cd\u4f5c\uff1a");
        SelectText.setFont(SelectText.getFont().deriveFont(SelectText.getFont().getSize() + 4f));
        contentPane.add(SelectText);
        SelectText.setBounds(350, 140, 235, 30);

        //---- OrderManage ----
        OrderManage.setText("\u8ba2\u5355\u7ba1\u7406");
        OrderManage.setFont(OrderManage.getFont().deriveFont(OrderManage.getFont().getSize() + 4f));
        OrderManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderManageMouseClicked(e);
            }
        });
        contentPane.add(OrderManage);
        OrderManage.setBounds(470, 270, 240, 45);

        //---- CostomerManage ----
        CostomerManage.setText("\u987e\u5ba2\u7ba1\u7406");
        CostomerManage.setFont(CostomerManage.getFont().deriveFont(CostomerManage.getFont().getSize() + 4f));
        CostomerManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CostomerManageMouseClicked(e);
            }
        });
        contentPane.add(CostomerManage);
        CostomerManage.setBounds(475, 355, 240, 45);

        //---- ProductManage ----
        ProductManage.setText("\u4ea7\u54c1\u7ba1\u7406");
        ProductManage.setFont(ProductManage.getFont().deriveFont(ProductManage.getFont().getSize() + 4f));
        ProductManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductManageMouseClicked(e);
                ProductManageMouseClicked(e);
            }
        });
        contentPane.add(ProductManage);
        ProductManage.setBounds(470, 190, 240, 45);

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
    private JButton modify;
    private JLabel label5;
    private JLabel Address;
    private JLabel PhoneNumber;
    private JLabel label4;
    private JLabel label3;
    private JLabel UserName;
    private JLabel UserNum;
    private JLabel label2;
    private JLabel label1;
    private JLabel label6;
    private JLabel SelectText;
    private JButton OrderManage;
    private JButton CostomerManage;
    private JButton ProductManage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
