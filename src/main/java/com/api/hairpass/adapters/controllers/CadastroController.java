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
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(@RequestBody CadastroUsuariosRequest cadastroUsuariosRequest) {
        return cadastroUseCase.cadastrarNovoUsuario(cadastroUsuariosRequest);
    }

    @PostMapping("/servico")
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(@RequestBody CadastroServicosRequest cadastroServicosRequest) {
        return cadastroUseCase.cadastrarNovoServico(cadastroServicosRequest);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(@RequestBody CadastroFuncionariosRequest cadastroFuncionariosRequest) {
        return cadastroUseCase.cadastrarNovoFuncionario(cadastroFuncionariosRequest);
    }

    @PostMapping("/salao")
    public ResponseEntity<CadastroSalaoResponse> cadastrarNovoSalao(@RequestBody CadastroEmpresasRequest cadastroEmpresasRequest) {
        return cadastroUseCase.cadastrarNovoSalao(cadastroEmpresasRequest);
    }

    @PostMapping("/funcionario-salao")
    public ResponseEntity<CadastroFuncionarioSalaoResponse> cadastrarNovoFuncionarioParaSalao(@RequestBody CadastroFuncionarioSalaoRequest cadastroFuncionarioSalaoRequest) {
        return cadastroUseCase.cadastrarNovoFuncionarioParaSalao(cadastroFuncionarioSalaoRequest);
    }

    @PostMapping("/servico-funcionario")
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(@RequestBody CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoServicoParaFuncionario(cadastroServicoFuncionarioRequest);
    }
}
