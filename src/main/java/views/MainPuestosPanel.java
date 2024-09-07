package views;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.PuestoModel;
import services.PuestosService;
import widgets.PuestoWidget;

public class MainPuestosPanel extends JPanel {

    public MainPuestosPanel() {
        super();

        build();
    }

    public final void build() {
        setBorder(new EmptyBorder(20, 20, 0, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (PuestoModel p : PuestosService.getAllPuestosModels()) {
            add(new PuestoWidget(p));
            add(Box.createVerticalStrut(10));
        }
    }

}
