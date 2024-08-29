import java.util.List;

import models.PuestoModel;
import services.DAOPuesto;
import services.PuestosService;
import views.MainView;

public class main {
      public static void main(String[] args) {
            new PuestosService();
            new MainView();

            List<PuestoModel> puestos = DAOPuesto.getAllPuestosModels();

            for (PuestoModel puesto : puestos) {
                  System.out.println(puesto);
            }
    }
}
