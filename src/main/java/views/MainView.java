package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.MainController;
import controllers.MainTableController;

public class MainView extends JFrame {
    MainController controller = new MainController();

    public MainView() {
        super("Puestos");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        MainTableController tableController = new MainTableController();
        JTable table = new MainPuestosTable(tableController);
        add(new JScrollPane(table));

        JButton addPuestoButton = new JButton("Agregar Puesto");
        addPuestoButton.addActionListener(e -> {
            controller.addPuesto(tableController);
        });

        add(addPuestoButton);
    }

}
