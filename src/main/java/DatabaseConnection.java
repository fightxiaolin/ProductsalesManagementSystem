import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    static Connection con = null;
    static Statement stmt = null;

    static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ProductsalesDatabase;user=xiaolin;password=123456";
    public static Connection getConnection(){
        try {
            //建立数据库连接
            System.out.println("尝试建立数据库连接~~~");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            System.out.println("建立数据库成功~~~");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
