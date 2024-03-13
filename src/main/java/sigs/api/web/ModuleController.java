package sigs.api.web;


import java.util.List;

import sigs.api.model.Module;
import sigs.api.repository.ModuleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
@RestController
public class ModuleController
{


    private final ModuleRepository repository;
   ModuleController(ModuleRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/modules")
    List<Module> all() {
        return (List<Module>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/module-add")
    Module newModule(@RequestBody Module newModule) {
        return repository.save(newModule);
    }

    // Single item

    @GetMapping("/module/{id}")
    Module one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/module-update/{id}")
    Module replaceModule(@RequestBody Module newModule, @PathVariable Long id) {

        return repository.findById(id)
                .map(module -> {
                    module.setNom(newModule.getNom());
                    module.setStatut(newModule.getStatut());
                    module.setDescription(newModule.getDescription());


                    return repository.save(module);
                })
                .orElseGet(() -> {
                    newModule.setId(id);
                    return repository.save(newModule);
                });
    }

    @DeleteMapping("/module-delete/{id}")
    void deleteModule(@PathVariable Long id) {
        repository.deleteById(id);
    }






}


