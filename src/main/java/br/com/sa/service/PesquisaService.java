package br.com.sa.service;

import br.com.sa.model.Pesquisa;

import java.util.List;

public interface PesquisaService {

    public List<Pesquisa> findAll();

    public boolean save(Pesquisa pesquisa);

    public Pesquisa findById(Long id);

    public Pesquisa findByImage(byte[] image);

    public boolean deleteById(Long id);

}
