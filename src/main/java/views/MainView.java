package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import services.DAOPuestoService;

public class MainView extends JFrame {

    public MainView() {
        super("Puestos");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JScrollPane(new MainPuestosPanel(DAOPuestoService.getAllPuestosModels())));

        setVisible(true);
    }

}
