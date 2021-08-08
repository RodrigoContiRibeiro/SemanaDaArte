package br.com.sa.service;

import br.com.sa.model.Pesquisa;

import java.util.List;

public interface PesquisaService {

    public List<Pesquisa> findAll();

    public boolean save(Pesquisa pesquisa);

    public Pesquisa findById(Long id);

    public boolean deleteBySlug(String slug);

    public Pesquisa findByImage(byte[] image);

    public Pesquisa findByTitleIgnoreCase(String title);

    public Pesquisa findBySlug(String slug);

    public List<Pesquisa> findAllBySlug(String slug);

    public String validarPesquisa(Pesquisa pesquisa, boolean isImageEmpty);

    public String gerarSlug(String title);
}
