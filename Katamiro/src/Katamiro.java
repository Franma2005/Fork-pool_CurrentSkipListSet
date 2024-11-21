import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main class of our program. In the main we have to send the client to different Kitchen and create instance
 * of all the class
 */
public class Katamiro {
    public static void main(String[] args) {
        /**
         * Las cocinas y los camareros serán un Arraylist
         */
        ArrayList<Waiter> waiters = new ArrayList<>();
        ArrayList<Kitchen> kitchens = new ArrayList<>();
        /**
         * Mientras el hilo esté vivo va a estas constantemente asignando los cocineros a cualquier cocina.
         */
        //while (Thread.currentThread().isAlive())
        kitchens.add(new Kitchen("laPacoKitchen"));
        kitchens.add(new Kitchen("laGuilleKitchen"));
        kitchens.add(new Kitchen("laIsmaKitchen"));

        Waiter paquet = new Waiter("Paco", kitchens);
        Waiter isma = new Waiter("Isma", kitchens);
        Waiter guille = new Waiter("Guille", kitchens);

        Client client1 = new Client("client1");
        Client client2 = new Client("client2");
        Client client3 = new Client("client3");
        Client client4 = new Client("client4");
        Client client5 = new Client("client5");
        Client client6 = new Client("client6");
        Client client7 = new Client("client7");
        Client client8 = new Client("client8");
        Client client9 = new Client("client9");
        Client client10 = new Client("client10");

        Funciones.getRandomList(kitchens).addCliente(client1);
        Funciones.getRandomList(kitchens).addCliente(client2);
        Funciones.getRandomList(kitchens).addCliente(client3);
        Funciones.getRandomList(kitchens).addCliente(client4);
        Funciones.getRandomList(kitchens).addCliente(client5);
        Funciones.getRandomList(kitchens).addCliente(client6);
        Funciones.getRandomList(kitchens).addCliente(client7);
        Funciones.getRandomList(kitchens).addCliente(client8);
        Funciones.getRandomList(kitchens).addCliente(client9);
        Funciones.getRandomList(kitchens).addCliente(client10);



        paquet.start();
        isma.start();
        guille.start();
    }
}