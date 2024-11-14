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
        waiters = new ArrayList<>();
    }

    public void addCliente(Client client) {
        colaClientes.add(client);
    }

    public void attendCliente(Client client) {
        colaClientes.poll();
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }
}
