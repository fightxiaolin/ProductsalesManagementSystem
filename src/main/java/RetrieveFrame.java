import java.awt.*;
import java.awt.event.*;
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
        if(UserNum.getText().isEmpty()){
            //显示错误提示
        }
        else if(PhoneNumber.getText().isEmpty()){

        }

        //显示一个输入弹窗，来实现验证码


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
