package Abastecimento;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import conexao.ConnectionFactory;

import conexao.ConnectionFactory;

public class ListarAbastecimento {
	static void listarAbastecimento(){
		try {
			//abrindo uma conexão
			Connection conexao = ConnectionFactory.createConnection();
			//criar o SQL para extrai dados do banco
			String sql = "SELECT * FROM abastecimento;";
			int kmanterio, kmtotal, kmatual;
			float kml, precocombustivel, precototal;
			kmanterio = 0;
			precototal = 0;
			precocombustivel = 0;
			//criando comando...
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
            //executando o comando...
            ResultSet resultado = cmd.executeQuery(); //resultado recebe os dados da consulta
            String combustivel; //variavel para receber os dados 
            combustivel = "<< Abastecimentos encontrados >>\n";
            
            while(resultado.next()){ //percorre todos os dados do retorno da consulta
            	kmatual  = resultado.getInt("kmatual");
            	precocombustivel = resultado.getFloat("precocombustivel");
            	precototal = resultado.getFloat("precototal");
        		kmtotal = kmatual - kmanterio;
        		kml = precototal / precocombustivel;
        		if(kmtotal==0) {
        			kml = 0;
        		}
            	combustivel += "ID: " + resultado.getInt("idabastecimento") //add cada item na string manuscritos
                        + " - Data: " + resultado.getDate("data")
                        + "\n"
                        + " - Nome: " + resultado.getString("nome")
                        + " - CPF: " + resultado.getString("cpf")
                        + " - Nome Empresa: " + resultado.getString("nome_empresa")
                        + " - CNPJ: " + resultado.getString("cnpj")
                        + " - Montadora: " + resultado.getString("montadora")
                        + " - Modelo: " + resultado.getString("modelo")
                        + " - Ano: " + resultado.getString("ano")
                        + " - Placa: " + resultado.getString("placa")
                        + " - Email: " + resultado.getString("email")
                        + " - Endereço: " + resultado.getString("endereco")
                        + " - Bairro: " + resultado.getString("bairro")
                        + " - Cidade: " + resultado.getString("cidade")
                        + " - UF: " + resultado.getString("uf")
                        + " - CEP: " + resultado.getString("cep")
                        + "\n"
                        + " - Preço Unitário: " + resultado.getFloat("precocombustivel")
                        + " - Abastecimento: " +  resultado.getFloat("precototal")
                        + " - Tipo de Combustivel: " +  resultado.getString("tipocombustivel")
                        + " - KM Atual: " +  resultado.getInt("kmatual")
                        + "\n"
                        + "> KM Total: " + kmtotal 
                        + " - Km/l: " + kml 
                        + "\n\n";
            	
            		kmanterio  = resultado.getInt("kmatual");
            		
            		
            		
         
            		            	
           }
           JOptionPane.showMessageDialog(null, combustivel); //exibe os manuscritos
           conexao.close(); //fecha a conexão
            
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
