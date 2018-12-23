package org.lpro.devwebService.boundaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.lpro.devwebService.entity.Sandwich;

public interface SandwichRessource extends JpaRepository<Sandwich, String> {

}