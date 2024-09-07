package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.MainTableController;

public class MainView extends JFrame {

    public MainView() {
        super("Puestos");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // poner una columna de componentes
        setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        // add(new JScrollPane(new MainPuestosPanel()));
        JTable table = new MainTableView();
        add(new JScrollPane(table));

        // add boton
        JButton addPuestoButton = new JButton("Agregar Puesto");
        addPuestoButton.addActionListener(e -> {
            MainTableController.get().addPuestoModel("Nuevo Puesto");
        });

        add(addPuestoButton, 1);

        setVisible(true);
    }

}
