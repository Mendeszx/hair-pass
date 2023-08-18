package com.api.hairpass.adapters.controllers.dtos.response;

import org.springframework.http.HttpStatus;

public class CadastroEmpresasResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String mensagem;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
