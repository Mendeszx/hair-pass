package com.api.hairpass.adapters.controllers;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroFuncionarioRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroServicoRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CadastroUsuarioResponse;
import com.api.hairpass.domain.useCases.cadastro.CadastroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroUseCase cadastroUseCase;

    @PostMapping("/cadastro-usuario")
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(@RequestBody CadastroUsuarioRequest cadastroUsuarioRequest) {
        return cadastroUseCase.cadastrarNovoUsuario(cadastroUsuarioRequest);
    }

    @PostMapping("/cadastro-servico")
    public ResponseEntity<Object> cadastrarNovoServico(@RequestBody CadastroServicoRequest cadastroServicoRequest) {
        return cadastroUseCase.cadastrarNovoServico(cadastroServicoRequest);
    }

    @PostMapping("/cadastro-funcionario")
    public ResponseEntity<Object> cadastrarNovoFuncionario(@RequestBody CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoFuncionario(cadastroFuncionarioRequest);
    }
}
