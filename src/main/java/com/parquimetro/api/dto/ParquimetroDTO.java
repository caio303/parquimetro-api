package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Parquimetro;

public record ParquimetroDTO(
        Long id,
        Float tarifaAtual,
        String endereco
) {

    public ParquimetroDTO(Parquimetro parquimetro) {
        this(parquimetro.getId(), parquimetro.getValorTarifaAtual(), parquimetro.getEndereco());
    }
}