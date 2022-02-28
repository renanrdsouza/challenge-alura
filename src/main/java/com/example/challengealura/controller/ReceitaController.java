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
    public ResponseEntity<List<ReceitaDTO>> list() {
        return ResponseEntity.ok().body(receitaService.listAll());
    }

    @PostMapping
    public ResponseEntity<Receita> save(@RequestBody Receita receita) {
        receitaService.save(receita);

        return ResponseEntity.ok().body(receita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        receitaService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> update(@PathVariable Long id, @RequestBody Receita receita) {
        receitaService.update(id, receita);

        return ResponseEntity.ok().body(receita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> detail(@PathVariable Long id) {
        ReceitaDTO receita = receitaService.detail(id);

        return ResponseEntity.ok().body(receita);
    }
}