package controllers;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import models.PuestoModel;
import services.PuestosService;

public class MainTableController {
    // singleton
    private static MainTableController instance = null;

    private DefaultTableModel model = new DefaultTableModel(new String[] { "ID", "Descripción" }, 0);

    private MainTableController() {
    }

    public static MainTableController get() {
        if (instance == null) {
            instance = new MainTableController();
        }
        return instance;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public DefaultTableModel setModel(Object[][] rowData, String[] columnNames) {
        model = new DefaultTableModel(rowData, columnNames);
        return model;
    }

    public void addPuestoModel(String descripcion) {
        PuestosService.addPuestoModel(descripcion);

        updateTable();
    }

    private void updateTable() {
        List<PuestoModel> data = PuestosService.getAllPuestosModels();

        int lastRow = data.size() - 1;

        int id = data.get(lastRow).getId();

        String descripcion = data.get(lastRow).getDescripcion();

        model.addRow(new Object[] { id, descripcion });

    }

}
