package com.example.challengealura.service;

import com.example.challengealura.dto.ReceitaDTO;
import com.example.challengealura.model.Receita;
import com.example.challengealura.repository.ReceitaRepository;
import com.example.challengealura.service.exceptions.IncomeAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita save(Receita receita) {
        List<Receita> cadastradas = receitaRepository.findAll();

        boolean jaCadastrada = cadastradas.stream()
                .anyMatch(receita::equals);

        if(jaCadastrada) {
            throw new IncomeAlreadyRegisteredException("Receita já cadastrada");
        }

        return receitaRepository.save(receita);
    }

    public List<ReceitaDTO> listAll() {
        List<Receita> receitas = receitaRepository.findAll();

        return receitas
                .stream()
                .map(ReceitaDTO::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Receita receita = receitaRepository.getById(id);

        if(receita == null) {
            throw new NoSuchElementException("Não encontrado.");
        }

        receitaRepository.deleteById(id);
    }

    public Receita update(Long id, Receita receitaAtualizada) {
        Receita receita = receitaRepository.getById(id);

        if(receita == null) {
            throw new NoSuchElementException("Não encontrado.");
        }

        receita.setDescricao(receitaAtualizada.getDescricao());
        receita.setValor(receitaAtualizada.getValor());
        return receitaRepository.save(receita);
    }

    public ReceitaDTO detail(Long id) {
        Receita receita = receitaRepository.getById(id);

        if(receita == null) {
            throw new NoSuchElementException("Não encontrado");
        }

        return new ReceitaDTO(receita);
    }
}
