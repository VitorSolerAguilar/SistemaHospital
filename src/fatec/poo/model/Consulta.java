/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.List;

/**
 *
 * @author vitor
 */
public class Consulta {

    private int codigo;
    private String data;
    private double valor;

    private Medico medico;
    private List<Medicacao> medicacoes;
    private List<Exame> exames;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void addMedicacoes(Medicacao m) {
        medicacoes.add(m);
    }

    public void addExame(Exame e) {
        exames.add(e);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public double calcValorTotalPagar() {
        return 0;
    }
}
