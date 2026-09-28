package com.exemplo.site.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entidade Pessoa - Representa uma pessoa cadastrada no sistema
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@Entity
@Table(name = "pessoas", indexes = {
    @Index(name = "idx_nome", columnList = "nome"),
    @Index(name = "idx_data_criacao", columnList = "data_criacao")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 255)
    private String nome;

    @Min(value = 0, message = "Idade deve ser maior que 0")
    @Max(value = 150, message = "Idade deve ser menor que 150")
    @Column(nullable = false)
    private Integer idade;

    @Column(name = "data_criacao", nullable = false)
    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
