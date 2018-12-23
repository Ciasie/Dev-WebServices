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
import org.lpro.devwebService.entity.Sandwich;

import java.util.Optional;
import java.util.UUID;

//Permet de définir un controller REST
@RestController
// Définition d'une route par défaut
@RequestMapping(value="/sandwich", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Sandwich.class)
public class SandwichRepresentation {
    @Autowired
    private final SandwichRessource sr;

    public SandwichRepresentation(SandwichRessource sr){
        this.sr = sr;
    }

    @GetMapping
    public ResponseEntity<?> getAllSandwichs(){
        Iterable<Sandwich> allSandwich = sr.findAll();
        return new ResponseEntity<>(allSandwich,HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<?> getSandwich (@PathVariable("id") String id){
        Optional<Sandwich> sandwich = sr.findById(id);
        if(sandwich.isPresent()){
            return new ResponseEntity<>(sandwich.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}