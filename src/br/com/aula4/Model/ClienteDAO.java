package br.com.aula4.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClienteDAO {

	public static String status = "Desconectado";

	ClienteModel cliente = new ClienteModel();
	static Connection connection = null;

	public static Connection conexao() {

		try {
			String url = "jdbc:mysql://localhost/dbteste";
			String u_name = "root";
			String pass = "";
			connection = DriverManager.getConnection(url, u_name, pass);

			if (connection != null) {
				status = ("Conectado a base de dados");
				

			}

			else {
				status = ("Erro ao conectar");
				
			}
			return connection;

		} catch (SQLException e) {
			System.out.println("Erro ao conectar" + e);
			return null;
		}

	}

}
