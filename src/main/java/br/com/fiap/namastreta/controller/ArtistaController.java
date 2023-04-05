package br.com.fiap.namastreta.controller;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.namastreta.exception.RestNotFoundException;
import br.com.fiap.namastreta.models.Artista;
import br.com.fiap.namastreta.repository.ArtistaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/artista")
public class ArtistaController {

    // List<Artista> artistas = new ArrayList<Artista>();
    Logger log = LoggerFactory.getLogger(ArtistaController.class);

    @Autowired
    ArtistaRepository repository;

    @GetMapping
    public List<Artista> listarArtistas() {
        return repository.findAll();
    }

    // C - Create
    @PostMapping
    public ResponseEntity<Artista> cadastrar(@RequestBody @Valid Artista artista) {
        log.info("Cadastrando novo artista: " + artista);
        repository.save(artista);

        return ResponseEntity.status(HttpStatus.CREATED).body(artista);

    }

    // R - read

    // Get id
    @GetMapping("{id}")
    public ResponseEntity<Artista> show(@PathVariable Long id) {
        log.info("buscando artista com id " + id);
        var artistaEncontrado = getArtista(id);

        // if (artistaEncontrado.isEmpty())
        //     return ResponseEntity.notFound().build();

        return ResponseEntity.ok(artistaEncontrado);
    }

    // U - update
    @PutMapping("{id}")
    public ResponseEntity<Artista> updateById(@PathVariable Long id, @RequestBody Artista art) {
        log.info("atualizando despesa com id " + id);

        var artistaEncontrado =getArtista(id);

        // if (artistaEncontrado.isEmpty())
        //     return ResponseEntity.notFound().build();

        art.setId(artistaEncontrado.getId());
        repository.save(art);

        return ResponseEntity.ok(art);
    }

    // D -delete
    @DeleteMapping("{id}")
    public ResponseEntity<Artista> deletaComId(@PathVariable Long id) {
        log.info("Apagando artista com id: " + id);

        var artistaEncontrado = repository.findById(id);

        // if (artistaEncontrado.isEmpty())
        //     return ResponseEntity.notFound().build();

        repository.delete(artistaEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(getArtista(id));

    }

    private Artista getArtista(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Artista não encontrado"));
    }

}
