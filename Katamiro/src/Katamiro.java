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

        laPacoKitchen.addCliente(client1);
        laPacoKitchen.addCliente(client2);
        laPacoKitchen.addCliente(client3);
        laPacoKitchen.addCliente(client4);
        laPacoKitchen.addCliente(client5);
        laPacoKitchen.addCliente(client6);
        laPacoKitchen.addCliente(client7);
        laPacoKitchen.addCliente(client8);
        laPacoKitchen.addCliente(client9);
        laPacoKitchen.addCliente(client10);

        laPacoKitchen.addWaiters(paquet);
        laPacoKitchen.addWaiters(isma);
        laPacoKitchen.addWaiters(guille);

        paquet.start();
        isma.start();
        guille.start();
    }
}