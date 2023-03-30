package br.com.fiap.namastreta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Contatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String redeSocial; // url da rede social

    // @OneToMany
    // private List <Obra> obras;

    public Contatos (){

    }

    public Contatos(String email, String senha, String redeSocial){
        this.email = email;
        this.senha = senha;
        this.redeSocial = redeSocial;
        //this.obras = obras;
    }
    
    

}
