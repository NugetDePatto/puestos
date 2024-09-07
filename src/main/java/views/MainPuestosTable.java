package views;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.MainTableController;

public class MainPuestosTable extends JTable {

    private MainTableController controller = new MainTableController();

    public MainPuestosTable(MainTableController controller) {
        super();
        this.controller = controller;

        build();
    }

    public final void build() {
        setBorder(new EmptyBorder(20, 20, 0, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setModel(controller.setModel());

    }
}
