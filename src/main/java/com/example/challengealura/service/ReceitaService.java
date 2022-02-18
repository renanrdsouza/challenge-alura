package com.example.challengealura.service;

import com.example.challengealura.dto.ReceitaDTO;
import com.example.challengealura.model.Receita;
import com.example.challengealura.repository.ReceitaRepository;
import com.example.challengealura.service.exceptions.IncomeAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public ResponseEntity<Receita> create(Receita receita) {
        List<Receita> cadastradas = receitaRepository.findAll();
        boolean jaCadastrada = cadastradas.stream()
                .anyMatch(receita::equals);
        if(jaCadastrada) {
            throw new IncomeAlreadyRegisteredException("Receita já cadastrada");
        }

        receitaRepository.save(receita);

        return ResponseEntity.ok().body(receita);
    }

    public List<ReceitaDTO> listAll() {
        List<Receita> receitas = receitaRepository.findAll();

        return receitas
                .stream()
                .map(receita -> new ReceitaDTO(receita))
                .collect(Collectors.toList());
    }
}
