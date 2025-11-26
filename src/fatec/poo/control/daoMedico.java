/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class daoMedico {

    private Connection conn;

    public daoMedico(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tblMedico(CPF, nome, endereco, telefone, crm, especialidade) VALUES(?,?,?,?,?,?)");
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void excluir(Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblMedico WHERE cpf = ?");
            ps.setString(1, medico.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Medico medico) {
        PreparedStatement ps = null;
        try {
        ps = conn.prepareStatement(
            "UPDATE tblMedico SET nome = ?, endereco = ?, telefone = ?, crm = ?, especialidade = ? WHERE cpf = ?"
        );

        ps.setString(1, medico.getNome());
        ps.setString(2, medico.getEndereco());
        ps.setString(3, medico.getTelefone());
        ps.setString(4, medico.getCrm());
        ps.setString(5, medico.getEspecialidade());
        ps.setString(6, medico.getCpf()); 

        ps.execute();
        } catch (SQLException ex) {
        System.out.println(ex.toString());
        }
    }

    public Medico consultar(String cpf) {
        Medico m = null;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tblMedico WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String crm = rs.getString("crm");
                String especialidade = rs.getString("especialidade");

                m = new Medico(cpf, nome, crm, especialidade);
                m.setEndereco(endereco);
                m.setTelefone(telefone);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return m;
    }

    public ArrayList<Medico> consultarMedicos() {
        ArrayList<Medico> medico = new ArrayList<Medico>();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tblMedico ORDER BY nome");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String crm = rs.getString("crm");
                String especialidade = rs.getString("especialidade");

                Medico m = new Medico(cpf, nome, crm, especialidade);
                m.setEndereco(endereco);
                m.setTelefone(telefone);

                medico.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return medico;
    }
}