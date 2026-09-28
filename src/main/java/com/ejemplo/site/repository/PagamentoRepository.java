package com.exemplo.site.repository;

import com.exemplo.site.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para Pagamento
 * Responsável por operações de banco de dados relacionadas a pagamentos
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    /**
     * Busca pagamento pelo ID do Mercado Pago
     * @param mercadopagoId ID do Mercado Pago
     * @return Optional contendo o pagamento
     */
    Optional<Pagamento> findByMercadopagoId(String mercadopagoId);

    /**
     * Busca pagamentos por status
     * @param status status do pagamento
     * @return lista de pagamentos
     */
    List<Pagamento> findByStatus(String status);

    /**
     * Busca pagamentos por email
     * @param email email do pagador
     * @return lista de pagamentos
     */
    @Query("SELECT p FROM Pagamento p WHERE LOWER(p.email) = LOWER(:email) ORDER BY p.dataCriacao DESC")
    List<Pagamento> findByEmailIgnoreCase(@Param("email") String email);

    /**
     * Busca pagamento pela preferência ID do Mercado Pago
     * @param preferenciaId ID da preferência
     * @return Optional contendo o pagamento
     */
    Optional<Pagamento> findByPreferenciaId(String preferenciaId);
}
