package com.api.hairpass.adapters.controllers.dtos.request;

public class CadastroFuncionarioSalaoRequest {

    private String funcionarioCPF;
    private String salaoId;

    public String getFuncionarioCPF() {
        return funcionarioCPF;
    }

    public void setFuncionarioCPF(String funcionarioCPF) {
        this.funcionarioCPF = funcionarioCPF;
    }

    public String getSalaoId() {
        return salaoId;
    }

    public void setSalaoId(String salaoId) {
        this.salaoId = salaoId;
    }
}
