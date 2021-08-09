package br.com.sa.controller;

import br.com.sa.model.Pesquisa;
import br.com.sa.service.PesquisaServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class PesquisaController {

    @Autowired
    PesquisaServiceImpl pesquisaService;

    @GetMapping("/pesquisa/list")
    public String list(Model model) {
        model.addAttribute("pesquisas", pesquisaService.findAll());
        return "pesquisa/list";
    }

    @GetMapping("/pesquisa/add")
    public String add(Model model) {
        model.addAttribute("pesquisa", new Pesquisa());
        return "pesquisa/add";
    }

    @PostMapping("/pesquisa/save")
    public String save(Model model, Pesquisa pesquisa,
                       @RequestParam("imagem") MultipartFile multipartFile) throws IOException {
        String validacao = pesquisaService.validarPesquisa(pesquisa, multipartFile.isEmpty());

        if (multipartFile.isEmpty() && pesquisa.getId() != null) {
            //Edit page only
            pesquisa.setImage(pesquisaService.findById(pesquisa.getId()).getImage());
        } else {
            pesquisa.setImage(multipartFile.getBytes());
        }
        if (validacao.equals("")) {
            pesquisa.setSlug(pesquisaService.gerarSlug(pesquisa.getTitle()));
            pesquisaService.save(pesquisa);
            return "redirect:/pesquisa/list";
        } else {
            model.addAttribute("erro", true);
            model.addAttribute("msgErro", validacao);
            model.addAttribute("pesquisa", pesquisa);
            if (pesquisa.getId() != null) {
                model.addAttribute("imagem", Base64.encodeBase64String(pesquisa.getImage()));
                return "pesquisa/edit";
            } else {
                return "pesquisa/add";
            }
        }
    }

    @GetMapping("/pesquisa/{slug}")
    public String view(Model model, @PathVariable String slug) {
        Pesquisa pesquisa = pesquisaService.findBySlug(slug);
        model.addAttribute("pesquisa", pesquisa);
        model.addAttribute("imagem", Base64.encodeBase64String(pesquisa.getImage()));
        return "pesquisa/view";
    }

    @GetMapping("/pesquisa/edit/{slug}")
    public String edit(Model model, @PathVariable String slug) {
        Pesquisa pesquisa = pesquisaService.findBySlug(slug);
        model.addAttribute("pesquisa", pesquisa);
        model.addAttribute("imagem", Base64.encodeBase64String(pesquisa.getImage()));
        System.out.println(model.getAttribute("imagem"));
        return "pesquisa/edit";
    }

    @GetMapping("/pesquisa/delete/{slug}")
    public String delete(Model model, @PathVariable String slug) {
        if (pesquisaService.deleteBySlug(slug)) {
            model.addAttribute("succ", true);
            model.addAttribute("msgSucc", "Deletou corretamente");
        } else {
            model.addAttribute("erro", true);
            model.addAttribute("msgErro", "Erro ao deletar");
        }
        model.addAttribute("pesquisas", pesquisaService.findAll());
        return "pesquisa/list";
    }
}
