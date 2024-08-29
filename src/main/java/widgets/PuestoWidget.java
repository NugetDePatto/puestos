package widgets;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import models.PuestoModel;

public class PuestoWidget extends  JPanel{
    PuestoModel puesto;

    public PuestoWidget(PuestoModel puesto) {
        super();
        this.puesto = puesto;

        setBackground(java.awt.Color.WHITE);
        setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 100));

        setLayout(new GridLayout(3, 1, 10, 0));

        add(new JLabel("Código: " + puesto.getId()));
        
        add(new JLabel(puesto.getDescripcion()));

        JButton actionButton = new JButton("Acción");
        actionButton.setBorder(new MatteBorder(0, 10, 10, 10, Color.WHITE));
        actionButton.setSize(0, 50);

        actionButton.addActionListener((ActionEvent e) -> {
            // Acción al presionar el botón
            System.out.println("Botón presionado para: " + puesto.getDescripcion());
        });


        add(actionButton);
    }

  
}
