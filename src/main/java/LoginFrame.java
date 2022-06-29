import util.Res;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 09:44:52 CST 2022
 */



/**
 * @author unknown
 */
public class LoginFrame extends JFrame implements Res {
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
                g.drawImage(LoginBackground, 0, 0, LoginBackground.getWidth(), LoginBackground.getHeight(), null);
            }
        };
        LoginPanel.setLayout(null);

        //======== this ========
        
        setContentPane(LoginPanel);
        setResizable(false);
        setTitle("登录");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

    /**
     * 找回账号按钮监听器触发事件
     * @param e
     */
    private void retrievemouseClicked(MouseEvent e) {

    }

    /**
     * 注册账号按钮监听器触发事件
     * @param e
     */
    private void registermouseClicked(MouseEvent e) {

    }

    /**
     * 登录按钮监听器出发事件
     * @param e
     */
    private void loginmouseClicked(MouseEvent e) {
        String UserNum = Username.getText();
        String Pass = new String(Password.getPassword());
        String Type;
        if(UserNum.equals("123456")){
            Type = "Costomer";
        }
        else {
            Type = "Manager";
        }
        Boolean Judge;
        if(Pass.equals("xiaolin")){
            Judge = true;
        }
        else{
            Judge = false;
        }
        if(Type.equals("Manager") && Judge){
            dispose();
            new ManagerFrame().setVisible(true);
        }
        else if(Type.equals("Costomer") && Judge){
            dispose();
            new CustomerFrame().setVisible(true);
        }
    }

    /**
     * 退出按钮的监听器触发事件
     * @param e
     */
    private void exitmouseClicked(MouseEvent e) {
        dispose();
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

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
