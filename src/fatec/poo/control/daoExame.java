/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Exame;
import fatec.poo.model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class daoExame {

    private Connection conn;

    public daoExame(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Exame exame, int codigoConsulta) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO tblExame (codigo, descricao, data, horario, valor, codigoConsulta) VALUES (?,?,?,?,?,?)"
            );

            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, codigoConsulta);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Exame: " + ex.getMessage());
        }
    }

    public Exame consultar(int codigo) {
        Exame exame = null;

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tblExame WHERE codigo = ?"
            );

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exame = new Exame(
                        rs.getInt("codigo"),
                        rs.getString("descricao")
                );

                exame.setData(rs.getString("data"));
                exame.setHorario(rs.getString("horario"));
                exame.setValor(rs.getDouble("valor"));
                exame.setCodigoConsulta(rs.getInt("codigoConsulta"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Exame: " + ex.getMessage());
        }

        return exame;
    }

    public int consultarCodigoConsulta(int codigoExame) {
        int codigoConsulta = -1;

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT codigoConsulta FROM tblExame WHERE codigo = ?"
            );

            ps.setInt(1, codigoExame);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                codigoConsulta = rs.getInt("codigoConsulta");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar código da consulta: " + ex.getMessage());
        }

        return codigoConsulta;
    }

    public void alterar(Exame exame) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tblExame SET descricao=?, data=?, horario=?, valor=? WHERE codigo=?"
            );

            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar Exame: " + ex.getMessage());
        }
    }

    public void excluir(Exame exame) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tblExame WHERE codigo=?"
            );

            ps.setInt(1, exame.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Exame: " + ex.getMessage());
        }
    }
}
