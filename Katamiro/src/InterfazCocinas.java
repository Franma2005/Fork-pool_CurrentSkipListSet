import javax.swing.*;
import javax.swing.border.Border;
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

            // Panel principal con un diseño vertical
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(240, 240, 240)); // Fondo claro
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;

            // Crear un borde decorativo
            Border border = BorderFactory.createLineBorder(new Color(100, 100, 200), 2);

            // Configurar los JTextAreas con títulos fijos
            int row = 0;
            for (Waiter waiter : waiters) {
                // Etiqueta con el nombre del camarero
                JLabel label = new JLabel(waiter.getname(), SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setForeground(new Color(50, 50, 150));
                gbc.gridx = 0;
                gbc.gridy = row;
                panel.add(label, gbc);

                // JTextArea con el scroll pane
                JTextArea textArea = waiter.getTextArea();
                JScrollPane scroll = new JScrollPane(textArea);
                textArea.setEditable(false);
                textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
                textArea.setBackground(new Color(230, 230, 250)); // Fondo lila suave
                textArea.setBorder(BorderFactory.createCompoundBorder(border,
                        BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Borde con relleno

                gbc.gridy = row + 1;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.BOTH;
                panel.add(scroll, gbc);

                row += 2; // Avanzar dos filas por cada camarero
            }

            // Agregar el panel a la ventana principal
            frame.add(panel);

            // Hacer visible la ventana
            frame.setVisible(true);
        });
    }
}





