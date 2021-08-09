package br.com.sa.service;

import br.com.sa.model.Pesquisa;
import br.com.sa.repository.PesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Service
public class PesquisaServiceImpl implements PesquisaService {

    @Autowired
    PesquisaRepository pesquisaRepo;

    @Override
    public List<Pesquisa> findAll() {
        return pesquisaRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

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

    @Override
    public boolean deleteById(Long id) {
        try {
            pesquisaRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Pesquisa findByTitleIgnoreCase(String title) {
        return pesquisaRepo.findByTitleIgnoreCase(title);
    }

    @Override
    public Pesquisa findBySlug(String slug) {
        return pesquisaRepo.findBySlug(slug);
    }

    @Override
    public String validarPesquisa(Pesquisa pesquisa, boolean isImageEmpty) {
        ArrayList<String> erros = new ArrayList<>();
        Pesquisa byTitle = findByTitleIgnoreCase(pesquisa.getTitle());
        Pesquisa bySlug = findBySlug(gerarSlug(pesquisa.getTitle()));
        Long pesquisaId = pesquisa.getId();

        if (byTitle != null || bySlug != null) {
            if (pesquisa.hashCode() == bySlug.hashCode() && pesquisaId != null) {
                // Stopping the verification if the
                // values didn't change when editing
                return "";
            }
            erros.add("Título já registrado, tente outro.");
        }
        if (isImageEmpty && pesquisaId == null) {
            erros.add("Esqueceu de carregar uma imagem.");
        }
        return StringUtils.join(erros, "<br><br>");
    }

    @Override
    public String gerarSlug(String title) {
        String normalizedTitle = Normalizer.normalize(title, Normalizer.Form.NFD);
        normalizedTitle = normalizedTitle.replaceAll("\\p{M}", "");
        normalizedTitle = normalizedTitle.replaceAll("\\p{Punct}", "");
        return normalizedTitle.toLowerCase().replace(" ", "-");
    }
}
