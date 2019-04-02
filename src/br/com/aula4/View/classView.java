package br.com.aula4.View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.aula.Control.ClienteCtr;
import br.com.aula4.Model.ClienteDAO;

public class classView extends JFrame {

	public JLabel lblNome;
	public JTextField txtNome;

	public JLabel lblSobrenome;
	public JTextField txtSobrenome;

	private JLabel lblIdade;
	public JTextField txtIdade;

	private JLabel lblSexo;
	public JRadioButton rbSexoF;
	public JRadioButton rbSexoM;

	public JLabel lblID;
	public JTextField txtID;

	public JButton btnAdd;
	public JButton btnBuscar;
	public JButton btnRemover;
	public JButton btnAlterar;
	public ButtonGroup radioGroup;

	public classView() {

		super("Cadastro Cliente");
		setLayout(new FlowLayout());

		Connection conn = ClienteDAO.conexao();

		ClienteCtr clientectr = null;

		lblNome = new JLabel("Nome");
		add(lblNome);

		txtNome = new JTextField(10);
		add(txtNome);

		lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome);

		txtSobrenome = new JTextField(10);
		add(txtSobrenome);

		lblIdade = new JLabel("Idade");
		add(lblIdade);

		txtIdade = new JTextField(2);
		add(txtIdade);

		lblSexo = new JLabel("Sexo");
		add(lblSexo);

		rbSexoM = new JRadioButton("M");
		add(rbSexoM);

		rbSexoF = new JRadioButton("F");
		add(rbSexoF);

		

		

		btnAdd = new JButton("Adicionar");
		add(btnAdd);

		btnBuscar = new JButton("Buscar");
		add(btnBuscar);

		btnRemover = new JButton("Remover");
		add(btnRemover);

		btnAlterar = new JButton("Alterar");
		add(btnAlterar);

		radioGroup = new ButtonGroup();
		radioGroup.add(rbSexoF);
		radioGroup.add(rbSexoM);

		rbSexoM.setSelected(true);

		Adicionar Add = new Adicionar();
		btnAdd.addActionListener(Add);

		Buscar busca = new Buscar();
		btnBuscar.addActionListener(busca);

		Remover remove = new Remover();
		btnRemover.addActionListener(remove);

		Alterar altera = new Alterar();
		btnAlterar.addActionListener(altera);

	}

	private class Adicionar implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			ClienteCtr cliente = new ClienteCtr();

			if (txtNome.getText().isEmpty() || txtSobrenome.getText().isEmpty() || txtIdade.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Preencha os cambos obrigatorios!");
			}

			else {
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				String idade = txtIdade.getText();
				String sexo = null;

				if (rbSexoF.isSelected()) {
					sexo = rbSexoF.getText();
				} else {
					sexo = rbSexoM.getText();
				}

				cliente.insereCliente(nome, sobrenome, idade, sexo);

				txtNome.setText(null);
				txtSobrenome.setText(null);
				txtIdade.setText(null);
			}

		}

	}

	private class Buscar implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			ClienteCtr cliente = new ClienteCtr();
			
			cliente.Buscar();

		}

	}

	public class Remover implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			ClienteCtr cliente = new ClienteCtr();

			
				cliente.Remover();
				
			

		}
	}

	public class Alterar implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			ClienteCtr cliente = new ClienteCtr();


				cliente.alterar();
				

		}
	}

}
