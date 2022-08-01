import util.MyOptionPane;
import util.Res;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

/*
 * Created by JFormDesigner on Mon Jun 27 09:44:52 CST 2022
 */
/**
 * @author unknown
 */

public class LoginFrame extends JFrame implements Res {
    public static void main(String[]args){
    new LoginFrame();
    }
    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        Username = new JTextField();
        UserText = new JLabel();
        PassText = new JLabel();
        Password = new JPasswordField();
        login = new JButton();
        exit = new JButton();
        register = new JButton();
        retrieve = new JButton();
        Title = new JLabel();
        LoginPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.drawImage(LoginBackground, 0, 0, LoginBackground.getWidth(), LoginBackground.getHeight(), null);
            }
        };
        LoginPanel.setLayout(null);

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        setContentPane(LoginPanel);
//        setResizable(false);
        setTitle("登录");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        LoginPanel.add(Username);
        Username.setBounds(160, 115, 120, 30);
        Username.setOpaque(false);


        //---- UserText ----
        UserText.setText("用户名：");
        LoginPanel.add(UserText);
        UserText.setBounds(105, 120, 60, 17);

        //---- PassText ----
        PassText.setText("密码：");
        LoginPanel.add(PassText);
        PassText.setBounds(115, 165, 40, 17);

        LoginPanel.add(Password);
        Password.setBounds(160, 155, 120, 30);
        Password.setOpaque(false);

        //---- login ----
        login.setText("登录");
        LoginPanel.add(login);
        login.setBounds(125, 220, 78, 30);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginmouseClicked(e);
            }
        });
        login.setContentAreaFilled(false);

        //---- exit ----
        exit.setText("退出");
        LoginPanel.add(exit);
        exit.setBounds(235, 220, 78, 30);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitmouseClicked(e);
            }
        });
        exit.setContentAreaFilled(false);

        //---- register ----
        register.setText("注册账号");
        LoginPanel.add(register);
        register.setBounds(new Rectangle(new Point(295, 115), register.getPreferredSize()));
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registermouseClicked(e);
            }
        });
        register.setContentAreaFilled(false);

        //---- retrieve ----
        retrieve.setText("找回密码");
        LoginPanel.add(retrieve);
        retrieve.setBounds(new Rectangle(new Point(295, 155), retrieve.getPreferredSize()));
        retrieve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                retrievemouseClicked(e);
            }
        });
        retrieve.setContentAreaFilled(false);

        //---- Title ----
        Title.setText("欢迎使用产品销售管理系统");
        Title.setFont(Title.getFont().deriveFont(Font.BOLD, Title.getFont().getSize() + 12f));
        LoginPanel.add(Title);
        Title.setBounds(new Rectangle(new Point((500-(int)Title.getPreferredSize().getWidth())/2, 40), Title.getPreferredSize()));


        setSize(500, 400);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void thisWindowClosing(WindowEvent e) {
        if (MyOptionPane.showConfirmDialog(this, "提示", "你是否要退出？", "是", "否")) {
            dispose();
        }
    }

    /**
     * 找回账号按钮监听器触发事件
     * @param e
     */
    private void retrievemouseClicked(MouseEvent e) {
        dispose();
        new RetrieveFrame().setVisible(true);
    }

    /**
     * 注册账号按钮监听器触发事件
     * @param e
     */
    private void registermouseClicked(MouseEvent e) {
        dispose();
        new RegisterFrame().setVisible(true);
    }

    /**
     * 登录按钮监听器触发事件
     * @param e
     */
    private void loginmouseClicked(MouseEvent e) {
        String UserNum = Username.getText();
        Statement stmt = null;
        String Pass = new String(Password.getPassword());
        Connection con = DatabaseConnection.getConnection();
        String SQL = "select * from regist_info where no=" + "'" +  UserNum + "'";
        ResultSet result = null;
        int sign = 0;
        String password = null;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            if(result.next()){
                sign = result.getInt("sign");
                password = result.getString("password").trim();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        System.out.println("密码：" + password + password.length() + "职务：" + sign);
        Boolean Judge;
        if(Pass.equals(password)){
            Judge = true;
        }
        else{
            Judge = false;
        }
        if(sign == 1 && Judge){
            /**
             * 结束当前窗口的进程，并开启管理员窗口进程
             */
            MyOptionPane.showMessageDialog(this, "登录成功！", "欢迎使用产品管理系统");
//            JOptionPane.showConfirmDialog(null, "登录成功！", "欢迎使用产品管理系统", JOptionPane.DEFAULT_OPTION);
            dispose();
            new ManagerFrame(UserNum).setVisible(true);
        }
        else if(sign == 2 && Judge){
            /**
             * 结束当前窗口进程，并开启顾客窗口进程
             */
            MyOptionPane.showMessageDialog(this, "登录成功！", "欢迎使用产品管理系统");
            dispose();
            new CustomerFrame(UserNum).setVisible(true);
        }
        else if(sign == 3 && Judge){
            /**
             * 结束当前窗口进程，并开启供应商窗口进程
             */
            MyOptionPane.showMessageDialog(this, "登录成功！", "欢迎使用产品管理系统");
            dispose();

        }else{
            /**
             * 显示对话框“输入的账号或者密码错误”
             */
            MyOptionPane.showMessageDialog(this, "输入的用户名或密码错误，请重试！", "登录失败");
//            JOptionPane.showMessageDialog(null, "输入的用户名或密码错误，请重试！", "ERROR", JOptionPane.WARNING_MESSAGE);
            Username.setText("");
            Password.setText("");
        }
    }

    /**
     * 退出按钮的监听器触发事件
     * @param e
     */
    private void exitmouseClicked(MouseEvent e) {
        if (MyOptionPane.showConfirmDialog(this, "提示", "你是否要退出？", "是", "否")) {
            dispose();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField Username;
    private JLabel UserText;
    private JLabel PassText;
    private JPasswordField Password;
    private JButton login;
    private JButton exit;
    private JButton register;
    private JButton retrieve;
    private JLabel Title;
    private JPanel LoginPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
