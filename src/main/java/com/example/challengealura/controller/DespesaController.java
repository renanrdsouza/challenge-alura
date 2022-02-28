package com.example.challengealura.controller;

import com.example.challengealura.dto.DespesaDTO;
import com.example.challengealura.model.Despesa;
import com.example.challengealura.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> listAll() {
        return ResponseEntity.ok().body(despesaService.listAll());
    }

    @PostMapping
    public ResponseEntity<Despesa> save(@RequestBody Despesa despesa) {
        despesaService.save(despesa);

        return ResponseEntity.ok().body(despesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        despesaService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
        despesaService.update(id, despesa);

        return ResponseEntity.ok().body(despesa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDTO> detail(@PathVariable Long id) {
        DespesaDTO despesa = despesaService.detail(id);

        return ResponseEntity.ok().body(despesa);
    }
}
