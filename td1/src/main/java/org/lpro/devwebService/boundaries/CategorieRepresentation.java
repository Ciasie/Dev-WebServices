package org.lpro.devwebService.boundaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.lpro.devwebService.entity.Categorie;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;
import java.util.UUID;



//Permet de définir un controller REST
@RestController
// Définition d'une route par défaut
@RequestMapping(value="/categorie", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Categorie.class)
public class CategorieRepresentation {
    @Autowired
    private final CategorieRessource cr;

    public CategorieRepresentation(CategorieRessource cr) {
        this.cr = cr;
    } 

    @GetMapping
    public ResponseEntity<?> getAllIntervenants() {
        Iterable<Categorie> allIntervenant = cr.findAll();
        return new ResponseEntity<>(allIntervenant,HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getCategorieWithId (@PathVariable("id") String id){
        Optional<Categorie> ctg = cr.findById(id);
        if(ctg.isPresent()){ // controle si l'optional contient une valeur
            return new ResponseEntity<>(ctg.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>("categorie non présente",HttpStatus.NOT_FOUND);
        }
    }
}



