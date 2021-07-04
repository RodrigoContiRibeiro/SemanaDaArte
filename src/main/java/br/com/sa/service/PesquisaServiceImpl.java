package br.com.sa.service;

import br.com.sa.model.Pesquisa;
import br.com.sa.repository.PesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PesquisaServiceImpl implements PesquisaService {

    @Autowired
    PesquisaRepository pesquisaRepo;

    @Override
    public boolean save(Pesquisa pesquisa) {
        try {
            if (pesquisa != null) {
                pesquisaRepo.save(pesquisa);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Pesquisa findById(Long id) {
        return pesquisaRepo.findById(id).orElse(new Pesquisa());
    }
}
