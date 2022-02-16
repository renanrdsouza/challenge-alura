package com.example.challengealura.controller;

import com.example.challengealura.model.Receita;
import com.example.challengealura.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> cadastrar(@RequestBody Receita receita) {
        receitaService.cadastrar(receita);

        return ResponseEntity.ok().body(receita);
    }
}
