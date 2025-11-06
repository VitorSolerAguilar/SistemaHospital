/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Paciente extends Pessoa {

    private LocalDate dataNascimento;
    private double altura;
    private double peso;

    private List<Consulta> consultas;

    public Paciente(LocalDate dataNascimento, String cpf, String nome) {
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public double calcIMC() {
        return peso / Math.pow(altura, 2);
    }

    public void calcIdade(LocalDate dataAtual) {
        int idade = dataAtual.getYear() - dataNascimento.getYear();
    }

}
