package Abastecimento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class InserirAbastecimento {
	static void inserirAbastecimento(){
		try {
			
			//Conexao com o banco
			Connection conexao = ConnectionFactory.createConnection();
			//JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
			
			//Variaveis de informaçoes essenciais
			String nome, cpf, montadora,modelo,placa, nome_empresa, cnpj,ano, fisicaJuridica; 
			
			//Variaveis de informaçoes opcionais
			String endereco, bairro, cidade, uf, cep, email, resposta;
			
			//funcao para data
			Date data = new java.sql.Date(new java.util.Date().getTime());
			
			//Variaveis de informaçoes de combustivel
			float precocombustivel, precototal;	
			String tipocombustivel,confprecocombustivel,confprecototal,convkmatual;	
			int kmatual;
			
			//Variaveis para Mostrar o Resultado
			int kmtotal ,kmanterio = 0;
			float kml;
			
			
			// Diferencair o fisico do Juridico
			Object[] fisica_juridica  = {"Juridico/Empresarial", "Fisico",};
			Object pergunta = JOptionPane.showInputDialog(null, "O VEICULO é JURIDICO/EMPRESARIAL ou FISICO?" , "Selecione uma opção" ,
			JOptionPane.PLAIN_MESSAGE , null ,fisica_juridica,"");
			fisicaJuridica = String.valueOf(pergunta);
			
			nome_empresa = "NULL";
			cnpj = "NULL";
			
			if(fisicaJuridica == "Fisico") {
				
				//Solicitação de dados bases do cadastramento
				nome = "";
				while(nome.isEmpty()) {
					nome = JOptionPane.showInputDialog("Insira seu NOME COMPLETO: ");
				}
				
				cpf = "";
				while(cpf.isEmpty()) {
					cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
				}
				
				montadora = "";
				while(montadora.isEmpty()) {
					montadora = JOptionPane.showInputDialog("Insira a MONTADORA/MARCA do seu VEICULO: ");
				}
				
				modelo = "";
				while(modelo.isEmpty()) {
					modelo = JOptionPane.showInputDialog("Insira a MODELO do seu VEICULO: ");
				}
				
				ano ="";
				while(ano.isEmpty()) {
					ano = JOptionPane.showInputDialog("Insira o ANO de fabricação do VEICULO: ");
				}
				
				placa = "";
				while(placa.isEmpty()) {
					placa = JOptionPane.showInputDialog("Insira a PLACA do seu VEICULO: ");
				}
				
				
				//Solicitação de dados dos combustiveis tornando obrigatoriedade
				confprecocombustivel = "";
				while(confprecocombustivel.isEmpty()) {
					confprecocombustivel = JOptionPane.showInputDialog("Qual foi o preço de litro unitário", "Exemplo: 4.66");
				}
				
				
				confprecototal = "";
				while(confprecototal.isEmpty()) {
					confprecototal = JOptionPane.showInputDialog("Qual foi o valor total abastecido", "Exemplo: 50");
				}
				
			
				//Selecionar as opçoes predefinidas
				Object[] opcoes = {"Gasolina comum","Gasolina aditivada","Gasolina premium","Gasolina formulada", "Etanol", "Etanol aditivado", "GNV (Gás Natural Veicular)", "Diesel"};
				Object res = JOptionPane.showInputDialog(null, "Escolha o Tipo do Combustével" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,opcoes,"");
				tipocombustivel = String.valueOf(res);

				convkmatual = "";
				while(convkmatual.isEmpty()) {
					convkmatual = JOptionPane.showInputDialog("Entre com o KM atual: ");
				}
				
				//Tornando null as informaçoes complementares
				Object[] op = {"Sim", "Não"};
				Object result = JOptionPane.showInputDialog(null, "Deseja complementar o cadastro? Essa ação não é obrigatoria" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,op,"");
				resposta = String.valueOf(result);
				
				email = "NULL";
				endereco = "NULL";
				bairro = "NULL";
				cidade = "NULL";
				uf = "NULL";
				cep = "NULL";
				
				
				if(resposta == "Sim") {
					email = "";
					while(email.isEmpty()) {
						email = JOptionPane.showInputDialog("Insira seu EMAIL: ");
					}
					
					endereco = "";
					while(endereco.isEmpty()) {
						endereco = JOptionPane.showInputDialog("Insira sua RUA e NUMERO","Exemplo: Rua tal, 50");
					}
					
					bairro = "";
					while(bairro.isEmpty()) {
						bairro = JOptionPane.showInputDialog("Insira seu BAIRRO: ");
					}
					
					cidade = "";
					while(cidade.isEmpty()) {
						cidade = JOptionPane.showInputDialog("Insira sua CIDADE: ");
					}
					
					uf = "";
					while(uf.isEmpty()) {
						uf = JOptionPane.showInputDialog("Insira seu ESTADO: ");
					}
					
					cep = "";
					while(cep.isEmpty()) {
						cep = JOptionPane.showInputDialog("Informe seu CEP: ");
					}
					
				}
				
			} else {
				
				//Solicitação de dados bases do cadastramento
				nome = "";
				while(nome.isEmpty()) {
					nome = JOptionPane.showInputDialog("Insira seu NOME COMPLETO: ");
				}
				
				cpf = "";
				while(cpf.isEmpty()) {
					cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
				}
				
				nome_empresa = "";
				while(nome_empresa.isEmpty()) {
					nome_empresa = JOptionPane.showInputDialog("Insira o NOME da EMPRESA: ");
				}
				
				cnpj = "";
				while(cnpj.isEmpty()) {
					cnpj = JOptionPane.showInputDialog("Insira o CNPJ da EMPRESA: ");
				}
				
				montadora = "";
				while(montadora.isEmpty()) {
					montadora = JOptionPane.showInputDialog("Insira a MONTADORA/MARCA do seu VEICULO: ");
				}
				
				modelo = "";
				while(modelo.isEmpty()) {
					modelo = JOptionPane.showInputDialog("Insira a MODELO do seu VEICULO: ");
				}
				
				ano ="";
				while(ano.isEmpty()) {
					ano = JOptionPane.showInputDialog("Insira o ANO de fabricação do VEICULO: ");
				}
				
				placa = "";
				while(placa.isEmpty()) {
					placa = JOptionPane.showInputDialog("Insira a PLACA do seu VEICULO: ");
				}
				
				
				//Solicitação de dados dos combustiveis tornando obrigatoriedade
				confprecocombustivel = "";
				while(confprecocombustivel.isEmpty()) {
					confprecocombustivel = JOptionPane.showInputDialog("Qual foi o preço de litro unitário", "Exemplo: 4.66");
				}
				
				
				confprecototal = "";
				while(confprecototal.isEmpty()) {
					confprecototal = JOptionPane.showInputDialog("Qual foi o valor total abastecido", "Exemplo: 50");
				}
				
			
				//Selecionar as opçoes predefinidas
				Object[] opcoes = {"Gasolina comum","Gasolina aditivada","Gasolina premium","Gasolina formulada", "Etanol", "Etanol aditivado", "GNV (Gás Natural Veicular)", "Diesel"};
				Object res = JOptionPane.showInputDialog(null, "Escolha o Tipo do Combustével" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,opcoes,"");
				tipocombustivel = String.valueOf(res);

				convkmatual = "";
				while(convkmatual.isEmpty()) {
					convkmatual = JOptionPane.showInputDialog("Entre com o KM atual: ");
				}
				
				//Tornando null as informaçoes complementares
				Object[] op = {"Sim", "Não"};
				Object result = JOptionPane.showInputDialog(null, "Deseja complementar o cadastro? Essa ação não é obrigatoria" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,op,"");
				resposta = String.valueOf(result);
				
				email = "NULL";
				endereco = "NULL";
				bairro = "NULL";
				cidade = "NULL";
				uf = "NULL";
				cep = "NULL";
				
				
				if(resposta == "Sim") {
					email = "";
					while(email.isEmpty()) {
						email = JOptionPane.showInputDialog("Insira seu EMAIL: ");
					}
					
					endereco = "";
					while(endereco.isEmpty()) {
						endereco = JOptionPane.showInputDialog("Insira sua RUA e NUMERO","Exemplo: Rua tal, 50");
					}
					
					bairro = "";
					while(bairro.isEmpty()) {
						bairro = JOptionPane.showInputDialog("Insira seu BAIRRO: ");
					}
					
					cidade = "";
					while(cidade.isEmpty()) {
						cidade = JOptionPane.showInputDialog("Insira sua CIDADE: ");
					}
					
					uf = "";
					while(uf.isEmpty()) {
						uf = JOptionPane.showInputDialog("Insira seu ESTADO: ");
					}
					
					cep = "";
					while(cep.isEmpty()) {
						cep = JOptionPane.showInputDialog("Informe seu CEP: ");
					}
					
					
					
				}
				
				
			}
			
			
			//Conversão de String para FLOAT e INT
			precocombustivel = Float.parseFloat(confprecocombustivel);
			precototal = Float.parseFloat(confprecototal);
			kmatual = Integer.parseInt(convkmatual);
			
			
			//Mandar pro banco as informaçoes
			String sql = "INSERT INTO abastecimento(data,nome,cpf,nome_empresa,cnpj,montadora,modelo,ano,placa,precocombustivel,precototal,tipocombustivel,kmatual,email,endereco,bairro,cidade,uf,cep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			
			//String sql = "INSERT INTO abastecimento(data,nome,cpf,veiculo,precocombustivel,precototal,tipocombustivel,kmatual,email,endereco,cidade,bairro,uf,cep) VALUES ('"+data+"','"+nome+"','"+cpf+"','"+veiculo+"','"+precocombustivel+"','"+precototal+"','"+tipocombustivel+"','"+kmatual+"','"+email+"','"+endereco+"','"+bairro+"','"+cidade+"','"+uf+"','"+cep+"');";
			//System.out.print(sql);
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setDate(1,data);
			cmd.setString(2,nome);
			cmd.setString(3,cpf);
			cmd.setString(4,nome_empresa);
			cmd.setString(5,cnpj);
			cmd.setString(6,montadora);
			cmd.setString(7,modelo);
			cmd.setString(8,ano);
			cmd.setString(9,placa);
			//
			cmd.setFloat(10,precocombustivel);
			cmd.setFloat(11,precototal);
			cmd.setString(12,tipocombustivel);
			cmd.setInt(13,kmatual);
			//
			cmd.setString(14,email);
			cmd.setString(15,endereco);
			cmd.setString(16,bairro);
			cmd.setString(17,cidade);
			cmd.setString(18,uf);
			cmd.setString(19,cep);
			
			
			//Mostrar Resultado
			kmtotal = kmatual - kmanterio;
	    	kml = precototal / precocombustivel;
	    	JOptionPane.showMessageDialog(null, "> KM Total: " + kmtotal);
	    	JOptionPane.showMessageDialog(null, "> Km/L: " + kml);
	    		
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Dados Cadastrados");
			cmd.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}