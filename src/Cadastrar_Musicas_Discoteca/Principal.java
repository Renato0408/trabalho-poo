package Cadastrar_Musicas_Discoteca;

import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) { 
           
		//==============================
		//Exemplo de inserção de 1 Genero SGBD
		//==============================
//             JOptionPane.showInputDialog("genero :"); 
        
		Genero r = new Genero ("Rock",3);
		if(Conexaobd.inserir(r)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
                        
		}
                
                Genero s = new Genero ("Sertanejo",8);
		if(Conexaobd.inserir(s)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
		
                Genero re = new Genero ("Reggae",9);
		if(Conexaobd.inserir(re)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
                
		//==============================
		//Exemplo de inserção de outro Genero no SGBD
		//==============================
		 
                 Artista o= new Artista("Link Park",9);
		if(Conexaobd.inserir(o)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
                
                Musica m = new Musica ("amor",12,12);
		if(Conexaobd.inserir(m)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
                
                
                
                Album f = new Album("Closse",1987);
		if(Conexaobd.inserir(f)!=0) {
			System.out.println("Album  inserido com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
		
		//==============================
		//Exemplo de inserção de outra Pessoa no SGBD
		//==============================
		/*Pessoa z = new Pessoa("Fulano Açucena", "5678-1234", 27);
		if(Conexao.inserir(z)!=0) {
			System.out.println("Pessoa inserida com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
		*/
		
		//==============================
		//Exemplo de remoção de Pessoa pelo Telefone
		//==============================
		/*String tel = "1234-5678";
		if(Conexao.removerPeloTelefone(tel)!=0) {
			System.out.println("Pessoa removida com sucesso do banco!");
		} else {
			System.out.println("Erro na inserção!");
		}

		*/
		//==============================
		//Exemplo de atualização da Pessoa no SGBD, buscando-a pelo nome atual!!!
		//==============================
		/*z.setIdade(65);
		String nomeAtual = z.getNome();
		z.setNome("Fulano Açucena Mais Velho");
		if(Conexao.atualizar(z, nomeAtual)!=0) {
			System.out.println("Pessoa atualizada com sucesso no banco!");
		} else {
			System.out.println("Erro na atualização!");
		}
		*/
		
		//==============================
		//Exemplo de listagem de todas Pessoas do SGBD
		//==============================
		ResultSet res = Conexaobd.relatorio();
		if(res!=null) {
			try {
				while(res.next()) {
					System.out.println("Nome: "+res.getString("nome"));
//					System.out.println("genero: "+res.getInt("genero"));
					//System.out.println("Telefone: "+res.getString("telefone"));
					//System.out.println("==========");
				}
			} catch (SQLException e) {
				System.out.println("Problema para exibir registros!");
			}
		} else {
			System.out.println("A pesquisa não retornou nenhum registro!");
		}

	}
               
}

