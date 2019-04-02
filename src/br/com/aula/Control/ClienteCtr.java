package br.com.aula.Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.aula4.Model.ClienteDAO;
import br.com.aula4.Model.ClienteModel;
import br.com.aula4.View.classView;

public class ClienteCtr {
	
	

    
	Connection conn = ClienteDAO.conexao();
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	public void insereCliente(String nome, String sobrenome , String idade , String sexo) {
		
		Connection conn = ClienteDAO.conexao();
		
		
		String sql = "INSERT INTO Cliente (nome,sobrenome,idade,sexo) VALUES (?,?,?,?)";
		
		
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,nome);
			pst.setString(2,sobrenome);
			pst.setString(3,idade);
			pst.setString(4, sexo);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
		
		
	}
	
	
	public void Buscar() {
		
		String id = JOptionPane.showInputDialog("Digite um ID:");
		
		Connection conn = ClienteDAO.conexao();
		
		String sql = "select * from Cliente where id = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,id);
			
			rs = pst.executeQuery();	
			
			if(rs.next()) {
				
				 String nome = rs.getString(2);
				 String sobrenome = rs.getString(3);
				 String idade = rs.getString(4);
				 String sexo = rs.getString(5);
				 
				
				 JOptionPane.showMessageDialog(null,"Registro encontrado!\n\nNome: " + nome + " " + sobrenome + "\nIdade: " + idade + "\nSexo: " + sexo);
				
			}
			
			else {
				 JOptionPane.showMessageDialog(null,"Registro não encontrado!!");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public void Remover() {
		
		String id = JOptionPane.showInputDialog("Digite um ID:");
		Connection conn = ClienteDAO.conexao();
		String sql = "delete from cliente where id = ?";
		
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,id);
			pst.execute();
			
			JOptionPane.showMessageDialog(null,"Cadastro removido");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
	public void alterar() {
		
		String nome = JOptionPane.showInputDialog("Atualizar nome");
		String sobrenome = JOptionPane.showInputDialog("Atualizar sobrenome");
		String idade = JOptionPane.showInputDialog("Atualizar idade");
		String sexo = JOptionPane.showInputDialog("Atualizar sexo");
		String id = JOptionPane.showInputDialog("Qual o id que deseja alterar");
		
		Connection conn = ClienteDAO.conexao();
		String sql = "update cliente set nome =?,sobrenome =?,idade =?,sexo=? where id = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,nome);
			pst.setString(2, sobrenome);
			pst.setString(3, idade);
			pst.setString(4, sexo);
			pst.setString(5, id);
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Cadastro Alterado!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	
	
	

}
