package com.api.hairpass.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class AgendamentosEntity {

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
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "cancelado")
    private boolean cancelado;

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public UsuariosEntity getUsuariosEntity() {
        return usuariosEntity;
    }

    public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
        this.usuariosEntity = usuariosEntity;
    }

    public EmpresasEntity getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(EmpresasEntity empresaId) {
        this.empresaId = empresaId;
    }

    public ServicosEntity getServicoId() {
        return servicoId;
    }

    public void setServicoId(ServicosEntity servicoId) {
        this.servicoId = servicoId;
    }

    public FuncionariosEntity getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(FuncionariosEntity funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Time getInicio() {
        return inicio;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public Time getFim() {
        return fim;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
