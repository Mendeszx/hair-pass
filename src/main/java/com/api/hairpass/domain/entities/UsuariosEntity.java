package com.api.hairpass.domain.entities;

import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.common.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuariosEntity implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(name = "foto")
    private byte[] foto;
    @Column(nullable = false, unique = true, name = "cpf")
    private String cpf;
    @Column(nullable = false, unique = true, name = "numero_celular")
    private String numeroCelular;
    @Column(nullable = false, name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "sexo")
    private SexoEnum sexo;
    @Column(nullable = false, name = "endereco")
    private String endereco;
    @Column(nullable = false, unique = true, name = "email")
    private String email;
    @Column(nullable = false, name = "senha")
    private String senha;
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", unique = true)
    private EmpresasEntity empresaId;
    @Column(name = "empresa_ativo")
    private boolean empresaAtivo;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id", unique = true)
    private FuncionariosEntity funcionarioId;
    @Column(name = "funcionario_ativo")
    private boolean funcionarioAtivo;
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role")
    private RoleEnum role;
    @Column(nullable = false, name = "usuario_ativo")
    private boolean usuarioAtivo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
