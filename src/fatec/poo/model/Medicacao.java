/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author lucas
 */
public class Medicacao{
    private String nome;
    private String dosagem;
    private int qtdeDias;
    private Consulta consulta;

    public Medicacao(String nome) {
        this.nome = nome;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    public String getNome() {
        return nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }
    
    public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
    consulta.addMedicacoes(this);
}
}
