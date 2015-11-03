package Cadastrar_Musicas_Discoteca;

import Cadastrar_Musicas_Discoteca.Genero;
import Cadastrar_Musicas_Discoteca.Artista;
import Cadastrar_Musicas_Discoteca.Album;
import Cadastrar_Musicas_Discoteca.Musica;
import java.sql.*;

public class Conexaobd {
     
	public void cadastrar(Genero g,Artista a,Album f,Musica m) throws Exception {
        PreparedStatement p = null;
        PreparedStatement insercao = conectar().prepareStatement("insert into genero (nome) values ('"+g.getNome()+"');",PreparedStatement.RETURN_GENERATED_KEYS);
        p.execute();
        ResultSet rs = p.getGeneratedKeys();  
        int id = 0;  
        if(rs.next()){  
            id = rs.getInt(1);  
        }      
        p = conectar().prepareStatement("insert into artista (nome,genero_id) values ('"+a.getNome()+"','"+id+"');");
        p.execute();    
        p = conectar().prepareStatement("insert into album (nome,ano,artista_id) values ('"+f.getNome()+"','"+f.getAno()+"','"+id+"');");
        p.execute();
        p = conectar().prepareStatement("insert into musica (nome,nota,duracao,album_id) values ('"+m.getNome()+"','"+m.getNota()+"','"+m.getDuracao()+"','"+id+"');");
        p.execute();
        p.close();
    }
	//Método para Conectar ao Banco de Dados Local chamado 'cadastro', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecamusical", "root", "");
			return(c);
		} catch (ClassNotFoundException e) {
			System.out.println("Problema na configuração do Driver do MySQL!");
		} catch (SQLException e) {
			System.out.println("Problema na conexão com o banco de dados!");
		}
		return(null);
	}
	
	//Retorna o relatório contendo todas as Pessoa do Banco
	public static ResultSet relatorio() {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery("SELECT * FROM genero;"));
		} catch (SQLException e) {
			System.out.println("Problema na consulta à tabela genero!");
		}
		return(null);
	}
	
	//Método para inserir no banco uma Pessoa passada como parâmetro
	public static int inserir(Genero g) {
		String insercao = "INSERT INTO `genero` (`nome`) VALUES ('"+g.getNome()+"');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da genero!, ou ja existe");
		}
		return(0);
	}
        public static int inserir(Musica m) {
		String insercao = "INSERT INTO `musica` (`nome`, `duracao`, `nota`) VALUES ('"+m.getNome()+"',"+m.getDuracao()+",'"+m.getNota()+"');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da pessoa!");
		}
		return(0);
	}
	public static int inserir(Artista a) {
		String insercao = ("insert into artista (nome,genero_id) values ('"+a.getNome()+"','+id+');");
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção do artista!, ou ja existe");
		}
		return(0);
	}
      
                public static int inserir(Album f) {
		String insercao = "INSERT INTO `album` (`nome`, ano ) VALUES ('"+f.getNome()+");";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção do album!");
		}
		return(0);
	}
	
	///Método para remover do banco uma Pessoa pelo 'telefone'
	public static int removerGenero(String g) {
		String remocao = "DELETE FROM `genero` WHERE `nome` = '"+g+"'";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(remocao));
		} catch (SQLException e) {
			System.out.println("Problema na remoção da genero!");
		}
		return(0);
	}
	
	
	//Método para Atualizar os campos no banco uma Pessoa passada como parâmetro, buscando-a pelo nome atual!!!
	
        public static int atualizar(Genero g,Artista a, String n) {
		String atualizacao = "UPDATE `genero` SET `nome` = '"+g.getNome()+"\"+a.getNome()+,' WHERE `nome` = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			System.out.println("Problema na atualização da genero!");
		}
		return(0);
	}	
        
}

