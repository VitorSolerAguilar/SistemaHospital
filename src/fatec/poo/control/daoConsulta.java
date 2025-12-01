/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author vitor
 */
public class daoConsulta {

    private Connection conn;

    public daoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tblConsulta(codigo, dtConsulta, valor, cpfMedico, cpfPaciente) VALUES(?,?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5, consulta.getPaciente().getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tblConsulta WHERE codigo = ?");
            ps.setInt(1, consulta.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Consulta consultar(int codigo) {
        Consulta c = null;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tblConsulta WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String data = rs.getString("dtConsulta");
                double valor = rs.getDouble("valor");
                String cpfMedico = rs.getString("cpfMedico");
                String cpfPaciente = rs.getString("cpfPaciente");

                c = new Consulta(codigo, data);
                c.setValor(valor);

                daoMedico daoM = new daoMedico(conn);
                Medico m = daoM.consultar(cpfMedico);
                c.setMedico(m);

                daoPaciente daoP = new daoPaciente(conn);
                Paciente p = daoP.consultar(cpfPaciente);
                c.setPaciente(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return c;
    }

    public void alterar(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tblConsulta SET dtConsulta = ?, valor = ?, cpfMedico = ?, cpfPaciente = ? WHERE codigo = ?");

            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setString(3, consulta.getMedico().getCpf());
            ps.setString(4, consulta.getPaciente().getCpf());
            ps.setInt(5, consulta.getCodigo());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
