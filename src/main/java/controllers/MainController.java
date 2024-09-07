package controllers;

import javax.swing.JOptionPane;

import repositories.PuestosRepository;

public class MainController {

    public MainController() {
    }

    public void addPuesto(MainTableController tableController) {
        String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del puesto",
                "Agregar Puesto", JOptionPane.QUESTION_MESSAGE);

        if (PuestosRepository.addPuestoModel(descripcion)) {
            tableController.updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el puesto",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}
