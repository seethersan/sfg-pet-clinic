package dev.tokhna.sfgpetclinic.repositories;

import dev.tokhna.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
