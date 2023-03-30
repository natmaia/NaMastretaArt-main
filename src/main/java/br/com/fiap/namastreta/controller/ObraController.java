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

import br.com.fiap.namastreta.models.Obra;
import br.com.fiap.namastreta.repository.ObraRepository;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    // List<Obra> obras = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(ObraController.class);

    @Autowired
    ObraRepository repository;

    @GetMapping
    public List<Obra> listarObras() {
        return repository.findAll();
    }

    // C —- CREATE

    @PostMapping
    public ResponseEntity<Obra> cadastrarObra(@RequestBody Obra obra) {

        log.info("Cadastrando a obrinha: " + obra);

        repository.save(obra);

        // obra.setId(obra.size() + 1);
        // obras.add(obra);

        return ResponseEntity.status(HttpStatus.CREATED).body(obra);

    }

    // R —- READ
    @GetMapping("{id}")
    public ResponseEntity<Obra> retornaObraComId(@PathVariable Long id) {

        log.info("Buscando Obra por id: " + id);
        var obraEncontrada = repository.findById(id);

        if (obraEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(obraEncontrada.get());
    }

    // U — UPDATE

    @PutMapping("{id}")
    public ResponseEntity<Obra> update(@PathVariable Long id, @RequestBody Obra obra) {
        log.info("atualizando despesa com id " + id);
        var obraEncontrada = repository.findById(id);

        if (obraEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        obra.setId(id);
        repository.save(obra);

        return ResponseEntity.ok(obra);
    }

    // D — DELETE

    @DeleteMapping("{id}")
    public ResponseEntity<Obra> deletaObraComId(@PathVariable Long id) {

        log.info("apagando obra através do id " + id);
        var obraEncontrada = repository.findById(id);

        if (obraEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(obraEncontrada.get());

        return ResponseEntity.noContent().build();

    }

}

    // -----  Entender como faz a versão optional com spring boot JPA -----

    //Alterei tudo para variavel, até entender melhor a estrutura do optional

                        /*
                        * Optional<Obra> obraContainer = obras.stream().filter((Obra obra) ->
                        * obra.getId().equals(id))
                        * .findFirst();
                        * 
                        * if (obraContainer.isPresent()) {
                        * return ResponseEntity.ok(obraContainer.get());
                        * }
                        */
