package com.api.hairpass.adapters.controllers.dtos.request;

import org.springframework.stereotype.Component;

@Component
public class CadastroServicoRequest {

    private String nomeServico;

    private String descricaoServico;

    private String precoServico;

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(String precoServico) {
        this.precoServico = precoServico;
    }
}
