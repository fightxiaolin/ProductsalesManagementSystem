import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



/**
 * @author unknown
 */
public class CustomerManage extends JFrame {
    public CustomerManage() {
        initComponents();
    }
    public CustomerManage(String Number){
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CustomerwindowClosing(Number);
                dispose();
            }
        });
    }

    private void CustomerwindowClosing(String UserNum) {
        new ManagerFrame(UserNum).setVisible(true);
    }

    private void checkMouseClicked(MouseEvent e) {

            // TODO add your code here
            int rowcount = Customertable.getRowCount();
            showCustomerinformation(rowcount);
            DefaultTableModel model = (DefaultTableModel) Customertable.getModel();
            model.insertRow(rowcount, new Object[]{null, null, null, null, null, null});
            check.setVisible(false);
            addconfirm.setVisible(true);
            adddelete.setVisible(true);

    }

    private void handleMouseClicked(MouseEvent e) {
        // TODO add your code here
        editRow = Customertable.getSelectedRow();
        showCustomerinformation(editRow,0);
        handle.setVisible(false);
        handleconfirm.setVisible(true);
        handledelete.setVisible(true);
    }

    private void addconfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = Customertable.getRowCount() - 1;
        String  cno = Customertable.getValueAt(row, 0).toString().trim();
        String  cna = Customertable.getValueAt(row, 1).toString().trim();
        String  cad = Customertable.getValueAt(row, 2).toString().trim();
        String  cte = Customertable.getValueAt(row, 3).toString().trim();
        String  cco = Customertable.getValueAt(row, 4).toString().trim();
        String  cpm = Customertable.getValueAt(row, 5).toString().trim();
        String SQL = "insert into customer_info(cno, cna, cad,cte,cco,cpm) values('" + cno + "', '" + cna + "', '" + cad + "','" + cte + "','" + cco + "',"+ Integer.valueOf(cpm) + ");";

        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showCustomerinformation(-1);
        addconfirm.setVisible(false);
        adddelete.setVisible(false);
        check.setVisible(true);

    }

    private void adddeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        showCustomerinformation(-1);
        addconfirm.setVisible(false);
        adddelete.setVisible(false);
        check.setVisible(true);
    }

    private void deleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = Customertable.getSelectedRow();
        String cno = Customertable.getValueAt(row, 0).toString().trim();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "delete from customer_info where cno='" + cno + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showCustomerinformation(-1);
    }

    private void handleconfirmMouseClicked(MouseEvent e) {
        // TODO add your code here

        String  cno = Customertable.getValueAt(editRow, 0).toString().trim();
        String  cna = Customertable.getValueAt(editRow, 1).toString().trim();
        String  cad = Customertable.getValueAt(editRow, 2).toString().trim();
        String  cte = Customertable.getValueAt(editRow, 3).toString().trim();
        String  cco = Customertable.getValueAt(editRow, 4).toString().trim();
        String  cpm = Customertable.getValueAt(editRow, 5).toString().trim();

        String SQL = "update customer_info set cna='" + cna + "', cad='" + cad + "' ,cte = '" + cte + "',cco='" + cco +"',cpm='" +Integer.valueOf(cpm)+"' where cno='" + cno + "'";
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showCustomerinformation(-1);
        handleconfirm.setVisible(false);
        handledelete.setVisible(false);
        handle.setVisible(true);

    }


    private void handledeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        showCustomerinformation(-1);
        handle.setVisible(true);
        handleconfirm.setVisible(false);
        handledelete.setVisible(false);
    }

    private void refreshMouseClicked(MouseEvent e) {
        // TODO add your code here
        showCustomerinformation(-1);
    }

    private void researchMouseClicked(MouseEvent e) {
        // TODO add your code here
        String text = textField1.getText();
        String SQL = null;
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result;
        if( cno.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cno='" + text + "'";
        }
        else if(cna.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cna='" + text + "'";
        }
        else if(cad.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cad='" + text + "'";
        }
        else if(cte.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cte='" + text + "'";
        }
        else if(cco.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cco='" + text + "'";
        }
        else if(cpm.isSelected())
        {
            SQL = "select C.cno,C.cna,C.cad,C.cte,C.cco,C.cpm from customer_info C where C.cpm =" + Integer.valueOf(text);
        }
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Customertable = new JTable(buildCustomerTableModel(result, -1));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        Customertable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane1.setViewportView(Customertable);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        Customertable = new JTable();
        check = new JButton();
        handle = new JButton();
        delete = new JButton();
        refresh = new JButton();
        label1 = new JLabel();
        cno = new JRadioButton();
        cna = new JRadioButton();
        cad = new JRadioButton();
        cte = new JRadioButton();
        cco = new JRadioButton();
        cpm = new JRadioButton();
        textField1 = new JTextField();
        research = new JButton();
        addconfirm = new JButton();
        adddelete = new JButton();
        handleconfirm = new JButton();
        handledelete = new JButton();

        //======== this ========
        setTitle("\u987e\u5ba2\u7ba1\u7406\u754c\u9762");
        setFont(new Font(Font.DIALOG, Font.ITALIC, 18));
        setBackground(new Color(204, 204, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(Customertable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 5, 675, 705);

        //---- check ----
        check.setText("\u6dfb\u52a0\u4fe1\u606f");
        check.setFont(check.getFont().deriveFont(check.getFont().getSize() + 3f));
        check.setForeground(Color.white);
        check.setBackground(new Color(255, 204, 204));
        check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkMouseClicked(e);
            }
        });
        contentPane.add(check);
        check.setBounds(685, 35, 130, 45);

        //---- handle ----
        handle.setText("\u4fee\u6539\u4fe1\u606f");
        handle.setFont(handle.getFont().deriveFont(handle.getFont().getSize() + 3f));
        handle.setForeground(Color.white);
        handle.setBackground(new Color(255, 204, 204));
        handle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClicked(e);
                handleMouseClicked(e);
                handleMouseClicked(e);
            }
        });
        contentPane.add(handle);
        handle.setBounds(835, 35, 130, 45);

        //---- delete ----
        delete.setText("\u5220\u9664\u4fe1\u606f");
        delete.setFont(delete.getFont().deriveFont(delete.getFont().getSize() + 3f));
        delete.setForeground(Color.white);
        delete.setBackground(new Color(255, 204, 204));
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteMouseClicked(e);
                deleteMouseClicked(e);
            }
        });
        contentPane.add(delete);
        delete.setBounds(685, 100, 130, 45);

        //---- refresh ----
        refresh.setText("\u5237\u65b0\u4fe1\u606f");
        refresh.setFont(refresh.getFont().deriveFont(refresh.getFont().getSize() + 3f));
        refresh.setForeground(Color.white);
        refresh.setBackground(new Color(255, 204, 204));
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                refreshMouseClicked(e);
            }
        });
        contentPane.add(refresh);
        refresh.setBounds(835, 100, 130, 45);

        //---- label1 ----
        label1.setText("\u8bf7\u9009\u62e9\u67e5\u8be2\u7c7b\u578b\uff1a~");
        label1.setIconTextGap(8);
        label1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 15));
        contentPane.add(label1);
        label1.setBounds(690, 170, 135, 50);

        //---- cno ----
        cno.setText("\u987e\u5ba2\u53f7");
        cno.setFont(cno.getFont().deriveFont(cno.getFont().getSize() + 4f));
        contentPane.add(cno);
        cno.setBounds(690, 230, 85, 30);

        //---- cna ----
        cna.setText("\u987e\u5ba2\u540d");
        cna.setFont(cna.getFont().deriveFont(cna.getFont().getSize() + 4f));
        contentPane.add(cna);
        cna.setBounds(795, 230, 85, 30);

        //---- cad ----
        cad.setText("\u987e\u5ba2\u5730\u5740");
        cad.setFont(cad.getFont().deriveFont(cad.getFont().getSize() + 4f));
        contentPane.add(cad);
        cad.setBounds(690, 280, 100, 30);

        //---- cte ----
        cte.setText("\u7535\u8bdd");
        cte.setFont(cte.getFont().deriveFont(cte.getFont().getSize() + 4f));
        contentPane.add(cte);
        cte.setBounds(795, 280, 85, 30);

        //---- cco ----
        cco.setText("\u4fe1\u8d37\u72b6\u51b5");
        cco.setFont(cco.getFont().deriveFont(cco.getFont().getSize() + 4f));
        contentPane.add(cco);
        cco.setBounds(690, 330, 95, 30);

        //---- cpm ----
        cpm.setText("\u9884\u4ed8\u6b3e");
        cpm.setFont(cpm.getFont().deriveFont(cpm.getFont().getSize() + 4f));
        contentPane.add(cpm);
        cpm.setBounds(800, 330, 85, 30);
        contentPane.add(textField1);
        textField1.setBounds(680, 405, 135, 40);

        //---- research ----
        research.setText("\u67e5\u8be2");
        research.setFont(research.getFont().deriveFont(research.getFont().getSize() + 4f));
        research.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                researchMouseClicked(e);
            }
        });
        contentPane.add(research);
        research.setBounds(820, 405, 70, 40);

        //---- addconfirm ----
        addconfirm.setText("\u786e\u8ba4");
        addconfirm.setFont(addconfirm.getFont().deriveFont(addconfirm.getFont().getSize() + 2f));
        addconfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addconfirmMouseClicked(e);
            }
        });
        contentPane.add(addconfirm);
        addconfirm.setBounds(685, 40, 65, 35);

        //---- adddelete ----
        adddelete.setText("\u53d6\u6d88");
        adddelete.setFont(adddelete.getFont().deriveFont(adddelete.getFont().getSize() + 2f));
        adddelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adddeleteMouseClicked(e);
            }
        });
        contentPane.add(adddelete);
        adddelete.setBounds(750, 40, 65, 35);

        //---- handleconfirm ----
        handleconfirm.setText("\u786e\u8ba4");
        handleconfirm.setFont(handleconfirm.getFont().deriveFont(handleconfirm.getFont().getSize() + 2f));
        handleconfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleconfirmMouseClicked(e);
            }
        });
        contentPane.add(handleconfirm);
        handleconfirm.setBounds(835, 40, 65, 35);

        //---- handledelete ----
        handledelete.setText("\u53d6\u6d88");
        handledelete.setFont(handledelete.getFont().deriveFont(handledelete.getFont().getSize() + 2f));
        handledelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handledeleteMouseClicked(e);
            }
        });
        contentPane.add(handledelete);
        handledelete.setBounds(900, 40, 65, 35);

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

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(cno);
        buttonGroup1.add(cna);
        buttonGroup1.add(cad);
        buttonGroup1.add(cte);
        buttonGroup1.add(cco);
        buttonGroup1.add(cpm);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable Customertable;
    private JButton check;
    private JButton handle;
    private JButton delete;
    private JButton refresh;
    private JLabel label1;
    private JRadioButton cno;
    private JRadioButton cna;
    private JRadioButton cad;
    private JRadioButton cte;
    private JRadioButton cco;
    private JRadioButton cpm;
    private JTextField textField1;
    private JButton research;
    private JButton addconfirm;
    private JButton adddelete;
    private JButton handleconfirm;
    private JButton handledelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static DefaultTableModel buildCustomerTableModel(ResultSet rs, int er) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("顾客号");
        columnNames.add("顾客名");
        columnNames.add("顾客地址");
        columnNames.add("电话");
        columnNames.add("信贷状况");
        columnNames.add("预付款");

        Vector data = new Vector();

        while (rs.next()) {
            Vector vector = new Vector();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                try {
                    vector.add(rs.getString(columnIndex).trim());
                } catch (Exception e) {
                    vector.add(null);
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (row == er) {
                    return true;
                } else
                    return false;
            }
        };
    }

    public static DefaultTableModel buildCustomerTableModel(ResultSet rs, int er,int unec) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("顾客号");
        columnNames.add("顾客名");
        columnNames.add("顾客地址");
        columnNames.add("电话");
        columnNames.add("信贷状况");
        columnNames.add("预付款");

        Vector data = new Vector();

        while (rs.next()) {
            Vector vector = new Vector();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                try {
                    vector.add(rs.getString(columnIndex).trim());
                } catch (Exception e) {
                    vector.add(null);
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (row == er) {
                    return true;
                } else
                    return false;
            }
        };
    }
    private void showCustomerinformation(int editrow) {
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select C.cno, C.cna, C.cad, C.cte, C.cco, C.cpm from customer_info C";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Customertable = new JTable(buildCustomerTableModel(result, editrow));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Customertable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane1.setViewportView(Customertable);
    }
    
    /**
     * 在JTable中显示product_info表中的数据，其中editrow行可进行编辑，uneditcol列不可进行编辑
     *
     * @param editrow 可进行编辑行
     */
    private void showCustomerinformation(int editrow, int uneditcol){
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select C.cno, C.cna, C.cad, C.cte, C.cco, C.cpm from customer_info C";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Customertable = new JTable(buildCustomerTableModel(result, editrow,uneditcol));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Customertable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane1.setViewportView(Customertable);
    }
    private int editRow;
}





