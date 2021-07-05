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

    @GetMapping("pesquisa/add")
    public String add(Model model) {
        model.addAttribute("pesquisa", new Pesquisa());
        return "pesquisa/add";
    };

    @PostMapping("pesquisa/save")
    public String save(Model model, Pesquisa pesquisa,
                       @RequestParam("imagem") MultipartFile multipartFile) throws IOException {
        pesquisa.setImage(Base64.encodeBase64String(multipartFile.getBytes()));
        pesquisaService.save(pesquisa);
        model.addAttribute("pesquisa", pesquisa);
        return "pesquisa/add";
    }

    @GetMapping("pesquisa/view/{id}")
    public String view(Model model, @PathVariable Long id) {
        model.addAttribute("pesquisa", pesquisaService.findById(id));
        return "pesquisa/view";
    }
}
