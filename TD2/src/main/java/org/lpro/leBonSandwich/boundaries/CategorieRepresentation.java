package org.lpro.leBonSandwich.boundaries;

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
import org.lpro.leBonSandwich.entity.Categorie;

import java.util.Optional;
import java.util.UUID;

import javax.swing.event.InternalFrameEvent;


//Permet de définir un controller REST
@RestController
// Définition d'une route par défaut
@RequestMapping(value="/categorie", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Categorie.class)
public class CategorieRepresentation {

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
        return new ResponseEntity<>(ctg,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postMethod(@RequestBody Categorie ctg) {
        ctg.setId(UUID.randomUUID().toString());
        Categorie newCtg = cr.save(ctg);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(linkTo(CategorieRepresentation.class).slash(newCtg.getId()).toUri());
        return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> putMethod(@PathVariable("id") String id,
        @RequestBody Categorie ctgUpdated) {
        


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public String deleteMethod() {
        return "DELETE appelé";
    }
}



