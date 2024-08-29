package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.PuestoModel;

public class DAOPuesto {
    public static List<PuestoModel> getAllPuestosModels(Connection connection) {
        List<PuestoModel> puestos = new ArrayList<>();
        
        try {
            CallableStatement statement = connection.prepareCall("call obtenerTodosLosPuestos()");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");

                puestos.add(new PuestoModel(id, descripcion));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOPuesto.class.getName()).log(Level.SEVERE, null, e);

        }

        return puestos;
    }

}
