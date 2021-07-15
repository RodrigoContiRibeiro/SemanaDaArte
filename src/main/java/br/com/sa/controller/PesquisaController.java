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

    @GetMapping("pesquisa/list")
    public String list(Model model) {
        model.addAttribute("pesquisas", pesquisaService.findAll());
        return "pesquisa/list";
    }

    @GetMapping("pesquisa/add")
    public String add(Model model) {
        model.addAttribute("pesquisa", new Pesquisa());
        return "pesquisa/add";
    }

    @PostMapping("pesquisa/save")
    public String save(Model model, Pesquisa pesquisa,
                       @RequestParam("imagem") MultipartFile multipartFile) throws IOException {
        pesquisa.setImage(multipartFile.getBytes());
        pesquisaService.save(pesquisa);
        model.addAttribute("pesquisa", pesquisa);
        return "redirect:/pesquisa/edit/" + pesquisa.getId() + "";
    }

    @GetMapping("pesquisa/view/{id}")
    public String view(Model model, @PathVariable Long id) {
        Pesquisa pesquisa = pesquisaService.findById(id);
        model.addAttribute("pesquisa", pesquisa);
        model.addAttribute("imagem", Base64.encodeBase64String(pesquisa.getImage()));
        return "pesquisa/view";
    }

    @GetMapping("pesquisa/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("pesquisa", pesquisaService.findById(id));
        return "pesquisa/edit";
    }

    @GetMapping("pesquisa/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        if (pesquisaService.deleteById(id)) {
            model.addAttribute("succ", true);
            model.addAttribute("msgSucc", "Salvou Corretamente");
        } else {
            model.addAttribute("erro", true);
            model.addAttribute("msgErro", "Erro ao salvar");
        }
        model.addAttribute("pesquisas", pesquisaService.findAll());
        return "pesquisa/list";
    }
}
