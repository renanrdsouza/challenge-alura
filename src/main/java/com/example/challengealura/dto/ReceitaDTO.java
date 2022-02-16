package com.example.challengealura.dto;

import com.example.challengealura.model.Receita;

import java.util.Date;

public class ReceitaDTO {

    private String descricao;
    private Double valor;
    private Date data;

    public ReceitaDTO(Receita receita) {
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
