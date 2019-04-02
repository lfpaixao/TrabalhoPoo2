package br.com.aula4.View;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;

import br.com.aula4.Model.ClienteDAO;



public class classTest {
	public static void main(String[] args){
		
		classView cliente = new classView();		
		cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cliente.setSize(540 , 200);
		cliente.setVisible(true);
		cliente.setLocationRelativeTo(null);
		cliente.setResizable(false);
		
		
		Connection conn = ClienteDAO.conexao();
		System.out.println(ClienteDAO.status);
	}

}
