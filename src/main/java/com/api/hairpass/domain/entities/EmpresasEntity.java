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
@Table(name = "empresas")
public class EmpresasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Long empresaId;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuariosEntity usuarioId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(unique = true, name = "cnpj")
    private String cnpj;
    @Column(unique = true, name = "cpf")
    private String cpf;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "foto_de_capa")
    private byte[] fotoDeCapa;
    @Column(name = "descricao")
    private String descricao;
    @Column(nullable = false, unique = true, name = "telefone")
    private String telefone;
    @Column(nullable = false, name = "endereco")
    private String endereco;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(nullable = false, name = "empresa_ativo")
    private boolean empresaAtivo;
}
