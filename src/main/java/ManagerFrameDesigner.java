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

    private void logoutMouseClicked(MouseEvent e) {
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
        SelectText = new JLabel();
        OrderManage = new JButton();
        CustomerManage = new JButton();
        ProductManage = new JButton();
        label7 = new JLabel();
        logout = new JButton();
        label6 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\wallhaven-pkdr23_1920x1080.png").getImage());
        setTitle("\u7ba1\u7406\u5458\u64cd\u4f5c\u5e73\u53f0");
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
        modify.setBounds(30, 345, 145, 30);

        //---- label5 ----
        label5.setText("\u516c\u53f8\uff1a");
        label5.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        contentPane.add(label5);
        label5.setBounds(20, 300, 55, 25);

        //---- Address ----
        Address.setText("\u5e7f\u897f\u5927\u5b66");
        Address.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        contentPane.add(Address);
        Address.setBounds(75, 300, 175, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText("18070786877");
        PhoneNumber.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(75, 260, 135, 25);

        //---- label4 ----
        label4.setText("\u7535\u8bdd\uff1a");
        label4.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        contentPane.add(label4);
        label4.setBounds(20, 260, 55, 25);

        //---- label3 ----
        label3.setText("\u7ba1\u7406\u5458\uff1a");
        label3.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        contentPane.add(label3);
        label3.setBounds(20, 215, 95, 30);

        //---- UserName ----
        UserName.setText("\u9646\u96c5\u5a1f");
        UserName.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
        contentPane.add(UserName);
        UserName.setBounds(85, 215, 135, 30);

        //---- UserNum ----
        UserNum.setText("01");
        UserNum.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
        contentPane.add(UserNum);
        UserNum.setBounds(85, 175, 135, 25);

        //---- label2 ----
        label2.setText("\u804c\u5de5\u53f7\uff1a");
        label2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(20, 170, 85, 35);
        contentPane.add(label1);
        label1.setBounds(50, 75, 70, 80);

        //---- SelectText ----
        SelectText.setText("\u8bf7\u9009\u62e9\u60a8\u8981\u8fdb\u884c\u7684\u64cd\u4f5c\uff1a");
        SelectText.setFont(SelectText.getFont().deriveFont(SelectText.getFont().getSize() + 7f));
        contentPane.add(SelectText);
        SelectText.setBounds(355, 100, 235, 30);

        //---- OrderManage ----
        OrderManage.setText("\u2461\u8ba2\u5355\u7ba1\u7406");
        OrderManage.setFont(OrderManage.getFont().deriveFont(OrderManage.getFont().getSize() + 4f));
        OrderManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderManageMouseClicked(e);
            }
        });
        contentPane.add(OrderManage);
        OrderManage.setBounds(335, 235, 240, 45);

        //---- CustomerManage ----
        CustomerManage.setText("\u2462\u987e\u5ba2\u7ba1\u7406");
        CustomerManage.setFont(CustomerManage.getFont().deriveFont(CustomerManage.getFont().getSize() + 4f));
        CustomerManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CostomerManageMouseClicked(e);
            }
        });
        contentPane.add(CustomerManage);
        CustomerManage.setBounds(335, 300, 240, 45);

        //---- ProductManage ----
        ProductManage.setText("\u2460\u4ea7\u54c1\u7ba1\u7406");
        ProductManage.setFont(ProductManage.getFont().deriveFont(ProductManage.getFont().getSize() + 4f));
        ProductManage.setBackground(new Color(204, 204, 204));
        ProductManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductManageMouseClicked(e);
                ProductManageMouseClicked(e);
            }
        });
        contentPane.add(ProductManage);
        ProductManage.setBounds(335, 165, 240, 45);

        //---- label7 ----
        label7.setText("text");
        label7.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\wallhaven-pkdr23_1920x1080.png"));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(-60, -30), label7.getPreferredSize()));

        //---- logout ----
        logout.setText("\u6ce8\u9500\u8d26\u53f7");
        logout.setFont(logout.getFont().deriveFont(logout.getFont().getSize() + 4f));
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutMouseClicked(e);
            }
        });
        contentPane.add(logout);
        logout.setBounds(545, 390, 175, 50);

        //---- label6 ----
        label6.setText("text");
        label6.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\\u5fae\u4fe1\u56fe\u7247_20220831160459.jpg"));
        label6.setOpaque(true);
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(-485, -270), label6.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(740, 485));
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
    private JLabel SelectText;
    private JButton OrderManage;
    private JButton CustomerManage;
    private JButton ProductManage;
    private JLabel label7;
    private JButton logout;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
