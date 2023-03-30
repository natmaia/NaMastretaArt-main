package br.com.fiap.namastreta.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Obra extends DadosBase {
    //COMENTEI ESSE ID PARA VERIFICAR O ERRO DA ENUM
        // @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        // private long id;

    //private String tamanho;

    @ManyToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    private BigDecimal valor;

    protected Obra() {
    }

    public Obra(Long id, String foto, String nome, String descricao, Curador curador, Artista artista,
            BigDecimal valor) {
        super(id, foto, nome, descricao);
        //this.tamanho = tamanho;
        this.curador = curador;
        this.artista = artista;
        this.valor = valor;
    }

    // em caso de promoção!
    @Override
    public String toString() {
        return "Obra [valor=" + valor + ", descricao=" + super.getDescricao() + "]";
    }

    public int size() {
        return 0;
    }

}
