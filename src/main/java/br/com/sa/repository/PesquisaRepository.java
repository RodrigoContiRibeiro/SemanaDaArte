package br.com.sa.repository;

import br.com.sa.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
    public Pesquisa findByImage(byte[] image);
}
