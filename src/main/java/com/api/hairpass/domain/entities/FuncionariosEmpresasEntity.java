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
@Table(name = "funcionarios_empresas")
public class FuncionariosEmpresasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarios_empresas_id")
    private Long funcionariosEmpresasId;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private FuncionariosEntity funcionarioId;
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
    private EmpresasEntity empresaId;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "funcionario_empresa_ativo")
    private boolean funcionarioEmpresaAtivo;
}
