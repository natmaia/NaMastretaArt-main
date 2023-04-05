package br.com.fiap.namastreta.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class DadosBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A foto é obrigatória")
    private String foto;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 5, max = 100)
    private String descricao;

    
    public DadosBase(String foto, String nome, String descricao) {
        //this.id = id;
        this.foto = foto;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    
    public DadosBase() {
    }

    

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
  

}
