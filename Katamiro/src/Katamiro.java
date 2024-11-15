/**
 * The main class of our program. In the main we have to send the client to different Kitchen and create instance
 * of all the class
 */
public class Katamiro {
    public static void main(String[] args) {
        Kitchen laPacoKitchen = new Kitchen("La Paco Kitchen");
        Waiter paquet = new Waiter("Paco", laPacoKitchen);
        Waiter isma = new Waiter("Isma", laPacoKitchen);
        Waiter guille = new Waiter("Guille", laPacoKitchen);

        laPacoKitchen.addWaiters(paquet);
        laPacoKitchen.addWaiters(isma);
        laPacoKitchen.addWaiters(guille);
    }
}