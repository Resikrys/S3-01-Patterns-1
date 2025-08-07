package s3_01_abstract_factory;

import s3_01_abstract_factory.controller.AgendaController;

public class Main {
    public static void main(String[] args) {
        AgendaController app = new AgendaController();
        app.run();
    }
}
