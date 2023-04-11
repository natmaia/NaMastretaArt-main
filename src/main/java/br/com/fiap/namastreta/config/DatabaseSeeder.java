package br.com.fiap.namastreta.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.namastreta.models.Artista;
import br.com.fiap.namastreta.models.Categoria;
import br.com.fiap.namastreta.models.Curador;
import br.com.fiap.namastreta.repository.ArtistaRepository;
import br.com.fiap.namastreta.repository.CuradorRepository;

public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    CuradorRepository curadorRepository;

    @Override
    public void run(String... args) throws Exception {
        artistaRepository.saveAll(List.of(
            new Artista("url","Maia", "test",Categoria.ROMANTISMO, null, null),
            new Artista("url","Maia", "test",Categoria.RAIVOSO, null, null),
            new Artista("url","Maia", "test",Categoria.GOSTOSISSIMO, null, null)

        ));

        curadorRepository.saveAll(List.of(
            new Curador("url", "nome", "test 2", Categoria.FOFINHO, "2 anos"),
            new Curador("url", "nome", "test 3", Categoria.FOFINHO, "3 anos"),
            new Curador("url", "nome", "test 3", Categoria.FOFINHO, "4 anos")
            

        ));

    }

    



}
