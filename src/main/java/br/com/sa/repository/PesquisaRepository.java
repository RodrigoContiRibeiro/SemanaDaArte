package br.com.sa.repository;

import br.com.sa.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    public void deleteById(Long id);
    public Pesquisa findByTitleIgnoreCase(String title);
    public Pesquisa findBySlug(String slug);
}
