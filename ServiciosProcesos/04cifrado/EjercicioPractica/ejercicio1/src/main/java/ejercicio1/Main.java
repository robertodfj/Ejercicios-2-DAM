package ejercicio1;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        gestor.crearUsuarios("roberto", "1234");
        boolean acceso = gestor.login("roberto", "1234");

        System.out.println(acceso ? "✅ Login correcto" : "❌ Login incorrecto");
    }
}