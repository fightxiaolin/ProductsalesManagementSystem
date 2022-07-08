import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jun 28 10:33:09 CST 2022
 */



/**
 * @author unknown
 */
public class OrderManageDesigner extends JFrame {
    public OrderManageDesigner() {
        initComponents();
    }

    private void CheckMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void HandleMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void WithdrawMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void RefreshMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void ResearchMouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void RangeResearchMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane = new JScrollPane();
        Ordertable = new JTable();
        Check = new JButton();
        Handle = new JButton();
        Withdraw = new JButton();
        label2 = new JLabel();
        OrderNum = new JRadioButton();
        Address = new JRadioButton();
        DeliveryDate = new JRadioButton();
        SupplyNum = new JRadioButton();
        OrderDate = new JRadioButton();
        Payment = new JRadioButton();
        textField1 = new JTextField();
        Research = new JButton();
        label3 = new JLabel();
        RangeOrderDate = new JRadioButton();
        RangePayment = new JRadioButton();
        RangeDeliveryDate = new JRadioButton();
        Rangecount = new JRadioButton();
        Rangelower = new JTextField();
        label4 = new JLabel();
        Rangeupper = new JTextField();
        RangeResearch = new JButton();
        Refresh = new JButton();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 48));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba2\u5355\u7ba1\u7406\u7cfb\u7edf");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 48));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(70, 35, 435, 55);

        //======== scrollPane ========
        {
            scrollPane.setViewportView(Ordertable);
        }
        contentPane.add(scrollPane);
        scrollPane.setBounds(10, 140, 750, 445);

        //---- Check ----
        Check.setText("\u67e5\u770b\u8ba2\u5355");
        Check.setFont(Check.getFont().deriveFont(Check.getFont().getSize() + 4f));
        Check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckMouseClicked(e);
            }
        });
        contentPane.add(Check);
        Check.setBounds(840, 45, 140, 45);

        //---- Handle ----
        Handle.setText("\u5904\u7406\u8ba2\u5355");
        Handle.setFont(Handle.getFont().deriveFont(Handle.getFont().getSize() + 4f));
        Handle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HandleMouseClicked(e);
            }
        });
        contentPane.add(Handle);
        Handle.setBounds(1005, 45, 140, 45);

        //---- Withdraw ----
        Withdraw.setText("\u64a4\u56de\u8ba2\u5355");
        Withdraw.setFont(Withdraw.getFont().deriveFont(Withdraw.getFont().getSize() + 4f));
        Withdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WithdrawMouseClicked(e);
            }
        });
        contentPane.add(Withdraw);
        Withdraw.setBounds(840, 115, 140, 45);

        //---- label2 ----
        label2.setText("\u9009\u62e9\u67e5\u8be2\u7c7b\u578b\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(840, 200, 130, 25);

        //---- OrderNum ----
        OrderNum.setText("\u8ba2\u5355\u53f7");
        OrderNum.setFont(OrderNum.getFont().deriveFont(OrderNum.getFont().getSize() + 2f));
        contentPane.add(OrderNum);
        OrderNum.setBounds(845, 245, 140, 20);

        //---- Address ----
        Address.setText("\u6536\u8d27\u5730");
        Address.setFont(Address.getFont().deriveFont(Address.getFont().getSize() + 2f));
        contentPane.add(Address);
        Address.setBounds(845, 275, 140, 20);

        //---- DeliveryDate ----
        DeliveryDate.setText("\u4ea4\u8d27\u65e5\u671f");
        DeliveryDate.setFont(DeliveryDate.getFont().deriveFont(DeliveryDate.getFont().getSize() + 2f));
        contentPane.add(DeliveryDate);
        DeliveryDate.setBounds(845, 305, 140, 20);

        //---- SupplyNum ----
        SupplyNum.setText("\u4f9b\u5e94\u5546\u53f7");
        SupplyNum.setFont(SupplyNum.getFont().deriveFont(SupplyNum.getFont().getSize() + 2f));
        contentPane.add(SupplyNum);
        SupplyNum.setBounds(1005, 245, 140, 20);

        //---- OrderDate ----
        OrderDate.setText("\u8ba2\u8d27\u65e5\u671f");
        OrderDate.setFont(OrderDate.getFont().deriveFont(OrderDate.getFont().getSize() + 2f));
        OrderDate.setActionCommand("\u8ba2\u8d27\u65e5\u671f");
        contentPane.add(OrderDate);
        OrderDate.setBounds(1005, 275, 140, 20);

        //---- Payment ----
        Payment.setText("\u4ed8\u6b3e\u91d1\u989d");
        Payment.setFont(Payment.getFont().deriveFont(Payment.getFont().getSize() + 2f));
        contentPane.add(Payment);
        Payment.setBounds(1005, 305, 140, 20);
        contentPane.add(textField1);
        textField1.setBounds(850, 345, 175, 30);

        //---- Research ----
        Research.setText("\u67e5\u8be2");
        Research.setFont(Research.getFont().deriveFont(Research.getFont().getSize() + 2f));
        Research.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ResearchMouseClicked(e);
                ResearchMouseClicked(e);
            }
        });
        contentPane.add(Research);
        Research.setBounds(new Rectangle(new Point(1040, 345), Research.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u9009\u62e9\u8303\u56f4\u7c7b\u578b\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(840, 400, 130, 25);

        //---- RangeOrderDate ----
        RangeOrderDate.setText("\u8ba2\u8d27\u65e5\u671f");
        RangeOrderDate.setFont(RangeOrderDate.getFont().deriveFont(RangeOrderDate.getFont().getSize() + 2f));
        contentPane.add(RangeOrderDate);
        RangeOrderDate.setBounds(845, 445, 140, 20);

        //---- RangePayment ----
        RangePayment.setText("\u4ed8\u6b3e\u91d1\u989d");
        RangePayment.setFont(RangePayment.getFont().deriveFont(RangePayment.getFont().getSize() + 2f));
        contentPane.add(RangePayment);
        RangePayment.setBounds(845, 475, 140, 20);

        //---- RangeDeliveryDate ----
        RangeDeliveryDate.setText("\u4ea4\u8d27\u65e5\u671f");
        RangeDeliveryDate.setFont(RangeDeliveryDate.getFont().deriveFont(RangeDeliveryDate.getFont().getSize() + 2f));
        contentPane.add(RangeDeliveryDate);
        RangeDeliveryDate.setBounds(1005, 445, 140, 20);

        //---- Rangecount ----
        Rangecount.setText("\u8ba2\u8d27\u9879\u6570");
        Rangecount.setFont(Rangecount.getFont().deriveFont(Rangecount.getFont().getSize() + 2f));
        contentPane.add(Rangecount);
        Rangecount.setBounds(1005, 475, 140, 20);
        contentPane.add(Rangelower);
        Rangelower.setBounds(835, 520, 105, 30);

        //---- label4 ----
        label4.setText("~");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(940, 525, 30, label4.getPreferredSize().height);
        contentPane.add(Rangeupper);
        Rangeupper.setBounds(970, 520, 105, 30);

        //---- RangeResearch ----
        RangeResearch.setText("\u67e5\u8be2");
        RangeResearch.setFont(RangeResearch.getFont().deriveFont(RangeResearch.getFont().getSize() + 2f));
        RangeResearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RangeResearchMouseClicked(e);
            }
        });
        contentPane.add(RangeResearch);
        RangeResearch.setBounds(new Rectangle(new Point(1085, 520), RangeResearch.getPreferredSize()));

        //---- Refresh ----
        Refresh.setText("\u5237\u65b0\u8ba2\u5355");
        Refresh.setFont(Refresh.getFont().deriveFont(Refresh.getFont().getSize() + 4f));
        Refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshMouseClicked(e);
            }
        });
        contentPane.add(Refresh);
        Refresh.setBounds(1005, 115, 140, 45);

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
    private JLabel label1;
    private JScrollPane scrollPane;
    private JTable Ordertable;
    private JButton Check;
    private JButton Handle;
    private JButton Withdraw;
    private JLabel label2;
    private JRadioButton OrderNum;
    private JRadioButton Address;
    private JRadioButton DeliveryDate;
    private JRadioButton SupplyNum;
    private JRadioButton OrderDate;
    private JRadioButton Payment;
    private JTextField textField1;
    private JButton Research;
    private JLabel label3;
    private JRadioButton RangeOrderDate;
    private JRadioButton RangePayment;
    private JRadioButton RangeDeliveryDate;
    private JRadioButton Rangecount;
    private JTextField Rangelower;
    private JLabel label4;
    private JTextField Rangeupper;
    private JButton RangeResearch;
    private JButton Refresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
