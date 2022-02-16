package com.example.challengealura.service;

import com.example.challengealura.model.Receita;
import com.example.challengealura.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita cadastrar(Receita receita) {

        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }
}
