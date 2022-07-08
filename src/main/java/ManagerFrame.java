import com.sun.org.apache.xpath.internal.operations.Or;
import util.MyOptionPane;
import util.Res;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 10:59:42 CST 2022
 */


/**
 * @author unknown
 */
public class ManagerFrame extends JFrame implements Res {
    public ManagerFrame(String Number) {
        initComponents(Number);
    }

    private void ProductManageMouseClicked(MouseEvent e) {
        // TODO add your code here
        new ProductManage(UserNum.getText()).setVisible(true);
        dispose();
    }

    private void modifyMouseClicked(String Number) {
        // TODO add your code here
        ModifyImformation(Number);
    }

    private void OrderManageMouseClicked(MouseEvent e) {
        // TODO add your code here
        new OrderManage(UserNum.getText()).setVisible(true);
        dispose();
    }

    private void CostomerManageMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void ConfirmMouseClicked(String Number) {
        // TODO add your code here
        ConfirmModify(Number);
    }

    private void CancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        CancelModify();
    }

    private void logoutMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(MyOptionPane.showConfirmDialog(this, "提示", "你确认要退出登录？", "确认", "取消")){
            dispose();
            new LoginFrame().setVisible(true);
        }
    }

    private void initComponents(String Number) {
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
        CustomerManage = new JButton();
        ProductManage = new JButton();
        logout = new JButton();
        ManagePanel = new JPanel(){
            @Override
            /**
             * 重写该方法以设置背景图片
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.drawImage(ManageBackground, 0, 0, ManageBackground.getWidth(), ManageBackground.getHeight(), null);
            }
        };

        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt= null;
        String SQL = "select * from customer_info where cno=" + "'" + Number + "'";
        String cno = null, cna = null, cad = null, cte = null;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            result.next();
            cno = result.getString("cno").trim();
            cna = result.getString("cna").trim();
            cad = result.getString("cad").trim();
            cte = result.getString("cte").trim();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //======== this ========
        setContentPane(ManagePanel);
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
                modifyMouseClicked(Number);
            }
        });
        contentPane.add(modify);
        modify.setBounds(20, 335, 145, 30);
        modify.setContentAreaFilled(false);

        //---- label5 ----
        label5.setText("地址：");
        label5.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label5);
        label5.setBounds(20, 300, 55, 25);

        //---- Address ----
        Address.setText(cad);
        Address.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Address);
        Address.setBounds(75, 300, 175, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText(cte);
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
        UserName.setText(cna);
        UserName.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserName);
        UserName.setBounds(75, 220, 135, 25);

        //---- UserNum ----
        UserNum.setText(cno);
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
        OrderManage.setContentAreaFilled(false);

        //---- CostomerManage ----
        CustomerManage.setText("\u987e\u5ba2\u7ba1\u7406");
        CustomerManage.setFont(CustomerManage.getFont().deriveFont(CustomerManage.getFont().getSize() + 4f));
        CustomerManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CostomerManageMouseClicked(e);
            }
        });
        contentPane.add(CustomerManage);
        CustomerManage.setBounds(475, 355, 240, 45);
        CustomerManage.setContentAreaFilled(false);

        //---- ProductManage ----
        ProductManage.setText("\u4ea7\u54c1\u7ba1\u7406");
        ProductManage.setFont(ProductManage.getFont().deriveFont(ProductManage.getFont().getSize() + 4f));
        ProductManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductManageMouseClicked(e);
            }
        });
        contentPane.add(ProductManage);
        ProductManage.setBounds(470, 190, 240, 45);
        ProductManage.setContentAreaFilled(false);

        //---- logout ----
        logout.setText("退出登录");
        logout.setFont(logout.getFont().deriveFont(logout.getFont().getSize() + 4f));
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutMouseClicked(e);
            }
        });
        contentPane.add(logout);
        logout.setBounds(30, 510, 175, 50);
        logout.setContentAreaFilled(false);

        setSize(1000, 620);
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
    private JButton CustomerManage;
    private JButton ProductManage;
    private JButton Confirm;
    private JButton Cancel;
    private JPanel ManagePanel;
    private JTextField UserNumText;
    private JTextField UserNameText;
    private JTextField PhoneNumberText;
    private JTextField AddressText;
    private JButton logout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void ModifyImformation(String Number){

        UserNumText = new JTextField();
        UserNameText = new JTextField();
        PhoneNumberText = new JTextField();
        AddressText = new JTextField();
        Confirm = new JButton();
        Cancel = new JButton();


        Container contentPane = getContentPane();
        /*//---- UserNum ----
        UserNumText.setText(UserNum.getText());
        UserNumText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNumText);
        UserNumText.setBounds(75, 180, 180, 25);*/

        //---- UserName ----
        UserNameText.setText(UserName.getText());
        UserNameText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNameText);
        UserNameText.setBounds(75, 220, 180, 25);

        //---- PhoneNumber ----
        PhoneNumberText.setText(PhoneNumber.getText());
        PhoneNumberText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(PhoneNumberText);
        PhoneNumberText.setBounds(75, 260, 180, 25);

        //---- Address ----
        AddressText.setText(Address.getText());
        AddressText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(AddressText);
        AddressText.setBounds(75, 300, 180, 25);


        contentPane.remove(modify);
        contentPane.repaint();

        //---- Confirm ----
        Confirm.setText("确认");
        Confirm.setFont(Confirm.getFont().deriveFont(Confirm.getFont().getSize() + 4f));
        Confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfirmMouseClicked(Number);
            }
        });
        contentPane.add(Confirm);
        Confirm.setBounds(15, 345, 70, 30);
        Confirm.setContentAreaFilled(false);
        //---- Cancel ----
        Cancel.setText("取消");
        Cancel.setFont(Cancel.getFont().deriveFont(Cancel.getFont().getSize() + 4f));
        Cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CancelMouseClicked(e);
            }
        });
        contentPane.add(Cancel);
        Cancel.setBounds(100, 345, 70, 30);
        Cancel.setContentAreaFilled(false);
    }

    private void ConfirmModify(String Number){
        Container contentPane = getContentPane();
//        contentPane.remove(UserNumText);
        contentPane.remove(UserNameText);
        contentPane.remove(AddressText);
        contentPane.remove(PhoneNumberText);
        contentPane.remove(Confirm);
        contentPane.remove(Cancel);
        contentPane.add(modify);
        contentPane.repaint();
        UserName.setText(UserNameText.getText());
        PhoneNumber.setText(PhoneNumberText.getText());
        Address.setText(AddressText.getText());

        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "update customer_info set cna='" + UserNameText.getText() + "'"
                + ", cad='" + AddressText.getText() + "'" + ", cte='" + PhoneNumberText.getText() + "'"
                + "where cno='" + Number + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            System.out.println("资料修改成功了！！！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void CancelModify(){
        Container contentPane = getContentPane();
        contentPane.remove(UserNumText);
        contentPane.remove(UserNameText);
        contentPane.remove(AddressText);
        contentPane.remove(PhoneNumberText);
        contentPane.remove(Confirm);
        contentPane.remove(Cancel);
        contentPane.add(modify);
        contentPane.repaint();
    }


}
