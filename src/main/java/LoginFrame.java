import javafx.beans.property.ReadOnlySetProperty;
import util.Res;

import java.awt.*;
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
                g.drawImage(UserImage, 0, 0, UserImage.getWidth(), UserImage.getHeight(), null);
            }
        };
        LoginPanel.setLayout(null);

        //======== this ========

        /*Container contentPane = getContentPane();
        contentPane.add(LoginPanel);
        contentPane.setLayout(null);*/
        setContentPane(LoginPanel);
//        LoginPanel.setSize(500, 400);
        setResizable(false);
        setTitle("登录");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LoginPanel.add(Username);
        Username.setBounds(160, 115, 120, 30);



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

        //---- login ----
        login.setText("登录");
        LoginPanel.add(login);
        login.setBounds(125, 220, 78, 30);

        //---- exit ----
        exit.setText("退出");
        LoginPanel.add(exit);
        exit.setBounds(235, 220, 78, 30);

        //---- register ----
        register.setText("注册账号");
        LoginPanel.add(register);
        register.setBounds(new Rectangle(new Point(295, 115), register.getPreferredSize()));

        //---- retrieve ----
        retrieve.setText("找回密码");
        LoginPanel.add(retrieve);
        retrieve.setBounds(new Rectangle(new Point(295, 155), retrieve.getPreferredSize()));

        //---- Title ----
        Title.setText("欢迎使用产品销售管理系统");
        Title.setFont(Title.getFont().deriveFont(Font.BOLD, Title.getFont().getSize() + 12f));
        LoginPanel.add(Title);
        Title.setBounds(new Rectangle(new Point((500-(int)Title.getPreferredSize().getWidth())/2, 40), Title.getPreferredSize()));


        setSize(500, 400);
        /*{
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

        pack();*/
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
