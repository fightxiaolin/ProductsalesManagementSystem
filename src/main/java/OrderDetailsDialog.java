import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun Jul 03 13:52:07 CST 2022
 */



/**
 * @author unknown
 */
public class OrderDetailsDialog extends JDialog {
    public OrderDetailsDialog(Frame owner, boolean modal, String Number) {
        super(owner, modal);
        initComponents(Number);
    }

    private void initComponents(String Number) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane = new JScrollPane();


        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u8ba2\u5355\u8be6\u7ec6");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                setVisible(false);
                dispose();
            }
        });

        //======== scrollPane ========
        {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = null;
            String SQL = "select sno, ssno, O.pno, pna, ssnu from product_info P, order_details O where sno='" + Number + "' and P.pno=O.pno";
            ResultSet result = null;
            try {
                stmt = con.createStatement();
                result = stmt.executeQuery(SQL);
                detailedTable = new JTable(buildDetailedOrderTableModel(result));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            scrollPane.setViewportView(detailedTable);
        }
        contentPane.add(scrollPane);
        scrollPane.setBounds(0, 0, 800, 590);

        contentPane.setPreferredSize(new Dimension(800, 590));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    /**
     *??????????????????ResultSet????????????product_info????????????Table??????DefaultTableModel????????????er??????????????????
     * @param rs    SQL??????????????????
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildDetailedOrderTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("?????????");
        columnNames.add("???????????????");
        columnNames.add("?????????");
        columnNames.add("?????????");
        columnNames.add("????????????");


        Vector data = new Vector();

        while (rs.next()) {
            Vector vector = new Vector();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                try{
                    vector.add(rs.getString(columnIndex).trim());
                }catch (Exception e){
                    vector.add(null);
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane;
    private JTable detailedTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

