package com.exemplo.site.repository;

import com.exemplo.site.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para Usuario
 * Responsável por operações de banco de dados relacionadas a usuários
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca usuário por username
     * @param username nome de usuário
     * @return Optional contendo o usuário
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Busca usuário por email
     * @param email email do usuário
     * @return Optional contendo o usuário
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Verifica se um username já existe
     * @param username nome de usuário
     * @return true se existe, false caso contrário
     */
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);

    /**
     * Verifica se um email já existe
     * @param email email do usuário
     * @return true se existe, false caso contrário
     */
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
