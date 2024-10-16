package com.parquimetro.api.controller;


import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.VeiculoDTO;
import com.parquimetro.api.service.VagaService;
import com.parquimetro.api.service.VeiculoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/veiculos")
@Tag(name = "veiculos", description = "Gerir veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final VagaService vagaService;

    public VeiculoController(VeiculoService veiculoService, VagaService vagaService) {
        this.veiculoService = veiculoService;
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<CreatedEntityIdDTO> cadastroEstacionar(@RequestBody VeiculoDTO veiculoDTO) {
        var idCadastrado = veiculoService.cadastrarVeiculo(veiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedEntityIdDTO(idCadastrado));
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = veiculoService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{idVeiculo}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable("idVeiculo") Long idVeiculo) {
        veiculoService.excluirVeiculo(idVeiculo);
        return ResponseEntity.noContent().build();
    }

}