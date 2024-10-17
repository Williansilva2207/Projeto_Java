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
        setLayout(new GridLayout(3, 1));

        // Título
        JLabel titulo = new JLabel("Selecione o Sistema", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo);

        // Botão para abrir o sistema de restaurante (sem implementação gráfica ainda)
        JButton restauranteButton = new JButton("Sistema de Restaurante");
        restauranteButton.setBackground(Color.ORANGE);
        restauranteButton.addActionListener(this::abrirRestaurante);
        add(restauranteButton);

        // Botão para abrir o sistema de clínica (sem implementação gráfica ainda)
        JButton clinicaButton = new JButton("Sistema de Clínica");
        clinicaButton.setBackground(Color.PINK);
        clinicaButton.addActionListener(this::abrirClinica);
        add(clinicaButton);

        // Botão para abrir o sistema de eventos
        JButton eventosButton = new JButton("Sistema de Eventos");
        eventosButton.setBackground(Color.CYAN);
        eventosButton.addActionListener(this::abrirEventos);
        add(eventosButton);
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

    // Método para abrir o sistema de eventos (chama a interface gráfica de eventos)
    private void abrirEventos(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            SistemaEventosApp eventosApp = new SistemaEventosApp(); // Chama a interface de eventos
            eventosApp.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
            interfacePrincipal.setVisible(true);
        });
    }
}
