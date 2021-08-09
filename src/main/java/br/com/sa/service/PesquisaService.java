package br.com.sa.service;

import br.com.sa.model.Pesquisa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PesquisaService {

    public List<Pesquisa> findAll();

    public boolean save(Pesquisa pesquisa);

    public Pesquisa findById(Long id);

    public boolean deleteById(Long id);

    public Pesquisa findByTitleIgnoreCase(String title);

    public Pesquisa findBySlug(String slug);

    public String validarPesquisa(Pesquisa pesquisa, boolean isImageEmpty);

    public String gerarSlug(String title);
}
