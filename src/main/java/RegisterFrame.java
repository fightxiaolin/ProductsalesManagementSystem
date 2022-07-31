import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Jul 31 15:58:26 CST 2022
 */



/**
 * @author unknown
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        initComponents();
    }

    private void RegisterMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        UserNum = new JTextField();
        label6 = new JLabel();
        UserName = new JTextField();
        Password = new JTextField();
        PhoneNumber = new JTextField();
        Address = new JTextField();
        Register = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        setTitle("用户注册");
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText("用户号：");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(105, 100, 80, 25);

        //---- label3 ----
        label3.setText("用户名：");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label3);
        label3.setBounds(105, 170, 80, 25);

        //---- label4 ----
        label4.setText("密码：");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label4);
        label4.setBounds(105, 240, 80, 25);

        //---- label5 ----
        label5.setText("手机号：");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label5);
        label5.setBounds(105, 310, 80, 25);

        //---- UserNum ----
        UserNum.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(UserNum);
        UserNum.setBounds(190, 95, 240, UserNum.getPreferredSize().height);

        //---- label6 ----
        label6.setText("地址：");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label6);
        label6.setBounds(105, 380, 80, 25);

        //---- UserName ----
        UserName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(UserName);
        UserName.setBounds(190, 165, 240, 37);

        //---- Password ----
        Password.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(Password);
        Password.setBounds(190, 235, 240, 37);

        //---- PhoneNumber ----
        PhoneNumber.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(190, 305, 240, 37);

        //---- Address ----
        Address.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(Address);
        Address.setBounds(190, 375, 240, 37);

        //---- Register ----
        Register.setText("立即注册");
        Register.setFont(Register.getFont().deriveFont(Register.getFont().getSize() + 4f));
        Register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterMouseClicked(e);
            }
        });
        contentPane.add(Register);
        Register.setBounds(170, 460, 175, 50);

        setSize(560,600);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField UserNum;
    private JLabel label6;
    private JTextField UserName;
    private JTextField Password;
    private JTextField PhoneNumber;
    private JTextField Address;
    private JButton Register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new RegisterFrame().setVisible(true);
    }
}

