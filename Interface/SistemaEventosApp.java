package Interface;

import Evento.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEventosApp extends JFrame {

    private Evento evento;

    public SistemaEventosApp() {
        setTitle("Sistema de Gerenciamento de Eventos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel labelTitulo = new JLabel("Gerenciamento de Eventos", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelTitulo);

        JButton btnRegistrar = new JButton("Registrar Participante");
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarParticipante();
            }
        });

        JButton btnVerificar = new JButton("Verificar Número de Participantes");
        btnVerificar.setBackground(Color.YELLOW);
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarNumeroParticipantes();
            }
        });

        JButton btnRelatorio = new JButton("Gerar Relatório");
        btnRelatorio.setBackground(Color.CYAN);
        btnRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorioParticipacao();
            }
        });

        add(btnRegistrar);
        add(btnVerificar);
        add(btnRelatorio);

        iniciarSistema();
    }

    private void iniciarSistema() {
        String nomeEvento = JOptionPane.showInputDialog("Informe o nome do evento:");
        String dataEvento = JOptionPane.showInputDialog("Informe a data do evento:");
        String nomeLocal = JOptionPane.showInputDialog("Informe o nome do local:");
        int capacidadeMaxima = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade máxima:"));

        Local local = new Local(nomeLocal, "Endereço Padrão");
        evento = new Evento(nomeEvento, dataEvento, local, capacidadeMaxima);

        JOptionPane.showMessageDialog(this, "Evento criado com sucesso!");
    }

    private void registrarParticipante() {
        if (evento != null) {
            String nome = JOptionPane.showInputDialog("Nome do participante:");
            String email = JOptionPane.showInputDialog("Email do participante:");

            Participante participante = new Participante(nome, email);
            boolean sucesso = evento.registrarParticipante(participante);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Participante registrado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível registrar o participante.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum evento está ativo.");
        }
    }

    private void verificarNumeroParticipantes() {
        if (evento != null) {
            JOptionPane.showMessageDialog(this, "Número de participantes: " + evento.getNumeroParticipantes());
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum evento está ativo.");
        }
    }

    private void gerarRelatorioParticipacao() {
        if (evento != null) {
            StringBuilder relatorio = new StringBuilder("Relatório de Participantes - Evento: " + evento.getNome() + "\n");
            for (Participante p : evento.getParticipantes()) {
                relatorio.append("Nome: ").append(p.getNome()).append(" | Email: ").append(p.getEmail()).append("\n");
            }
            JOptionPane.showMessageDialog(this, relatorio.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum evento está ativo.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaEventosApp app = new SistemaEventosApp();
            app.setVisible(true);
        });
    }
}