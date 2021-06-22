package br.com.sa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
<<<<<<< HEAD

    @GetMapping("/sobreNos")
    public String sobreNos(){ return "sobreNos"; }
=======
>>>>>>> 073d52ca3b0a525155d60fce924613b0f7ba5f8d
}
