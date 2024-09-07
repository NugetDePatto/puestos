package controllers;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import models.PuestoModel;
import repositories.PuestosRepository;

public class MainTableController {
    private DefaultTableModel model;

    public MainTableController() {
        model = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Descripción" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

    }

    public DefaultTableModel setModel() {
        String[] columnNames = { "ID", "Descripción" };

        List<PuestoModel> data = PuestosRepository.getAllPuestosModels();

        Object[][] rowData = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            rowData[i][0] = data.get(i).getId();
            rowData[i][1] = data.get(i).getDescripcion();
        }

        model = new DefaultTableModel(rowData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return model;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void updateTable() {
        List<PuestoModel> data = PuestosRepository.getAllPuestosModels();

        model.setRowCount(0);

        for (int i = 0; i < data.size(); i++) {
            model.addRow(new Object[] { data.get(i).getId(), data.get(i).getDescripcion() });
        }

    }

}
