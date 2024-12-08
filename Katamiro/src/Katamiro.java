import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The main class of our program. In the main we have to send the client to different Kitchen and create instance
 * of all the class
 */
public class Katamiro {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Las cocinas y los camareros serán un Arraylist
         */
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

        paquet.start();
        isma.start();
        guille.start();

        int i= 1;
        while(true){
                Funciones.getRandomList(kitchens).addCliente(new Client("client " + i));
                i++;
                Thread.sleep(ThreadLocalRandom.current().nextInt(1700, 2500 + 1));
        }
    }
}