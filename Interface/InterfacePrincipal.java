package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Classe principal da interface
public class InterfacePrincipal extends JFrame {
    public InterfacePrincipal() {
        setTitle("Sistema de Gerenciamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botão para abrir o sistema de restaurante
        JButton restauranteButton = new JButton("Restaurante");
        restauranteButton.addActionListener(this::abrirRestaurante);
        
        // Botão para abrir o sistema de clínica
        JButton clinicaButton = new JButton("Clínica");
        clinicaButton.addActionListener(this::abrirClinica);

        add(restauranteButton);
        add(clinicaButton);
    }

    private void abrirRestaurante(ActionEvent e) {
        // Chama o aplicativo do sistema de restaurante
        SwingUtilities.invokeLater(() -> {
            SistemaRestauranteApp app = new SistemaRestauranteApp();
            app.setVisible(true);
        });
    }

    private void abrirClinica(ActionEvent e) {
        // Chama o aplicativo do sistema de clínica
        SwingUtilities.invokeLater(() -> {
            SistemaClinicaApp app = new SistemaClinicaApp();
            app.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
            interfacePrincipal.setVisible(true);
        });
    }
}
