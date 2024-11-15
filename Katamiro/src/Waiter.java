/**
 * Already not implement. We are sure it must be a Thread
 */
public class Waiter extends Thread {
    private String name;
    private Client client;
    private Kitchen kitchen;

    public Waiter(String name, Kitchen kitchen) {
        this.name = name;
        this.kitchen = kitchen;
        client = null;
    }

    @Override
    public void run() {
        System.out.println("The waiter " + name + " begins to attend to the kitchen " + kitchen);
        while (true) {
            client = kitchen.attendCliente();
            if (client != null) {
                try {

                    System.out.println("The waiter " + name + " begins to attend the client " + client);
                    Thread.sleep(client.getAttention_time());
                    System.out.println(name + " termina de atender a: " + client.getName());
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }

        }
    }
}
