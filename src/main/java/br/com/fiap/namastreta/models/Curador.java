package br.com.fiap.namastreta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
//@NoArgsConstructor
@Entity
public class Curador extends DadosBase {
   
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Positive(message = "O tempo de atuação deve ser maior que zero")
    private String tempoAtuacao;

    @OneToOne
    private Contatos contatos;


	protected Curador(){

    }


    public Curador(String foto, String nome, String descricao, Categoria categoria, String tempoAtuacao) {
        super(foto, nome, descricao);
        this.categoria = categoria;
        this.tempoAtuacao = tempoAtuacao;
        setId(getId() + 1);
    }


    public int size() {
        return 0;
    }


    public void add(Curador curador) {
    }
   
}