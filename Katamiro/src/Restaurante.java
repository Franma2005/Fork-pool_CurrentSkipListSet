import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Restaurante {

    private Queue<String> colaClientes = new ConcurrentLinkedQueue<>(); // Cambiamos a ConcurrentLinkedQueue

    // Método para que los clientes se agreguen a la cola
    public void entrarCliente(String cliente) {
        colaClientes.add(cliente);
        System.out.println(cliente + " entra en la cola de espera.");
    }

    // Método para que los camareros atiendan a un cliente de la cola
    public String atenderCliente() {
        String cliente = colaClientes.poll(); // No bloquea si la cola está vacía, devuelve null
        if (cliente != null) {
            System.out.println("Camarero comienza a atender a: " + cliente);
        }
        return cliente;
    }

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        
        // Crear e iniciar hilos de clientes que ingresan al restaurante
        Thread cliente1 = new Thread(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 1");
        });

        Thread cliente2 = new Thread(() -> {
            try {
                Thread.sleep(12500);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 2");
        });

        Thread cliente3 = new Thread(() -> {
            try {
                Thread.sleep(22200);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 3");
        });

        Thread cliente4 = new Thread(() -> {
            try {
                Thread.sleep(25000);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 4");
        });

        Thread cliente5 = new Thread(() -> {
            try {
                Thread.sleep(36000);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 5");
        });

        Thread cliente6 = new Thread(() -> {
            try {
                Thread.sleep(42500);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 6");
        });

        Thread cliente7 = new Thread(() -> {
            try {
                Thread.sleep(55000);
            } catch (InterruptedException e) {
            }
            restaurante.entrarCliente("Cliente 7");
        });

        // Crear e iniciar hilos de camareros que atienden a los clientes con tiempos aleatorios
        Thread camarero1 = new Thread(() -> {
            while (true) {
                String cliente = restaurante.atenderCliente();
                if (cliente != null) { // Solo atender si hay cliente
                    try {
                        int tiempoAtencion = ThreadLocalRandom.current().nextInt(3000, 8000 + 1); // Tiempo aleatorio entre 3 y 8 segundos
                        System.out.println("Camarero 1 atendiendo a " + cliente + " durante " + tiempoAtencion + "ms.");
                        Thread.sleep(tiempoAtencion); // Simula el tiempo de atención aleatorio
                        System.out.println("Camarero 1 termina de atender a: " + cliente);
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
                String cliente = restaurante.atenderCliente();
                if (cliente != null) { // Solo atender si hay cliente
                    try {
                        int tiempoAtencion = ThreadLocalRandom.current().nextInt(3000, 8000 + 1); // Tiempo aleatorio entre 3 y 8 segundos
                        System.out.println("Camarero 2 atendiendo a " + cliente + " durante " + tiempoAtencion + "ms.");
                        Thread.sleep(tiempoAtencion); // Simula el tiempo de atención aleatorio
                        System.out.println("Camarero 2 termina de atender a: " + cliente);
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

        // Iniciar los hilos de clientes
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();

        // Iniciar los hilos de camareros
        camarero1.start();
        camarero2.start();
    }
}


