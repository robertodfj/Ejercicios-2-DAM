public class Main {
    public static void main(String[] args) {
        Maquinas gym = new Maquinas();

        // Crear 5 deportistas
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    while (true) {
                        gym.entrenar(id);
                        Thread.sleep(1000); // pausa entre entrenamientos
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Crear un limpiador
        new Thread(() -> {
            try {
                while (true) {
                    gym.limpiar();
                    Thread.sleep(5000); // tiempo entre limpiezas
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}