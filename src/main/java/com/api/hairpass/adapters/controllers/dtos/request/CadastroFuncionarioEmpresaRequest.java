package com.api.hairpass.adapters.controllers.dtos.request;

public class CadastroFuncionarioEmpresaRequest {

    private String usuarioId;
    private String empresaId;

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }
}
