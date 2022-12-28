package Abastecimento;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;


public class UpdateAbastecimento {
	static void updateAbastecimento() {
		try {
			//Conexao com o banco
			Connection conexao = ConnectionFactory.createConnection();
			//JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
			
			//INSERIR O CPF PARA REALIZAR O UPDATE
			String cpf = "";
			while(cpf.isEmpty()) {
				 cpf = JOptionPane.showInputDialog("Insira o CPF : ");
			}
						
			//Variaveis de informaçoes essenciais
			String nome, montadora,modelo,placa, nome_empresa, ano, fisicaJuridica;  
			
			//Variaveis de informaçoes opcionais
			String endereco , bairro , cidade , uf , cep , email , resposta;
			
			//dados do abastecimento
			float precocombustivel, precototal;	
			String tipocombustivel,confprecocombustivel,confprecototal,convkmatual;	
			int kmatual;
			
			//Variaveis para Mostrar o Resultado
			int kmtotal ,kmanterio = 0;
			float kml;
			
			//data do update
			Date data_update = new java.sql.Date(new java.util.Date().getTime());
			
			//Solicitação de dados bases do cadastramento
			Object[] fisica_juridica  = {"Juridico/Empresarial", "Fisico",};
			Object pergunta = JOptionPane.showInputDialog(null, "O VEICULO é JURIDICO/EMPRESARIAL ou FISICO?" , "Selecione uma opção" ,
			JOptionPane.PLAIN_MESSAGE , null ,fisica_juridica,"");
			fisicaJuridica = String.valueOf(pergunta);
			
			nome_empresa = "NULL";
			
			
			if(fisicaJuridica == "Fisico") {
				
				//Solicitação de dados bases do cadastramento
				nome = "";
				while(nome.isEmpty()) {
					nome = JOptionPane.showInputDialog("Insira seu NOME COMPLETO: ");
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
				
				//Conversão de String para FLOAT e INT
				precocombustivel = Float.parseFloat(confprecocombustivel);
				precototal = Float.parseFloat(confprecototal);
				kmatual = Integer.parseInt(convkmatual);
				
				//Tornando null as informaçoes complementares
				Object[] op = {"Sim", "Não"};
				Object result = JOptionPane.showInputDialog(null, "Deseja complementar o cadastro? Essa ação não é obrigatoria" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,op,"");
				resposta = String.valueOf(result);
		
				
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
					
					
					String sql = "UPDATE abastecimento SET data_update = ?,nome= ?,nome_empresa = ?,montadora = ?,modelo = ?,ano = ?,placa = ?,precocombustivel= ? ,precototal= ? ,tipocombustivel= ? ,kmatual= ? ,email= ? ,endereco= ? ,bairro= ? ,cidade= ? ,uf= ? ,cep= ? WHERE cpf =?;";
					//String sql = "UPDATE abastecimento SET data_update='"+ data_update +"', nome='"+nome+"', cpf='"+cpf+"', telefone='"+telefone+"', endereco ='"+endereco+"', bairro='"+bairro+"', cidade='"+cidade+"', uf='"+uf+"', cep='"+cep+"', precocombustivel ='"+precocombustivel+"', precototal ='"+precototal+"', tipocombustivel ='"+tipocombustivel+"', kmatual='"+kmatual+"', WHERE cpf ='"+cpf+"';";
					//System.out.print(sql);
					
					//Mandar os dados pro banco
					PreparedStatement cmd = conexao.prepareStatement(sql);
					cmd.setDate(1,data_update);
					cmd.setString(2,nome);
					cmd.setString(3,nome_empresa);
					cmd.setString(4,montadora);
					cmd.setString(5,modelo);
					cmd.setString(6,ano);
					cmd.setString(7,placa);
					//
					cmd.setFloat(8,precocombustivel);
					cmd.setFloat(9,precototal);
					cmd.setString(10,tipocombustivel);
					cmd.setInt(11,kmatual);
					//
					cmd.setString(12,email);
					cmd.setString(13,endereco);
					cmd.setString(14,bairro);
					cmd.setString(15,cidade);
					cmd.setString(16,uf);
					cmd.setString(17,cep);
					cmd.setString(18,cpf);
					
					//Mostrar Resultado
					kmtotal = kmatual - kmanterio;
			    	kml = precototal / precocombustivel;
			    	JOptionPane.showMessageDialog(null, "> KM Total: " + kmtotal);
			    	JOptionPane.showMessageDialog(null, "> Km/L: " + kml);
					
					cmd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados Atualizados");
					cmd.close();
					
				} else {
					
					String sql = "UPDATE abastecimento SET data_update = ?,nome= ?,nome_empresa = ?,montadora = ?,modelo = ?,ano = ?,placa = ?,precocombustivel= ? ,precototal= ? ,tipocombustivel= ? ,kmatual= ?  WHERE cpf =?;";
					//String sql = "UPDATE abastecimento SET data_update='"+ data_update +"', nome='"+nome+"', cpf='"+cpf+"', telefone='"+telefone+"', endereco ='"+endereco+"', bairro='"+bairro+"', cidade='"+cidade+"', uf='"+uf+"', cep='"+cep+"', precocombustivel ='"+precocombustivel+"', precototal ='"+precototal+"', tipocombustivel ='"+tipocombustivel+"', kmatual='"+kmatual+"', WHERE cpf ='"+cpf+"';";
					//System.out.print(sql);
					
					//Mandar os dados pro banco
					PreparedStatement cmd = conexao.prepareStatement(sql);
					cmd.setDate(1,data_update);
					cmd.setString(2,nome);
					cmd.setString(3,nome_empresa);
					cmd.setString(4,montadora);
					cmd.setString(5,modelo);
					cmd.setString(6,ano);
					cmd.setString(7,placa);
					//
					cmd.setFloat(8,precocombustivel);
					cmd.setFloat(9,precototal);
					cmd.setString(10,tipocombustivel);
					cmd.setInt(11,kmatual);
					//
					cmd.setString(12,cpf);
					
					//Mostrar Resultado
					kmtotal = kmatual - kmanterio;
			    	kml = precototal / precocombustivel;
			    	JOptionPane.showMessageDialog(null, "> KM Total: " + kmtotal);
			    	JOptionPane.showMessageDialog(null, "> Km/L: " + kml);
					
					cmd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados Atualizados");
					cmd.close();
				}
				
			} else {
				
				//Solicitação de dados bases do cadastramento
				nome = "";
				while(nome.isEmpty()) {
					nome = JOptionPane.showInputDialog("Insira seu NOME COMPLETO: ");
				}
				
				nome_empresa = "";
				while(nome_empresa.isEmpty()) {
					nome_empresa = JOptionPane.showInputDialog("Insira o NOME da EMPRESA: ");
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
				
				//Conversão de String para FLOAT e INT
				precocombustivel = Float.parseFloat(confprecocombustivel);
				precototal = Float.parseFloat(confprecototal);
				kmatual = Integer.parseInt(convkmatual);
				
				//Tornando null as informaçoes complementares
				Object[] op = {"Sim", "Não"};
				Object result = JOptionPane.showInputDialog(null, "Deseja complementar o cadastro? Essa ação não é obrigatoria" , "Selecione uma opção" ,
				JOptionPane.PLAIN_MESSAGE , null ,op,"");
				resposta = String.valueOf(result);
				
				
				
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
					
					String sql = "UPDATE abastecimento SET data_update = ?,nome= ?,nome_empresa = ?,montadora = ?,modelo = ?,ano = ?,placa = ?,precocombustivel= ? ,precototal= ? ,tipocombustivel= ? ,kmatual= ? ,email= ? ,endereco= ? ,bairro= ? ,cidade= ? ,uf= ? ,cep= ? WHERE cpf =?;";
					
					//String sql = "UPDATE abastecimento SET data_update='"+ data_update +"', nome='"+nome+"', cpf='"+cpf+"', telefone='"+telefone+"', endereco ='"+endereco+"', bairro='"+bairro+"', cidade='"+cidade+"', uf='"+uf+"', cep='"+cep+"', precocombustivel ='"+precocombustivel+"', precototal ='"+precototal+"', tipocombustivel ='"+tipocombustivel+"', kmatual='"+kmatual+"', WHERE cpf ='"+cpf+"';";
					
					//System.out.print(sql);
					
					//Mandar os dados pro banco
					PreparedStatement cmd = conexao.prepareStatement(sql);
					cmd.setDate(1,data_update);
					cmd.setString(2,nome);
					cmd.setString(3,nome_empresa);
					cmd.setString(4,montadora);
					cmd.setString(5,modelo);
					cmd.setString(6,ano);
					cmd.setString(7,placa);
					//
					cmd.setFloat(8,precocombustivel);
					cmd.setFloat(9,precototal);
					cmd.setString(10,tipocombustivel);
					cmd.setInt(11,kmatual);
					//
					cmd.setString(12,email);
					cmd.setString(13,endereco);
					cmd.setString(14,bairro);
					cmd.setString(15,cidade);
					cmd.setString(16,uf);
					cmd.setString(17,cep);
					cmd.setString(18,cpf);
					
					//Mostrar Resultado
					kmtotal = kmatual - kmanterio;
			    	kml = precototal / precocombustivel;
			    	JOptionPane.showMessageDialog(null, "> KM Total: " + kmtotal);
			    	JOptionPane.showMessageDialog(null, "> Km/L: " + kml);
					
					cmd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados Atualizados");
					cmd.close();
					
				}else {
					
					String sql = "UPDATE abastecimento SET data_update = ?,nome= ?,nome_empresa = ?,montadora = ?,modelo = ?,ano = ?,placa = ?,precocombustivel= ? ,precototal= ? ,tipocombustivel= ? ,kmatual= ?  WHERE cpf =?;";
					//String sql = "UPDATE abastecimento SET data_update='"+ data_update +"', nome='"+nome+"', cpf='"+cpf+"', telefone='"+telefone+"', endereco ='"+endereco+"', bairro='"+bairro+"', cidade='"+cidade+"', uf='"+uf+"', cep='"+cep+"', precocombustivel ='"+precocombustivel+"', precototal ='"+precototal+"', tipocombustivel ='"+tipocombustivel+"', kmatual='"+kmatual+"', WHERE cpf ='"+cpf+"';";
					//System.out.print(sql);
					
					//Mandar os dados pro banco
					PreparedStatement cmd = conexao.prepareStatement(sql);
					cmd.setDate(1,data_update);
					cmd.setString(2,nome);
					cmd.setString(3,nome_empresa);
					cmd.setString(4,montadora);
					cmd.setString(5,modelo);
					cmd.setString(6,ano);
					cmd.setString(7,placa);
					//
					cmd.setFloat(8,precocombustivel);
					cmd.setFloat(9,precototal);
					cmd.setString(10,tipocombustivel);
					cmd.setInt(11,kmatual);
					//
					cmd.setString(12,cpf);
					
					//Mostrar Resultado
					kmtotal = kmatual - kmanterio;
			    	kml = precototal / precocombustivel;
			    	JOptionPane.showMessageDialog(null, "> KM Total: " + kmtotal);
			    	JOptionPane.showMessageDialog(null, "> Km/L: " + kml);
					
					cmd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados Atualizados");
					cmd.close();
				}	
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}