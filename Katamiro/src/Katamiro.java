import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main class of our program. In the main we have to send the client to different Kitchen and create instance
 * of all the class
 */
public class Katamiro {

    public static void main(String[] args) {
        Kitchen cocina1 = new Kitchen("Cocina1");
        Client cliente1 = new Client("Cliente1");
        Client cliente2 = new Client("Cliente2");
        Client cliente3 = new Client("Cliente3");
        Client cliente4 = new Client("Cliente4");
        Client cliente5 = new Client("Cliente5");
        cocina1.addCliente(cliente1);
        cocina1.addCliente(cliente2);
        cocina1.addCliente(cliente3);
        cocina1.addCliente(cliente4);
        cocina1.addCliente(cliente5);
        Thread camarero1 = new Thread(() -> {
            while (true) {
                Client cliente = cocina1.attendCliente();
                if (cliente != null) { // Solo atender si hay cliente
                    try {
                        int tiempoAtencion = cliente.getAttention_time(); // Tiempo aleatorio entre 3 y 8 segundos
                        System.out.println("Camarero 1 atendiendo a " + cliente.getName() + " durante " + tiempoAtencion + "ms.");
                        Thread.sleep(tiempoAtencion); // Simula el tiempo de atención aleatorio
                        System.out.println("Camarero 1 termina de atender a: " + cliente.getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    try {
                        // Si no hay clientes, el camarero espera un momento antes de verificar nuevamente
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        Thread camarero2 = new Thread(() -> {
            while (true) {
                Client cliente = cocina1.attendCliente();
                if (cliente != null) { // Solo atender si hay cliente
                    try {
                        int tiempoAtencion = cliente.getAttention_time(); // Tiempo aleatorio entre 3 y 8 segundos
                        System.out.println("Camarero 2 atendiendo a " + cliente.getName() + " durante " + tiempoAtencion + "ms.");
                        Thread.sleep(tiempoAtencion); // Simula el tiempo de atención aleatorio
                        System.out.println("Camarero 2 termina de atender a: " + cliente.getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    try {
                        // Si no hay clientes, el camarero espera un momento antes de verificar nuevamente
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        camarero1.start();
        camarero2.start();
    }
}