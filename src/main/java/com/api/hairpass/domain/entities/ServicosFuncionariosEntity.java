package com.api.hairpass.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos_funcionarios")
public class ServicosFuncionariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_funcionario_id")
    private Long servicoFuncionarioId;
    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "servico_id")
    private ServicosEntity servicoId;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private FuncionariosEntity funcionarioId;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "servico_funcionario_ativo")
    private boolean servicoFuncionarioAtivo;
}
