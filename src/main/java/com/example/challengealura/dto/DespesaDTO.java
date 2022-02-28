package com.example.challengealura.dto;

import com.example.challengealura.model.Despesa;

import java.util.Date;

public class DespesaDTO {

    private String descricao;
    private Double valor;
    private Date data;

    public DespesaDTO(Despesa despesa) {
        this.descricao = despesa.getDescricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
