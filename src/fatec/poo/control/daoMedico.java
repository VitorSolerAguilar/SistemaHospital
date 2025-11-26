/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vitor
 */
public class daoMedico {
    private Connection conn;

    public daoMedico(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Medico medico){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tblMedico(CPF, nome, endereco, telefone, crm, especialidade) VALUES(?,?,?,?,?,?)");
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Medico medico){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("DELETE FROM tblMedico WHERE cpf = ?");
            
            ps.setString(1, medico.getCpf());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
            
        }
    }   
    
}
