package sigs.api.web;


import java.util.List;

import sigs.api.model.CompteFournisseur;
import sigs.api.repository.CompteFournisseurRepository;
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
public class CompteFournisseurController
{


    private final CompteFournisseurRepository repository;

    CompteFournisseurController(CompteFournisseurRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/compte-fournisseurs")
    List<CompteFournisseur> all() {
        return (List<CompteFournisseur>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/compte-fournisseur-add")
    CompteFournisseur newCompteFournisseur(@RequestBody CompteFournisseur newCompteFournisseur) {
        return repository.save(newCompteFournisseur);
    }

    // Single item

    @GetMapping("/compte-fournisseur/{id}")
    CompteFournisseur one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }


    @PutMapping("/compte-fournisseur-update/{id}")
    CompteFournisseur replaceCompteFournisseur(@RequestBody CompteFournisseur newCompteFournisseur, @PathVariable Long id) {

        return repository.findById(id)
                .map(compteFournisseur -> {
                    compteFournisseur.setNom(newCompteFournisseur.getNom());
                    compteFournisseur.setDate(newCompteFournisseur.getDate());
                    compteFournisseur.setNumero_compte(newCompteFournisseur.getNumero_compte());
                    compteFournisseur.setMontant_acompte(newCompteFournisseur.getMontant_acompte());

                    return repository.save(compteFournisseur);
                })
                .orElseGet(() -> {
                    newCompteFournisseur.setId(id);
                    return repository.save(newCompteFournisseur);
                });
    }

    @DeleteMapping("/compte-fournisseur-delete/{id}")
    void deleteCompteFournisseur(@PathVariable Long id) {
        repository.deleteById(id);
    }






}

