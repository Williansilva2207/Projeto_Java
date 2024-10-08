package Evento;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private Local local;
    private int capacidadeMaxima;
    private List<Participante> participantes;

    public Evento(String nome, String data, Local local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public Local getLocal() {
        return local;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public boolean registrarParticipante(Participante participante) {
        if (participantes.size() < capacidadeMaxima) {
            participantes.add(participante);
            return true;
        } else {
            System.out.println("Capacidade máxima atingida para o evento: " + nome);
            return false;
        }
    }

    public int getNumeroParticipantes() {
        return participantes.size();
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void gerarRelatorioParticipacao() {
        System.out.println("Relatório de Participantes - Evento: " + nome);
        for (Participante p : participantes) {
            System.out.println("Nome: " + p.getNome() + " | Email: " + p.getEmail());
        }
    }
}

