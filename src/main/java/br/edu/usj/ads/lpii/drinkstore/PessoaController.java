package br.edu.usj.ads.lpii.drinkstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;



import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        List<Pessoa> lista = pessoaRepository.findAll();

        ModelAndView modelAndView = new ModelAndView ("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("bebida", pessoa);
        return modelAndView;
    }
    
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        Pessoa pessoa = new Pessoa();


        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", pessoa);
        return modelAndView;
    }
    
    @PostMapping(value="/cadastrar")
    public String postMethodName(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
       
        return "redirect:/";
    }
    
    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);

        return "redirect:/";
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getMethodName(@PathVariable Long id) {
        Pessoa bebida = pessoaRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("bebida", bebida);
        return modelAndView;
    }
}