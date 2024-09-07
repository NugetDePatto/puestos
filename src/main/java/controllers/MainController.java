package controllers;

import services.PuestosService;

public class MainController {

    public MainController() {
    }

    public void addPuesto(String descripcion, MainTableController tableController) {
        PuestosService.addPuestoModel(descripcion);

        tableController.updateTable();

    }

}
