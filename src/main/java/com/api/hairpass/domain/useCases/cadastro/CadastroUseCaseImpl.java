package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import com.api.hairpass.domain.entities.*;
import com.api.hairpass.domain.services.*;
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
    @Autowired
    FuncionariosEmpresasService funcionariosEmpresasService;
    @Autowired
    ServicosFuncionariosService servicosFuncionariosService;

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
    public ResponseEntity<CadastroFuncionarioEmpresaResponse> cadastrarNovoFuncionarioParaEmpresa(CadastroFuncionarioEmpresaRequest cadastroFuncionarioEmpresaRequest) {
        CadastroFuncionarioEmpresaResponse cadastroFuncionarioEmpresaResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosByCpf(cadastroFuncionarioEmpresaRequest.getFuncionarioCpf());
            FuncionariosEntity funcionariosEntity = funcionariosService.findFuncionariosByUsuarioId(usuariosEntity);
            EmpresasEntity empresasEntity = empresasService.findEmpresaById(cadastroFuncionarioEmpresaRequest.getEmpresaId());
            funcionariosEmpresasService.cadastratNovoFuncionarioNaEmpresa(funcionariosEntity, empresasEntity);
            cadastroFuncionarioEmpresaResponse = criarCadastroFuncionarioSalaoResponse(201, HttpStatus.CREATED, "Funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroFuncionarioEmpresaResponse = criarCadastroFuncionarioSalaoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroFuncionarioEmpresaResponse.getHttpStatusCode()).body(cadastroFuncionarioEmpresaResponse);
    }

    @Override
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        CadastroServicoFuncionarioResponse cadastroServicoFuncionarioResponse;

        try {
            FuncionariosEntity funcionariosEntity = funcionariosService.findFuncionariosById(cadastroServicoFuncionarioRequest.getFuncionarioId());
            ServicosEntity servicosEntity = servicosService.findServicosById(cadastroServicoFuncionarioRequest.getServicoId());
            ServicosFuncionariosEntity servicosFuncionariosEntity = servicosFuncionariosService.cadastratNovoServicoParaFuncionario(funcionariosEntity, servicosEntity);
            cadastroServicoFuncionarioResponse = criarCadastroServicoFuncionarioResponse(201, HttpStatus.CREATED, "Serviço para funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroServicoFuncionarioResponse = criarCadastroServicoFuncionarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroServicoFuncionarioResponse.getHttpStatusCode()).body(cadastroServicoFuncionarioResponse);
    }

    private CadastroServicoFuncionarioResponse criarCadastroServicoFuncionarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroServicoFuncionarioResponse cadastroServicoFuncionarioResponse = new CadastroServicoFuncionarioResponse();

        cadastroServicoFuncionarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroServicoFuncionarioResponse.setHttpStatus(httpStatus);
        cadastroServicoFuncionarioResponse.setMensagem(mensagem);

        return cadastroServicoFuncionarioResponse;
    }

    private CadastroFuncionarioEmpresaResponse criarCadastroFuncionarioSalaoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroFuncionarioEmpresaResponse cadastroFuncionarioEmpresaResponse = new CadastroFuncionarioEmpresaResponse();

        cadastroFuncionarioEmpresaResponse.setHttpStatusCode(httpStatusCode);
        cadastroFuncionarioEmpresaResponse.setHttpStatus(httpStatus);
        cadastroFuncionarioEmpresaResponse.setMensagem(mensagem);

        return cadastroFuncionarioEmpresaResponse;
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
