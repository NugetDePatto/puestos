package views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.PuestoModel;
import widgets.PuestoWidget;

public class MainPuestosPanel extends JPanel {
    List<PuestoModel> puestos = new ArrayList<>();

    public MainPuestosPanel(List<PuestoModel> puestos) {
        super();
        this.puestos = puestos;

        build();
    }

    public final void build() {
        setBorder(new EmptyBorder(20, 20, 0, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (PuestoModel p : puestos) {
            add(new PuestoWidget(p));
            add(Box.createVerticalStrut(10));
        }
    }

}
