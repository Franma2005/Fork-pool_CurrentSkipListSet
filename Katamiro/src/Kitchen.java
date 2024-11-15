import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Kitchen {
    private String kitchenName;
    private Queue<Client> colaClientes;
    private ArrayList<Waiter> waiters;

    public Kitchen() {
        colaClientes = new ConcurrentLinkedQueue<>();
    }

    public Kitchen(String kitchenName) {
        colaClientes = new ConcurrentLinkedQueue<>();
        this.kitchenName = kitchenName;
    }

    public void addCliente(Client client) {
        colaClientes.add(client);
        System.out.println(client.getName() + " está esperando en la cola");
    }

    public Client attendCliente() {
        return colaClientes.poll();
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }
}
