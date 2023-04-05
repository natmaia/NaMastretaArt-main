package br.com.fiap.namastreta.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Obra extends DadosBase {
 

    @ManyToOne
    @JoinColumn(name = "curador_id")
    private Curador curador;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
    
    @Min(value = 0, message = "deve ser positivo") 
    @NotNull
    private BigDecimal valor;

    protected Obra() {
    }

    public Obra(String foto, String nome, String descricao, Curador curador, Artista artista,
            BigDecimal valor) {
        super(foto, nome, descricao);
        //this.tamanho = tamanho;
        this.curador = curador;
        this.artista = artista;
        this.valor = valor;
        setId(getId() + 1);
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
