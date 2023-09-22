package com.api.hairpass.adapters.controllers.dtos.request;

public class CadastroFuncionarioEmpresaRequest {

    private String funcionarioCpf;
    private String empresaId;

    public String getFuncionarioCpf() {
        return funcionarioCpf;
    }

    public void setFuncionarioCpf(String funcionarioCpf) {
        this.funcionarioCpf = funcionarioCpf;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }
}
