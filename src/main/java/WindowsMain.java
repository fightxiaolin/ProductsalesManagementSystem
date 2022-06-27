import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WindowsMain {
        private JFrame frame;
        private String userNow;
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        WindowsMain window = new WindowsMain();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        private WindowsMain() {
            initialize();
        }
        private static void initialize() {
            final JFrame frame = new JFrame("药品销存管理系统");
            frame.setBounds(100, 100, 800, 450);
            //窗口居中
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            frame.setVisible(true);

            //添加窗口组件
            JLabel label = new JLabel("欢迎进入药品销存管理系统！");
            JLabel labUsername = new JLabel("用户名");
            JLabel labPassword = new JLabel("密码");
            final JTextField username = new JTextField(20);
            final JPasswordField password = new JPasswordField(20);
            JButton btn1 = new JButton("登录");
            JButton btn2 = new JButton("退出");

            frame.getContentPane().add(label);
            frame.getContentPane().add(labUsername);
            frame.getContentPane().add(labPassword);
            frame.getContentPane().add(username);
            frame.getContentPane().add(password);
            frame.getContentPane().add(btn1);
            frame.getContentPane().add(btn2);

            //设置组件属性
            label.setBounds(220, 40, 500, 75);
            labUsername.setBounds(260, 150, 60, 40);
            labPassword.setBounds(265, 220, 60, 40);
            username.setBounds(320, 150, 180, 40);
            password.setBounds(320, 220, 180, 40);
            btn1.setBounds(250, 290, 100, 30);
            btn2.setBounds(420, 290, 100, 30);
            //设置文字的字体及大小
            label.setFont(new Font("", Font.BOLD, 30));
            //设置按钮功能
            //登录
            btn1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //登陆验证
                    if (username.getText().trim().length() == 0 || new String(password.getPassword()).trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
                        return;
                    } else {
                        String loginName = username.getText().trim();
                        String loginPwd = new String(password.getPassword()).trim();
                        //查询数据库
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        //向表中传入数据
                        sql = "SELECT * FROM user WHERE username=" + loginName + " AND password=" + loginPwd;
                        try {
                            assert statement != null;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                if (!rs.getString("id").equals(0)) {
                                    System.out.println("登陆成功");
                                    //查询用户类别，进入不同的页面
                                    String roleId = rs.getString("role_id");
                                    String username = rs.getString("username");
                                    System.out.println(roleId);
                                    checkUserRole(roleId, username);
                                    frame.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                                }
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }
                }
            });
            //退出
            btn2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

        }//主界面的方法
        private static void checkUserRole(String roleId, final String username) {


            if (roleId.equals("1")) {
                //管理员
                System.out.println("管理员");

                final JFrame amdin = new JFrame("药品销存管理系统-管理员");
                amdin.setBounds(100, 100, 800, 450);
                //窗口居中
                amdin.setLocationRelativeTo(null);
                amdin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                amdin.getContentPane().setLayout(null);
                amdin.setVisible(true);
                //添加窗口组件
                JButton btn1 = new JButton("员工记录");
                JButton btn2 = new JButton("库存记录");
                JButton btn3 = new JButton("销售记录");
                JButton btn4 = new JButton("账号设置");
                JButton btn33 = new JButton("退出");

                amdin.getContentPane().add(btn1);
                amdin.getContentPane().add(btn2);
                amdin.getContentPane().add(btn3);
                amdin.getContentPane().add(btn4);
                amdin.getContentPane().add(btn33);

                btn1.setBounds(125, 30, 100, 40);
                btn2.setBounds(275, 30, 100, 40);
                btn3.setBounds(425, 30, 100, 40);
                btn4.setBounds(575, 30, 100, 40);
                btn33.setBounds(550, 320, 100, 30);

                //退出
                btn33.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        amdin.dispose();
                    }
                });

                //员工信息按钮事件
                btn1.addActionListener(new ActionListener() {
                    //创建一个表单
                    String columns[] = {"序号", "用户名", "密码", "姓名", "所属角色"};
                    Object cells[][] = new Object[100][5];

                    public void actionPerformed(ActionEvent e) {
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        sql = "SELECT user.id,username,password,name,role_name FROM user INNER JOIN role ON user.role_id=role.role_id";
                        try {
                            int count = 0;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                cells[count][0] = rs.getString("id");
                                cells[count][1] = rs.getString("username");
                                cells[count][2] = rs.getString("password");
                                cells[count][3] = rs.getString("name");
                                cells[count][4] = rs.getString("role_name");
                                count++;
                            }

                            String title = "用户信息表";
                            FTable fTable = new FTable(cells, columns, title);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }

                        try {
                            statement.executeQuery(sql);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }
                });

                //库存管理按钮事件
                btn2.addActionListener(new ActionListener() {
                    //创建一个表单
                    String columns[] = {"序号", "药品名", "进价", "售价", "数量", "生产厂商"};
                    Object cells[][] = new Object[100][6];

                    public void actionPerformed(ActionEvent e) {
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        sql = "SELECT * FROM medic";
                        try {
                            int count = 0;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                cells[count][0] = rs.getString("id");
                                cells[count][1] = rs.getString("medic_name");
                                cells[count][2] = rs.getString("input_price");
                                cells[count][3] = rs.getString("price");
                                cells[count][4] = rs.getString("num");
                                cells[count][5] = rs.getString("address");
                                count++;
                            }
                            String title = "药品信息表";
                            FTable fTable = new FTable(cells, columns, title);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        try {
                            statement.executeQuery(sql);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }
                });

                //销售管理按钮事件
                btn3.addActionListener(new ActionListener() {
                    //创建一个表单
                    String columns[] = {"序号", "药品名", "售价", "数量", "销售时间","共计金额"};
                    Object cells[][] = new Object[100][6];
                    public void actionPerformed(ActionEvent e) {
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        sql="SELECT medic.id,medic.medic_name,medic.price,record.medic_num,record.time,record.sum_price FROM record INNER JOIN medic ON record.medic_id=medic.id";
                        try {
                            int count = 0;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                cells[count][0] = rs.getString("id");
                                cells[count][1] = rs.getString("medic_name");
                                cells[count][2] = rs.getString("price");
                                cells[count][3] = rs.getString("medic_num");
                                cells[count][4] = rs.getString("time");
                                cells[count][5] = rs.getString("sum_price");
                                count++;
                            }
                            String title = "销售信息表";
                            FTable fTable = new FTable(cells, columns, title);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }

                        try {
                            statement.executeQuery(sql);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }

                });
                //用户管理按钮事件
                btn4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final JFrame updatePwd = new JFrame("药品销存管理系统-管理员");
                        updatePwd.setBounds(100, 100, 800, 450);
                        //窗口居中
                        updatePwd.setLocationRelativeTo(null);
                        updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatePwd.getContentPane().setLayout(null);
                        updatePwd.setVisible(true);
                        //添加窗口组件
                        JButton btn0 = new JButton("增加");
                        JButton btn1 = new JButton("修改");
                        JButton btn2 = new JButton("删除");
                        JButton btn22 = new JButton("分配");
                        JButton btn3 = new JButton("返回");

                        btn0.setBounds(120, 30, 100, 40);
                        btn1.setBounds(240, 30, 100, 40);
                        btn2.setBounds(360, 30, 100, 40);
                        btn22.setBounds(480, 30, 100, 40);
                        btn3.setBounds(600, 30, 100, 40);

                        updatePwd.getContentPane().add(btn0);
                        updatePwd.getContentPane().add(btn1);
                        updatePwd.getContentPane().add(btn2);
                        updatePwd.getContentPane().add(btn22);
                        updatePwd.getContentPane().add(btn3);

                        //修改数据
                        btn1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-管理员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("修改员工信息");
                                JLabel labid = new JLabel("id：");
                                JLabel labusername = new JLabel("用户名：");
                                JLabel labpassword = new JLabel("密码：");
                                JLabel labname = new JLabel("员工姓名：");
                                JLabel labrole_id = new JLabel("员工等级：");

                                final JTextField id = new JTextField(20);
                                final JTextField newusername  = new JTextField(20);
                                final JTextField newpassword = new JTextField(20);
                                final JTextField newname = new JTextField(20);
                                final JTextField newrole_id = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(labusername);
                                updatePwd.getContentPane().add(labpassword);
                                updatePwd.getContentPane().add(labname);
                                updatePwd.getContentPane().add(labrole_id);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(newusername);
                                updatePwd.getContentPane().add(newpassword);
                                updatePwd.getContentPane().add(newname);
                                updatePwd.getContentPane().add(newrole_id);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                labid.setBounds(120, 100, 80, 40);
                                id.setBounds(220, 100, 120, 40);
                                labusername.setBounds(460, 100, 80, 40);
                                newusername.setBounds(560, 100, 120, 40);

                                labpassword.setBounds(120, 170, 80, 40);
                                newpassword.setBounds(220, 170, 120, 40);
                                labname.setBounds(460, 170, 80, 40);
                                newname.setBounds(560, 170, 120, 40);

                                labrole_id.setBounds(120, 240, 80, 40);
                                newrole_id.setBounds(220, 240, 120, 40);
                                btn.setBounds(400, 320, 100, 30);
                                btn3.setBounds(550, 320, 100, 30);
                                add.setBounds(320, 30, 200, 75);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labusername.setFont(new Font("", 0, 15));
                                labpassword.setFont(new Font("", 0, 15));
                                labname.setFont(new Font("", 0, 15));
                                labrole_id.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        String logusername = newusername.getText().trim();
                                        String logpassword = newpassword.getText().trim();
                                        String logname = newname.getText().trim();
                                        String logrole_id = newrole_id.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!=""){
                                            String sql = null;
                                            sql = "update user set username='" + logusername + "',password='" + logpassword + "',name = '" + logname + "',role_id='" + logrole_id + "' where id='" + logid + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "修改员工信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });
                            }
                        });
                        //删除数据
                        btn2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-管理员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("删除员工信息");
                                JLabel labid = new JLabel("id行：");
                                final JTextField id = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                labid.setBounds(120, 150, 60, 30);
                                id.setBounds(220, 150, 100, 30);

                                btn.setBounds(250, 300, 100, 30);
                                btn3.setBounds(400, 300, 100, 30);
                                add.setBounds(320, 30, 200, 75);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!=""){
                                            String sql = null;
                                            sql = "delete from user where id='" + logid + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                int b = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "删除员工信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {

                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });
                            }
                        });
                        //返回按钮
                        btn3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                updatePwd.dispose();
                            }
                        });
                        //增加数据
                        btn0.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                final JFrame addgoods = new JFrame("药品销存管理系统-管理员");
                                addgoods.setBounds(100, 100, 800, 450);
                                //窗口居中
                                addgoods.setLocationRelativeTo(null);
                                addgoods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                addgoods.getContentPane().setLayout(null);
                                addgoods.setVisible(true);

                                JLabel add = new JLabel("添加员工信息");

                                JLabel labid = new JLabel("id");
                                JLabel labusername = new JLabel("用户名");
                                JLabel labpassword = new JLabel("密码");
                                JLabel labname = new JLabel("姓名");
                                JLabel labrole_id = new JLabel("员工等级");

                                final JTextField id = new JTextField(20);
                                final JTextField username = new JTextField(20);
                                final JTextField password = new JTextField(20);
                                final JTextField name = new JTextField(20);
                                final JTextField role_id = new JTextField(20);

                                JButton btnn = new JButton("确定");
                                JButton btnn5 = new JButton("取消");

                                addgoods.getContentPane().add(add);
                                addgoods.getContentPane().add(labid);
                                addgoods.getContentPane().add(labusername);
                                addgoods.getContentPane().add(labpassword);
                                addgoods.getContentPane().add(labname);
                                addgoods.getContentPane().add(labrole_id);

                                addgoods.getContentPane().add(id);
                                addgoods.getContentPane().add(username);
                                addgoods.getContentPane().add(password);
                                addgoods.getContentPane().add(name);
                                addgoods.getContentPane().add(role_id);

                                addgoods.getContentPane().add(btnn);
                                addgoods.getContentPane().add(btnn5);

                                add.setBounds(320, 30, 200, 75);

                                labid.setBounds(120, 100, 80, 40);
                                id.setBounds(220, 100, 120, 40);
                                labusername.setBounds(460, 100, 80, 40);
                                username.setBounds(560, 100, 120, 40);

                                labpassword.setBounds(120, 170, 80, 40);
                                password.setBounds(220, 170, 120, 40);
                                labname.setBounds(460, 170, 80, 40);
                                name.setBounds(560, 170, 120, 40);

                                labrole_id.setBounds(120, 240, 80, 40);
                                role_id.setBounds(220, 240, 120, 40);

                                btnn.setBounds(400, 320, 100, 30);
                                btnn5.setBounds(550, 320, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labusername.setFont(new Font("", 0, 15));
                                labpassword.setFont(new Font("", 0, 15));
                                labname.setFont(new Font("", 0, 15));
                                labrole_id.setFont(new Font("", 0, 15));

                                //编号对话框确定键监听事件
                                btnn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        ///获取输入的信息
                                        if (id.getText().equals("") ||username.getText().equals("") ||password.getText().equals("") || name.getText().equals("") || role_id.getText().equals("") ) {
                                            JOptionPane.showMessageDialog(null, "表单不能为空！");
                                        } else {
                                            Connection con = SqlOperation.getConnection();
                                            Statement statement = null;
                                            try {
                                                statement = con.createStatement();
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }

                                            String sql = null;
                                            //向表中传入数据
                                            sql = "INSERT INTO user(id,username,password,name,role_id) VALUES (" + "'" + id.getText() + "'" + "," + "'" + username.getText() + "'" + "," + "'" + password.getText() + "'" + "," + "'" + name.getText() + "'" + "," + "'" + role_id.getText() + "'" + ")";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "添加成功");
                                                    addgoods.dispose();
                                                }

                                            } catch (SQLException e1) {
                                                // TODO Auto-generated catch block
                                                e1.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                    }
                                });
                                btnn5.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        addgoods.dispose();
                                    }
                                });
                            }
                        });
                        //分配职务
                        btn22.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                final JFrame addgoods = new JFrame("药品销存管理系统-管理员");
                                addgoods.setBounds(100, 100, 800, 450);
                                //窗口居中
                                addgoods.setLocationRelativeTo(null);
                                addgoods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                addgoods.getContentPane().setLayout(null);
                                addgoods.setVisible(true);

                                JLabel add = new JLabel("分配员工职务");

                                JLabel labid = new JLabel("role_id");
                                JLabel labrole_name = new JLabel("员工职务");

                                final JTextField id = new JTextField(20);
                                final JTextField role_name = new JTextField(20);

                                JButton btnn = new JButton("确定");
                                JButton btnn5 = new JButton("取消");

                                addgoods.getContentPane().add(add);
                                addgoods.getContentPane().add(labid);
                                addgoods.getContentPane().add(labrole_name);

                                addgoods.getContentPane().add(id);
                                addgoods.getContentPane().add(role_name);

                                addgoods.getContentPane().add(btnn);
                                addgoods.getContentPane().add(btnn5);

                                add.setBounds(320, 30, 200, 75);

                                labid.setBounds(120, 100, 80, 40);
                                id.setBounds(220, 100, 120, 40);
                                labrole_name.setBounds(460, 100, 80, 40);
                                role_name.setBounds(560, 100, 120, 40);

                                btnn.setBounds(400, 320, 100, 30);
                                btnn5.setBounds(550, 320, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labrole_name.setFont(new Font("", 0, 15));

                                //编号对话框确定键监听事件
                                btnn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        ///获取输入的信息
                                        if (id.getText().equals("") ||role_name.getText().equals("") ) {
                                            JOptionPane.showMessageDialog(null, "表单不能为空！");
                                        } else {
                                            Connection con = SqlOperation.getConnection();
                                            Statement statement = null;
                                            try {
                                                statement = con.createStatement();
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }

                                            String sql = null;
                                            //向表中传入数据
                                            sql = "INSERT INTO role(role_id,role_name) VALUES (" + "'" + id.getText() + "'" + "," + "'" + role_name.getText() + "'" +  ")";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "添加成功");
                                                    addgoods.dispose();
                                                }

                                            } catch (SQLException e1) {
                                                // TODO Auto-generated catch block
                                                e1.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                    }
                                });
                                btnn5.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        addgoods.dispose();
                                    }
                                });

                            }
                        });
                    }
                });
            }

            //销售员方法
            else if (roleId.equals("2")) {
                System.out.println("销售员");
                final JFrame sale = new JFrame("药品销存管理系统-销售员");
                sale.setBounds(100, 100, 800, 450);
                //窗口居中
                sale.setLocationRelativeTo(null);
                sale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sale.getContentPane().setLayout(null);
                sale.setVisible(true);
                //添加窗口组件
                JButton btn1 = new JButton("销售记录");
                JButton btn2 = new JButton("销售管理");
                JButton btn3 = new JButton("账号管理");
                JButton btn4 = new JButton("添加销售");
                JButton btn33 = new JButton("退出");

                sale.getContentPane().add(btn1);
                sale.getContentPane().add(btn2);
                sale.getContentPane().add(btn3);
                sale.getContentPane().add(btn4);
                sale.getContentPane().add(btn33);

                btn1.setBounds(120, 30, 100, 40);
                btn2.setBounds(240, 30, 100, 40);
                btn3.setBounds(360, 30, 100, 40);
                btn4.setBounds(480, 30, 100, 40);
                btn33.setBounds(550, 320, 100, 30);

                //退出
                btn33.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        sale.dispose();
                    }
                });

                //编号对话框确定键监听事件
                //添加销售信息
                btn4.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        final JFrame addgoods = new JFrame("药品销存管理系统-销售员");
                        addgoods.setBounds(100, 100, 800, 450);
                        //窗口居中
                        addgoods.setLocationRelativeTo(null);
                        addgoods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        addgoods.getContentPane().setLayout(null);
                        addgoods.setVisible(true);

                        JLabel add = new JLabel("添加销售信息");

                        JLabel labid = new JLabel("id");
                        JLabel labmedic_num = new JLabel("数量");
                        JLabel labmedic_id = new JLabel("药品id");
                        JLabel labmedic_name = new JLabel("药品名");
                        JLabel labtime = new JLabel("时间");
                        JLabel labprice = new JLabel("售价");
                        JLabel labsum_price = new JLabel("共计金额");

                        final JTextField id = new JTextField(20);
                        final JTextField medic_name = new JTextField(20);
                        final JTextField medic_num = new JTextField(20);
                        final JTextField medic_id = new JTextField(20);
                        final JTextField time = new JTextField(20);
                        final JTextField price = new JTextField(20);
                        final JTextField sum_price = new JTextField(20);

                        JButton btnn = new JButton("确定");
                        JButton btnn5 = new JButton("取消");

                        addgoods.getContentPane().add(add);
                        addgoods.getContentPane().add(labid);
                        addgoods.getContentPane().add(labmedic_name);
                        addgoods.getContentPane().add(labmedic_num);
                        addgoods.getContentPane().add(labmedic_id);
                        addgoods.getContentPane().add(labtime);
                        addgoods.getContentPane().add(labprice);
                        addgoods.getContentPane().add(labsum_price);

                        addgoods.getContentPane().add(id);
                        addgoods.getContentPane().add(medic_name);
                        addgoods.getContentPane().add(medic_num);
                        addgoods.getContentPane().add(medic_id);
                        addgoods.getContentPane().add(time);
                        addgoods.getContentPane().add(price);
                        addgoods.getContentPane().add(sum_price);

                        addgoods.getContentPane().add(btnn);
                        addgoods.getContentPane().add(btnn5);

                        add.setBounds(320, 30, 200, 75);

                        labid.setBounds(120, 100, 80, 40);
                        id.setBounds(220, 100, 120, 40);
                        labmedic_id.setBounds(460, 100, 80, 40);
                        medic_id.setBounds(560, 100, 120, 40);

                        labmedic_name.setBounds(120, 170, 80, 40);
                        medic_name.setBounds(220, 170, 120, 40);
                        labmedic_num.setBounds(460, 170, 80, 40);
                        medic_num.setBounds(560, 170, 120, 40);

                        labprice.setBounds(120, 240, 80, 40);
                        price.setBounds(220, 240, 120, 40);
                        labtime.setBounds(460, 240, 80, 40);
                        time.setBounds(560, 240, 120, 40);

                        labsum_price.setBounds(120, 310, 80, 40);
                        sum_price.setBounds(220, 310, 120, 40);
                        btnn.setBounds(400, 320, 100, 30);
                        btnn5.setBounds(550, 320, 100, 30);

                        add.setFont(new Font("", Font.BOLD, 30));
                        labid.setFont(new Font("", 0, 15));
                        labmedic_name.setFont(new Font("", 0, 15));
                        labmedic_num.setFont(new Font("", 0, 15));
                        labmedic_id.setFont(new Font("", 0, 15));
                        labtime.setFont(new Font("", 0, 15));
                        labprice.setFont(new Font("", 0, 15));
                        labsum_price.setFont(new Font("", 0, 15));

                        //编号对话框确定键监听事件
                        btnn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                                ///获取输入的信息
                                if (id.getText().equals("") ||medic_name.getText().equals("") ||medic_num.getText().equals("") || medic_id.getText().equals("") || time.getText().equals("") || price.getText().equals("") || sum_price.getText().equals("") ) {
                                    JOptionPane.showMessageDialog(null, "表单不能为空！");
                                } else {
                                    Connection con = SqlOperation.getConnection();
                                    Statement statement = null;
                                    try {
                                        statement = con.createStatement();
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e2.printStackTrace();
                                    }

                                    String sql = null;
                                    //向表中传入数据
                                    sql = "INSERT INTO record(id,medic_name,medic_num,medic_id,time,price,sum_price) VALUES (" + "'" + id.getText() + "'" + "," + "'" + medic_name.getText() + "'" + "," + "'" + medic_num.getText() + "'" + "," + "'" + medic_id.getText() + "'" + "," + "'" + time.getText() + "'" + ","  + "'" + price.getText() + "'" + "," + "'" + sum_price.getText() + "'" + ")";
                                    try {
                                        int a = statement.executeUpdate(sql);
                                        if (a == 1) {
                                            JOptionPane.showMessageDialog(null, "添加成功");
                                            addgoods.dispose();
                                        }

                                    } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                    SqlOperation.release(statement, con);
                                }
                            }
                        });
                        btnn5.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                addgoods.dispose();
                            }
                        });
                    }
                });

                //销售记录按钮事件
                btn1.addActionListener(new ActionListener() {
                    //创建一个表单
                    String columns[] = {"id","药品id","药品名", "药品数量", "售价", "销售时间", "共计金额"};
                    Object cells[][] = new Object[100][7];
                    public void actionPerformed(ActionEvent e) {
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        sql = "SELECT * FROM record";
                        try {
                            int count = 0;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                cells[count][0] = rs.getString("id");
                                cells[count][1] = rs.getString("medic_id");
                                cells[count][2] = rs.getString("medic_name");
                                cells[count][3] = rs.getString("medic_num");
                                cells[count][4] = rs.getString("price");
                                cells[count][5] = rs.getString("time");
                                cells[count][6] = rs.getString("sum_price");
                                count++;
                            }
                            String title = "销售信息表";
                            FTable fTable = new FTable(cells, columns, title);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }

                        try {
                            statement.executeQuery(sql);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }
                });

                //销售管理按钮事件
                btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final JFrame updatePwd = new JFrame("药品销存管理系统-售货员");
                        updatePwd.setBounds(100, 100, 800, 450);
                        //窗口居中
                        updatePwd.setLocationRelativeTo(null);
                        updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatePwd.getContentPane().setLayout(null);
                        updatePwd.setVisible(true);
                        //添加窗口组件
                        JButton btn1 = new JButton("修改");
                        JButton btn2 = new JButton("删除");
                        JButton btn3 = new JButton("返回");

                        sale.getContentPane().add(btn1);
                        sale.getContentPane().add(btn2);
                        sale.getContentPane().add(btn3);

                        btn1.setBounds(140, 30, 100, 40);
                        btn2.setBounds(280, 30, 100, 40);
                        btn3.setBounds(420, 30, 100, 40);

                        updatePwd.getContentPane().add(btn1);
                        updatePwd.getContentPane().add(btn2);
                        updatePwd.getContentPane().add(btn3);

                        //修改数据
                        btn1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-销售员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("修改销售信息");
                                JLabel info1 = new JLabel("修改数据");
                                JLabel labid = new JLabel("id：");
                                JLabel labmedic_id = new JLabel("药品序号：");
                                JLabel labmedic_name = new JLabel("药品名：");
                                JLabel labmedic_num = new JLabel("数量：");
                                JLabel labprice = new JLabel("售价：");
                                JLabel labtime = new JLabel("销售时间：");
                                JLabel labsum_price = new JLabel("总额：");

                                final JTextField id = new JTextField(20);
                                final JTextField newmedic_id = new JTextField(20);
                                final JTextField newmedic_name = new JTextField(20);
                                final JTextField newmedic_num = new JTextField(20);
                                final JTextField newprice = new JTextField(20);
                                final JTextField newtime = new JTextField(20);
                                final JTextField newsum_price = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(labmedic_id);
                                updatePwd.getContentPane().add(labmedic_name);
                                updatePwd.getContentPane().add(labmedic_num);
                                updatePwd.getContentPane().add(labprice);
                                updatePwd.getContentPane().add(labtime);
                                updatePwd.getContentPane().add(labsum_price);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(newmedic_id);
                                updatePwd.getContentPane().add(newmedic_name);
                                updatePwd.getContentPane().add(newmedic_num);
                                updatePwd.getContentPane().add(newprice);
                                updatePwd.getContentPane().add(newtime);
                                updatePwd.getContentPane().add(newsum_price);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                add.setBounds(320, 30, 200, 75);
                                labid.setBounds(120, 100, 80, 40);
                                id.setBounds(220, 100, 120, 40);
                                labmedic_id.setBounds(460, 100, 80, 40);
                                newmedic_id.setBounds(560, 100, 120, 40);

                                labmedic_name.setBounds(120, 170, 80, 40);
                                newmedic_name.setBounds(220, 170, 120, 40);
                                labmedic_num.setBounds(460, 170, 80, 40);
                                newmedic_num.setBounds(560, 170, 120, 40);

                                labprice.setBounds(120, 240, 80, 40);
                                newprice.setBounds(220, 240, 120, 40);
                                labtime.setBounds(460, 240, 80, 40);
                                newtime.setBounds(560, 240, 120, 40);

                                labsum_price.setBounds(120, 310, 80, 40);
                                newsum_price.setBounds(220, 310, 120, 40);

                                btn.setBounds(400, 320, 100, 30);
                                btn3.setBounds(550, 320, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labmedic_id.setFont(new Font("", 0, 15));
                                labmedic_name.setFont(new Font("", 0, 15));
                                labmedic_num.setFont(new Font("", 0, 15));
                                labtime.setFont(new Font("", 0, 15));
                                labprice.setFont(new Font("", 0, 15));
                                labsum_price.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        String logmedic_id = newmedic_id.getText().trim();
                                        String logmedic_name = newmedic_name.getText().trim();
                                        String logmedic_num = newmedic_num.getText().trim();
                                        String logprice = newprice.getText().trim();
                                        String logtime = newtime.getText().trim();
                                        String logsum_price = newsum_price.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!=""){
                                            String sql = null;
                                            sql = "update record set medic_id='" + logmedic_id + "',medic_name='" + logmedic_name + "',medic_num = '" + logmedic_num + "',price='" + logprice + "' ,time='" + logtime + "' ,sum_price='" + logsum_price + "' where id='" + logid + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "修改销售信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });
                            }
                        });
                        //删除数据
                        btn2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-销售员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("删除销售信息");
                                JLabel labid = new JLabel("id行：");
                                final JTextField id = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                add.setBounds(320, 30, 200, 75);
                                labid.setBounds(120, 150, 60, 30);
                                id.setBounds(220, 150, 100, 30);

                                btn.setBounds(250, 300, 100, 30);
                                btn3.setBounds(400, 300, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!=""){
                                            String sql = null;
                                            sql = "delete from record where id='" + logid + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "删除销售信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {

                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });
                            }
                        });
                        //返回按钮
                        btn3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                updatePwd.dispose();
                            }
                        });
                    }
                });

                //用户管理按钮事件
                btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final JFrame updatePwd = new JFrame("药品销存管理系统-售货员");
                        updatePwd.setBounds(100, 100, 800, 450);
                        //窗口居中
                        updatePwd.setLocationRelativeTo(null);
                        updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatePwd.getContentPane().setLayout(null);
                        updatePwd.setVisible(true);
                        //添加窗口组件
                        JButton btn1 = new JButton("进货管理");
                        JButton btn2 = new JButton("账号管理");

                        updatePwd.getContentPane().add(btn1);
                        updatePwd.getContentPane().add(btn2);
                        JLabel info = new JLabel("修改密码");
                        JLabel labNewPwd = new JLabel("请输入新的密码：");
                        final JTextField newPwd = new JTextField(20);
                        JButton btn = new JButton("确定修改");
                        JButton btn3 = new JButton("取消");

                        updatePwd.getContentPane().add(labNewPwd);
                        updatePwd.getContentPane().add(info);
                        updatePwd.getContentPane().add(newPwd);
                        updatePwd.getContentPane().add(btn);
                        updatePwd.getContentPane().add(btn3);

                        info.setBounds(320, 90, 200, 75);
                        labNewPwd.setBounds(250, 195, 150, 50);
                        newPwd.setBounds(380, 200, 200, 40);
                        btn.setBounds(250, 300, 100, 30);
                        btn3.setBounds(400, 300, 100, 30);

                        info.setFont(new Font("", Font.BOLD, 30));
                        labNewPwd.setFont(new Font("", 0, 15));

                        btn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                Connection con = SqlOperation.getConnection();
                                Statement statement = null;
                                ResultSet rs = null;
                                String loginPwd = newPwd.getText().trim();
                                try {
                                    statement = con.createStatement();
                                } catch (SQLException e2) {
                                    // TODO Auto-generated catch block
                                    e2.printStackTrace();
                                }
                                if (loginPwd!=""){
                                    String sql = null;
                                    sql = "UPDATE user SET PASSWORD = " + loginPwd + " WHERE username = " + username;
                                    try {
                                        int a = statement.executeUpdate(sql);
                                        if (a == 1) {
                                            JOptionPane.showMessageDialog(null, "修改密码成功");
                                            updatePwd.dispose();
                                        }
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e2.printStackTrace();
                                    }
                                    SqlOperation.release(statement, con);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "新密码不能为空");
                                }

                            }
                        });

                        btn3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                updatePwd.dispose();
                            }
                        });

                    }
                });
            }

            //进货员方法
            else {
                System.out.println("进货员");
                final JFrame goods = new JFrame("药品销存管理系统-进货员");
                goods.setBounds(100, 100, 800, 450);
                //窗口居中
                goods.setLocationRelativeTo(null);
                goods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                goods.getContentPane().setLayout(null);
                goods.setVisible(true);
                //添加窗口组件
                JButton btn1 = new JButton("进货管理");
                JButton btn11 = new JButton("库存查看");
                JButton btn111 = new JButton("库存管理");
                JButton btn2 = new JButton("账号管理");
                JButton btn33 = new JButton("退出");

                goods.getContentPane().add(btn1);
                goods.getContentPane().add(btn11);
                goods.getContentPane().add(btn111);
                goods.getContentPane().add(btn2);
                goods.getContentPane().add(btn33);

                btn1.setBounds(140, 30, 100, 40);
                btn11.setBounds(260, 30, 100, 40);
                btn111.setBounds(380, 30, 100, 40);
                btn2.setBounds(500, 30, 100, 40);
                btn33.setBounds(550, 320, 100, 30);

                //退出
                btn33.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        goods.dispose();
                    }
                });

                //编号对话框确定键监听事件
                btn1.addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {
                        final JFrame addgoods = new JFrame("药品销存管理系统-进货员");
                        addgoods.setBounds(100, 100, 800, 450);
                        //窗口居中
                        addgoods.setLocationRelativeTo(null);
                        addgoods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        addgoods.getContentPane().setLayout(null);
                        addgoods.setVisible(true);

                        JLabel add = new JLabel("添加货物");

                        JLabel labid = new JLabel("药品id");
                        JLabel labName = new JLabel("药品名");
                        JLabel labInPrice = new JLabel("进价");
                        JLabel labPrice = new JLabel("售价");
                        JLabel labNum = new JLabel("数量");
                        JLabel labAddress = new JLabel("生产厂家");

                        final JTextField id = new JTextField(20);
                        final JTextField name = new JTextField(20);
                        final JTextField inPrice = new JTextField(20);
                        final JTextField price = new JTextField(20);
                        final JTextField num = new JTextField(20);
                        final JTextField address = new JTextField(20);

                        JButton btn = new JButton("确定");
                        JButton btn5 = new JButton("取消");

                        addgoods.getContentPane().add(add);
                        addgoods.getContentPane().add(labid);
                        addgoods.getContentPane().add(labName);
                        addgoods.getContentPane().add(labInPrice);
                        addgoods.getContentPane().add(labPrice);
                        addgoods.getContentPane().add(labNum);
                        addgoods.getContentPane().add(labAddress);

                        addgoods.getContentPane().add(id);
                        addgoods.getContentPane().add(name);
                        addgoods.getContentPane().add(inPrice);
                        addgoods.getContentPane().add(price);
                        addgoods.getContentPane().add(num);
                        addgoods.getContentPane().add(address);

                        addgoods.getContentPane().add(btn);
                        addgoods.getContentPane().add(btn5);

                        add.setBounds(320, 80, 200, 75);

                        labid.setBounds(120, 150, 60, 30);
                        id.setBounds(220, 150, 100, 30);
                        labName.setBounds(460, 150, 60, 30);
                        name.setBounds(560, 150, 100, 30);

                        labInPrice.setBounds(120, 200, 60, 30);
                        inPrice.setBounds(220, 200, 100, 30);
                        labPrice.setBounds(460, 200, 60, 30);
                        price.setBounds(560, 200, 100, 30);

                        labNum.setBounds(120, 250, 60, 30);
                        num.setBounds(220, 250, 100, 30);
                        labAddress.setBounds(460, 250, 60, 30);
                        address.setBounds(560, 250, 100, 30);

                        btn.setBounds(250, 300, 100, 30);
                        btn5.setBounds(400, 300, 100, 30);

                        add.setFont(new Font("", Font.BOLD, 30));
                        labid.setFont(new Font("", 0, 15));
                        labName.setFont(new Font("", 0, 15));
                        labInPrice.setFont(new Font("", 0, 15));
                        labPrice.setFont(new Font("", 0, 15));
                        labNum.setFont(new Font("", 0, 15));
                        labAddress.setFont(new Font("", 0, 15));

                        //编号对话框确定键监听事件
                        btn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                ///获取输入的信息
                                if (id.getText().equals("") || price.getText().equals("") || name.getText().equals("") || inPrice.getText().equals("") || num.getText().equals("") || address.getText().equals("")) {
                                    JOptionPane.showMessageDialog(null, "表单不能为空！");
                                } else {
                                    Connection con = SqlOperation.getConnection();
                                    Statement statement = null;
                                    try {
                                        statement = con.createStatement();
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e2.printStackTrace();
                                    }

                                    String sql = null;
                                    //向表中传入数据
                                    sql = "INSERT INTO medic(id,medic_name,input_price,price,num,address) VALUES (" + "'" + id.getText() + "'" + "," + "'" + name.getText() + "'" + "," + inPrice.getText() + "," + "'" + price.getText() + "'" + "," + num.getText() + "," + "'" + address.getText() + "'" + ")";
                                    try {
                                        int a = statement.executeUpdate(sql);
                                        if (a == 1) {
                                            JOptionPane.showMessageDialog(null, "添加成功");
                                            addgoods.dispose();
                                        }

                                    } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                    SqlOperation.release(statement, con);
                                }
                            }
                        });
                        btn5.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                addgoods.dispose();
                            }
                        });
                    }
                });

                //库存查看按钮事件
                btn11.addActionListener(new ActionListener() {
                    //创建一个表单
                    String columns[] = {"序号", "药品名", "进价", "售价", "数量", "生产厂商"};
                    Object cells[][] = new Object[100][6];


                    public void actionPerformed(ActionEvent e) {
                        Connection con = SqlOperation.getConnection();
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            statement = con.createStatement();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        String sql = null;
                        sql = "SELECT * FROM medic";
                        try {
                            int count = 0;
                            rs = statement.executeQuery(sql);
                            while (rs.next()) {
                                cells[count][0] = rs.getString("id");
                                cells[count][1] = rs.getString("medic_name");
                                cells[count][2] = rs.getString("input_price");
                                cells[count][3] = rs.getString("price");
                                cells[count][4] = rs.getString("num");
                                cells[count][5] = rs.getString("address");
                                count++;
                            }
                            String title = "药品信息表";
                            FTable fTable = new FTable(cells, columns, title);
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        try {
                            statement.executeQuery(sql);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        SqlOperation.release(statement, con);
                    }
                });

                //库存管理按钮事件
                btn111.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        final JFrame updatePwd = new JFrame("药品销存管理系统-进货员");
                        updatePwd.setBounds(100, 100, 800, 450);
                        //窗口居中
                        updatePwd.setLocationRelativeTo(null);
                        updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatePwd.getContentPane().setLayout(null);
                        updatePwd.setVisible(true);
                        //添加窗口组件
                        JButton btn1 = new JButton("修改");
                        JButton btn2 = new JButton("删除");
                        JButton btn3 = new JButton("返回");

                        goods.getContentPane().add(btn1);
                        goods.getContentPane().add(btn2);
                        goods.getContentPane().add(btn3);

                        btn1.setBounds(140, 30, 100, 40);
                        btn2.setBounds(280, 30, 100, 40);
                        btn3.setBounds(420, 30, 100, 40);

                        updatePwd.getContentPane().add(btn1);
                        updatePwd.getContentPane().add(btn2);
                        updatePwd.getContentPane().add(btn3);
                        //修改数据
                        btn1.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-进货员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("修改进货信息");
                                JLabel labid = new JLabel("id：");
                                JLabel labin_price = new JLabel("进价：");
                                JLabel labprice = new JLabel("售价：");
                                JLabel labnum = new JLabel("数量：");
                                JLabel labaddress = new JLabel("生产厂家：");

                                final JTextField id = new JTextField(20);
                                final JTextField newin_price = new JTextField(20);
                                final JTextField newprice = new JTextField(20);
                                final JTextField newnum = new JTextField(20);
                                JTextField newaddress = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(labin_price);
                                updatePwd.getContentPane().add(labprice);
                                updatePwd.getContentPane().add(labnum);
                                updatePwd.getContentPane().add(labaddress);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(newin_price);
                                updatePwd.getContentPane().add(newprice);
                                updatePwd.getContentPane().add(newnum);
                                updatePwd.getContentPane().add(newaddress);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                add.setBounds(320, 30, 200, 75);
                                labid.setBounds(120, 150, 60, 30);
                                id.setBounds(220, 150, 100, 30);
                                labnum.setBounds(460, 150, 60, 30);
                                newnum.setBounds(560, 150, 100, 30);
                                labin_price.setBounds(120, 200, 60, 30);
                                newin_price.setBounds(220, 200, 100, 30);
                                labprice.setBounds(460, 200, 60, 30);
                                newprice.setBounds(560, 200, 100, 30);
                                labaddress.setBounds(120, 250, 60, 30);
                                newaddress.setBounds(220, 250, 100, 30);

                                btn.setBounds(250, 300, 100, 30);
                                btn3.setBounds(400, 300, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labin_price.setFont(new Font("", 0, 15));
                                labprice.setFont(new Font("", 0, 15));
                                labnum.setFont(new Font("", 0, 15));
                                labaddress.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        String login_price = newin_price.getText().trim();
                                        String loginprice = newprice.getText().trim();
                                        String loginnum = newnum.getText().trim();
                                        String loginaddress = newnum.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!=""){
                                            String sql = null;
                                            sql = "update medic set input_price='" + login_price + "',price = '" + loginprice + "',num='" + loginnum + "',address = '" + loginaddress + "' where id='" + logid + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "修改库存信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });				}});
                        //删除数据
                        btn2.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                final JFrame updatePwd = new JFrame("药品销存管理系统-进货员");
                                updatePwd.setBounds(100, 100, 800, 450);
                                //窗口居中
                                updatePwd.setLocationRelativeTo(null);
                                updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                updatePwd.getContentPane().setLayout(null);
                                updatePwd.setVisible(true);

                                JLabel add = new JLabel("删除进货信息");
                                JLabel labid = new JLabel("id行：");
                                JLabel labname = new JLabel("药品名：");
                                final JTextField id = new JTextField(20);
                                final JTextField name = new JTextField(20);
                                JButton btn = new JButton("确定");
                                JButton btn3 = new JButton("取消");

                                updatePwd.getContentPane().add(add);
                                updatePwd.getContentPane().add(labid);
                                updatePwd.getContentPane().add(labname);
                                updatePwd.getContentPane().add(id);
                                updatePwd.getContentPane().add(name);
                                updatePwd.getContentPane().add(btn);
                                updatePwd.getContentPane().add(btn3);

                                add.setBounds(320, 30, 200, 75);
                                labid.setBounds(120, 150, 60, 30);
                                id.setBounds(220, 150, 100, 30);
                                labname.setBounds(120, 200, 60, 30);
                                name.setBounds(220, 200, 100, 30);

                                btn.setBounds(250, 300, 100, 30);
                                btn3.setBounds(400, 300, 100, 30);

                                add.setFont(new Font("", Font.BOLD, 30));
                                labid.setFont(new Font("", 0, 15));
                                labname.setFont(new Font("", 0, 15));

                                btn.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        Connection con = SqlOperation.getConnection();
                                        Statement statement = null;
                                        ResultSet rs = null;
                                        String logid = id.getText().trim();
                                        String logname = name.getText().trim();
                                        try {
                                            statement = con.createStatement();
                                        } catch (SQLException e2) {
                                            // TODO Auto-generated catch block
                                            e2.printStackTrace();
                                        }
                                        if (logid!="" || logname!=""){
                                            String sql = null;
                                            sql = "delete from medic where id='" + logid + "' and medic_name='" + logname + "'";
                                            try {
                                                int a = statement.executeUpdate(sql);
                                                if (a == 1) {
                                                    JOptionPane.showMessageDialog(null, "删除库存信息成功");
                                                    updatePwd.dispose();
                                                }
                                            } catch (SQLException e2) {
                                                // TODO Auto-generated catch block
                                                e2.printStackTrace();
                                            }
                                            SqlOperation.release(statement, con);
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "id或者药品名不能为空");
                                        }

                                    }
                                });

                                btn3.addMouseListener(new MouseAdapter() {

                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        updatePwd.dispose();
                                    }
                                });
                            }
                        });
                        //返回按钮
                        btn3.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                updatePwd.dispose();
                            }
                        });
                    }
                });

                //用户管理按钮事件
                btn2.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        final JFrame updatePwd = new JFrame("药品销存管理系统-进货员");
                        updatePwd.setBounds(100, 100, 800, 450);
                        //窗口居中
                        updatePwd.setLocationRelativeTo(null);
                        updatePwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatePwd.getContentPane().setLayout(null);
                        updatePwd.setVisible(true);
                        //添加窗口组件
                        JButton btn1 = new JButton("进货管理");
                        JButton btn2 = new JButton("账号管理");

                        updatePwd.getContentPane().add(btn1);
                        updatePwd.getContentPane().add(btn2);
                        JLabel info = new JLabel("修改密码");
                        JLabel labNewPwd = new JLabel("请输入新的密码：");
                        final JTextField newPwd = new JTextField(20);
                        JButton btn = new JButton("确定修改");
                        JButton btn3 = new JButton("取消");

                        updatePwd.getContentPane().add(labNewPwd);
                        updatePwd.getContentPane().add(info);
                        updatePwd.getContentPane().add(newPwd);
                        updatePwd.getContentPane().add(btn);
                        updatePwd.getContentPane().add(btn3);

                        info.setBounds(320, 90, 200, 75);
                        labNewPwd.setBounds(250, 195, 150, 50);
                        newPwd.setBounds(380, 200, 200, 40);
                        btn.setBounds(250, 300, 100, 30);
                        btn3.setBounds(400, 300, 100, 30);

                        info.setFont(new Font("", Font.BOLD, 30));
                        labNewPwd.setFont(new Font("", 0, 15));

                        btn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                Connection con = SqlOperation.getConnection();
                                Statement statement = null;
                                ResultSet rs = null;
                                String loginPwd = newPwd.getText().trim();
                                try {
                                    statement = con.createStatement();
                                } catch (SQLException e2) {
                                    // TODO Auto-generated catch block
                                    e2.printStackTrace();
                                }
                                if (loginPwd!=""){
                                    String sql = null;
                                    sql = "UPDATE user SET PASSWORD = " + loginPwd + " WHERE username = " + username;
                                    try {
                                        int a = statement.executeUpdate(sql);
                                        if (a == 1) {
                                            JOptionPane.showMessageDialog(null, "修改密码成功");
                                            updatePwd.dispose();
                                        }
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e2.printStackTrace();
                                    }
                                    SqlOperation.release(statement, con);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "新密码不能为空");
                                }

                            }
                        });

                        btn3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                updatePwd.dispose();
                            }
                        });

                    }
                });
            }//药品采购员
        }
}
