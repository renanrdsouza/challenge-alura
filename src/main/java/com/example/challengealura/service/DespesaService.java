package com.example.challengealura.service;

import com.example.challengealura.dto.DespesaDTO;
import com.example.challengealura.model.Despesa;
import com.example.challengealura.repository.DespesaRepository;
import com.example.challengealura.service.exceptions.ExpenseAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;


    public List<DespesaDTO> listAll() {
        List<Despesa> despesas = despesaRepository.findAll();

        return despesas.stream()
                .map(DespesaDTO::new)
                .collect(Collectors.toList());
    }

    public Despesa save(Despesa despesa) {
        List<Despesa> despesas = despesaRepository.findAll();

        boolean jaCadastrada = despesas.stream()
                .anyMatch(despesa::equals);

        if(jaCadastrada) {
            throw new ExpenseAlreadyRegisteredException("Despesa já cadastrada.");
        }

        return despesaRepository.save(despesa);
    }

    public void delete(Long id) {
        Despesa despesa = despesaRepository.getById(id);

        if(despesa == null) {
            throw new NoSuchElementException("Não encontrado.");
        }

        despesaRepository.deleteById(id);
    }

    public Despesa update(Long id, Despesa despesaAtualizada) {
        Despesa despesa = despesaRepository.getById(id);

        if(despesa == null) {
            throw new NoSuchElementException("Não encontrado.");
        }

        despesa.setDescricao(despesaAtualizada.getDescricao());
        despesa.setValor(despesaAtualizada.getValor());
        return despesaRepository.save(despesa);
    }

    public DespesaDTO detail(Long id) {
        Despesa despesa = despesaRepository.getById(id);

        if(despesa == null) {
            throw new NoSuchElementException("Não encontrado.");
        }

        return new DespesaDTO(despesa);
    }
}
