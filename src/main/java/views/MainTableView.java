package views;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.MainTableController;
import models.PuestoModel;
import services.PuestosService;

public class MainTableView extends JTable {

    public MainTableView() {
        super();

        build();
    }

    public final void build() {
        setBorder(new EmptyBorder(20, 20, 0, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] columnNames = { "ID", "Descripción" };

        List<PuestoModel> data = PuestosService.getAllPuestosModels();

        Object[][] rowData = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            rowData[i][0] = data.get(i).getId();
            rowData[i][1] = data.get(i).getDescripcion();
        }

        setModel(MainTableController.get().setModel(rowData, columnNames));

    }
}
