/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Paciente extends Pessoa {

    private LocalDate dataNascimento;
    private double altura;
    private double peso;

    private List<Consulta> consultas = new ArrayList<>();

    public Paciente(String cpf, String nome, LocalDate dataNascimento) {
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

    public void addConsulta(Consulta c){
        consultas.add(c);
        c.setPaciente(this);
    }
    
    public double calcIMC() {
        return peso / Math.pow(altura, 2);
    }

    public int calcIdade(LocalDate dataAtual) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }

}
