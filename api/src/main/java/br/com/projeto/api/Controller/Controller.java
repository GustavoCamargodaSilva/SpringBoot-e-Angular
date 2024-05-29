package br.com.projeto.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.Model.Cliente;
import br.com.projeto.api.Repository.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    Repository repository;
    
    @GetMapping("/")
    public Iterable<Cliente> obterCliente(){
        return repository.findAll();
    }

    @PostMapping("/")
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping("/")
    public Cliente editarCliente(@RequestBody Cliente entity) {
        return repository.save(entity);
    }

    @DeleteMapping("/{codigo}")
    public void removerCliente(@PathVariable Long codigo){
        repository.deleteById(codigo);
    }
}
