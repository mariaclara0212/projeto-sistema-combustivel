package Abastecimento;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;

public class DeleteAbastecimento {
	static void deleteAbastecimento() {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			//JOptionPane.showMessageDialog(null, "Conexão aberta no sistema.");
			
				//INSERIR O CPF PARA REALIZAR O UPDATE
				String cpf = "";
				while(cpf.isEmpty()) {
					cpf = JOptionPane.showInputDialog("Insira o CPF : ");
				}
				
				String sql = "DELETE FROM abastecimento WHERE cpf = ?";
				
				PreparedStatement cmd = conexao.prepareStatement(sql);
				cmd.setString(1, cpf);
				
				cmd.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
				cmd.close();
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
