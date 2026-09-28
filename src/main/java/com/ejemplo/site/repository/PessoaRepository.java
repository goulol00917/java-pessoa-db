package com.exemplo.site.repository;

import com.exemplo.site.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para Pessoa
 * Responsável por operações de banco de dados relacionadas a pessoas
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    /**
     * Busca pessoas por nome (case-insensitive)
     * @param nome nome da pessoa
     * @return lista de pessoas
     */
    @Query("SELECT p FROM Pessoa p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Pessoa> findByNomeContainingIgnoreCase(@Param("nome") String nome);

    /**
     * Busca pessoas maiores de idade
     * @return lista de pessoas com idade >= 18
     */
    @Query("SELECT p FROM Pessoa p WHERE p.idade >= 18 ORDER BY p.dataCriacao DESC")
    List<Pessoa> findMaioresDeIdade();

    /**
     * Conta total de pessoas
     * @return quantidade de pessoas
     */
    @Query("SELECT COUNT(p) FROM Pessoa p")
    long countTotalPessoas();
}
