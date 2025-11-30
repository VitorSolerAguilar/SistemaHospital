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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;

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

    public void excluir(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblPaciente WHERE CPF = ?");
            ps.setString(1, paciente.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Paciente consultar(String cpf) {
        Paciente p = null;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tblPaciente WHERE CPF = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
                double altura = rs.getDouble("altura");
                double peso = rs.getDouble("peso");

                p = new Paciente(dataNascimento, cpf, nome);

                p.setEndereco(endereco);
                p.setTelefone(telefone);
                p.setAltura(altura);
                p.setPeso(peso);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }

    public void alterar(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tblPaciente SET nome = ?, endereco = ?, telefone = ?, dataNascimento = ?, altura = ?, peso = ? WHERE CPF = ?");

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setDate(4, Date.valueOf(paciente.getDataNascimento()));
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
