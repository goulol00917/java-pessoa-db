package com.exemplo.site.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidade Pagamento - Representa um pagamento realizado via Mercado Pago
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Entity
@Table(name = "pagamentos", indexes = {
    @Index(name = "idx_mercadopago_id", columnList = "mercadopago_id", unique = true),
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_data_criacao", columnList = "data_criacao")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ID Mercado Pago é obrigatório")
    @Column(nullable = false, unique = true, length = 50)
    private String mercadopagoId;

    @Min(value = 0, message = "Valor deve ser maior que 0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, length = 50)
    @Builder.Default
    private String status = "PENDENTE"; // PENDENTE, APROVADO, RECUSADO, CANCELADO

    @Column(length = 255)
    private String email;

    @Column(name = "preferencia_id", unique = true, length = 50)
    private String preferenciaId;

    @Column(name = "init_point")
    private String initPoint; // URL do Mercado Pago

    @Column(name = "data_criacao", nullable = false)
    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_aprovacao")
    private LocalDateTime dataAprovacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
