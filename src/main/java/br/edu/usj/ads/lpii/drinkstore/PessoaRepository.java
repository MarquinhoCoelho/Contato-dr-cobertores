package br.edu.usj.ads.lpii.drinkstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PessoaRepository extends CrudRepository <Pessoa, Long> {
    
List<Pessoa> findAll();

}