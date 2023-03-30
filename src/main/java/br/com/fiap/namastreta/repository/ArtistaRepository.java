package br.com.fiap.namastreta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.namastreta.models.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{

}