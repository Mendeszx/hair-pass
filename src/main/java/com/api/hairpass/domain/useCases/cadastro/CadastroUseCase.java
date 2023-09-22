package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import org.springframework.http.ResponseEntity;

public interface CadastroUseCase {
    ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest);
    ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest);
    ResponseEntity<CadastroEmpresasResponse> cadastrarNovaEmpresa(CadastroEmpresasRequest cadastroEmpresasRequest);
    ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest);
    ResponseEntity<CadastroFuncionarioEmpresaResponse> cadastrarNovoFuncionarioParaEmpresa(CadastroFuncionarioEmpresaRequest cadastroFuncionarioEmpresaRequest);
    ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest);
}
