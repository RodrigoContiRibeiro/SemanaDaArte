package br.com.sa.repository;

import br.com.sa.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    public Pesquisa deleteBySlug(String slug);
    public Pesquisa findByImage(byte[] image);
    public Pesquisa findByTitleIgnoreCase(String title);
    public Pesquisa findBySlug(String slug);
    public List<Pesquisa> findAllBySlug(String slug);
}
