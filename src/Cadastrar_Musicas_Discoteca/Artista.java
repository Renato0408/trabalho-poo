
package Cadastrar_Musicas_Discoteca;

public class Artista {
    private String nome;
    private int id;

    public Artista(String nome, int genero_id) {
        this.nome = nome;
        this.id = genero_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGenero_id() {
        return id;
    }

    public void setGenero_id(int genero_id) {
        this.id = genero_id;
    }
    

    


}
