package Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SistemaClinicaApp extends JFrame {
    private JButton voltarButton;

    public SistemaClinicaApp() {
        setTitle("Clínica SóOsLoucos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Adicionando um botão de voltar
        voltarButton = new JButton("<- Voltar");
        voltarButton.addActionListener(this::voltarAoMenuPrincipal);

        // Painel para o conteúdo da clínica
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(voltarButton, BorderLayout.NORTH); // Colocando o botão no topo

        // Adicionando o painel ao JFrame
        add(panel, BorderLayout.CENTER);
        // Aqui você adiciona o restante do seu código para o sistema de clínica

        // Exemplo de adição de conteúdo
        JTextArea textArea = new JTextArea("Bem-vindo ao Sistema de Clínica!");
        panel.add(textArea, BorderLayout.CENTER);
    }

    private void voltarAoMenuPrincipal(ActionEvent e) {
        this.dispose(); // Fecha a janela atual da clínica
        new InterfacePrincipal().setVisible(true); // Retorna ao menu principal
    }
}
