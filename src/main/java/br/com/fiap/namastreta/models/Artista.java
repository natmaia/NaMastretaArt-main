package br.com.fiap.namastreta.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Artista extends DadosBase {
    //COMENTEI ESSE ID PARA VERIFICAR O ERRO DA ENUM
        // @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        // private Long id;

    
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany
    private List<Obra> obras;

    @OneToOne
    private Curador curador;

    public Artista() {
    }

    public Artista(long id, String foto, String nome, String descricao, Categoria categoria, List<Obra> obras, Curador curador) {
        super(id, foto, nome, descricao);
        this.categoria = categoria;
        this.obras = obras;
        this.curador = curador;

    }

}
