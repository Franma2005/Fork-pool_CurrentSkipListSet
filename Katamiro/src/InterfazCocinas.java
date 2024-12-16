import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazCocinas {
    public static void createMenuKitchen(ArrayList<Waiter> waiters) {
        // Establecer el estilo Nimbus
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo configurar el estilo Nimbus. Usando el estilo por defecto.");
        }

        // Crear la ventana principal
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Katamiro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana

            // Crear el panel principal con un GridLayout para ocupar toda la pantalla
            JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));

            // Configurar los JTextAreas
            for (Waiter waiter : waiters) {
                JTextArea textArea = waiter.getTextArea();
                JScrollPane scroll = new JScrollPane(textArea);
                textArea.setEditable(false);
                textArea.setText(waiter.getname());
                panel.add(scroll);
            }

            // Agregar el panel a la ventana principal
            frame.add(panel);

            // Hacer visible la ventana
            frame.setVisible(true);
        });
    }
}

