/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class daoMedicacao {

    private Connection conn;

    public daoMedicacao(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medicacao medicacao) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO tblMedicacao (nome, dosagem, qtdeDias, codigoConsulta) VALUES (?,?,?,?)"
            );
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, medicacao.getCodigoConsulta());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Medicacao: " + ex.getMessage());
        }
    }

    public Medicacao consultar(String nome) {
        Medicacao medicacao = null;

        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tblMedicacao WHERE nome = ?"
            );

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                medicacao = new Medicacao(nome);
                medicacao.setDosagem(rs.getString("dosagem"));
                medicacao.setQtdeDias(rs.getInt("qtdeDias"));
                medicacao.setCodigoConsulta(rs.getInt("codigoConsulta"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar medicacao: " + ex.getMessage());
        }

        return medicacao;
    }

    public void alterar(Medicacao medicacao) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tblMedicacao SET dosagem=?, qtdeDias=?, codigoConsulta=? WHERE nome=?"
            );
            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setInt(3, medicacao.getCodigoConsulta());
            ps.setString(4, medicacao.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar Medicacao: " + ex.getMessage());
        }
    }

    public void excluir(String nome) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tblMedicacao WHERE nome=?"
            );
            ps.setString(1, nome);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Medicacao: " + ex.getMessage());
        }
    }
}
