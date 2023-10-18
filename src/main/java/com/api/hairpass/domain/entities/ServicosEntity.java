package com.api.hairpass.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class ServicosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private Long servicoId;
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", nullable = false)
    private EmpresasEntity empresaId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(nullable = false, name = "valor")
    private BigDecimal valor;
    @Column(nullable = false, name = "duracao")
    private Time duracao;
    @Column(name = "descricao")
    private String descricao;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "servico_ativo")
    private boolean servicoAtivo;
}
