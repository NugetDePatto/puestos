package services;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLService {
    private Connection connection;

    public  MySQLService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/tienda", "root", "admin");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos");
            System.exit(1);
        }
    }

}
