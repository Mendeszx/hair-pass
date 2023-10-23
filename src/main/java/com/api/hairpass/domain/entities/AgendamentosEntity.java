package com.api.hairpass.domain.entities;

import com.api.hairpass.common.entities.CommonEntitiesColumns;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "agendamentos")
public class AgendamentosEntity extends CommonEntitiesColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Long agendamentoId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuariosEntity usuariosEntity;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
    private EmpresasEntity empresaId;

    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "servico_id")
    private ServicosEntity servicoId;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private FuncionariosEntity funcionarioId;

    @Column(nullable = false, name = "dia")
    private LocalDate dia;

    @Column(nullable = false, name = "inicio")
    private Time inicio;

    @Column(nullable = false, name = "fim")
    private Time fim;

    @Column(nullable = false, name = "cancelado")
    private boolean cancelado;
}
