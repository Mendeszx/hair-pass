package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.*;
import com.api.hairpass.adapters.controllers.dtos.response.*;
import com.api.hairpass.domain.entities.FuncionariosEntity;
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
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuariosRequest cadastroUsuariosRequest) {
        CadastroUsuarioResponse cadastroUsuarioResponse;

        try {
            usuariosService.cadastrarNovoUsuario(cadastroUsuariosRequest);
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroUsuarioResponse.getHttpStatusCode()).body(cadastroUsuarioResponse);
    }

    @Override
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicosRequest cadastroServicosRequest) {
        CadastroServicoResponse cadastroServicoResponse;

        try {
            servicosService.save(cadastroServicosRequest);
            cadastroServicoResponse = criarCadastroServicoResponse(201, HttpStatus.CREATED, "Serviço cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroServicoResponse = criarCadastroServicoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroServicoResponse.getHttpStatusCode()).body(cadastroServicoResponse);
    }

    @Override
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionariosRequest cadastroFuncionariosRequest) {
        CadastroFuncionarioResponse cadastroFuncionarioResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(cadastroFuncionariosRequest.getUsuarioId());
            FuncionariosEntity funcionariosEntity = funcionariosService.cadastrarNovoFuncionario(usuariosEntity);
            usuariosService.atualizarUsuarioParaUsuarioFuncionario(funcionariosEntity);
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(201, HttpStatus.CREATED, "Funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroFuncionarioResponse.getHttpStatusCode()).body(cadastroFuncionarioResponse);
    }

    @Override
    public ResponseEntity<CadastroSalaoResponse> cadastrarNovoSalao(CadastroEmpresasRequest cadastroEmpresasRequest) {
        CadastroSalaoResponse cadastroSalaoResponse;

        try {
            empresasService.save(cadastroEmpresasRequest);
            cadastroSalaoResponse = criarCadastroSalaoResponse(201, HttpStatus.CREATED, "Salão cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroSalaoResponse = criarCadastroSalaoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroSalaoResponse.getHttpStatusCode()).body(cadastroSalaoResponse);
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

    private CadastroSalaoResponse criarCadastroSalaoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroSalaoResponse cadastroSalaoResponse = new CadastroSalaoResponse();

        cadastroSalaoResponse.setHttpStatusCode(httpStatusCode);
        cadastroSalaoResponse.setHttpStatus(httpStatus);
        cadastroSalaoResponse.setMensagem(mensagem);

        return cadastroSalaoResponse;
    }
}
