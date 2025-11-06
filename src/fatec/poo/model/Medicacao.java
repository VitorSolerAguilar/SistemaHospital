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
    private String nome, dosagem, descricao;
    private int qtdeDias;

    public Medicacao(String descricao) {
        this.descricao = descricao;
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
}
