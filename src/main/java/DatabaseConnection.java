import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class DatabaseConnection {
    static Connection con = null;
    static Statement stmt = null;

    static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ProductsalesDatabase;user=xiaolin;password=123456";
    public static Connection getConnection(){
        try {
            //建立数据库连接
//            System.out.println("尝试建立数据库连接~~~");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
//            System.out.println("建立数据库成功~~~");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，不可进行编辑
     * @param rs    SQL语句查询结果
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("产品描述");
        columnNames.add("产品重量");

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

    /**
     *根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，其中仅er行可进行编辑
     * @param rs    SQL语句查询结果
     * @param er    可进行编辑行
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("产品描述");
        columnNames.add("产品重量");

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
                if(row == er){
                    return true;
                }
                else
                    return false;
            }
        };
    }

    /**
     * 根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，其中仅er行可进行编辑，且unec列不可进行编辑
     * @param rs    SQL语句的查询结果
     * @param er    可进行编辑行editrow
     * @param unec  不可进行编辑列uneditcolumn
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er, int unec) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("产品描述");
        columnNames.add("产品重量");

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
                if(row == er && column != unec){
                    return true;
                }
                else
                    return false;
            }
        };
    }
}
