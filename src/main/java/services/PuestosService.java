package services;

import java.util.ArrayList;
import java.util.List;

import models.PuestoModel;

public class PuestosService {
    private static PuestosService instance;
    private static List<PuestoModel> listPuestos;

    private PuestosService() {
    }

    public static PuestosService get() {
        return instance;
    }

    public static PuestosService init() {
        instance = new PuestosService();
        listPuestos = new ArrayList<>();
        
        instance.testPuestos();
 
        return instance;
    }

    public List<PuestoModel> getListPuestos() {
        return PuestosService.listPuestos;
    }

    public void addPuesto(PuestoModel puesto) {
        PuestosService.listPuestos.add(puesto);
    }

    public void removePuesto(PuestoModel puesto) {
        PuestosService.listPuestos.remove(puesto);
    }

    public void updatePuesto(PuestoModel puesto) {
        for (PuestoModel p : PuestosService.listPuestos) {
            if (p.getId() == puesto.getId()) {
                p.setDescripcion(puesto.getDescripcion());
            }
        }
    }

    public PuestoModel getPuestoById(int id) {
        for (PuestoModel p : PuestosService.listPuestos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void removePuestoById(int id) {
        for (PuestoModel p : PuestosService.listPuestos) {
            if (p.getId() == id) {
                PuestosService.listPuestos.remove(p);
            }
        }
    }

    public void testPuestos() {
        PuestosService.listPuestos.add(new PuestoModel(1, "Gerente"));
        PuestosService.listPuestos.add(new PuestoModel(2, "Subgerente"));
        PuestosService.listPuestos.add(new PuestoModel(3, "Jefe"));
        PuestosService.listPuestos.add(new PuestoModel(4, "Empleado"));
    }

}
