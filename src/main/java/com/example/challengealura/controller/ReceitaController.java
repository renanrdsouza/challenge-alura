package com.example.challengealura.controller;

import com.example.challengealura.dto.ReceitaDTO;
import com.example.challengealura.model.Receita;
import com.example.challengealura.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<ReceitaDTO> list() {
        return receitaService.listAll();
    }

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita receita) {
        receitaService.create(receita);

        return ResponseEntity.ok().body(receita);
    }
}
