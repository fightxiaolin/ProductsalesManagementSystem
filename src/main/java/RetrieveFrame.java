import util.MyOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Jul 31 19:47:12 CST 2022
 */



/**
 * @author unknown
 */
public class RetrieveFrame extends JFrame {
    public RetrieveFrame() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });
    }

    private void RetrieveMouseClicked(MouseEvent e) {
        // TODO add your code here
        boolean bool = true;
        if(UserNum.getText().isEmpty()){
            //显示错误提示
            bool = false;
            MyOptionPane.showMessageDialog(this, "请输入需要找回的用户号！", "提示");
        }
        else if(PhoneNumber.getText().isEmpty()){
            bool = false;
            MyOptionPane.showMessageDialog(this, "请输入对应的手机号！", "提示");
        }
        else{
            Statement stmt = null;
            Connection con = DatabaseConnection.getConnection();
            String SQL = "select cte from customer_info where cno='" + UserNum.getText().trim() + "'";
            ResultSet result = null;
            try {
                stmt = con.createStatement();
                result = stmt.executeQuery(SQL);
                if(result.next()){
                    System.out.println(result.getString("cte").trim());
                    if(!PhoneNumber.getText().trim().equals(result.getString("cte").trim())){
                        bool = false;
                        MyOptionPane.showMessageDialog(this, "输入的用户号或手机号错误！", "提示");
                    }
                }
                else{
                    bool = false;
                    MyOptionPane.showMessageDialog(this, "输入的用户号不存在！", "提示");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //显示一个输入弹窗，来实现验证码
        if(bool){
            String input = MyOptionPane.showInputDialog(this,"","请输入验证码：");

            if(input.equals("123456")){
                String newpass = MyOptionPane.showInputDialog(this, "", "请输入新的登录密码：");
                if(!newpass.isEmpty()){
                    Statement stmt = null;
                    Connection con = DatabaseConnection.getConnection();
                    String SQL = "update regist_info set password='" + newpass + "' where no='" + UserNum.getText().trim() + "'";
                    try {
                        stmt = con.createStatement();
                        stmt.executeUpdate(SQL);
                        MyOptionPane.showMessageDialog(this, "密码重置成功！", "提示");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                dispose();
                new LoginFrame().setVisible(true);
            }
            else{
                MyOptionPane.showMessageDialog(this, "验证码错误，请输入正确的验证码！", "提示");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        UserNum = new JTextField();
        label2 = new JLabel();
        PhoneNumber = new JTextField();
        label3 = new JLabel();
        Retrieve = new JButton();

        //======== this ========
        setTitle("找回密码");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- UserNum ----
        UserNum.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(UserNum);
        UserNum.setBounds(185, 105, 240, 37);

        //---- label2 ----
        label2.setText("用户号：");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(100, 110, 80, 25);

        //---- PhoneNumber ----
        PhoneNumber.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(185, 175, 240, 37);

        //---- label3 ----
        label3.setText("电话：");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label3);
        label3.setBounds(100, 180, 80, 25);

        //---- Retrieve ----
        Retrieve.setText("找回密码");
        Retrieve.setFont(Retrieve.getFont().deriveFont(Retrieve.getFont().getSize() + 4f));
        Retrieve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RetrieveMouseClicked(e);
            }
        });
        contentPane.add(Retrieve);
        Retrieve.setBounds(165, 265, 175, 50);

        setSize(560, 400);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField UserNum;
    private JLabel label2;
    private JTextField PhoneNumber;
    private JLabel label3;
    private JButton Retrieve;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
