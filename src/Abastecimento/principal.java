package Abastecimento;
//importando as bibliotecas
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class principal {

	public static void main(String[] args) {
		// Determinar as variavéis a ser usadas
		String opcao, nome;
		int covopcao;
		
		Connection conexao = ConnectionFactory.createConnection();
		
		//Iniciando valor na variavél declarada acima
		opcao = "0";
		covopcao = Integer.parseInt(opcao);
		while(covopcao != 9) {
			opcao = JOptionPane.showInputDialog(null, "Entre com uma opção: \n"
					+ "1 - Cadastrar\n"
					+ "2 - Editar\n"
					+ "3 - Excluir\n"
					+ "4 - Listar\n"
					+ "5 - Consultar\n"
					+ "9 - Sair\n", 
	                "SisCombustivel", JOptionPane.INFORMATION_MESSAGE);	
			covopcao = Integer.parseInt(opcao);
			
			switch(covopcao) {
			case 1: {
				InserirAbastecimento.inserirAbastecimento();
			}
			break;
			case 2: {
				UpdateAbastecimento.updateAbastecimento();
			}
			break;
			case 3: {
				DeleteAbastecimento.deleteAbastecimento();
				
				  
			}
			break;
			case 4:{
				ListarAbastecimento.listarAbastecimento();
			}
			break;
			case 5: {
				SelectItemAbastecimento.selectItemAbastecimento();
			}
			break;
			case 9: {
				JOptionPane.showMessageDialog(null, "Obrigado por usar o nosso sistema!");
			}
			break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
			}
		}
	}

}
