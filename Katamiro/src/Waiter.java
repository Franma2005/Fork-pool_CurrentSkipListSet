import java.util.ArrayList;

/**
 * Already not implement. We are sure it must be a Thread
 */
public class Waiter extends Thread {
    private String name;
    private ArrayList<Kitchen> kitchens;

    public Waiter(String name, ArrayList<Kitchen> kitchens) {
        this.name = name;
        this.kitchens = kitchens;
    }

    @Override
    public void run() {
        Kitchen kitchenAttend = Funciones.getRandomList(kitchens); // Le asignamos la primera  cocina al camarero
        /**
         * Imprimimos el nombre del camarero, a qué cocina ha ido a atender y cuántos clietes hay en ésta
         */
        System.out.println("El camarero "+name+" ha ido a atender a la cocina "+kitchenAttend.getKitchenName()+" cantidad de clientes: "+kitchenAttend.getColaClientes().size());
        /**
         * Bucle infinito
         */
        while (true) {
            // Si el camarero ve que no hay clientes en la cocina, va a ayudar a otra para mejorar la eficiencia.
            while (kitchenAttend.getColaClientes().isEmpty()) {
                System.out.println("la cocina " + kitchenAttend.getKitchenName() + " no tiene clientes. El camarero " + name + " busca otra cocina aleatoria.");

                Kitchen previousKitchen = kitchenAttend; // He creado una variable kitchen para guardar en qué cocina estaba antes de asignarle una nueva
                kitchenAttend = Funciones.getRandomList(kitchens); // Al camarero se le asigna una nueva cocina

                // Ahora compruebo si la cocina que se le ha asignado al camarero no es igual a la anterior (si hay sólo una cocina el valor de esta condición será false)
                if (kitchens.size() > 1 && kitchenAttend == previousKitchen) {
                    continue;
                }

                System.out.println("El camarero " + name + " cambia a la cocina " + kitchenAttend.getKitchenName());
            }

            // Y ahora el camarero atiende al cliente que haya en la cocina :)
            Client client1 = kitchenAttend.attendCliente();
            if (client1 != null) {
                try {
                    System.out.println("El camarero " + name + " atiende al cliente " + client1.getClientName() + ", " + kitchenAttend.getKitchenName());
                    Thread.sleep(client1.getAttention_time());
                    System.out.println("El camarero " + name + " terminó de atender al cliente " + client1.getClientName());
                    Thread.sleep(2000);
                    kitchenAttend = Funciones.getRandomList(kitchens);
                    System.out.println("El camarero " + name + " cambia a la cocina " + kitchenAttend.getKitchenName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }
    }
}
