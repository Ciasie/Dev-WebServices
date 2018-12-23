package org.lpro.devwebService.boundaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.lpro.devwebService.entity.Categorie;

public interface CategorieRessource extends JpaRepository<Categorie, String> {


}