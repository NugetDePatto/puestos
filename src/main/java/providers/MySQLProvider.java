package providers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLProvider {

    private MySQLProvider() {
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root/tienda", "root", "admin");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
            return null;
        }
    }

    public static List<Map<String, String>> getTable(String call, String[] columns) {
        List<Map<String, String>> table = new ArrayList<>();

        try {
            CallableStatement statement = getConnection().prepareCall(call);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, String> row = new HashMap<>();

                for (String column : columns) {
                    row.put(column, resultSet.getString(column));
                }

                table.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la tabla" + e.getMessage());
        }

        return table;

    }

    public static boolean addRow(String call, String[] columns, String[] values) {
        try {
            CallableStatement statement = getConnection().prepareCall(call);

            for (int i = 0; i < columns.length; i++) {
                statement.setString(1, values[i]);
            }

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar la fila" + e.getMessage());
            return false;
        }
    }

    public static boolean updateRow(String call, String[] columns, String[] values) {
        try {
            CallableStatement statement = getConnection().prepareCall(call);

            for (int i = 0; i < columns.length; i++) {
                statement.setString(i + 1, values[i]);
            }

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la fila" + e.getMessage());
            return false;
        }
    }

    public static boolean deleteRow(String call, String[] columns, String[] values) {
        try {
            CallableStatement statement = getConnection().prepareCall(call);

            for (int i = 0; i < columns.length; i++) {
                statement.setString(1, values[i]);
            }

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la fila" + e.getMessage());
            return false;
        }
    }

}
