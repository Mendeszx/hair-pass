package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import org.springframework.http.ResponseEntity;

public interface CadastroUseCase {
    ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuariosRequest cadastroUsuariosRequest);
    ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicosRequest cadastroServicosRequest);
    ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionariosRequest cadastroFuncionariosRequest);
    ResponseEntity<CadastroSalaoResponse> cadastrarNovoSalao(CadastroEmpresasRequest cadastroEmpresasRequest);
    ResponseEntity<CadastroFuncionarioSalaoResponse> cadastrarNovoFuncionarioParaSalao(CadastroFuncionarioSalaoRequest cadastroFuncionarioSalaoRequest);
    ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest);
}
