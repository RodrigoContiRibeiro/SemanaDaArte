package br.com.sa.service;

import br.com.sa.model.Pesquisa;

public interface PesquisaService {

    public boolean save(Pesquisa pesquisa);

    public Pesquisa findById(Long id);
}
