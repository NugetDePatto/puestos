package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.PuestoModel;

public class DAOPuesto {

    private  DAOPuesto() {}

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root/tienda", "root", "admin");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
            return null;
        }
    }

    public static List<PuestoModel> getAllPuestosModels() {
        List<PuestoModel> puestos = new ArrayList<>();
        
        try {
            CallableStatement statement = getConnection().prepareCall("call tienda.obtenerTodosLosPuestos()");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");

                puestos.add(new PuestoModel(id, descripcion));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los puestos" + e.getMessage());

        }

        return puestos;
    }

}
