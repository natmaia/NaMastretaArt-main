package br.com.fiap.namastreta.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Login {

    @Email
    private String email;
    //para não perder a internacionalização (message = "O email deve ser um endereço válido")

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[@%&._-]).+$", message = "A senha deve conter letras e pelo menos um dos seguintes caracteres especiais: @, %, &, . , _ ou -")
    private String senha;

    public  Login(){
        
    }

    public Login(String string, String string2) {
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}
