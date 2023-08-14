package com.api.hairpass.domain.useCases.cadastro;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroFuncionarioRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroServicoRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.controllers.dtos.response.CadastroUsuarioResponse;
import com.api.hairpass.domain.entities.FuncionarioEntity;
import com.api.hairpass.domain.entities.ServicoEntity;
import com.api.hairpass.domain.services.FuncionarioService;
import com.api.hairpass.domain.services.ServicoService;
import com.api.hairpass.domain.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CadastroUseCaseImpl implements CadastroUseCase {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ServicoService servicoService;

    @Override
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        CadastroUsuarioResponse cadastroUsuarioResponse;

        try {
            usuarioService.save(cadastroUsuarioRequest);
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroUsuarioResponse.getHttpStatusCode()).body(cadastroUsuarioResponse);
    }

    @Override
    public ResponseEntity<Object> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest) {
        var servicoModel = new ServicoEntity();
        BeanUtils.copyProperties(cadastroServicoRequest, servicoModel);
        servicoService.save(servicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Serviço cadastrado");
    }

    @Override
    public ResponseEntity<Object> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        var funcionarioModel = new FuncionarioEntity();
        BeanUtils.copyProperties(cadastroFuncionarioRequest, funcionarioModel);
        funcionarioService.save(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario cadastrado");
    }

    //TODO: Poderia estar em um utils
    public LocalDate trasformDateOfBirth(String dateOfBirh) {
        int day = Integer.parseInt(dateOfBirh.substring(0, 2));
        int month = Integer.parseInt(dateOfBirh.substring(2, 4));
        int year = Integer.parseInt(dateOfBirh.substring(4, 8));
        return LocalDate.of(year, month, day);
    }

    private CadastroUsuarioResponse criarCadastroUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroUsuarioResponse cadastroUsuarioResponse = new CadastroUsuarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }
}
