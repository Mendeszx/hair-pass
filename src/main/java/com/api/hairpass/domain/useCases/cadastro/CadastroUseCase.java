package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroFuncionarioRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroServicoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CriarAgendamentoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CadastroUsuarioResponse;
import org.springframework.http.ResponseEntity;

public interface CadastroUseCase {
    ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest);
    ResponseEntity<Object> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest);
    ResponseEntity<Object> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest);
}
