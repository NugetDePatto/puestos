import services.PuestosService;
import views.MainView;

public class main {
      public static void main(String[] args) {
            PuestosService.init();
            new MainView();
    }
}
