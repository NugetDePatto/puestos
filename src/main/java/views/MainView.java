package views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.PuestoModel;
import services.PuestosService;

public class MainView extends JFrame {

    public MainView() {
        super("Puestos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(new GridLayout(10, 1, 0, 10));

        //poner 10 botones en una columna
        for (PuestoModel p : PuestosService.get().getListPuestos()) {
            JButton btn = new JButton(p.getDescripcion());
            btn.setBackground(java.awt.Color.WHITE);
            add(btn);
        }

    }

}
