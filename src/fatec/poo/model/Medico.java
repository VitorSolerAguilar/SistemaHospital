/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Medico extends Pessoa{
    private String crm, especialidade;
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public Medico(String cpf, String nome, String crm, String especialidade) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    public void addConsulta(Consulta c) {
        consultas.add(c);
        c.setMedico(this);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
}
