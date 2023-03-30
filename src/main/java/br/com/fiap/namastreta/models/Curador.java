package br.com.fiap.namastreta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Curador extends DadosBase {
    //COMENTEI ESSE ID PARA VERIFICAR O ERRO DA ENUM
        // @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        // private long id;

    //@OneToOne
    @Enumerated(EnumType.STRING)
    //@PrimaryKeyJoinColumn(name = "categoria")
    private Categoria categoria;

    private String tempoAtuacao;

    @OneToOne
    private Contatos contatos;


	protected Curador(){

    }


    public Curador(Long id, String foto, String nome, String descricao, Categoria categoria, String tempoAtuacao) {
        super(id, foto, nome, descricao);
        this.categoria = categoria;
        this.tempoAtuacao = tempoAtuacao;
    }


    public int size() {
        return 0;
    }


    public void add(Curador curador) {
    }
   
}