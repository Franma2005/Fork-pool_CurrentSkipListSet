import javax.swing.*;
import java.awt.*;

public class InterfazCocinas {
    public static void createMenuKitchen() {
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
            JTextArea textArea1 = new JTextArea();
            JTextArea textArea2 = new JTextArea();
            JTextArea textArea3 = new JTextArea();

            textArea1.setEditable(false);
            textArea2.setEditable(false);
            textArea3.setEditable(false);
            textArea1.setText("Guille Kitchen");
            textArea2.setText("Paquet Kitchen");
            textArea3.setText("Isma Kitchen");

            // Hacer que las áreas de texto sean desplazables
            JScrollPane scroll1 = new JScrollPane(textArea1);
            JScrollPane scroll2 = new JScrollPane(textArea2);
            JScrollPane scroll3 = new JScrollPane(textArea3);

            // Agregar las áreas de texto al panel
            panel.add(scroll1);
            panel.add(scroll2);
            panel.add(scroll3);

            // Agregar el panel a la ventana principal
            frame.add(panel);

            // Hacer visible la ventana
            frame.setVisible(true);
        });
    }
}

