package com.exemplo.site.repository;

import com.exemplo.site.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para Plano
 * Responsável por operações de banco de dados relacionadas a planos
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    /**
     * Busca plano por nome
     * @param nome nome do plano
     * @return Optional contendo o plano
     */
    Optional<Plano> findByNome(String nome);

    /**
     * Busca todos os planos ativos
     * @return lista de planos ativos
     */
    @Query("SELECT p FROM Plano p WHERE p.ativo = true ORDER BY p.preco ASC")
    List<Plano> findPlanosAtivos();
}
