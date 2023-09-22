package com.api.hairpass.adapters.controllers;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import com.api.hairpass.domain.useCases.cadastro.CadastroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroUseCase cadastroUseCase;

    @PostMapping("/usuario")
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(@RequestBody CadastroUsuarioRequest cadastroUsuarioRequest) {
        return cadastroUseCase.cadastrarNovoUsuario(cadastroUsuarioRequest);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(@RequestBody CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoFuncionario(cadastroFuncionarioRequest);
    }

    @PostMapping("/empresa")
    public ResponseEntity<CadastroEmpresasResponse> cadastrarNovaEmpresa(@RequestBody CadastroEmpresasRequest cadastroEmpresasRequest) {
        return cadastroUseCase.cadastrarNovaEmpresa(cadastroEmpresasRequest);
    }

    @PostMapping("/servico")
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(@RequestBody CadastroServicoRequest cadastroServicoRequest) {
        return cadastroUseCase.cadastrarNovoServico(cadastroServicoRequest);
    }

    @PostMapping("/funcionario-empresa")
    public ResponseEntity<CadastroFuncionarioEmpresaResponse> cadastrarNovoFuncionarioParaSalao(@RequestBody CadastroFuncionarioEmpresaRequest cadastroFuncionarioEmpresaRequest) {
        return cadastroUseCase.cadastrarNovoFuncionarioParaEmpresa(cadastroFuncionarioEmpresaRequest);
    }

    @PostMapping("/servico-funcionario")
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(@RequestBody CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoServicoParaFuncionario(cadastroServicoFuncionarioRequest);
    }
}
