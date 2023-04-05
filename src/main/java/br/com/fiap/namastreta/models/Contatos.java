package br.com.fiap.namastreta.models;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Contatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Email
    private String email;
    //para não perder a internacionalização (message = "O email deve ser um endereço válido")

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[@%&._-]).+$", message = "A senha deve conter letras e pelo menos um dos seguintes caracteres especiais: @, %, &, . , _ ou -")
    private String senha;
    
    @URL(message = "A URL da rede social é inválida")
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
