package Cadastrar_Musicas_Discoteca;

public class Genero {
    private String nome;
    private int genero_id;

    public Genero(String nome, int genero_id) {
        this.nome = nome;
        this.genero_id = genero_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }

 
}
