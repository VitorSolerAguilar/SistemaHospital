/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package fatec.poo.model;

/**
 * * * @author lucas
 */
public class Exame {

    private int codigo;
    private String descricao;
    private String data;
    private String horario;
    private double valor;
    private int codigoConsulta;
    private Consulta consulta;

    public Exame(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public double getValor() {
        return valor;
    }
}
