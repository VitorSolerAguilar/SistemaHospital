/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vitor
 */
public class daoPaciente {

    private Connection conn;

    public daoPaciente(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tblPaciente(CPF, nome, endereco, telefone, dataNascimento, altura, peso) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setDate(5, Date.valueOf(paciente.getDataNascimento()));
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

}
