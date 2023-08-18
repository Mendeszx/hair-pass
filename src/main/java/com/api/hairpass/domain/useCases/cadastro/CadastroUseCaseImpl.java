package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import com.api.hairpass.domain.entities.EmpresasEntity;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import com.api.hairpass.domain.entities.ServicosEntity;
import com.api.hairpass.domain.entities.UsuariosEntity;
import com.api.hairpass.domain.services.FuncionariosService;
import com.api.hairpass.domain.services.EmpresasService;
import com.api.hairpass.domain.services.ServicosService;
import com.api.hairpass.domain.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroUseCaseImpl implements CadastroUseCase {

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    FuncionariosService funcionariosService;

    @Autowired
    ServicosService servicosService;

    @Autowired
    EmpresasService empresasService;

    @Override
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        CadastroUsuarioResponse cadastroUsuarioResponse;

        try {
            usuariosService.cadastrarNovoUsuario(cadastroUsuarioRequest);
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroUsuarioResponse.getHttpStatusCode()).body(cadastroUsuarioResponse);
    }

    @Override
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        CadastroFuncionarioResponse cadastroFuncionarioResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(cadastroFuncionarioRequest.getUsuarioId());
            FuncionariosEntity funcionariosEntity = funcionariosService.cadastrarNovoFuncionario(usuariosEntity);
            usuariosService.atualizarUsuarioParaUsuarioFuncionario(funcionariosEntity);
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(201, HttpStatus.CREATED, "Funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroFuncionarioResponse.getHttpStatusCode()).body(cadastroFuncionarioResponse);
    }

    @Override
    public ResponseEntity<CadastroEmpresasResponse> cadastrarNovaEmpresa(CadastroEmpresasRequest cadastroEmpresasRequest) {
        CadastroEmpresasResponse cadastroEmpresasResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(cadastroEmpresasRequest.getUsuarioId());
            EmpresasEntity empresasEntity = empresasService.cadastrarNovaEmpresa(usuariosEntity, cadastroEmpresasRequest);
            usuariosService.atualizarUsuarioParaUsuarioEmpresa(empresasEntity);
            cadastroEmpresasResponse = criarCadastroSalaoResponse(201, HttpStatus.CREATED, "Salão cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroEmpresasResponse = criarCadastroSalaoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroEmpresasResponse.getHttpStatusCode()).body(cadastroEmpresasResponse);
    }

    @Override
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest) {
        CadastroServicoResponse cadastroServicoResponse;

        try {
            EmpresasEntity empresasEntity = empresasService.findEmpresaById(cadastroServicoRequest.getEmpresaId());
            servicosService.criarNovoServicoParaEmpresa(cadastroServicoRequest, empresasEntity);
            cadastroServicoResponse = criarCadastroServicoResponse(201, HttpStatus.CREATED, "Serviço cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroServicoResponse = criarCadastroServicoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroServicoResponse.getHttpStatusCode()).body(cadastroServicoResponse);
    }

    @Override
    public ResponseEntity<CadastroFuncionarioSalaoResponse> cadastrarNovoFuncionarioParaSalao(CadastroFuncionarioSalaoRequest cadastroFuncionarioSalaoRequest) {
        return null;
    }

    @Override
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        return null;
    }

    private CadastroUsuarioResponse criarCadastroUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroUsuarioResponse cadastroUsuarioResponse = new CadastroUsuarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }

    private CadastroFuncionarioResponse criarCadastroFuncionarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroFuncionarioResponse cadastroUsuarioResponse = new CadastroFuncionarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }

    private CadastroServicoResponse criarCadastroServicoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroServicoResponse cadastroServicoResponse = new CadastroServicoResponse();

        cadastroServicoResponse.setHttpStatusCode(httpStatusCode);
        cadastroServicoResponse.setHttpStatus(httpStatus);
        cadastroServicoResponse.setMensagem(mensagem);

        return cadastroServicoResponse;
    }

    private CadastroEmpresasResponse criarCadastroSalaoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroEmpresasResponse cadastroEmpresasResponse = new CadastroEmpresasResponse();

        cadastroEmpresasResponse.setHttpStatusCode(httpStatusCode);
        cadastroEmpresasResponse.setHttpStatus(httpStatus);
        cadastroEmpresasResponse.setMensagem(mensagem);

        return cadastroEmpresasResponse;
    }
}
