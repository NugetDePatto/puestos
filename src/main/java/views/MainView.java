package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import services.PuestosService;

public class MainView extends JFrame {

    public MainView() {
        super("Puestos");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



        add(new JScrollPane( new MainPuestosPanel(new PuestosService().getListPuestos()) ));

        setVisible(true);
    }

}
